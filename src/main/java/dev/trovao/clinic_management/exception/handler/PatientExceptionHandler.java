package dev.trovao.clinic_management.exception.handler;

import dev.trovao.clinic_management.exception.model.response.GlobalErrorResponse;
import dev.trovao.clinic_management.exception.patient.PatientEmailAlreadyUsedException;
import dev.trovao.clinic_management.exception.patient.PatientNotFoundException;
import dev.trovao.clinic_management.exception.patient.PatientPhoneNumberAlreadyUsedException;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class PatientExceptionHandler extends BaseExceptionHandler {
    @ExceptionHandler(PatientNotFoundException.class)
    public ResponseEntity<GlobalErrorResponse> notFoundException(PatientNotFoundException exception, HttpServletRequest request) {
        return handleErrorResponse(request, HttpStatus.NOT_FOUND, exception.getMessage());
    }

    @ExceptionHandler(PatientEmailAlreadyUsedException.class)
    public ResponseEntity<GlobalErrorResponse> emailAlreadyUsedException(PatientEmailAlreadyUsedException exception, HttpServletRequest request) {
        return handleErrorResponse(request, HttpStatus.CONFLICT, exception.getMessage());
    }

    @ExceptionHandler(PatientPhoneNumberAlreadyUsedException.class)
    public ResponseEntity<GlobalErrorResponse> phoneNumberAlreadyUsedException(PatientPhoneNumberAlreadyUsedException exception, HttpServletRequest request) {
        return handleErrorResponse(request, HttpStatus.CONFLICT, exception.getMessage());
    }
}
