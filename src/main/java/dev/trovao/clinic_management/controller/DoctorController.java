package dev.trovao.clinic_management.controller;

import dev.trovao.clinic_management.domain.doctor.dto.DoctorDTO;
import dev.trovao.clinic_management.service.DoctorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/doctors")
public class DoctorController {
    private final DoctorService doctorService;

    @GetMapping
    public ResponseEntity<List<DoctorDTO>> getAllDoctors() {
        return ResponseEntity.ok(doctorService.getAllDoctors());
    }

    @GetMapping
    @RequestMapping("/:id")
    public ResponseEntity<DoctorDTO> getDoctorById(@PathVariable UUID id) {
        return ResponseEntity.ok(doctorService.getDoctorById(id));
    };
}
