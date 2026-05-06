package com.ueniweb.swiftwaresolutions.domain;

import com.ueniweb.swiftwaresolutions.request.CreateOutsideInvRequest;
import com.ueniweb.swiftwaresolutions.utils.DateTimeUtils;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "OutsideInv")
@Table(name = "cli_patient_outside_lab")
@Getter
@Setter
public class OutsideInv {

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

    @Column(name = "selDateTime")
    private String selDateTime;

    @Column(name = "type", nullable = false)
    private Long type;

    @Column(name = "isValid")
    private Long isValid;

    @OneToMany(mappedBy = "invDisplay",cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<OutsideInvResult> outsideInvResultList = new ArrayList<>();

    public static OutsideInv to(final CreateOutsideInvRequest createOutsideInvRequest) {

        OutsideInv outsideInv = new OutsideInv();
        outsideInv.setDisplay(createOutsideInvRequest.getDisplay());
        outsideInv.setPatId(createOutsideInvRequest.getPatId());
        outsideInv.setVstId(createOutsideInvRequest.getVstId());
        outsideInv.setIpId(createOutsideInvRequest.getIpId());
        outsideInv.setLabName(createOutsideInvRequest.getLabName());
        outsideInv.setConsultantId(createOutsideInvRequest.getConsultantId());
        outsideInv.setSuggestDoc(createOutsideInvRequest.getSuggestDoc());
        outsideInv.setDateTime(DateTimeUtils.convertLocalDateToDateTimeFormat(LocalDateTime.now()));
        outsideInv.setSelDateTime(createOutsideInvRequest.getSelDateTime());
        outsideInv.setType(2L);
        outsideInv.setIsValid(1L);

        return  outsideInv;
    }
}
