package dev.trovao.clinic_management.exception.doctor;

public class DoctorAlreadyExists extends RuntimeException {
    public DoctorAlreadyExists() {
        super("Doctor already exists.");
    }
}
