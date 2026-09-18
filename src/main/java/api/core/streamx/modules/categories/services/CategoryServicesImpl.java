package api.core.streamx.modules.categories.services;

import api.core.streamx.modules.categories.repository.CategoryRepository;
import api.core.streamx.modules.videos.dto.response.CategoryResponse;
import lombok.RequiredArgsConstructor;
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
    public List<CategoryResponse> getAllCategories() {
        return List.of();
    }
}
