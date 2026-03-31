package dev.trovao.clinic_management.controller;

import dev.trovao.clinic_management.domain.patient.dto.PatientDTO;
import dev.trovao.clinic_management.domain.patient.dto.PatientRequestDTO;
import dev.trovao.clinic_management.service.PatientService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

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
    public ResponseEntity<PatientDTO> getPatientById(@PathVariable UUID id) {
        PatientDTO patientFound = patientService.getPatientById(id);

        if (patientFound == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(patientFound);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<PatientDTO> updatePatientById(@PathVariable UUID id, @RequestBody PatientRequestDTO patientDto) {
        return ResponseEntity.ok(patientService.updatePatientById(id, patientDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deletePatientById(@PathVariable UUID id) {
        PatientDTO patientFound = patientService.getPatientById(id);

        if (patientFound == null) {
            return ResponseEntity.notFound().build();
        }

        patientService.deletePatientById(id);
        return ResponseEntity.ok().build();
    }
}
