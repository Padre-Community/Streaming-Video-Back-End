package api.core.streamx.modules.videos.services;


import api.core.streamx.modules.videos.dto.response.CategoryResponse;
import api.core.streamx.modules.videos.model.Category;
import api.core.streamx.modules.videos.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


@Service
public class CategoryServices {

    @Autowired
    private CategoryRepository categoryRepository;

    public Page<CategoryResponse> getCategories(Pageable pageable) {
        Page<Category> categoryEntity = categoryRepository.findAll(pageable);

        Page<CategoryResponse> categoryDto = categoryEntity.map(list -> new CategoryResponse(list.getId(), list.getCategoryName()));

        return categoryDto;
    }
}
