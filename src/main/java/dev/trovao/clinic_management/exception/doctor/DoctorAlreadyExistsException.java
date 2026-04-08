package dev.trovao.clinic_management.exception.doctor;

public class DoctorAlreadyExistsException extends RuntimeException {
    public DoctorAlreadyExistsException() {
        super("Doctor already exists.");
    }
}
