package api.core.streamx.integration.users;

import api.core.streamx.integration.utils.JsonUtils;
import api.core.streamx.modules.users.controller.UsersController;
import api.core.streamx.modules.users.dto.request.UsersRequest;
import api.core.stream_video_backend.modules.users.dto.response.UsersResponse;
import api.core.streamx.modules.users.dto.response.FollowerResponse;
import api.core.streamx.modules.users.dto.response.UserFollowersResponse;
import api.core.streamx.modules.users.services.UsersServices;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@WebMvcTest(controllers = UsersController.class)
public class UsersIntegrationTest {

    @Autowired
    MockMvc mockMvc;

    @MockitoBean
    UsersServices usersServices;

    @Test
    void shouldCreateUsersAndReturnCreated() throws Exception {
        UsersRequest request = new UsersRequest("Goku", "goku@capsulecorps.com", "goku123");

        UsersResponse response = new UsersResponse(request.name(), request.email());

        when(usersServices.registerUser(request)).thenReturn(response);

        mockMvc.perform(post("/api/users/save")
                        .param("name", response.name())
                        .param("email", response.email())
                        .param("password", "goku123")
                        .contentType(MediaType.APPLICATION_JSON)
                        .characterEncoding("UTF-8")
                        .accept(MediaType.APPLICATION_JSON)
                        .content(JsonUtils.toJson(request)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.name").value("Goku"))
                .andExpect(jsonPath("$.email").value("goku@capsulecorps.com"));

        verify(usersServices).registerUser(request);
    }

    @Test
    void shouldReturnUserFollowers() throws Exception {

        UserFollowersResponse response = new UserFollowersResponse(
                "User",
                List.of(
                        new FollowerResponse("user1"),
                        new FollowerResponse("user2"),
                        new FollowerResponse("user3")
                )
        );

        when(usersServices.findFollowers(1L))
                .thenReturn(response);

        mockMvc.perform(
                        get("/api/users/followers")
                                .param("userID", "1")
                )
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.userName").value("User"))
                .andExpect(jsonPath("$.followers").isArray())
                .andExpect(jsonPath("$.followers.length()").value(3))
                .andExpect(jsonPath("$.followers[0].userName").value("user1"))
                .andExpect(jsonPath("$.followers[1].userName").value("user2"))
                .andExpect(jsonPath("$.followers[2].userName").value("user3"));
    }
}
