package dev.trovao.clinic_management.domain.doctor.dto;

import dev.trovao.clinic_management.domain.doctor.DoctorSpeciality;
import jakarta.validation.constraints.*;

import java.time.LocalDate;


public record DoctorRequestDTO(
     @NotBlank(message = "Name is required.")
     String name,

     @NotNull(message = "Birth date is required.")
     @Past(message = "Invalid birth date.")
     LocalDate birthDate,

     @NotBlank(message = "E-mail is required.")
     @Email(message = "E-mail is invalid.")
     String email,

     @NotBlank(message = "National id is required.")
     String nationalId,

     @NotBlank(message = "Phone number is required.")
     @Pattern(regexp = "\\d{10,11}", message = "Invalid phone number.")
     String phoneNumber,

     @NotNull(message = "Graduation date is required.")
     @Past(message = "Invalid graduation date.")
     LocalDate graduationDate,

     @NotNull(message = "Speciality is required.")
     DoctorSpeciality speciality,

     @NotBlank(message = "Council registry is required.")
     String councilRegistry,

     @NotBlank(message = "Speciality registry is required.")
     String specialityRegistry,

     @Pattern(regexp = "^(https?://)([\\w\\-]+\\.)+[\\w\\-]+(/[\\w\\-./?%&=]*)?$", message = "Invalid image url.")
     String imgUrl
) {}
