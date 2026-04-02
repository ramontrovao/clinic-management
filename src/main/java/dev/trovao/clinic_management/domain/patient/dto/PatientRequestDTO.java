package dev.trovao.clinic_management.domain.patient.dto;



import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Pattern;

import java.time.LocalDate;


public record PatientRequestDTO(
        @NotBlank
        String name,

        @NotBlank
        @Email(message = "Invalid email.")
        String email,

        @NotBlank
        @Pattern(regexp = "\\d{10,11}", message = "Invalid phone number.")
        String phoneNumber,

        @PastOrPresent(message = "Invalid birth date.")
        LocalDate birthDate,

        String imgUrl
) {}
