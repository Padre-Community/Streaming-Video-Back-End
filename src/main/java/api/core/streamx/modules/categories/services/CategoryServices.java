package api.core.streamx.modules.categories.services;

import api.core.streamx.modules.videos.dto.response.CategoryResponse;

import java.util.List;


public interface CategoryServices {

    CategoryResponse createCategory(String categoryName);

    CategoryResponse updateCategory(Long categoryId, String categoryName);

    void deleteCategory(Long categoryId);

    void deleteCategory(String categoryName);

    List<CategoryResponse> getAllCategories();
}
