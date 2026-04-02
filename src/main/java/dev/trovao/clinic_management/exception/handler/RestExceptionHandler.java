package dev.trovao.clinic_management.exception.handler;

import dev.trovao.clinic_management.exception.model.ErrorResponse;
import dev.trovao.clinic_management.exception.patient.PatientNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;


@RestControllerAdvice
public class RestExceptionHandler {
    public ResponseEntity<ErrorResponse> handleErrorResponse(Exception exception, HttpServletRequest request, HttpStatus httpStatus) {
        ErrorResponse errorResponse = ErrorResponse
                .builder()
                .timestamp(LocalDateTime.now())
                .code(httpStatus.value())
                .status(httpStatus.name())
                .path(request.getRequestURI())
                .message(exception.getMessage())
                .build();

        return new ResponseEntity<>(errorResponse, httpStatus);
    }

    public ResponseEntity<ErrorResponse> handleErrorResponse(HttpServletRequest request, HttpStatus httpStatus, String errorMessage) {
        ErrorResponse errorResponse = ErrorResponse
                .builder()
                .timestamp(LocalDateTime.now())
                .code(httpStatus.value())
                .status(httpStatus.name())
                .path(request.getRequestURI())
                .message(errorMessage)
                .build();

        return new ResponseEntity<>(errorResponse, httpStatus);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> genericException(Exception exception, HttpServletRequest request) {
        return handleErrorResponse(exception, request, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(PatientNotFoundException.class)
    public ResponseEntity<ErrorResponse> notFoundException(Exception exception, HttpServletRequest request) {
        return handleErrorResponse(exception, request, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> argumentNotValidException(MethodArgumentNotValidException exception, HttpServletRequest request) {
        FieldError fieldError = exception.getBindingResult().getFieldError();
        String errorMessage = fieldError.getField() + ' ' + fieldError.getDefaultMessage();

        return handleErrorResponse(request, HttpStatus.BAD_REQUEST, errorMessage);
    }
}
