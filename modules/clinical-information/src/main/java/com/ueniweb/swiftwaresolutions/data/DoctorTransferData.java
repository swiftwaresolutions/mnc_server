package com.ueniweb.swiftwaresolutions.data;

import lombok.Data;

@Data
public class DoctorTransferData {

    private Long transferId;

    private String fromDoctor;

    private String toDoctor;

    private int isCompleted;
    private String nextReview;

    public DoctorTransferData(Long transferId ,String fromDoctor, String toDoctor, int isCompleted, String nextReview) {
        this.transferId = transferId;
        this.fromDoctor = fromDoctor;
        this.toDoctor = toDoctor;
        this.isCompleted = isCompleted;
        this.nextReview = nextReview;
    }

    public static DoctorTransferData newInstance(final Long transferId,final String fromDoctor, final String toDoctor, final int isCompleted , final String nextReview){
        return new DoctorTransferData(transferId,fromDoctor, toDoctor, isCompleted , nextReview);
    }
}
