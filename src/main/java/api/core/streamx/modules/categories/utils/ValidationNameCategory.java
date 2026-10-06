package api.core.streamx.modules.categories.utils;



import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@RequiredArgsConstructor
@Component
public class ValidationNameCategory implements CategoryValidation {

    @Override
    public void validate(String request) {
        if(!isCategoryNameEmpty(request)) {
            log.info("O nome da categoria é válida");
        } else {
            throw new CategoryException("Categoria não pode ser vazia ");
        }
    }

    private boolean isCategoryNameEmpty(String categoryName) {
        return categoryName.isEmpty();
    }

}
