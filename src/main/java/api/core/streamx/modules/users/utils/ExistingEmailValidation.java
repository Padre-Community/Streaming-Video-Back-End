package api.core.streamx.modules.users.utils;

import api.core.streamx.modules.exception.users.EmailAlreadyExistsException;
import api.core.streamx.modules.users.dto.request.UsersRequest;
import api.core.streamx.modules.users.repository.UsersRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@RequiredArgsConstructor
@Component
public class ExistingEmailValidation implements UserValidation {

    private final UsersRepository usersRepository;

    @Override
    public void execute(UsersRequest request) {
        log.info("Validando se e-mail existe");
        if (!isValidEmail(request.email())) {
            log.error("E-mail já cadastrado: {}", request.email());
            throw new EmailAlreadyExistsException("E-mail já cadastrado");
        }
    }

    private boolean isValidEmail(String email) {
        return usersRepository.findAll()
                              .stream()
                              .noneMatch(users -> usersRepository.findById(users.getId()).get().getEmail().equals(email));
    }
}
