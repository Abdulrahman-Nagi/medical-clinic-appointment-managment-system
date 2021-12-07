package com.medical.clinic.appointment_management_system.mappers;

import com.medical.clinic.appointment_management_system.model.dto.PatientDto;
import com.medical.clinic.appointment_management_system.model.entity.Patient;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PatientMapper {

    Patient dtoToEntity(PatientDto patientDto);

    PatientDto entityToDto(Patient patient);

}
