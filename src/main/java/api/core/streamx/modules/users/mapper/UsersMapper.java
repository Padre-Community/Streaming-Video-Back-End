package api.core.streamx.modules.users.mapper;

import api.core.streamx.modules.users.dto.request.UsersRequest;
import api.core.streamx.modules.users.dto.response.UsersResponse;
import api.core.streamx.modules.users.model.Users;

import java.util.Collections;
import java.util.List;

public final class UsersMapper {

    private UsersMapper() {}

    public static UsersResponse toUsersResponse(Users u) {

        if (u == null) {
            return null;
        }

        return new UsersResponse(u.getName(), u.getEmail());
    }

    public static Users toEntity(UsersRequest req) {
        if (req == null) return null;

        return Users.builder()
                    .name(req.name())
                    .email(req.email())
                    .password(req.password())
                    .build();
    }

    public static List<UsersResponse> toResponseList(List<Users> entities) {

        if (entities == null || entities.isEmpty()) return Collections.emptyList();

        return entities.stream()
                       .filter(e -> e.getStatus() == Boolean.TRUE)
                       .map(UsersMapper::toUsersResponse)
                       .toList();
    }

    public static void updateEntity(Users entity, UsersRequest request) {
        if (request == null || entity == null) return;

        if (request.name() != null)     entity.setName(request.name());
        if (request.email() != null)    entity.setEmail(request.email());
        if (request.password() != null) entity.setPassword(request.password());
    }
}
