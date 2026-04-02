package dev.trovao.clinic_management.exception.handler;

import dev.trovao.clinic_management.exception.model.ErrorResponse;
import dev.trovao.clinic_management.exception.patient.PatientEmailAlreadyUsedException;
import dev.trovao.clinic_management.exception.patient.PatientNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;


@RestControllerAdvice
@Slf4j
public class RestExceptionHandler {
    private ResponseEntity<ErrorResponse> handleErrorResponse(HttpServletRequest request, HttpStatus httpStatus, String message) {
        ErrorResponse errorResponse = ErrorResponse
                .builder()
                .timestamp(LocalDateTime.now())
                .code(httpStatus.value())
                .status(httpStatus.name())
                .path(request.getRequestURI())
                .message(message)
                .build();

        return new ResponseEntity<>(errorResponse, httpStatus);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> genericException(Exception exception, HttpServletRequest request) {
        log.error("Internal server error", exception);
        return handleErrorResponse(request, HttpStatus.INTERNAL_SERVER_ERROR, "Internal server error.");
    }

    @ExceptionHandler(PatientNotFoundException.class)
    public ResponseEntity<ErrorResponse> notFoundException(Exception exception, HttpServletRequest request) {
        return handleErrorResponse(request, HttpStatus.NOT_FOUND, exception.getMessage());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> argumentNotValidException(MethodArgumentNotValidException exception, HttpServletRequest request) {
        FieldError fieldError = exception.getBindingResult().getFieldError();

        if (fieldError != null) {
            String errorMessage = fieldError.getField() + ' ' + fieldError.getDefaultMessage();

            return handleErrorResponse(request, HttpStatus.BAD_REQUEST, errorMessage);
        }

        return handleErrorResponse(request, HttpStatus.BAD_REQUEST, "Argument not valid.");
    }

    @ExceptionHandler(PatientEmailAlreadyUsedException.class)
    public ResponseEntity<ErrorResponse> patientAlreadyExists(Exception exception, HttpServletRequest request) {
        return handleErrorResponse(request, HttpStatus.BAD_REQUEST, exception.getMessage());
    }
}
