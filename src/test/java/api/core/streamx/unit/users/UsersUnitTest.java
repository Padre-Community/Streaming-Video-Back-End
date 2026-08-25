package api.core.streamx.unit.users;

import api.core.streamx.modules.users.dto.response.UserFollowersResponse;
import api.core.streamx.modules.users.model.Users;
import api.core.streamx.modules.users.repository.FollowersRepository;
import api.core.streamx.modules.users.repository.UsersRepository;
import api.core.streamx.modules.users.services.UserServicesImpl;
import api.core.streamx.modules.users.services.UsersServices;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class UsersUnitTest {
    @Mock
    private UsersRepository usersRepository;

    @Mock
    private FollowersRepository followersRepository;

    @Mock
    private PasswordEncoder passwordEncoder;

    @InjectMocks
    private UserServicesImpl usersServices;

    @Test
    void ShouldReturnUserFollowers() {

        Users user = Users.builder()
                .id(1L)
                .name("User")
                .build();

        Users follower1 = Users.builder()
                .id(2L)
                .name("user1")
                .build();

        Users follower2 = Users.builder()
                .id(3L)
                .name("user2")
                .build();

        Users follower3 = Users.builder()
                .id(4L)
                .name("user3")
                .build();

        when(usersRepository.findById(1L))
                .thenReturn(Optional.of(user));

        when(followersRepository.findFollowers(1L))
                .thenReturn(List.of(
                        follower1,
                        follower2,
                        follower3
                ));

        UserFollowersResponse response =
                usersServices.findFollowers(1L);

        assertEquals("User", response.userName());
        assertEquals(3, response.followers().size());

        assertEquals("user1", response.followers().get(0).userName());
        assertEquals("user2", response.followers().get(1).userName());
        assertEquals("user3", response.followers().get(2).userName());
    }

    @Test
    void MustThrowExceptionWhenUserDoesNotExist() {

        when(usersRepository.findById(1L))
                .thenReturn(Optional.empty());

        RuntimeException exception = org.junit.jupiter.api.Assertions.assertThrows(
                RuntimeException.class,
                () -> usersServices.findFollowers(1L)
        );

        assertEquals("Usuário não encontrado", exception.getMessage());
    }
}
