package com.ueniweb.swiftwaresolutions.data;

import lombok.Data;

@Data
public class AncChildDetialsData {

    private Long id;

    private Long anc_id;

    private Long status;

    private Long type;

    private String birthdate;

    private String mode;

    private String place;

    private String others;

    private Long isValid;

    private Long sex;

    private String riskFacOfThisPre;

    public AncChildDetialsData(final Long id, final Long anc_id, final Long status, final Long type, final String birthdate, final String mode, final String place, final String others, final Long isValid, final Long sex, final String riskFacOfThisPre) {

        this.id=id;

        this.anc_id=anc_id;

        this.status=status;

        this.type=type;

        this.birthdate=birthdate;

        this.mode=mode;

        this.place=place;

        this.others=others;

        this.isValid=isValid;

        this.sex=sex;

        this.riskFacOfThisPre=riskFacOfThisPre;

    }
    public static AncChildDetialsData createNewInstance(final Long id,final Long anc_id,final Long status,final Long type,final String birthdate,final String mode,final String place,final String others,final Long isValid,final Long sex, final String riskFacOfThisPre) {
        return new AncChildDetialsData(   id,  anc_id,  status,  type,  birthdate,  mode,  place,  others,isValid,sex,riskFacOfThisPre);
    }
}
