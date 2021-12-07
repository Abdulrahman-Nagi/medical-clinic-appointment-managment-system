package com.medical.clinic.appointment_management_system.controller;

import com.medical.clinic.appointment_management_system.mappers.PatientMapper;
import com.medical.clinic.appointment_management_system.model.dto.PatientDto;
import com.medical.clinic.appointment_management_system.model.entity.Patient;
import com.medical.clinic.appointment_management_system.service.PatientService;
import javax.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/medical/clinic/patients")
public class PatientController {


    private final PatientService patientService;

    private final PatientMapper patientMapper;

    public PatientController(PatientService patientService, PatientMapper patientMapper) {
        this.patientService = patientService;
        this.patientMapper = patientMapper;
    }

    @PostMapping(value = {"/",""})
    public ResponseEntity<PatientDto> createPatient(@RequestBody @Valid PatientDto patientDto) {

        Patient patient = patientService.savePatient(patientMapper.dtoToEntity(patientDto));
        return new ResponseEntity<>(patientMapper.entityToDto(patient), HttpStatus.CREATED);

    }
}
