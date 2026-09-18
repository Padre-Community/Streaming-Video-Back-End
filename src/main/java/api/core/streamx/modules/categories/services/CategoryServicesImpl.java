package api.core.streamx.modules.categories.services;

import api.core.streamx.modules.categories.dto.response.CategoryResponse;
import api.core.streamx.modules.categories.model.Category;
import api.core.streamx.modules.categories.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import java.util.List;

@RequiredArgsConstructor
@Service
public class CategoryServicesImpl implements CategoryServices {

    private final CategoryRepository categoryRepository;

    @Override
    public CategoryResponse createCategory(String categoryName) {
        return null;
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

        Page<Category> categoryEntity =  categoryRepository.findAll(pageable);

        List<CategoryResponse> CategoryDto = categoryEntity.map(category ->
                new CategoryResponse(category.getId(), category.getCategoryName())).getContent();

        return CategoryDto;
    }
}
