package com.ueniweb.swiftwaresolutions.data;

import lombok.Data;

@Data
public class TransferData {

    private final Long id;
    private final Long fromDoc;
    private final Long toDoc;
    private final Long isCompleted;
    private final String nextReview;

    public TransferData(Long id, Long fromDoc, Long toDoc, Long isCompleted, String nextReview) {
        this.id = id;
        this.fromDoc = fromDoc;
        this.toDoc = toDoc;
        this.isCompleted = isCompleted;
        this.nextReview = nextReview;
    }

}
