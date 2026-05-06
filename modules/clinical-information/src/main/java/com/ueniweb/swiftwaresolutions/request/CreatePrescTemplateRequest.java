package com.ueniweb.swiftwaresolutions.request;

import lombok.Data;

import java.util.List;

@Data
public class CreatePrescTemplateRequest {

    private Long id;

    private String name;

    private Long docId;

    private Long deptId;

    private String date;

    private String time;

    private Long uid;

    private Long isDocTemplate;

    private Long templateType;

    private Long VaccinationId;

    private Long VaccinationFrm;

    private Long FromPeriod;

    private Long VaccinationTo;

    private Long ToPeriod;

    private Long isValid;

    private List<CreatePrescTemplateDetailsRequest> createPrescTemplateRequestList;

    @Override
    public String toString() {
        return "CreatePrescTemplateRequest{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", docId=" + docId +
                ", deptId=" + deptId +
                ", date='" + date + '\'' +
                ", time='" + time + '\'' +
                ", uid=" + uid +
                ", isDocTemplate=" + isDocTemplate +
                ", templateType=" + templateType +
                ", VaccinationId=" + VaccinationId +
                ", VaccinationFrm=" + VaccinationFrm +
                ", FromPeriod=" + FromPeriod +
                ", VaccinationTo=" + VaccinationTo +
                ", ToPeriod=" + ToPeriod +
                ", isValid=" + isValid +
                ", createPrescTemplateRequestList=" + createPrescTemplateRequestList +
                '}';
    }
}
