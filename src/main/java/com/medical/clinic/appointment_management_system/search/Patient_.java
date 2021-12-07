package com.medical.clinic.appointment_management_system.search;

import com.medical.clinic.appointment_management_system.model.entity.Appointment;
import com.medical.clinic.appointment_management_system.model.entity.Patient;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Patient.class)
public abstract class Patient_{


    public static volatile SingularAttribute<Patient, Appointment> appointments;
    public static volatile SingularAttribute<Patient, String> name;

    public static final String APPOINTMENTS = "appointments";
    public static final String NAME = "name";
}
