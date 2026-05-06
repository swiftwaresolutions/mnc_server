package com.ueniweb.swiftwaresolutions.domain;

import com.ueniweb.swiftwaresolutions.request.CreatePrescTemplateEditRequest;
import com.ueniweb.swiftwaresolutions.request.CreatePrescTemplateRequest;
import com.ueniweb.swiftwaresolutions.utils.DateTimeUtils;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Entity(name="PrescTemplate")
@Table(name = "ph_template")
@Getter
@Setter
public class PrescTemplate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "doc_id",nullable = false)
    @Basic(optional = false)
    private Long docId;

    @Column(name = "dept_id", nullable = false)
    @Basic(optional = false)
    private Long deptId;

    @Column(name = "ent_date")
    private String date;

    @Column(name = "ent_time")
    private String time;

    @Column(name = "ent_uid")
    @Basic(optional = false)
    private Long uid;

    @Column(name = "is_doc_template")
    private Long isDocTemplate;

    @Column(name = "templateType")
    private Long templateType;

    @Column(name = "VaccinationId")
    private Long VaccinationId;

    @Column(name = "VaccinationFrm")
    private Long VaccinationFrm;

    @Column(name = "FromPeriod")
    private Long FromPeriod;

    @Column(name = "VaccinationTo")
    private Long VaccinationTo;

    @Column(name = "ToPeriod")
    private Long ToPeriod;

    @Column(name = "edit_date")
    private String editDate;

    @Column(name = "edit_time")
    private String editTime;

    @Column(name = "edit_uid")
    @Basic(optional = false)
    private Long editUid;

    @Column(name = "is_valid")
    private Long isValid;


    @OneToMany(mappedBy = "templateId", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<PrescTemplateDetails> prescTemplateDetailsList = new ArrayList<>();

    public static PrescTemplate to(final CreatePrescTemplateRequest prescTemplateRequest){
        PrescTemplate prescTemplate = new PrescTemplate();
        prescTemplate.setName(prescTemplateRequest.getName());
        prescTemplate.setDocId(prescTemplateRequest.getDocId());
        prescTemplate.setDeptId(prescTemplateRequest.getDeptId());
        prescTemplate.setDate(DateTimeUtils.convertLocalDateToDateFormat(LocalDate.now()));
        prescTemplate.setTime(DateTimeUtils.convertLocalDateToTimeFormat(LocalTime.now()));
        prescTemplate.setUid(prescTemplateRequest.getUid());
        prescTemplate.setIsDocTemplate(prescTemplateRequest.getIsDocTemplate());
        prescTemplate.setTemplateType(prescTemplateRequest.getTemplateType());
        prescTemplate.setVaccinationId(prescTemplateRequest.getVaccinationId());
        prescTemplate.setVaccinationFrm(prescTemplateRequest.getVaccinationFrm());
        prescTemplate.setFromPeriod(prescTemplateRequest.getFromPeriod());
        prescTemplate.setVaccinationTo(prescTemplateRequest.getVaccinationTo());
        prescTemplate.setToPeriod(prescTemplateRequest.getToPeriod());
        prescTemplate.setEditDate("0000-00-00");
        prescTemplate.setEditTime("00:00:00");
        prescTemplate.setEditUid(0L);
        prescTemplate.setIsValid(prescTemplateRequest.getIsValid());

        return prescTemplate;
    }

    public void update(final CreatePrescTemplateEditRequest createPrescTemplateEditRequest) {
        this.setName(createPrescTemplateEditRequest.getTemplateName());
        this.setEditDate(DateTimeUtils.convertLocalDateToDateFormat(LocalDate.now()));
        this.setEditTime(DateTimeUtils.convertLocalDateToTimeFormat(LocalTime.now()));
        this.setEditUid(createPrescTemplateEditRequest.getEditUid());
        this.setIsValid(createPrescTemplateEditRequest.getIsValid());
    }
}
