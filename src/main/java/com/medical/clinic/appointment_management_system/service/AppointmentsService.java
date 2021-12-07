package com.medical.clinic.appointment_management_system.service;

import com.medical.clinic.appointment_management_system.exception.AppointmentException;
import com.medical.clinic.appointment_management_system.model.entity.Appointment;
import com.medical.clinic.appointment_management_system.model.entity.Patient;
import com.medical.clinic.appointment_management_system.repository.AppointmentRepository;
import com.medical.clinic.appointment_management_system.search.AppointmentSpecification;
import java.util.List;
import java.util.UUID;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class AppointmentsService {


    private final AppointmentRepository appointmentRepository;

    private final PatientService patientService;


    public AppointmentsService(AppointmentRepository appointmentRepository,
        PatientService patientService) {
        this.appointmentRepository = appointmentRepository;
        this.patientService = patientService;
    }


    public Appointment saveAppointment(Appointment appointment) {

        Patient patient = patientService.getPatient(appointment.getPatient().getId());
        appointment.setPatient(patient);
        return appointmentRepository.save(appointment);
    }

    public Appointment updateAppointment(String appointmentId, Appointment updated) {

        Appointment existed = appointmentRepository.findById(UUID.fromString(appointmentId)).orElseThrow(() -> {
            throw new AppointmentException(HttpStatus.NOT_FOUND, "Appointment Error", "Appointment not found", null);

        });

        updated.setId(UUID.fromString(appointmentId));

        return appointmentRepository.save(updated);
    }

    public Page<Appointment> getAppointmentsByPatientName(String patientName,int pageNumber,int pageSize) {

        Specification<Appointment> getByPatientName = AppointmentSpecification.getAppointmentByPatientName(patientName);

        return appointmentRepository.findAll(getByPatientName, PageRequest.of(pageNumber,pageSize));
    }
}
