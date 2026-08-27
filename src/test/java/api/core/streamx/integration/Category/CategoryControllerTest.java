package api.core.streamx.integration.Category;

import api.core.streamx.modules.videos.controller.CategoryController;
import api.core.streamx.modules.videos.dto.response.CategoryResponse;
import api.core.streamx.modules.videos.services.CategoryServices;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import java.util.List;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.junit.jupiter.api.Assertions.*;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = CategoryController.class)
public class CategoryControllerTest{

    @Autowired
    MockMvc mockMvc;

    @MockitoBean
    CategoryServices categoryServices;

    @Test
    void shouldReturnSuccessWhenListingCategories() throws Exception {

        CategoryResponse response = new CategoryResponse(10L, "CategorieOfTest");
        Page<CategoryResponse> paginaEsperada = new PageImpl<>(List.of(response));

        when(categoryServices.getCategories(any(Pageable.class)))
                .thenReturn(paginaEsperada);

        mockMvc.perform(get("/categories/list")
                        .param("page", "0")
                        .param("size", "1")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id").value(10))
                .andExpect(jsonPath("$[0].categoryName").value("CategorieOfTest"));

        verify(categoryServices).getCategories(any(Pageable.class));
    }
}
