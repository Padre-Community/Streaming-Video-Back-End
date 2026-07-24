package api.core.stream_video_backend.modules.users.controller;

import api.core.stream_video_backend.modules.users.dto.request.UsersRequest;
import api.core.stream_video_backend.modules.users.dto.response.UsersResponse;
import api.core.stream_video_backend.modules.users.services.UsersServices;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
public class UsersApi {

    @Autowired
    private UsersServices usersServices;

    @PostMapping("/save")
    public ResponseEntity<UsersResponse> register(@Valid @RequestBody UsersRequest request) {
        UsersResponse response = usersServices.registerUser(request);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
}
