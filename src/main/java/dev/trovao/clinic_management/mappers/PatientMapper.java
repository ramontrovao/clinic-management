package dev.trovao.clinic_management.mappers;


import dev.trovao.clinic_management.domain.Patient;
import dev.trovao.clinic_management.domain.patient.PatientDTO;
import dev.trovao.clinic_management.domain.patient.dto.PatientRequestDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PatientMapper {
    Patient toEntity(PatientRequestDTO patientDto);
    PatientDTO toDto(Patient patient);
}
