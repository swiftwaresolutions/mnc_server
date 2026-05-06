package com.ueniweb.swiftwaresolutions.data;

import lombok.Data;

@Data
public class DisSumDeptData {

    private Long id;

    private Integer summaryId;

    private Integer deptId;

    private String name;

    public DisSumDeptData(final Long id, final Integer summaryId, final Integer deptId ,final String name) {
        this.id = id;
        this.summaryId = summaryId;
        this.deptId = deptId;
        this.name= name;
    }

    public static DisSumDeptData createNewInstance(final Long id, final Integer summaryId, final Integer deptId,final String name) {
        return new DisSumDeptData(id,summaryId,deptId,name);
    }
}
