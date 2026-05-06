package com.ueniweb.swiftwaresolutions.data;
import lombok.Data;

@Data
public class DischargeSummaryDiagnosisData {
    private Integer id;
    private String  name;


    public DischargeSummaryDiagnosisData(final Integer id,final String name )
    {
        this.id=id;
        this.name=name;

    }
    public static DischargeSummaryDiagnosisData createNewInstance(final Integer id,final String name){
        return new DischargeSummaryDiagnosisData(id,name);
    }
}
