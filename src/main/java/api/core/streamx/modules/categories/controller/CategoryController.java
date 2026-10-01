package api.core.streamx.modules.categories.controller;

import api.core.streamx.modules.categories.dto.response.CategoryResponse;
import api.core.streamx.modules.categories.services.CategoryServicesImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;



@RequiredArgsConstructor
@RestController
@RequestMapping(path = "/api/categories")
public class CategoryController {

    private final CategoryServicesImpl categoryServicesImpl;

    public ResponseEntity<?> createCategory(String categoryName) {
        // Implementation Caller here
        // { "category": "Category Name" }
        return null;
    }



    @GetMapping
    public List<CategoryResponse> fetchCategory(@RequestParam(value = "page", defaultValue = "0") int page,
                                                @RequestParam(value = "size", defaultValue = "10") int size) {
        List<CategoryResponse> categoryPagined = categoryServicesImpl.getAllCategories(PageRequest.of(page, size));
        // { "category": "Category Name" }
        return categoryPagined;
    }
}