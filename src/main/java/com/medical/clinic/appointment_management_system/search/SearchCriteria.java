package com.medical.clinic.appointment_management_system.search;

import lombok.Data;

@Data
public class SearchCriteria {

    private String key;
    private String operation;
    private Object value;
}
