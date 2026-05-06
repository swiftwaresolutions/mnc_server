package com.ueniweb.swiftwaresolutions.domain;

import com.ueniweb.swiftwaresolutions.request.CreateCaseSheetTemplateRequest;
import com.ueniweb.swiftwaresolutions.request.CreateSummaryTemplateRequest;
import com.ueniweb.swiftwaresolutions.utils.DateTimeUtils;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.w3c.dom.Text;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity(name="SummaryTemplate")
    @Table(name = "cli_discharge_summary_template")
    @Getter
    @Setter
    public class SummaryTemplate {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @Column(name = "name")
        private String name;

        @Column(name = "fieldId")
        private int fieldId;

        @Column(name = "details")
        private String details;

        @Column(name = "docId")
        private int docId;

        @Column(name = "isValid")
        private int isValid;

        @Column(name = "uid")
        private int uid;

        @Column(name = "dtm")
        private String dtm;

    public static SummaryTemplate to(CreateSummaryTemplateRequest createSummaryTemplateRequest) {
            SummaryTemplate summaryTemplate = new SummaryTemplate();
            summaryTemplate.setName(createSummaryTemplateRequest.getName());
            summaryTemplate.setFieldId(createSummaryTemplateRequest.getFieldId());
            summaryTemplate.setDetails(createSummaryTemplateRequest.getDetails());
            summaryTemplate.setDocId(createSummaryTemplateRequest.getDocId());
            summaryTemplate.setIsValid(1);
            summaryTemplate.setUid(createSummaryTemplateRequest.getUid());
            summaryTemplate.setDtm(DateTimeUtils.convertLocalDateToDateTimeFormat(LocalDateTime.now()));
            return summaryTemplate;
        }
}
