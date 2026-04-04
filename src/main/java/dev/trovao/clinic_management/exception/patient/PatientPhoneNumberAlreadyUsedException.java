package dev.trovao.clinic_management.exception.patient;

public class PatientPhoneNumberAlreadyUsedException extends RuntimeException {
    public PatientPhoneNumberAlreadyUsedException() {
        super("Patient phone number already used.");
    }
}
