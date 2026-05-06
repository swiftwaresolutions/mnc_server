package com.ueniweb.swiftwaresolutions.domain;

import com.ueniweb.swiftwaresolutions.request.CreateDisSumConsRequest;
import com.ueniweb.swiftwaresolutions.request.CreateLabAndInvSummaryRequest;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity(name="DischargeSummaryConsultant")
@Table(name = "cli_discharge_summary_consultant")
@Getter
@Setter
public class DischargeSummaryConsultant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "summaryId",nullable = false)
    @Basic(optional = false)
    private DischargeSummary summaryId;

    @Column(name = "consultantId",nullable = false)
    @Basic(optional = false)
    private Integer consultantId;

    @Column(name = "isValid")
    private Integer isValid;

    public static List<DischargeSummaryConsultant> to(final DischargeSummary dischargeSummary, final List<CreateDisSumConsRequest> createDisSumConsRequestList){
        List<DischargeSummaryConsultant> dischargeSummaryConsultantList = new ArrayList<>();
        for (CreateDisSumConsRequest createDisSumConsRequest: createDisSumConsRequestList) {
            dischargeSummaryConsultantList.add(to(dischargeSummary,createDisSumConsRequest));
        }
        return dischargeSummaryConsultantList;
    }

    public static DischargeSummaryConsultant to(final DischargeSummary dischargeSummary,final CreateDisSumConsRequest createDisSumConsRequest){
        DischargeSummaryConsultant dischargeSummaryConsultant = new DischargeSummaryConsultant();
        dischargeSummaryConsultant.setSummaryId(dischargeSummary);
        dischargeSummaryConsultant.setConsultantId(createDisSumConsRequest.getConsultantId());
        dischargeSummaryConsultant.setIsValid(1);
        return dischargeSummaryConsultant;
    }
}
