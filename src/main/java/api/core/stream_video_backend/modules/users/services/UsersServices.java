package api.core.stream_video_backend.modules.users.services;

import api.core.stream_video_backend.modules.users.dto.request.UsersRequest;
import api.core.stream_video_backend.modules.users.dto.response.UsersResponse;
import api.core.stream_video_backend.modules.users.model.Users;
import api.core.stream_video_backend.modules.users.repository.UsersRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class UsersServices {

    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public UsersResponse registerUser(UsersRequest request) {
        if (usersRepository.findByEmail(request.getEmail()).isPresent()) {
            throw new RuntimeException("Email já existe");
        }

        Users users = modelMapper.map(request, Users.class);
        users.setPassword(passwordEncoder.encode(request.getPassword()));
        users.setCreatedAt(LocalDateTime.now());
        users.setUpdatedAt(LocalDateTime.now());
        users.setStatus(true);

        Users saved = usersRepository.save(users);
        return modelMapper.map(saved, UsersResponse.class);
    }
}
