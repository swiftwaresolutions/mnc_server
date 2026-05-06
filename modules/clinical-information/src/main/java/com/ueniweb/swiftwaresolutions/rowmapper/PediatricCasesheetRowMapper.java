package com.ueniweb.swiftwaresolutions.rowmapper;

import com.ueniweb.swiftwaresolutions.data.PediatricCaseSheetData;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PediatricCasesheetRowMapper implements RowMapper<PediatricCaseSheetData> {

    private final String schema;

    private final String tableSchema;

    public PediatricCasesheetRowMapper() {
        final StringBuilder tableBuilder = new StringBuilder(200);
        tableBuilder.append(" FROM cli_patient_pediatric_casesheet a ");

        final StringBuilder builder = new StringBuilder(200);
        builder.append("a.id as id, ");
        builder.append("a.patId as patId, ");
        builder.append("a.vstId as visitId, ");
        builder.append("a.ipId as ipId, ");
        builder.append("a.presentIllness as presentIllness, ");
        builder.append("a.pastHistory as pastHistory, ");
        builder.append("a.birthHistory as birthHistory, ");
        builder.append("a.personalHistory as personalHistory, ");
        builder.append("a.perinatalhistory as perinatalhistory, ");
        builder.append("a.treatmentHistory as treatmentHistory, ");
        builder.append("a.investigationHistory as investigationHistory, ");
        builder.append("a.feedinghistory as feedinghistory, ");
        builder.append("a.pulse as pulse, ");
        builder.append("a.bp as bp, ");
        builder.append("a.rr as rr, ");
        builder.append("a.spo2 as spo2, ");
        builder.append("a.crt as crt, ");
        builder.append("a.temp as temp, ");
        builder.append("a.pallor as pallor, ");
        builder.append("a.clubbing as clubbing, ");
        builder.append("a.icterus as icterus, ");
        builder.append("a.cyanosis as cyanosis, ");
        builder.append("a.lymphadenopathy as lymphadenopathy, ");
        builder.append("a.edema as edema, ");
        builder.append("a.headtotoe as headtotoe, ");
        builder.append("a.oralcavity as oralcavity, ");
        builder.append("a.cvs as cvs, ");
        builder.append("a.rs as rs, ");
        builder.append("a.cns as cns, ");
        builder.append("a.abdo as abdo, ");
        builder.append("a.skin as skin, ");
        builder.append("a.musculoskeletal as musculoskeletal, ");
        builder.append("a.aditionalfindings as aditionalfindings, ");
        builder.append("a.allergy as allergy, ");
        builder.append("a.differentialDiagnosis as differentialDiagnosis,");
        builder.append("a.confirmedDiagnosis as confirmedDiagnosis ");
        builder.append(tableBuilder);
        this.tableSchema = tableBuilder.toString();
        this.schema = builder.toString();
    }

    public String schema() {
        return this.schema;
    }

    public String tableSchema() {
        return this.tableSchema;
    }

    @Override
    public PediatricCaseSheetData mapRow(ResultSet resultsRS, int i) throws SQLException {
        final Long id = resultsRS.getLong("id");
        final Long patId = resultsRS.getLong("patId");
        final Long visitId = resultsRS.getLong("visitId");
        final Long ipId = resultsRS.getLong("ipId");
        final String presentIllness = resultsRS.getString("presentIllness");
        final String pastHistory = resultsRS.getString("pastHistory");
        final String birthHistory = resultsRS.getString("birthHistory");
        final String personalHistory = resultsRS.getString("personalHistory");
        final String perinatalhistory = resultsRS.getString("perinatalhistory");
        final String treatmentHistory = resultsRS.getString("treatmentHistory");
        final String investigationHistory = resultsRS.getString("investigationHistory");
        final String feedinghistory = resultsRS.getString("feedinghistory");
        final String pulse = resultsRS.getString("pulse");
        final String bp = resultsRS.getString("bp");
        final String rr = resultsRS.getString("rr");
        final String spo2 = resultsRS.getString("spo2");
        final String crt = resultsRS.getString("crt");
        final String temp = resultsRS.getString("temp");
        final String pallor = resultsRS.getString("pallor");
        final String clubbing = resultsRS.getString("clubbing");
        final String icterus = resultsRS.getString("icterus");
        final String cyanosis = resultsRS.getString("cyanosis");
        final String lymphadenopathy = resultsRS.getString("lymphadenopathy");
        final String edema = resultsRS.getString("edema");
        final String headtotoe = resultsRS.getString("headtotoe");
        final String oralcavity = resultsRS.getString("oralcavity");
        final String cvs = resultsRS.getString("cvs");
        final String rs = resultsRS.getString("rs");
        final String cns = resultsRS.getString("cns");
        final String abdo = resultsRS.getString("abdo");
        final String skin = resultsRS.getString("skin");
        final String musculoskeletal = resultsRS.getString("musculoskeletal");
        final String aditionalfindings = resultsRS.getString("aditionalfindings");
        final String allergy = resultsRS.getString("allergy");
        final String differentialDiagnosis = resultsRS.getString("differentialDiagnosis");
        final String confirmedDiagnosis = resultsRS.getString("confirmedDiagnosis");

        return PediatricCaseSheetData.newInstance(id,patId,visitId,ipId,presentIllness,pastHistory,birthHistory,
                personalHistory,perinatalhistory,treatmentHistory,investigationHistory,feedinghistory,
                pulse, bp,rr,spo2,crt,temp,pallor,clubbing,icterus,
                cyanosis,lymphadenopathy,edema,headtotoe, oralcavity,cvs,rs,
                cns,abdo,skin,musculoskeletal,aditionalfindings,allergy,differentialDiagnosis,confirmedDiagnosis);
    }
}
