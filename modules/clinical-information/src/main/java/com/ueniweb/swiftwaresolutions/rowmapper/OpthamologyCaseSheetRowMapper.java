package com.ueniweb.swiftwaresolutions.rowmapper;

import com.ueniweb.swiftwaresolutions.data.OpthamologyCaseSheetData;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class OpthamologyCaseSheetRowMapper implements RowMapper<OpthamologyCaseSheetData> {

    private final String schema;

    private final String tableSchema;

    public OpthamologyCaseSheetRowMapper() {

        final StringBuilder tableBuilder = new StringBuilder();
        tableBuilder.append(" FROM cli_patient_opthamology_casesheet cs ");

        final StringBuilder builder = new StringBuilder();
        builder.append("cs.id as id, ");
        builder.append("cs.patId as patId, ");
        builder.append("cs.vstId as vstId, ");
        builder.append("cs.ipId as ipId, ");
        builder.append("cs.consultantId as consultantId, ");
        builder.append("cs.dateTime as dateTime, ");
        builder.append("cs.presentIllness as presentIllness, ");
        builder.append("cs.pastHistory as pastHistory, ");
        builder.append("cs.allergy as allergy, ");
        builder.append("cs.temperature as temperature, ");
        builder.append("cs.pulse as pulse, ");
        builder.append("cs.rr as rr, ");
        builder.append("cs.bp as bp, ");
        builder.append("cs.spo2 as spo2, ");
        builder.append("cs.height as height, ");
        builder.append("cs.weight as weight, ");
        builder.append("cs.bmi as bmi, ");
        builder.append("cs.examination as examination, ");
        builder.append("cs.diagnosis as diagnosis, ");
        builder.append("cs.discussion as discussion, ");
        builder.append("cs.recomendations as recomendations, ");
        builder.append("cs.treatmentPlan as treatmentPlan, ");
        builder.append("cs.treatmentGiven as treatmentGiven, ");
        builder.append("cs.extra1 as extra1, ");
        builder.append("cs.extra2 as extra2, ");
        builder.append("cs.extra3 as extra3, ");
        builder.append("cs.extra4 as extra4, ");
        builder.append("cs.extra5 as extra5, ");
        builder.append("cs.isCancelled as isCancelled ");
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
    public OpthamologyCaseSheetData mapRow(ResultSet rs, int i) throws SQLException {
        final Long id = rs.getLong("id");
        final Long patId = rs.getLong("patId");
        final Long vstId = rs.getLong("vstId");
        final Long ipId = rs.getLong("ipId");
        final Long consultantId = rs.getLong("consultantId");
        final String dateTime = rs.getString("dateTime");
        final String presentIllness = rs.getString("presentIllness");
        final String pastHistory = rs.getString("pastHistory");
        final String allergy = rs.getString("allergy");
        final String temperature = rs.getString("temperature");
        final String pulse = rs.getString("pulse");
        final String rr = rs.getString("rr");
        final String bp = rs.getString("bp");
        final String spo2 = rs.getString("spo2");
        final String height = rs.getString("height");
        final String weight = rs.getString("weight");
        final String bmi = rs.getString("bmi");
        final String examination = rs.getString("examination");
        final String diagnosis = rs.getString("diagnosis");
        final String discussion = rs.getString("discussion");
        final String recomendations = rs.getString("recomendations");
        final String treatmentPlan = rs.getString("treatmentPlan");
        final String treatmentGiven = rs.getString("treatmentGiven");
        final String extra1 = rs.getString("extra1");
        final String extra2 = rs.getString("extra2");
        final String extra3 = rs.getString("extra3");
        final String extra4 = rs.getString("extra4");
        final String extra5 = rs.getString("extra5");
        final Long isCancelled = rs.getLong("isCancelled");

        return OpthamologyCaseSheetData.newInstance(id, patId, vstId, ipId, consultantId, dateTime, presentIllness, pastHistory, allergy,
                temperature, pulse, rr, bp, spo2, height, weight, bmi, examination, diagnosis, discussion, recomendations, treatmentPlan,
                treatmentGiven, extra1, extra2, extra3, extra4, extra5,isCancelled);

    }
}
