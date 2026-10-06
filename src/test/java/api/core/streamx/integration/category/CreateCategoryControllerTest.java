package api.core.streamx.integration.category;


import api.core.streamx.integration.utils.JsonUtils;
import api.core.streamx.modules.audit.repository.AuditRepository;
import api.core.streamx.modules.categories.controller.CategoryController;
import api.core.streamx.modules.categories.dto.request.CategoryRequest;
import api.core.streamx.modules.categories.dto.response.CategoryResponse;
import api.core.streamx.modules.categories.repository.CategoryRepository;
import api.core.streamx.modules.categories.services.CategoryServicesImpl;
import api.core.streamx.modules.categories.utils.ExistingCategoryValidation;
import api.core.streamx.modules.categories.utils.ValidationNameCategory;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.mockito.Mockito.verify;




@WebMvcTest(controllers = CategoryController.class)
public class CreateCategoryControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockitoBean
    CategoryServicesImpl categoryServices;

    @MockitoBean
    CategoryRepository categoryRepository;

    @MockitoBean
    AuditRepository auditRepository;

    @Test
    public void ShouldReturnCreatedCategory() throws Exception {
        CategoryRequest request = new CategoryRequest(" Anime ");
        CategoryResponse response = new CategoryResponse("anime");

        when(categoryServices.createCategory(request)).thenReturn(response);

        mockMvc.perform(post("/api/categories/save")
                .param("categoryName", request.name())
                .contentType(MediaType.APPLICATION_JSON)
                .characterEncoding("UTF-8")
                .accept(MediaType.APPLICATION_JSON)
                .content(JsonUtils.toJson(request)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.name").value("anime"));

        verify(categoryServices).createCategory(request);
    }



}
