package com.medical.clinic.appointment_management_system.search;

import com.medical.clinic.appointment_management_system.model.entity.Appointment;
import javax.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(Appointment.class)
public abstract class Appointment_ {

    public static final String PATIENT = "patient";
    public static final String STATUS = "status";
    public static final String CREATION_DATE = "creationDate";

}
