package api.core.streamx.unit.category;

import api.core.streamx.modules.videos.dto.response.CategoryResponse;
import api.core.streamx.modules.videos.model.Category;
import api.core.streamx.modules.videos.services.CategoryServices;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class testeCategoryPaginated {

    @Autowired
    CategoryServices categoryServices;

    @Test
    void testeCategoryPaginetd(){
        CategoryResponse response = new CategoryResponse(10L, "CategorieOfTest");
        Page<CategoryResponse> paginaEsperada = new PageImpl<>(List.of(response));

        assertEquals(1,paginaEsperada.getContent().size());
    }

}

