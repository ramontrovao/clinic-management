package dev.trovao.clinic_management.domain.patient.dto;

import jakarta.validation.constraints.*;

import java.time.LocalDate;

public record PatientRequestDTO(
        @NotBlank(message = "Name is required.")
        String name,

        @NotBlank(message = "E-mail is required.")
        @Email(message = "Invalid email.")
        String email,

        @NotBlank(message = "Phone number is required.")
        // Regex to validate phone length
        @Pattern(regexp = "\\d{10,11}", message = "Invalid phone number.")
        String phoneNumber,

        @NotNull(message = "Birth date is required.")
        @PastOrPresent(message = "Invalid birth date.")
        LocalDate birthDate,

        // Regex to validate URL
        @Pattern(regexp = "^(https?://)([\\w\\-]+\\.)+[\\w\\-]+(/[\\w\\-./?%&=]*)?$", message = "Invalid image url.")
        String imgUrl
) {}
