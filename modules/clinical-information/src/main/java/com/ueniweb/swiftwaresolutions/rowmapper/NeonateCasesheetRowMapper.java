package com.ueniweb.swiftwaresolutions.rowmapper;

import com.ueniweb.swiftwaresolutions.data.NeonateCaseSheetData;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class NeonateCasesheetRowMapper implements RowMapper<NeonateCaseSheetData> {

    private final String schema;

    private final String tableSchema;

    public NeonateCasesheetRowMapper() {
        final StringBuilder tableBuilder = new StringBuilder(200);
        tableBuilder.append(" FROM cli_patient_neonate_casesheet a ");

        final StringBuilder builder = new StringBuilder(200);
        builder.append("a.id as id, ");
        builder.append("a.patId as patId, ");
        builder.append("a.vstId as visitId, ");
        builder.append("a.ipId as ipId,a.dobtob,a.placeofbirth, ");
        builder.append("a.presentIllness as presentIllness, ");
        builder.append("a.maternalhistory as maternalhistory, ");
        builder.append("a.birthHistory as birthHistory, ");
        builder.append("a.treatmentHistory as treatmentHistory, ");
        builder.append("a.investigationHistory as investigationHistory, ");
        builder.append("a.pulse as pulse, ");
        builder.append("a.bp as bp, ");
        builder.append("a.rr as rr, ");
        builder.append("a.spo2 as spo2, ");
        builder.append("a.crt as crt, ");
        builder.append("a.temp as temp, ");
        builder.append("a.pallor as pallor, ");
        builder.append("a.icterus as icterus, ");
        builder.append("a.cyanosis as cyanosis,a.cogenital, ");
        builder.append("a.headtotoe as headtotoe, ");
        builder.append("a.oralcavity as oralcavity, ");
        builder.append("a.cvs as cvs, ");
        builder.append("a.rs as rs, ");
        builder.append("a.abdo as abdo, ");
        builder.append("a.cns as cns, ");
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
    public NeonateCaseSheetData mapRow(ResultSet rs, int i) throws SQLException {
        final Long id = rs.getLong("id");
        final Long patId = rs.getLong("patId");
        final Long visitId = rs.getLong("visitId");
        final Long ipId = rs.getLong("ipId");
        final String dobTob = rs.getString("dobtob");
        final String placeofbirth =rs.getString("placeofbirth");
        final String presentIllness = rs.getString("presentIllness");
        final String maternalHistory = rs.getString("maternalhistory");
        final String birthHistory = rs.getString("birthHistory");
        final String treatmentHistory = rs.getString("treatmentHistory");
        final String investigationHistory = rs.getString("investigationHistory");
        final String pulse = rs.getString("pulse");
        final String bp = rs.getString("bp");
        final String rr = rs.getString("rr");
        final String spo2 = rs.getString("spo2");
        final String crt = rs.getString("crt");
        final String temp = rs.getString("temp");
        final String pallor = rs.getString("pallor");
        final String icterus = rs.getString("icterus");
        final String cyanosis = rs.getString("cyanosis");
        final String cogenital = rs.getString("cogenital");
        final String headtotoe = rs.getString("headtotoe");
        final String oralcavity = rs.getString("oralcavity");
        final String cvs = rs.getString("cvs");
        final String res = rs.getString("rs");
        final String abdo = rs.getString("abdo");
        final String cns = rs.getString("cns");
        final String skin = rs.getString("skin");
        final String musculoskeletal = rs.getString("musculoskeletal");
        final String aditionalfindings = rs.getString("aditionalfindings");
        final String allergy = rs.getString("allergy");
        final String differentialDiagnosis = rs.getString("differentialDiagnosis");
        final String confirmedDiagnosis = rs.getString("confirmedDiagnosis");

        return NeonateCaseSheetData.newInstance(id,patId,visitId,ipId,dobTob,placeofbirth,presentIllness, maternalHistory, birthHistory,
                treatmentHistory,  investigationHistory,  pulse,  bp,  rr,spo2,crt,temp,pallor,icterus,cyanosis,cogenital,
                headtotoe,  oralcavity,  cvs,  res,  abdo, cns,  skin,musculoskeletal,aditionalfindings,allergy,differentialDiagnosis,confirmedDiagnosis);
    }
}
