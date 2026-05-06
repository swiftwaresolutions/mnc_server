package com.ueniweb.swiftwaresolutions.domain;

import com.ueniweb.swiftwaresolutions.request.CreateOrderTemplateRequest;
import com.ueniweb.swiftwaresolutions.request.CreatePrescTemplateRequest;
import com.ueniweb.swiftwaresolutions.utils.DateTimeUtils;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity(name="OrderTemplate")
@Table(name = "cli_investigation_template")
@Getter
@Setter
public class OrderTemplate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "templateName")
    private String templateName;

    @Column(name = "consultantId")
    private Long consultantId;

    @Column(name = "isActive")
    private Long isActive;

    @Column(name = "createdBy")
    private Long createdBy;

    @Column(name = "tempType")
    private Long tempType;

    @Column(name = "createdDTM")
    private String createdDTM;


    @OneToMany(mappedBy = "templateId", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<OrderTemplateDetails> orderTemplateDetailsList = new ArrayList<>();

    public static OrderTemplate to(final CreateOrderTemplateRequest orderTemplateRequest){
        OrderTemplate orderTemplate = new OrderTemplate();
        orderTemplate.setTemplateName(orderTemplateRequest.getTemplateName());
        orderTemplate.setConsultantId(orderTemplateRequest.getConsultantId());
        orderTemplate.setIsActive(orderTemplateRequest.getIsActive());
        orderTemplate.setCreatedBy(orderTemplateRequest.getCreatedBy());
        orderTemplate.setTempType(orderTemplateRequest.getTempType());
        orderTemplate.setCreatedDTM(DateTimeUtils.convertLocalDateToDateTimeFormat(LocalDateTime.now()));

        return orderTemplate;
    }
}
