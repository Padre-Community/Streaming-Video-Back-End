package api.core.streamx.modules.categories.controller;


import api.core.streamx.modules.categories.dto.request.CategoryRequest;
import api.core.streamx.modules.categories.dto.response.CategoryResponse;
import api.core.streamx.modules.categories.services.CategoryServicesImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;

import java.util.List;


@CrossOrigin
@RequiredArgsConstructor
@RestController
@RequestMapping(path = "/api/categories")
public class CategoryController {

    private final CategoryServicesImpl categoryServices;

    @PostMapping("/save")
    public ResponseEntity<CategoryResponse> createCategory(@RequestParam(value = "categoryName") String categoryName) {
        CategoryRequest categoryRequest = new CategoryRequest(categoryName);
        return ResponseEntity.status(HttpStatus.CREATED).body(categoryServices.createCategory(categoryRequest));
    }

    public ResponseEntity<?> fetchCategory(String categoryName) {
        // Implementation Caller here
        // { "category": "Category Name" }
        return null;
    }

    @GetMapping
    public List<CategoryResponse> fetchCategory(@RequestParam(value = "page", defaultValue = "0") int page,
                                                @RequestParam(value = "size", defaultValue = "10") int size) {
        List<CategoryResponse> categoryPagined = categoryServices.getAllCategories(PageRequest.of(page, size));
        // { "category": "Category Name" }
        return categoryPagined;
    }
}