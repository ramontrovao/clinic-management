package dev.trovao.clinic_management.mapper;

import dev.trovao.clinic_management.domain.doctor.Doctor;
import dev.trovao.clinic_management.domain.doctor.dto.DoctorDTO;
import dev.trovao.clinic_management.domain.doctor.dto.DoctorRequestDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface DoctorMapper {
    Doctor toEntity(DoctorRequestDTO doctorDto);
    DoctorDTO toDto(Doctor doctor);

    List<Doctor> toEntityList(List<DoctorRequestDTO> DoctorDTO);
    List<DoctorDTO> toDtoList(List<Doctor> doctor);
}
