package com.medical.clinic.appointment_management_system.model.dto;

import com.medical.clinic.appointment_management_system.model.AppointmentStatus;
import java.util.UUID;
import lombok.Data;


@Data
public class AppointmentDto {

    private UUID id;
    private PatientDto patient;
    private String notes;
    private AppointmentStatus status;


}
