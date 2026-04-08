package dev.trovao.clinic_management.repository;

import dev.trovao.clinic_management.domain.doctor.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface DoctorRepository extends JpaRepository<Doctor, UUID> {
    Doctor findByNationalId(String nationalId);
}
