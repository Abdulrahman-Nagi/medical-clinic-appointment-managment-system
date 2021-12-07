package com.medical.clinic.appointment_management_system.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum AppointmentStatus {

    OPENED ("OPENED"),
    CANCELLED("CANCELLED");

    private String value;

    AppointmentStatus(String value) {
        this.value = value;
    }


    @Override
    @JsonValue
    public String toString() {
        return String.valueOf(value);
    }

    @JsonCreator
    public static AppointmentStatus fromValue(String text) {
        for (AppointmentStatus b : AppointmentStatus.values()) {
            if (String.valueOf(b.value).equals(text)) {
                return b;
            }
        }
        throw new IllegalArgumentException("Unexpected value '" + text + "'");
    }
}
