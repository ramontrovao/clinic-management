package dev.trovao.clinic_management.domain.doctor.dto;

import dev.trovao.clinic_management.domain.doctor.DoctorSpeciality;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

public record DoctorRequestDTO(
     String name,
     LocalDate birthDate,
     String email,
     String phoneNumber,
     LocalDate graduationDate,
     DoctorSpeciality speciality,
     String councilRegistry,
     String specialityRegistry,
     String imgUrl
) {}
