package com.medical.clinic.appointment_management_system.controller;

import com.medical.clinic.appointment_management_system.mappers.AppointmentMapper;
import com.medical.clinic.appointment_management_system.model.dto.AppointmentDto;
import com.medical.clinic.appointment_management_system.model.entity.Appointment;
import com.medical.clinic.appointment_management_system.service.AppointmentsService;
import java.util.List;
import javax.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/medical/clinic/appointments")
public class AppointmentsController {

    private final AppointmentsService appointmentsService;

    private final AppointmentMapper appointmentMapper;

    public AppointmentsController(AppointmentsService appointmentsService,
        AppointmentMapper appointmentMapper) {
        this.appointmentsService = appointmentsService;
        this.appointmentMapper = appointmentMapper;
    }


    @PostMapping(value = {"/", ""})
    public ResponseEntity<AppointmentDto> createAppointment(@RequestBody @Valid AppointmentDto appointmentDto) {

        Appointment appointment = appointmentsService.saveAppointment(appointmentMapper.dtoToEntity(appointmentDto));
        return new ResponseEntity<>(appointmentMapper.entityToDto(appointment), HttpStatus.CREATED);

    }

    @PutMapping(value = {"/{appointmentId}"})
    public ResponseEntity<AppointmentDto> updateAppointment(@PathVariable String appointmentId, @RequestBody @Valid AppointmentDto appointmentDto) {

        Appointment appointment = appointmentsService.updateAppointment(appointmentId, appointmentMapper.dtoToEntity(appointmentDto));
        return new ResponseEntity<>(appointmentMapper.entityToDto(appointment), HttpStatus.OK);

    }

    @PostMapping(value = {"/patient/{patientName}"})
    public ResponseEntity<List<Appointment>> getAppointmentsByPatientName(@PathVariable String patientName,
        @RequestParam(value = "pageNumber", required = false, defaultValue = "0") Integer pageNumber,
        @RequestParam(value = "pageSize", required = false, defaultValue = "3") Integer pageSize) {

        List<Appointment> appointments = appointmentsService.getAppointmentsByPatientName(patientName, pageNumber, pageSize).getContent();

        return new ResponseEntity<>(appointments, HttpStatus.OK);
    }
}
