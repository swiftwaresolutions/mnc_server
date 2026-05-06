package com.ueniweb.swiftwaresolutions.data;

import lombok.Data;

@Data
public class PatientUploadImageData {
    private Long id;
    private Long patientId;
    private Long visitId;
    private String imagePath    ;
    private String date  ;
    private Boolean imageExist  ;

    public PatientUploadImageData(Long id , Long patientId, Long visitId, String imagePath, String date, Boolean imageExist){
        this.id = id;
        this.patientId = patientId;
        this.visitId = visitId;
        this.imagePath = imagePath;
        this.date = date;
        this.imageExist =imageExist;
    }
    public static PatientUploadImageData createNewInstance(Long id , Long patientId, Long visitId, String imagePath, String date, Boolean imageExist){
        return new PatientUploadImageData(id,patientId,visitId,imagePath,date,imageExist);
    }
}

