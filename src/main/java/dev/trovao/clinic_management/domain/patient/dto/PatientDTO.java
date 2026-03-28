package dev.trovao.clinic_management.domain.patient.dto;

import java.time.LocalDate;
import java.util.UUID;

public class PatientDTO {
    private UUID id;
    private String name;
    private String email;
    private LocalDate birthDate;
    private String imgUrl;
    private LocalDate createdAt;
}
