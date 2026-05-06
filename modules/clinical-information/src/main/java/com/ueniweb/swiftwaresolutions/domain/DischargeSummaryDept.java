package com.ueniweb.swiftwaresolutions.domain;

import com.ueniweb.swiftwaresolutions.request.CreateDisSumConsRequest;
import com.ueniweb.swiftwaresolutions.request.CreateDisSumDeptRequest;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity(name="DischargeSummaryDept")
@Table(name = "cli_discharge_summary_department")
@Getter
@Setter
public class DischargeSummaryDept {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "summaryId",nullable = false)
    @Basic(optional = false)
    private DischargeSummary summaryId;

    @Column(name = "deptId",nullable = false)
    @Basic(optional = false)
    private Integer deptId;

    @Column(name = "isValid")
    private Integer isValid;

    public static List<DischargeSummaryDept> to(final DischargeSummary dischargeSummary, final List<CreateDisSumDeptRequest> createDisSumDeptRequestList){
        List<DischargeSummaryDept> dischargeSummaryDeptList = new ArrayList<>();
        for (CreateDisSumDeptRequest createDisSumConsRequestList: createDisSumDeptRequestList) {
            dischargeSummaryDeptList.add(to(dischargeSummary,createDisSumConsRequestList));
        }
        return dischargeSummaryDeptList;
    }

    public static DischargeSummaryDept to(final DischargeSummary dischargeSummary,final CreateDisSumDeptRequest createDisSumDeptRequest){
        DischargeSummaryDept dischargeSummaryDept = new DischargeSummaryDept();
        dischargeSummaryDept.setSummaryId(dischargeSummary);
        dischargeSummaryDept.setDeptId(createDisSumDeptRequest.getDeptId());
        dischargeSummaryDept.setIsValid(1);
        return dischargeSummaryDept;
    }
}
