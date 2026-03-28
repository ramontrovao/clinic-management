package dev.trovao.clinic_management.domain.patient.dto;

import java.time.LocalDate;


public record PatientRequestDTO(String name, String email, String phoneNumber, LocalDate birthDate, String imgUrl) {}
