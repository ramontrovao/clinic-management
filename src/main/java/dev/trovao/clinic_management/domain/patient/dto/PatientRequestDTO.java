package dev.trovao.clinic_management.domain.patient.dto;

import java.time.LocalDate;

public class PatientRequestDTO {
    private String name;
    private String email;
    private LocalDate birthDate;
    private String imgUrl;
    private LocalDate createdAt;
}
