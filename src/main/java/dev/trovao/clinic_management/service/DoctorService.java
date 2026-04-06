package dev.trovao.clinic_management.service;

import dev.trovao.clinic_management.domain.doctor.Doctor;
import dev.trovao.clinic_management.domain.doctor.dto.DoctorDTO;
import dev.trovao.clinic_management.mapper.DoctorMapper;
import dev.trovao.clinic_management.repository.DoctorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DoctorService {
    private final DoctorRepository doctorRepository;
    private final DoctorMapper doctorMapper;

    public List<DoctorDTO> getAllDoctors() {
        List<Doctor> doctorList = doctorRepository.findAll();

        return doctorMapper.toDtoList(doctorList);
    }
}
