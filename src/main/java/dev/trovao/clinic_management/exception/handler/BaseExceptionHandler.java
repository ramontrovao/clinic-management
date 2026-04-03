package dev.trovao.clinic_management.exception.handler;

import dev.trovao.clinic_management.exception.model.ErrorResponse;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.time.LocalDateTime;
import java.util.List;

public abstract class BaseExceptionHandler {
    public ResponseEntity<ErrorResponse> handleErrorResponse(HttpServletRequest request, HttpStatus httpStatus, List<String> errors) {
        ErrorResponse errorResponse = ErrorResponse
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
