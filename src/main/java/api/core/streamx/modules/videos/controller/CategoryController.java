package api.core.streamx.modules.videos.controller;

import api.core.streamx.modules.videos.dto.response.CategoryResponse;
import api.core.streamx.modules.videos.model.Category;
import api.core.streamx.modules.videos.repository.CategoryRepository;
import api.core.streamx.modules.videos.services.CategoryServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping(value = "/categories/list")
public class CategoryController {

    @Autowired
    CategoryServices categoryServices;

    @GetMapping
    public List<CategoryResponse> listCategories(Pageable pageable){
        return categoryServices.getCategories(pageable).getContent();
    }


}
