package com.ueniweb.swiftwaresolutions.domain;

import com.ueniweb.swiftwaresolutions.request.CreateAncDeliveryInductionRequest;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity(name = "AncDeliveryInduction")
@Table(name = "cli_anc_delivery_Induction")
@Getter
@Setter
public class AncDeliveryInduction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "anc_Delivery_id",nullable = false)
    @Basic(optional = false)
    private AncDeliverySheet anc_Delivery_id;

    @Column(name = "indDate",nullable = false)
    @Basic(optional = false)
    private String indDate;

    @Column(name = "indName",nullable = false)
    @Basic(optional = false)
    private String indName;

    @Column(name = "indNumber",nullable = false)
    @Basic(optional = false)
    private Long indNumber;

    @Column(name = "indTime",nullable = false)
    @Basic(optional = false)
    private String indTime;

    @Column(name = "isValid",nullable = false)
    @Basic(optional = false)
    private Long isValid;

    public static List<AncDeliveryInduction> to(final AncDeliverySheet ancDeliverySheet, final List<CreateAncDeliveryInductionRequest> createAncDeliveryInductionRequestList){
        List<AncDeliveryInduction> ancDeliveryInductions = new ArrayList<>();
        for (CreateAncDeliveryInductionRequest createAncDetailsRequest: createAncDeliveryInductionRequestList) {
            ancDeliveryInductions.add(to(ancDeliverySheet,createAncDetailsRequest));
        }
        return ancDeliveryInductions;
    }
    public static AncDeliveryInduction to(final AncDeliverySheet ancDeliverySheet, final CreateAncDeliveryInductionRequest createAncDeliveryInductionRequest){
        AncDeliveryInduction ancDeliveryInduction = new AncDeliveryInduction();
        ancDeliveryInduction.setAnc_Delivery_id(ancDeliverySheet);
        ancDeliveryInduction.setIndDate(createAncDeliveryInductionRequest.getIndDate());
        ancDeliveryInduction.setIndName(createAncDeliveryInductionRequest.getIndName());
        ancDeliveryInduction.setIndTime(createAncDeliveryInductionRequest.getIndTime());
        ancDeliveryInduction.setIndNumber(createAncDeliveryInductionRequest.getIndNumber());
        ancDeliveryInduction.setIsValid(createAncDeliveryInductionRequest.getIsValid());

        return ancDeliveryInduction;
    }
}
