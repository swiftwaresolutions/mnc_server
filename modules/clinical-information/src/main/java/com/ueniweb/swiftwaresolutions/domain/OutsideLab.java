package com.ueniweb.swiftwaresolutions.domain;

import com.ueniweb.swiftwaresolutions.request.CreateOutsideLabRequest;
import com.ueniweb.swiftwaresolutions.utils.DateTimeUtils;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "OutsideLab")
@Table(name = "cli_patient_outside_lab")
@Getter
@Setter
public class OutsideLab {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "display")
    @Basic(optional = false)
    private Long display;

    @Column(name = "patId", nullable = false)
    @Basic(optional = false)
    private Long patId;

    @Column(name = "vstId", nullable = false)
    @Basic(optional = false)
    private Long vstId;

    @Column(name = "ipId", nullable = false)
    @Basic(optional = false)
    private Long ipId;

    @Column(name = "labName")
    private String labName;

    @Column(name = "consultantId")
    private Long consultantId;

    @Column(name = "suggestDoc")
    private String suggestDoc;

    @Column(name = "dateTime")
    private String dateTime;

    @Column(name = "type", nullable = false)
    private Long type;

    @Column(name = "isValid")
    private Long isValid;

    @Column(name = "selDateTime")
    private String selDateTime;

    @OneToMany(mappedBy = "labDisp",cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<OutsideLabResult> outsideLabResultList = new ArrayList<>();

    public static OutsideLab to(final CreateOutsideLabRequest createOutsideLabRequest) {

        OutsideLab outsideLab = new OutsideLab();
        outsideLab.setDisplay(0L);
        outsideLab.setPatId(createOutsideLabRequest.getPatId());
        outsideLab.setVstId(createOutsideLabRequest.getVstId());
        outsideLab.setIpId(createOutsideLabRequest.getIpId());
        outsideLab.setLabName(createOutsideLabRequest.getLabName());
        outsideLab.setConsultantId(createOutsideLabRequest.getConsultantId());
        outsideLab.setSuggestDoc(createOutsideLabRequest.getSuggestDoc());
        outsideLab.setDateTime(DateTimeUtils.convertLocalDateToDateTimeFormat(LocalDateTime.now()));
        outsideLab.setSelDateTime(createOutsideLabRequest.getSelDateTime());
        outsideLab.setType(1L);
        outsideLab.setIsValid(1L);

        return outsideLab;
    }


}
