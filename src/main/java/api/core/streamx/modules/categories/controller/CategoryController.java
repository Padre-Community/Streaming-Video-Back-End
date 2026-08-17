package api.core.streamx.modules.categories.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping(path = "/api/categories")
public class CategoryController {


    public ResponseEntity<?> createCategory(String categoryName) {
        // Implementation Caller here
        // { "category": "Category Name" }
        return null;
    }

    public ResponseEntity<?> fetchCategory(String categoryName) {
        // Implementation Caller here
        // { "category": "Category Name" }
        return null;
    }
}
