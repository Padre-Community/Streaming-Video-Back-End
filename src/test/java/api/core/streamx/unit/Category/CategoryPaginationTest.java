package api.core.streamx.unit.Category;

import api.core.streamx.modules.categories.dto.response.CategoryResponse;
import api.core.streamx.modules.categories.model.Category;
import api.core.streamx.modules.categories.repository.CategoryRepository;
import api.core.streamx.modules.categories.services.CategoryServicesImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.when;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@ExtendWith(MockitoExtension.class)
public class CategoryPaginationTest {

    @Mock
    private CategoryRepository categoryRepository;

    @InjectMocks
    private CategoryServicesImpl categoryServices;


    @Test
    void shouldReturnPagination()  throws Exception{

        Category terror = new Category(1L, "Terror", null);
        Category comedia = new Category(2L, "Comedia", null);
        Category drama = new Category(3L, "Drama", null);
        Category acao = new Category(4L, "Ação", null);
        Category aventura = new Category(5L, "Aventura", null);



        Pageable pageRequest = PageRequest.of(0, 5);

        Page<Category> itensPageMock = new PageImpl<>(List.of(terror,
                comedia,
                drama,
                acao,
                aventura), pageRequest, 20); //20 itens


        when(categoryRepository.findAll(pageRequest)).thenReturn(itensPageMock);


        Page<CategoryResponse> serviceResponsePage = categoryServices.getAllCategories(pageRequest);


        Assertions.assertEquals(
                itensPageMock.getContent()
                        .stream()
                        .map(Category::getCategoryName).collect(Collectors.toList()),


                serviceResponsePage.getContent()
                        .stream()
                        .map(CategoryResponse::categoryName)
                        .collect(Collectors.toList())


        );


        Assertions.assertEquals(4, serviceResponsePage.getTotalPages());
        Assertions.assertEquals(20, serviceResponsePage.getTotalElements());
        Assertions.assertEquals(0, serviceResponsePage.getNumber());
        Assertions.assertEquals(5, serviceResponsePage.getNumberOfElements());
        Assertions.assertEquals(5, serviceResponsePage.getSize());
        Assertions.assertTrue(serviceResponsePage.hasNext());





    }


}
