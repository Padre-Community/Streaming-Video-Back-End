package api.core.streamx.integration.category;

import api.core.streamx.integration.utils.JsonUtils;
import api.core.streamx.modules.audit.repository.AuditRepository;
import api.core.streamx.modules.categories.controller.CategoryController;
import api.core.streamx.modules.categories.dto.response.CategoryResponse;
import api.core.streamx.modules.categories.services.CategoryServicesImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;


import java.util.List;
import java.util.stream.Collectors;

import static org.mockito.Mockito.when;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = CategoryController.class)
public class PaginationCategoryControllerTest {

    @Autowired
    MockMvc mockMvc;


    @MockitoBean
    CategoryServicesImpl categoryServices;

    @MockitoBean
    AuditRepository auditRepository;

    @Test
    void shouldReturnFiveItemsInPageable()  throws Exception {

        CategoryResponse content = new CategoryResponse("Comédia");
        CategoryResponse content2 = new CategoryResponse("Ação");
        CategoryResponse content3 = new CategoryResponse("Terror");
        CategoryResponse content4 = new CategoryResponse("Documentário");
        CategoryResponse content5 = new CategoryResponse("Romance");

        PageRequest request = PageRequest.of(0, 5, Sort.by(Sort.Direction.ASC, "categoryName"));

        Page<CategoryResponse> response = new PageImpl<>(List.of(content, content5, content2, content3, content4), request, 10);


        int totalElements = 10;
        int actualPage = 0;
        int pageSize = 5;
        int totalPages = 2;
        int numberOfElementsOfPage = 5;
        boolean lastPage = false;

        List<String> expectedCategoryNames = response.stream()
                .map(CategoryResponse::categoryName)
                .collect(Collectors.toList());


        when(categoryServices.getAllCategories(request)).thenReturn(response);
        mockMvc.perform(get("/api/categories/list")
                .param("page", "0")
                .param("size", "5")
                .contentType(MediaType.APPLICATION_JSON)
                .characterEncoding("UTF-8")
                .accept(MediaType.APPLICATION_JSON)
                .content(JsonUtils.toJson(request)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.totalElements").value(totalElements))// totalElements is a variable that represents the total number of items across all pages.
                .andExpect(jsonPath("$.content.*.categoryName").value(expectedCategoryNames))// get expectedCategoryNames and compare list<String> with list<String> of expectedCategoryNames.
                .andExpect(jsonPath("$.number").value(actualPage))
                .andExpect(jsonPath("$.size").value(pageSize))//Represents size: maximum number of items per page (the requested page size).
                .andExpect(jsonPath("$.last").value(lastPage)) // When LastPage is false, it has a next page. When LastPage is true, it doesn't have a next page.
                .andExpect(jsonPath("$.totalPages").value(totalPages))
                .andExpect(jsonPath("$.numberOfElements").value(numberOfElementsOfPage));//number of items actually returned in the current page.
    }
}
