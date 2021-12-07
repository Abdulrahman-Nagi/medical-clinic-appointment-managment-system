package com.medical.clinic.appointment_management_system.service;

import com.medical.clinic.appointment_management_system.exception.AppointmentException;
import com.medical.clinic.appointment_management_system.model.entity.Patient;
import com.medical.clinic.appointment_management_system.repository.PatientRepository;
import java.util.UUID;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class PatientService {

    private final PatientRepository patientRepository;

    public PatientService(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    public Patient savePatient(Patient patient) {

        return patientRepository.save(patient);
    }

    public Patient getPatient(UUID patientId) {
        return patientRepository.findById(patientId).orElseThrow(()->{throw new AppointmentException(HttpStatus.NOT_FOUND,"Appointment Error","patient not found",null);
        });
    }
}
