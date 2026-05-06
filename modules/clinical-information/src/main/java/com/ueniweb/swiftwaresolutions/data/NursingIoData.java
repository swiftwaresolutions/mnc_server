package com.ueniweb.swiftwaresolutions.data;

import jakarta.persistence.*;
import lombok.Data;
@Data
public class NursingIoData {

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

    private String oral;

    private String oralDetails;

    private String outOther;

    private String outOtherDetails;

    private String urine;

    private String urineDetails;

    private Long inTotal;

    private Long outTotal;

    private String curDtm;

    public NursingIoData(   final Long id,    final Long patId,    final Long visitId,    final Long ipId,    final String drain,    final String drainDetails,    final String inOther,    final String inOtherDetails,    final String ivf,    final String ivfDetails,    final String nurseDtmIo,    final String oral,    final String oralDetails,    final String outOther,    final String outOtherDetails,    final String urine,    final String urineDetails,    final Long inTotal,final Long outTotal,final String curDtm) {

        this.id = id;
        this.patId = patId;
        this.visitId =visitId;
        this.ipId=ipId;
        this.drain=drain;
        this.drainDetails=drainDetails;
        this.inOther=inOther;
        this.inOtherDetails=inOtherDetails;
        this.ivf=ivf;
        this.ivfDetails=ivfDetails;
        this.nurseDtmIo=nurseDtmIo;
        this.oral=oral;
        this.oralDetails=oralDetails;
        this.outOther=outOther;
        this.outOtherDetails=outOtherDetails;
        this.urine=urine;
        this.urineDetails=urineDetails;
        this.inTotal=inTotal;
        this.outTotal=outTotal;
        this.curDtm=curDtm;
    }
    public static NursingIoData createNewInstance(final Long id,final Long patId,final Long visitId,final Long ipId,final String drain,final String drainDetails,final String inOther,final String inOtherDetails,final String ivf,final String ivfDetails,final String nurseDtmIo,final String oral,final String oralDetails,final String outOther,final String outOtherDetails,final String urine,final String urineDetails,final Long inTotal,final Long outTotal ,final String curDtm){
        return new NursingIoData(  id,  patId,  visitId,  ipId,  drain,  drainDetails,  inOther,  inOtherDetails,  ivf,  ivfDetails,  nurseDtmIo,  oral,  oralDetails,  outOther,  outOtherDetails,  urine,  urineDetails,  inTotal,  outTotal,curDtm);
    }
}
