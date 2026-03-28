package dev.trovao.clinic_management.service;

import dev.trovao.clinic_management.domain.patient.Patient;
import dev.trovao.clinic_management.domain.patient.dto.PatientDTO;
import dev.trovao.clinic_management.domain.patient.dto.PatientRequestDTO;
import dev.trovao.clinic_management.mapper.PatientMapper;
import dev.trovao.clinic_management.repository.PatientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class PatientService {
    private final PatientRepository patientRepository;
    private final PatientMapper patientMapper;

    public List<PatientDTO> getAllPatients() {
        List<Patient> patientList = patientRepository.findAll();

        return patientMapper.toDtoList(patientList);
    }

    public PatientDTO getPatientById(UUID id) {
        return patientRepository.findById(id).map(patientMapper::toDto).orElse(null);
    }

    public PatientDTO createPatient(PatientRequestDTO patientDto) {
        Patient patientEntity = patientMapper.toEntity(patientDto);
        Patient createdPatient = patientRepository.save(patientEntity);

        return patientMapper.toDto(createdPatient);
    }
}
