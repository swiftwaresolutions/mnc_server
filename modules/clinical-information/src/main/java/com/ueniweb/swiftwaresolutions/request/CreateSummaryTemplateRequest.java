package com.ueniweb.swiftwaresolutions.request;

import lombok.Data;
import org.w3c.dom.Text;

@Data
public class CreateSummaryTemplateRequest {

    private String name;

    private int fieldId;

    private String details;

    private int docId;

    private int uid;

    @Override
    public String toString() {
        return "CreateSummaryTemplateRequest{" +
                "name=" + name +
                ", details=" + details +
                ", fieldId=" + fieldId +
                ", docId=" + docId +
                ", uid=" + uid +
                '}';
    }


}
