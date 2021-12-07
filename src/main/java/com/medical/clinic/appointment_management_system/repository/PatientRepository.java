package com.medical.clinic.appointment_management_system.repository;

import com.medical.clinic.appointment_management_system.model.entity.Patient;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientRepository extends JpaRepository<Patient, UUID> {

}
