package com.medical.clinic.appointment_management_system.mappers;

import com.medical.clinic.appointment_management_system.model.dto.AppointmentDto;
import com.medical.clinic.appointment_management_system.model.entity.Appointment;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring",uses = PatientMapper.class)
public interface AppointmentMapper {

    Appointment dtoToEntity (AppointmentDto appointmentDto);

    AppointmentDto entityToDto(Appointment appointment);
}
