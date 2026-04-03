package dev.trovao.clinic_management.exception.handler;

import dev.trovao.clinic_management.exception.model.ErrorResponse;
import dev.trovao.clinic_management.exception.patient.PatientEmailAlreadyUsedException;
import dev.trovao.clinic_management.exception.patient.PatientNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;

@RestControllerAdvice
@Slf4j
public class PatientExceptionHandler extends BaseExceptionHandler {
    @ExceptionHandler(PatientNotFoundException.class)
    public ResponseEntity<ErrorResponse> notFoundException(PatientNotFoundException exception, HttpServletRequest request) {
        return handleErrorResponse(request, HttpStatus.NOT_FOUND, List.of(exception.getMessage()));
    }

    @ExceptionHandler(PatientEmailAlreadyUsedException.class)
    public ResponseEntity<ErrorResponse> patientAlreadyExists(PatientEmailAlreadyUsedException exception, HttpServletRequest request) {
        return handleErrorResponse(request, HttpStatus.CONFLICT, List.of(exception.getMessage()));
    }
}
