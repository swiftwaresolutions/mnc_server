package com.ueniweb.swiftwaresolutions.request;

import lombok.Data;

@Data
public abstract class AbstractCaseSheetRequest {

    private String presentIllness;

    private String pastHistory;

    private String treatmentHistory;

    private String personalHistory;

    private String allergy;

    private String temperature;

    private String pulse;

    private String rr;

    private String bp;

    private String spo2;

    private String height;

    private String weight;

    private String bmi;
}
