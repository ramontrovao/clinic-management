package dev.trovao.clinic_management.domain.patient.dto;

import java.time.Instant;
import java.time.LocalDate;
import java.util.UUID;

public record PatientDTO(
        UUID id,
        String name,
        String email,
        String phoneNumber,
        LocalDate birthDate,
        String imgUrl,
        Instant createdAt
) {}
