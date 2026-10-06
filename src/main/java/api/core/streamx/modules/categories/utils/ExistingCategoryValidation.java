package api.core.streamx.modules.categories.utils;

import api.core.streamx.modules.categories.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@RequiredArgsConstructor
@Component
public class ExistingCategoryValidation implements CategoryValidation {

    private final CategoryRepository repository;


    @Override
    public void validate(String request) {
        log.info("Validando categoria: {}", request);
        if(!isValidCategory(request)) {
            log.error("Categoria já cadastrada: {}", request);
            throw new CategoryException("Categoria já cadastrada");
        }
    }

    private boolean isValidCategory(String categoryName) {
        return repository.findAll()
                .stream()
                .noneMatch(categorys -> repository.findById(categorys.getId()).get().getCategoryName().toLowerCase().equals(categoryName));
    }
}
