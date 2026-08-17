package api.core.streamx.modules.exception;

import api.core.streamx.modules.exception.users.EmailAlreadyExistsException;
import api.core.streamx.modules.exception.videos.BusinessException;
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

    @ExceptionHandler(value = BusinessException.class)
    public ResponseEntity<ExceptionMessage> businessException(BusinessException ex) {

        ExceptionMessage exceptionMessage = new ExceptionMessage(
                HttpStatus.NOT_FOUND.value(),
                HttpStatus.NOT_FOUND,
                new Date().toString(),
                List.of(ex.getMessage()));

        return new ResponseEntity<>(exceptionMessage, HttpStatus.NOT_FOUND);
    }
}