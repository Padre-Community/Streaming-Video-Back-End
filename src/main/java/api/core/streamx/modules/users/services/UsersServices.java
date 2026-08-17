package api.core.streamx.modules.users.services;

import api.core.streamx.modules.exception.users.EmailAlreadyExistsException;
import api.core.streamx.modules.exception.videos.BusinessException;
import api.core.streamx.modules.users.dto.request.UsersRequest;
import api.core.streamx.modules.users.dto.response.UsersResponse;
import api.core.streamx.modules.users.dto.response.FollowerResponse;
import api.core.streamx.modules.users.dto.response.UserFollowersResponse;
import api.core.streamx.modules.users.model.Users;
import api.core.streamx.modules.users.repository.FollowersRepository;
import api.core.streamx.modules.users.repository.UsersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UsersServices {

    private final UsersRepository usersRepository;
    private final PasswordEncoder passwordEncoder;
    private final FollowersRepository followersRepository;

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

        Users save = usersRepository.save(users);

        return new UsersResponse(save.getName(), save.getEmail());
    }

    public UserFollowersResponse findFollowers(Long userID) {

        Users user = usersRepository.findById(userID)
                                    .orElseThrow(() -> new BusinessException("Usuário não encontrado"));

        List<Users> followers = followersRepository.findFollowers(userID);

        List<FollowerResponse> response = followers.stream()
                .map(f -> new FollowerResponse(f.getName()))
                .toList();

        return new UserFollowersResponse(
                user.getName(),
                response
        );
    }
}
