package dev.trovao.clinic_management.mapper;

import dev.trovao.clinic_management.domain.doctor.Doctor;
import dev.trovao.clinic_management.domain.doctor.dto.DoctorDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface DoctorMapper {
    Doctor toEntity(DoctorDTO doctorDto);
    DoctorDTO toDto(Doctor doctor);

    List<Doctor> toEntityList(List<DoctorDTO> DoctorDTO);
    List<DoctorDTO> toDtoList(List<Doctor> doctor);
}
