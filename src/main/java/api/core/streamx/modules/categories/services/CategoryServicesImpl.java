package api.core.streamx.modules.categories.services;


import api.core.streamx.modules.categories.dto.request.CategoryRequest;
import api.core.streamx.modules.categories.model.Category;
import api.core.streamx.modules.categories.repository.CategoryRepository;
import api.core.streamx.modules.categories.utils.ExistingCategoryValidation;
import api.core.streamx.modules.categories.utils.ValidationNameCategory;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import api.core.streamx.modules.categories.dto.response.CategoryResponse;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryServicesImpl implements CategoryServices {

    private final ValidationNameCategory validationNameCategory;
    private final ExistingCategoryValidation existingCategoryValidation;
    private final CategoryRepository categoryRepository;

    @Override
    public CategoryResponse createCategory(CategoryRequest request) {

        String formattedCategoryName = request.name() //Se eu criar um metodo para converter o request em uma String formatada.
                .strip()
                .replaceAll("\\s+", " ")// Replaces any sequence of two or more whitespace characters with a single space.
                .toLowerCase();

        validationNameCategory.validate(formattedCategoryName);

        existingCategoryValidation.validate(formattedCategoryName);

        Category category = Category.builder()
                .categoryName(formattedCategoryName)
                .build();


        Category save = categoryRepository.save(category);


        return new CategoryResponse(save.getCategoryName());
    }

    @Override
    public CategoryResponse updateCategory(Long categoryId, String categoryName) {
        return null;
    }

    @Override
    public void deleteCategory(Long categoryId) {

    }

    @Override
    public void deleteCategory(String categoryName) {

    }

    @Override
    public List<CategoryResponse> getAllCategories(Pageable pageable) {
        return List.of();
    }

}
