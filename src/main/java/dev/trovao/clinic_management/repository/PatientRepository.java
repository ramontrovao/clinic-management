package dev.trovao.clinic_management.repository;

import dev.trovao.clinic_management.domain.patient.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PatientRepository extends JpaRepository<Patient, UUID> {
    boolean existsByEmail(String email);
}
