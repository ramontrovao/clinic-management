package dev.trovao.clinic_management.exception.patient;

public class PatientNotFoundException extends RuntimeException {
    public PatientNotFoundException() {
        super("Patient not found.");
    }
}
