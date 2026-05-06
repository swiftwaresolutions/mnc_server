package com.ueniweb.swiftwaresolutions.domain;

import com.ueniweb.swiftwaresolutions.request.CreateOrderTemplateDetailsRequest;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity(name="OrderTemplateDetails")
@Table(name = "cli_investigation_template_details")
@Getter
@Setter
public class OrderTemplateDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "templateId",nullable = false)
    @Basic(optional = false)
    private OrderTemplate templateId;

    @Column(name = "procedureId",nullable = false)
    @Basic(optional = false)
    private Long procedureId;

    @Column(name = "procedureType")
    private String procedureType;

    @Column(name = "procedureName")
    private String procedureName;

    @Column(name = "procedureRate",nullable = false)
    @Basic(optional = false)
    private double procedureRate;

    public static List<OrderTemplateDetails> to(final OrderTemplate orderTemplate, final List<CreateOrderTemplateDetailsRequest> createOrderTemplateDetailsRequestList){
        List<OrderTemplateDetails> orderTemplateDetailsList = new ArrayList<>();
        for (CreateOrderTemplateDetailsRequest createOrderTemplateDetailsRequest: createOrderTemplateDetailsRequestList) {
            orderTemplateDetailsList.add(to(orderTemplate,createOrderTemplateDetailsRequest));
        }
        return orderTemplateDetailsList;
    }

    public static OrderTemplateDetails to(final OrderTemplate orderTemplate, final CreateOrderTemplateDetailsRequest createOrderTemplateDetailsRequest){
        OrderTemplateDetails orderTemplateDetails = new OrderTemplateDetails();
        orderTemplateDetails.setTemplateId(orderTemplate);
        orderTemplateDetails.setProcedureId(createOrderTemplateDetailsRequest.getProcedureId());
        orderTemplateDetails.setProcedureType(createOrderTemplateDetailsRequest.getProcedureType());
        orderTemplateDetails.setProcedureName(createOrderTemplateDetailsRequest.getProcedureName());
        orderTemplateDetails.setProcedureRate(createOrderTemplateDetailsRequest.getProcedureRate());

        return orderTemplateDetails;
    }
}
