package dev.trovao.clinic_management.exception.handler;

import dev.trovao.clinic_management.exception.model.ErrorResponse;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler extends BaseExceptionHandler {
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> genericException(Exception exception, HttpServletRequest request) {
        log.error("Internal server error", exception);
        return handleErrorResponse(request, HttpStatus.INTERNAL_SERVER_ERROR, List.of("Internal server error."));
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> argumentNotValidException(MethodArgumentNotValidException exception, HttpServletRequest request) {
        List<FieldError> fieldErrors = exception.getBindingResult().getFieldErrors();
        List<String> errorMessages = fieldErrors.stream().map(error -> error.getField() + " " + error.getDefaultMessage()).toList();

        return handleErrorResponse(request, HttpStatus.BAD_REQUEST, errorMessages);
    }
}
