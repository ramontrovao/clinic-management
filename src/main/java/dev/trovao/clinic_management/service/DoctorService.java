package dev.trovao.clinic_management.service;

import dev.trovao.clinic_management.domain.doctor.Doctor;
import dev.trovao.clinic_management.domain.doctor.dto.DoctorDTO;
import dev.trovao.clinic_management.domain.doctor.dto.DoctorRequestDTO;
import dev.trovao.clinic_management.mapper.DoctorMapper;
import dev.trovao.clinic_management.repository.DoctorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class DoctorService {
    private final DoctorRepository doctorRepository;
    private final DoctorMapper doctorMapper;

    public List<DoctorDTO> getAllDoctors() {
        List<Doctor> doctorList = doctorRepository.findAll();

        return doctorMapper.toDtoList(doctorList);
    }

    public DoctorDTO getDoctorById(UUID id) {
        Doctor doctor = doctorRepository.findById(id).orElse(null);

        return doctorMapper.toDto(doctor);
    };

    public DoctorDTO createDoctor(DoctorRequestDTO doctorRequestDTO) {
        Doctor doctorEntity = doctorMapper.toEntity(doctorRequestDTO);
        Doctor createdDoctor = doctorRepository.save(doctorEntity);

        return doctorMapper.toDto(createdDoctor);
    }

    public void deleteDoctorById(UUID id) {
        doctorRepository.deleteById(id);
    }
}
