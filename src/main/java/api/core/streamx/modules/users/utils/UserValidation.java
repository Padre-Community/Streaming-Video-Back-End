package api.core.streamx.modules.users.utils;

import api.core.streamx.modules.users.dto.request.UsersRequest;

public interface UserValidation {

    void execute(UsersRequest request);
}
