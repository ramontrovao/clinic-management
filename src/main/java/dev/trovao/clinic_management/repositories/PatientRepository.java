package dev.trovao.clinic_management.repositories;

import dev.trovao.clinic_management.domain.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PatientRepository extends JpaRepository<Patient, UUID> {}
