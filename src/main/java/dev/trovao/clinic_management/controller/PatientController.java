package dev.trovao.clinic_management.controller;

import dev.trovao.clinic_management.domain.patient.dto.PatientDTO;
import dev.trovao.clinic_management.domain.patient.dto.PatientRequestDTO;
import dev.trovao.clinic_management.exception.model.response.ArgumentNotValidErrorResponse;
import dev.trovao.clinic_management.exception.patient.PatientNotFoundException;
import dev.trovao.clinic_management.service.PatientService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@Tag(name = "Patient Management", description = "APIs for managing patients")
@RequestMapping("/patients")
public class PatientController {
    private final PatientService patientService;

    @PostMapping
    @Operation(summary = "Create a new patient" )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Patient created successfully",
                    content = @Content(schema = @Schema(implementation = PatientDTO.class))),
            @ApiResponse(responseCode = "400", description = "Invalid request data",
                    content = @Content(schema = @Schema(implementation = ArgumentNotValidErrorResponse.class)))
    })
    public ResponseEntity<PatientDTO> createPatient(@RequestBody @Valid PatientRequestDTO patientDto) {
        return new ResponseEntity<>(patientService.createPatient(patientDto), HttpStatus.CREATED);
    }

    @GetMapping
    @Operation(summary = "Get all patients")
    @ApiResponse(responseCode = "200", description = "List of all patients",
            content = @Content(schema = @Schema(implementation = PatientDTO.class)))
    public ResponseEntity<List<PatientDTO>> getAllPatients() {
        return ResponseEntity.ok(patientService.getAllPatients());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PatientDTO> getPatientById(@PathVariable UUID id) {
        PatientDTO patientFound = patientService.getPatientById(id);

        if (patientFound == null) {
            throw new PatientNotFoundException();
        }

        return ResponseEntity.ok(patientFound);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<PatientDTO> updatePatientById(@PathVariable @Valid UUID id, @RequestBody PatientRequestDTO patientDto) {
        return ResponseEntity.ok(patientService.updatePatientById(id, patientDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deletePatientById(@PathVariable UUID id) {
        PatientDTO patientFound = patientService.getPatientById(id);

        if (patientFound == null) {
            throw new PatientNotFoundException();
        }

        patientService.deletePatientById(id);
        return ResponseEntity.ok().build();
    }
}
