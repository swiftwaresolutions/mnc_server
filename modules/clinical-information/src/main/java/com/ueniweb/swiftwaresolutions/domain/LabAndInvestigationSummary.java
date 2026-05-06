package com.ueniweb.swiftwaresolutions.domain;


import com.ueniweb.swiftwaresolutions.request.CreateLabAndInvSummaryRequest;
import com.ueniweb.swiftwaresolutions.utils.DateTimeUtils;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "LabAndInvestigationSummary")
@Table(name = "cli_discharge_summary_labandinv")
@Data
public class LabAndInvestigationSummary {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "summaryId",nullable = false)
    @Basic(optional = false)
    private DischargeSummary summaryId;

    @Column(name = "procName")
    private String procName;

    @Column(name = "procDate")
    private String procDate;

    @Column(name = "report", columnDefinition = "TEXT")
    private String report;

    @Column(name = "date")
    private String date;

    @Column(name = "time")
    private String time;

    @Column(name = "uid",nullable = false)
    @Basic(optional = false)
    private Long uid;

    @Column(name = "isActive",nullable = false)
    @Basic(optional = false)
    private Integer isActive;


    public static List<LabAndInvestigationSummary> to(final DischargeSummary dischargeSummary, final List<CreateLabAndInvSummaryRequest> createLabAndInvSummaryRequestList){
        List<LabAndInvestigationSummary> labAndInvestigationSummaryList = new ArrayList<>();
        for (CreateLabAndInvSummaryRequest createLabAndInvSummaryRequest: createLabAndInvSummaryRequestList) {
            labAndInvestigationSummaryList.add(to(dischargeSummary,createLabAndInvSummaryRequest));
        }
        return labAndInvestigationSummaryList;
    }

    public static LabAndInvestigationSummary to(final DischargeSummary dischargeSummary,final CreateLabAndInvSummaryRequest createLabAndInvSummaryRequest) {
        LabAndInvestigationSummary labAndInvestigationSummary = new LabAndInvestigationSummary();
        labAndInvestigationSummary.setSummaryId(dischargeSummary);
        labAndInvestigationSummary.setProcName(createLabAndInvSummaryRequest.getProcName());
        labAndInvestigationSummary.setProcDate(createLabAndInvSummaryRequest.getProcDate());
        labAndInvestigationSummary.setReport(createLabAndInvSummaryRequest.getReport());
        labAndInvestigationSummary.setDate(DateTimeUtils.convertLocalDateToDateFormat(LocalDate.now()));
        labAndInvestigationSummary.setTime(DateTimeUtils.convertLocalDateToTimeFormat(LocalTime.now()));
        labAndInvestigationSummary.setUid(createLabAndInvSummaryRequest.getUid());
        labAndInvestigationSummary.setIsActive(1);

        return labAndInvestigationSummary;
    }
}
