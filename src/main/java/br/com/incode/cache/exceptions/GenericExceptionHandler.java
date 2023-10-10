package br.com.incode.cache.exceptions;

import br.com.incode.cache.dto.ResponseDTO;
import jakarta.persistence.NoResultException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GenericExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(NoResultException.class)
    ResponseEntity<?> handleNoResultException(RuntimeException ex) {
        return new ResponseEntity<>(new ResponseDTO(false, "Resource not found"), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(Exception.class)
    ResponseEntity<?> handleGenericException(Exception ex) {
        logger.error(ex.getMessage(), ex.getCause());
        return new ResponseEntity<>(
                new ResponseDTO(false, "Internal server error. Contact your system administrator."),
                HttpStatus.INTERNAL_SERVER_ERROR);

    }
}
