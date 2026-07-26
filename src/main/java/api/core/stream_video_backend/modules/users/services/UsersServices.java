package api.core.stream_video_backend.modules.users.services;

import api.core.stream_video_backend.modules.exceptions.EmailAlreadyExistsException;
import api.core.stream_video_backend.modules.users.dto.request.UsersRequest;
import api.core.stream_video_backend.modules.users.dto.response.UsersResponse;
import api.core.stream_video_backend.modules.users.model.Users;
import api.core.stream_video_backend.modules.users.repository.UsersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class UsersServices {

    private final UsersRepository usersRepository;
    private final PasswordEncoder passwordEncoder;

    public UsersResponse registerUser(UsersRequest request) {
        if (usersRepository.findByEmail(request.email()).isPresent()) {
            throw new EmailAlreadyExistsException("Email já existe");
        }

        LocalDateTime now = LocalDateTime.now();
        Users users = Users.builder()
                .name(request.name())
                .email(request.email())
                .password(passwordEncoder.encode(request.password()))
                .createdAt(now)
                .updatedAt(now)
                .status(true)
                .build();

        Users saved = usersRepository.save(users);
        return new UsersResponse(saved.getName(), saved.getEmail());
    }
}
