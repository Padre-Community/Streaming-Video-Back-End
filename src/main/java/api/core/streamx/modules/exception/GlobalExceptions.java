package api.core.streamx.modules.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Date;
import java.util.List;

@RestControllerAdvice
public class GlobalExceptions {

    @ExceptionHandler(value = EmailAlreadyExistsException.class)
    public ResponseEntity<ExceptionMessage> emailAlreadyExistsException(EmailAlreadyExistsException ex) {

        ExceptionMessage exceptionMessage = new ExceptionMessage(
                HttpStatus.CONFLICT.value(),
                HttpStatus.CONFLICT,
                new Date().toString(),
                List.of(ex.getMessage()));

        return new ResponseEntity<>(exceptionMessage, HttpStatus.CONFLICT);
    }
}