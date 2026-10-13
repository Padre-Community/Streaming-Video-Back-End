package api.core.streamx.unit.Category;

import api.core.streamx.modules.categories.dto.request.CategoryRequest;
import api.core.streamx.modules.categories.model.Category;
import api.core.streamx.modules.categories.repository.CategoryRepository;
import api.core.streamx.modules.categories.services.CategoryServicesImpl;
import api.core.streamx.modules.categories.utils.ExistingCategoryValidation;
import api.core.streamx.modules.categories.utils.ValidationNameCategory;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.junit.jupiter.api.Assertions.assertEquals;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class CategoryUnitTest {

    @Mock
    private CategoryRepository categoryRepository;

    @InjectMocks
    private CategoryServicesImpl categoryServices;

    @Mock
    private ValidationNameCategory validationNameCategory;

    @Mock
    private ExistingCategoryValidation existingCategoryValidation;

    @Captor
    private ArgumentCaptor<Category> categoryArgumentCaptor;

    @Test
    void ShouldCreateCategory()  throws Exception {
        CategoryRequest request = new CategoryRequest("  Anime  ");

        ArgumentCaptor<Category> categoryArgumentCaptor = ArgumentCaptor.forClass(Category.class);

        String formattedCategoryName = request.name() //Se eu criar um metodo para converter o request em uma String formatada.
                .strip()
                .replaceAll("\\s+", " ")//Replaces any sequence of two or more whitespace characters with a single space.
                .toLowerCase();

        Category category = Category.builder()
                .categoryName(formattedCategoryName)
                .build();


        when(categoryRepository.save(any(Category.class))).thenReturn(category);

        categoryServices.createCategory(request);


        verify(categoryRepository).save(categoryArgumentCaptor.capture());
        assertEquals("anime", categoryArgumentCaptor.getValue().getCategoryName());
    }
}
