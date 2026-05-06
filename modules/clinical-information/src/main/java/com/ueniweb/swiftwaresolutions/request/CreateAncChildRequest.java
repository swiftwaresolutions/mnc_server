package com.ueniweb.swiftwaresolutions.request;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class CreateAncChildRequest {
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



    @Override
    public String toString() {
        return "CreateAncChildRequest{" +
                "id=" + id +
                ", anc_id=" + anc_id +
                ", status=" + status +
                ", type=" + type +
                ", birthdate='" + birthdate + '\'' +
                ", mode='" + mode + '\'' +
                ", place='" + place + '\'' +
                ", others='" + others + '\'' +
                ", isValid='" + isValid + '\'' +
                ", sex='" + sex + '\'' +
                ", riskFacOfThisPre='" + riskFacOfThisPre + '\'' +

                '}';
    }
}
