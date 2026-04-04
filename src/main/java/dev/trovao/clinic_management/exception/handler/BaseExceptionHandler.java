package dev.trovao.clinic_management.exception.handler;

import dev.trovao.clinic_management.exception.model.error.CustomFieldError;
import dev.trovao.clinic_management.exception.model.response.ArgumentNotValidErrorResponse;
import dev.trovao.clinic_management.exception.model.response.GlobalErrorResponse;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.time.LocalDateTime;
import java.util.List;

public class BaseExceptionHandler {
    public ResponseEntity<GlobalErrorResponse> handleErrorResponse(HttpServletRequest request, HttpStatus httpStatus, String error) {
        GlobalErrorResponse errorResponse = GlobalErrorResponse
                .builder()
                .timestamp(LocalDateTime.now())
                .code(httpStatus.value())
                .status(httpStatus.name())
                .path(request.getRequestURI())
                .error(error)
                .build();

        return new ResponseEntity<>(errorResponse, httpStatus);
    }

    public ResponseEntity<ArgumentNotValidErrorResponse> handleArgumentNotValidErrorResponse(HttpServletRequest request, HttpStatus httpStatus, List<CustomFieldError> errors) {
        ArgumentNotValidErrorResponse errorResponse = ArgumentNotValidErrorResponse
                .builder()
                .timestamp(LocalDateTime.now())
                .code(httpStatus.value())
                .status(httpStatus.name())
                .path(request.getRequestURI())
                .errors(errors)
                .build();

        return new ResponseEntity<>(errorResponse, httpStatus);
    }
}
