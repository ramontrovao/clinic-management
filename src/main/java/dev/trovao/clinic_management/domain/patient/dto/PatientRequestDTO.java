package dev.trovao.clinic_management.domain.patient.dto;



import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PastOrPresent;

import java.time.LocalDate;


public record PatientRequestDTO(
        @NotBlank
        String name,

        @NotBlank
        String email,

        @NotBlank
        String phoneNumber,

        @NotBlank
        @PastOrPresent
        LocalDate birthDate,

        @NotBlank
        String imgUrl
) {}
