package dev.trovao.clinic_management.exception.handler;

import dev.trovao.clinic_management.exception.model.error.CustomFieldError;
import dev.trovao.clinic_management.exception.model.response.ArgumentNotValidErrorResponse;
import dev.trovao.clinic_management.exception.model.response.GlobalErrorResponse;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.core.annotation.Order;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;

@RestControllerAdvice
@Order(org.springframework.core.Ordered.LOWEST_PRECEDENCE)
@Slf4j
public class GlobalExceptionHandler extends BaseExceptionHandler {
    @ExceptionHandler(Exception.class)
    public ResponseEntity<GlobalErrorResponse> genericException(Exception exception, HttpServletRequest request) {
        log.error("Internal server error", exception);
        return handleErrorResponse(request, HttpStatus.INTERNAL_SERVER_ERROR, "Internal server error.");
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<GlobalErrorResponse> messageNotReadableException(HttpMessageNotReadableException exception, HttpServletRequest request) {
        return handleErrorResponse(request, HttpStatus.BAD_REQUEST, "Invalid request body.");
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ArgumentNotValidErrorResponse> argumentNotValidException(MethodArgumentNotValidException exception, HttpServletRequest request) {
        List<FieldError> fieldErrors = exception.getBindingResult().getFieldErrors();
        List<CustomFieldError> errorMessages = fieldErrors.stream().map(error -> new CustomFieldError(error.getField(), error.getDefaultMessage())).toList();

        return handleArgumentNotValidErrorResponse(request, HttpStatus.BAD_REQUEST, errorMessages);
    }
}
