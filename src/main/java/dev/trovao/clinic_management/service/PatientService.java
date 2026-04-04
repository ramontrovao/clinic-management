package dev.trovao.clinic_management.service;

import dev.trovao.clinic_management.domain.patient.Patient;
import dev.trovao.clinic_management.domain.patient.dto.PatientDTO;
import dev.trovao.clinic_management.domain.patient.dto.PatientRequestDTO;
import dev.trovao.clinic_management.exception.patient.PatientEmailAlreadyUsedException;
import dev.trovao.clinic_management.exception.patient.PatientNotFoundException;
import dev.trovao.clinic_management.exception.patient.PatientPhoneNumberAlreadyUsedException;
import dev.trovao.clinic_management.mapper.PatientMapper;
import dev.trovao.clinic_management.repository.PatientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
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
        boolean isEmailAlreadyUsed = patientRepository.existsByEmail(patientDto.email());
        boolean isPhoneNumberAlreadyUsed = patientRepository.existsByPhoneNumber(patientDto.phoneNumber());

        if (isEmailAlreadyUsed) {
            throw new PatientEmailAlreadyUsedException();
        }

        if (isPhoneNumberAlreadyUsed) {
            throw new PatientPhoneNumberAlreadyUsedException();
        }

        Patient patientEntity = patientMapper.toEntity(patientDto);
        Patient createdPatient = patientRepository.save(patientEntity);

        return patientMapper.toDto(createdPatient);
    }

    public PatientDTO updatePatientById(UUID id, PatientRequestDTO patientDto) {
        Patient patientExisting = patientRepository.findById(id).orElseThrow(PatientNotFoundException::new);
        Patient patientUpdated = patientMapper.updateEntityFromDto(patientDto, patientExisting);

        patientRepository.save(patientUpdated);

        return patientMapper.toDto(patientUpdated);
    }

    public void deletePatientById(UUID id) {
        patientRepository.deleteById(id);
    }
}
