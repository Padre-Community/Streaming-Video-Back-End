package api.core.streamx.modules.categories.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record CategoryRequest(
        @NotBlank
        @Size(min = 5, max = 100)
        String name

) {

}
