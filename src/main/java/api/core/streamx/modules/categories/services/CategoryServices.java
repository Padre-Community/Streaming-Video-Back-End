package api.core.streamx.modules.categories.services;

import api.core.streamx.modules.categories.dto.request.CategoryRequest;
import api.core.streamx.modules.categories.dto.response.CategoryResponse;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;



public interface CategoryServices {

    CategoryResponse createCategory(CategoryRequest categoryName);

    CategoryResponse updateCategory(Long categoryId, String categoryName);

    void deleteCategory(Long categoryId);

    void deleteCategory(String categoryName);

    Page<CategoryResponse> getAllCategories(Pageable pageable);
}
