package dev.trovao.clinic_management.mapper;

import dev.trovao.clinic_management.domain.patient.Patient;
import dev.trovao.clinic_management.domain.patient.dto.PatientDTO;
import dev.trovao.clinic_management.domain.patient.dto.PatientRequestDTO;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PatientMapper {
    Patient toEntity(PatientRequestDTO patientDto);
    PatientDTO toDto(Patient patient);

    List<Patient> toEntityList(List<PatientRequestDTO> patientDtoList);
    List<PatientDTO> toDtoList(List<Patient> patientList);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Patient updateEntityFromDto(PatientRequestDTO patientDto, @MappingTarget Patient entity);
}
