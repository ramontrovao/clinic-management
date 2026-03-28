package dev.trovao.clinic_management.services;

import dev.trovao.clinic_management.domain.Patient;
import dev.trovao.clinic_management.repositories.PatientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PatientService {
    private PatientRepository patientRepository;

    // TODO: Refactor to use DTO
    public List<Patient> getAllPatients() {
        return patientRepository.findAll();
    }
}
