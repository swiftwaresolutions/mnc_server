package com.ueniweb.swiftwaresolutions.domain;

import com.ueniweb.swiftwaresolutions.request.CreateAntenatalPreviousCaseSheetRequest;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;


@Entity(name="AntenatalCaseSheetPrevious")
@Table(name = "cli_antenatal_previous")
@Getter
@Setter
public class AntenatalCaseSheetPrevious {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "ancId",nullable = false)
    @Basic(optional = false)
    private AntenatalCaseSheet ancId;

    @Column(name = "ChildNo", nullable = false)
    @Basic(optional = false)
    private Long ChildNo;

    @Column(name = "YrOfBirth")
    @Basic(optional = false)
    private String YrOfBirth;

    @Column(name = "Gender")
    private String Gender;

    @Column(name = "PregDuration")
    private String PregDuration;

    @Column(name = "PlaceDelivery")
    private String PlaceDelivery;

    @Column(name = "ModeDelivery")
    private String ModeDelivery;

    @Column(name = "Birthweight")
    private String Birthweight;

    @Column(name = "ChildStatus")
    private String ChildStatus;

    @Column(name = "isValid")
    private Long isValid;

    public static List<AntenatalCaseSheetPrevious> to(final AntenatalCaseSheet antenatalCaseSheet, final List<CreateAntenatalPreviousCaseSheetRequest> createAntenatelPreviousRequestList){
        List<AntenatalCaseSheetPrevious> antenatalCaseSheetPrevious = new ArrayList<>();
        for (CreateAntenatalPreviousCaseSheetRequest createAntenatalPreviousCaseSheetRequest: createAntenatelPreviousRequestList) {
            antenatalCaseSheetPrevious.add(to(antenatalCaseSheet,createAntenatalPreviousCaseSheetRequest));
        }
        return antenatalCaseSheetPrevious;
    }

    public static AntenatalCaseSheetPrevious to(final AntenatalCaseSheet antenatalCaseSheet, final CreateAntenatalPreviousCaseSheetRequest createAntenatalPreviousCaseSheetRequest){
        AntenatalCaseSheetPrevious antenatalPrevious = new AntenatalCaseSheetPrevious();
        antenatalPrevious.setAncId(antenatalCaseSheet);
        antenatalPrevious.setChildNo(createAntenatalPreviousCaseSheetRequest.getChildNo());
        antenatalPrevious.setYrOfBirth(createAntenatalPreviousCaseSheetRequest.getYrOfBirth());
        antenatalPrevious.setGender(createAntenatalPreviousCaseSheetRequest.getGender());
        antenatalPrevious.setPregDuration(createAntenatalPreviousCaseSheetRequest.getPregDuration());
        antenatalPrevious.setPlaceDelivery(createAntenatalPreviousCaseSheetRequest.getPlaceDelivery());
        antenatalPrevious.setModeDelivery(createAntenatalPreviousCaseSheetRequest.getModeDelivery());
        antenatalPrevious.setBirthweight(createAntenatalPreviousCaseSheetRequest.getBirthweight());
        antenatalPrevious.setChildStatus(createAntenatalPreviousCaseSheetRequest.getChildStatus());
        antenatalPrevious.setIsValid(createAntenatalPreviousCaseSheetRequest.getIsValid());


        return antenatalPrevious;
    }


}
