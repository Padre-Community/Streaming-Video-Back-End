package api.core.streamx.modules.users.controller;

import api.core.streamx.modules.users.dto.request.UsersRequest;
import api.core.stream_video_backend.modules.users.dto.response.UsersResponse;
import api.core.streamx.modules.users.services.UsersServices;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api/users")
@RequiredArgsConstructor
public class UsersController {

    private final UsersServices usersServices;

    @PostMapping("/save")
    public ResponseEntity<UsersResponse> register(@RequestParam(value = "name") String name, @RequestParam(value = "email") String email, @RequestParam(value = "password") String password) {
        UsersRequest request = new UsersRequest(name, email, password);
        return ResponseEntity.status(HttpStatus.CREATED).body(usersServices.registerUser(request));
    }
}
