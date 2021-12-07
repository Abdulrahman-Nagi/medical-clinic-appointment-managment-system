package com.medical.clinic.appointment_management_system.search;


import com.medical.clinic.appointment_management_system.model.entity.Appointment;
import java.util.Date;
import javax.persistence.criteria.Path;
import org.springframework.data.jpa.domain.Specification;

public class AppointmentSpecification {


    public static Specification<Appointment> getAppointmentByPatientName(String patientName) {

        return (root, query, criteriaBuilder) -> {
            Path<String> patientJoin = root.join(Appointment_.PATIENT);
            return criteriaBuilder.equal(patientJoin.get(Patient_.NAME), patientName);
        };


    }

    public static Specification<Appointment> getAppointmentsByCreatedDate(Date date) {

        return (root, query, criteriaBuilder) -> {
            return criteriaBuilder.equal(root.get(Appointment_.CREATION_DATE), date);
        };


    }

}