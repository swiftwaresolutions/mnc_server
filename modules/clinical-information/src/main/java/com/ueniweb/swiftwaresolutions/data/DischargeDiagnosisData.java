package com.ueniweb.swiftwaresolutions.data;

import lombok.Data;

@Data
public class DischargeDiagnosisData {

    private Integer id;

    private Integer patId;

    private Integer vstId;

    private Integer ipId;

    private Integer summaryId;

    private Integer diagnosisId;

    private Integer isValid;

    private String name;

    public DischargeDiagnosisData(final Integer id, final Integer patId,final Integer vstId, final Integer ipId,
                                final Integer summaryId, final Integer diagnosisId,final Integer isValid,final String name) {
        this.id = id;
        this.patId = patId;
        this.vstId = vstId;
        this.ipId = ipId;
        this.summaryId = summaryId;
        this.diagnosisId     = diagnosisId;
        this.isValid    = isValid;
        this.name   = name;
    }

    public static DischargeDiagnosisData createNewInstance(final Integer id, final Integer patId,final Integer vstId,final Integer ipId,
                                                         final Integer summaryId, final Integer diagnosisId, final Integer isValid,final String name) {
        return new DischargeDiagnosisData(id,patId,vstId,ipId,summaryId,diagnosisId,isValid,name);
    }


}
