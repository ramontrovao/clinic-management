package dev.trovao.clinic_management.exception.handler;

import dev.trovao.clinic_management.exception.doctor.DoctorAlreadyExistsException;
import dev.trovao.clinic_management.exception.model.response.GlobalErrorResponse;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Order(1)
public class DoctorExceptionHandler extends BaseExceptionHandler {
    @ExceptionHandler()
    public ResponseEntity<GlobalErrorResponse> doctorAlreadyExistsExceptionHandler(DoctorAlreadyExistsException exception, HttpServletRequest request) {
        return handleErrorResponse(request, HttpStatus.CONFLICT, exception.getMessage());
    }
}
