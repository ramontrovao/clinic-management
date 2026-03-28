package dev.trovao.clinic_management.controller;

import dev.trovao.clinic_management.domain.patient.dto.PatientDTO;
import dev.trovao.clinic_management.domain.patient.dto.PatientRequestDTO;
import dev.trovao.clinic_management.service.PatientService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/patients")
public class PatientController {
    private final PatientService patientService;

    @PostMapping
    public ResponseEntity<PatientDTO> createPatient(@RequestBody PatientRequestDTO patientDto) {
        return new ResponseEntity<>(patientService.createPatient(patientDto), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<PatientDTO>> getAllPatients() {
        return ResponseEntity.ok(patientService.getAllPatients());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PatientDTO> getPatientById(@PathVariable String id) {
        return ResponseEntity.ok(patientService.getPatientById());
    }
}
