package com.medical.clinic.appointment_management_system.model.dto;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;
import lombok.Data;

@Data
public class PatientDto {

    private UUID id;
    private String name;
    private String phoneNumber;
    private Set<AppointmentDto> appointments=new HashSet<>();
}
