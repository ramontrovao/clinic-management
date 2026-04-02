package dev.trovao.clinic_management.exception.patient;

public class PatientEmailAlreadyUsedException extends RuntimeException {
    public PatientEmailAlreadyUsedException() {
        super("Patient email already used.");
    }
}
