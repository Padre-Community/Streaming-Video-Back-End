package api.core.stream_video_backend.modules.users.dto.response;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UsersResponse {
    @NotBlank
    @Size(min = 3, max = 60)
    String name;

    @NotBlank
    @Email
    @Size(max = 100)
    String email;
}

