package com.ueniweb.swiftwaresolutions.request;

import lombok.Data;

@Data
public class CreateNursingIoReuest {

    private Long id;

    private Long patId;

    private Long visitId;

    private Long ipId;

    private String drain;

    private String drainDetails;

    private String inOther;

    private String inOtherDetails;

    private String ivf;

    private String ivfDetails;

    private String nurseDtmIo;

    private String  oral;

    private String oralDetails;

    private String outOther;

    private String outOtherDetails;

    private String urine;

    private String urineDetails;

    private Long inTotal;

    private Long  outTotal;

    private String  curDtm;

    @Override
    public String toString() {
        return "CreateNursingIoReuest{" +
                "id=" + id +
                ", patId=" + patId +
                ", visitId=" + visitId +
                ", ipId=" + ipId +
                ", drain='" + drain + '\'' +
                ", drainDetails='" + drainDetails + '\'' +
                ", inOther='" + inOther + '\'' +
                ", inOtherDetails='" + inOtherDetails + '\'' +
                ", ivf='" + ivf + '\'' +
                ", ivfDetails='" + ivfDetails + '\'' +
                ", nurseDtmIo='" + nurseDtmIo + '\'' +
                ", oral='" + oral + '\'' +
                ", oralDetails='" + oralDetails + '\'' +
                ", outOther='" + outOther + '\'' +
                ", outOtherDetails='" + outOtherDetails + '\'' +
                ", urine='" + urine + '\'' +
                ", urineDetails='" + urineDetails + '\'' +
                ", inTotal='" + inTotal + '\'' +
                ", outTotal='" + outTotal + '\'' +
                ", curDtm='" + curDtm + '\'' +
                '}';
    }

}
