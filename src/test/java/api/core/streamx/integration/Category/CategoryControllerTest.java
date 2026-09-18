package api.core.streamx.integration.Category;

import api.core.streamx.modules.audit.repository.AuditRepository;
import api.core.streamx.modules.categories.controller.CategoryController;
import api.core.streamx.modules.categories.dto.response.CategoryResponse;
import api.core.streamx.modules.categories.repository.CategoryRepository;
import api.core.streamx.modules.categories.services.CategoryServicesImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import java.util.List;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(controllers = CategoryController.class)

public class CategoryControllerTest{

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    AuditRepository auditRepository;

    @MockitoBean
    private CategoryRepository categoryRepository;

    @MockitoBean
    private CategoryServicesImpl categoryServices;



    @Test
    public void shouldReturnSucesWhenListingCategories() throws Exception {

        Pageable pageable = PageRequest.of(0, 10);

        CategoryResponse response = new CategoryResponse(10L, "Anime");
        Page<CategoryResponse> paginaEsperada = new PageImpl<>(List.of(response));
        List<CategoryResponse> content = paginaEsperada.getContent();

        when(categoryServices.getAllCategories(pageable))
                .thenReturn(content);

        mockMvc.perform(get("/api/categories")
                        .param("page", "0")
                        .param("size", "10")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id").value(10))
                .andExpect(jsonPath("$[0].categoryName").value("Anime"));

        verify(categoryServices).getAllCategories(pageable);
    }
}