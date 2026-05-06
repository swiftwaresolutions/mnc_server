package com.ueniweb.swiftwaresolutions.rowmapper;

import com.ueniweb.swiftwaresolutions.data.DentalCaseSheetData;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DentalCaseSheetRowMapper implements RowMapper<DentalCaseSheetData> {

    private final String schema;

    private final String tableSchema;

    public DentalCaseSheetRowMapper() {
        final StringBuilder tableBuilder = new StringBuilder(200);
        tableBuilder.append(" FROM cli_patient_dental_casesheet cs ");

        final StringBuilder builder = new StringBuilder(200);
        builder.append("cs.id as id, ");
        builder.append("cs.patId as patId, ");
        builder.append("cs.vstId as vstId, ");
        builder.append("cs.ipId as ipId, ");
        builder.append("cs.historyofpresentIllness as historyofpresentIllness, ");
        builder.append("cs.medicalHistory as medicalHistory, ");
        builder.append("cs.past_History as past_History, ");
        builder.append("cs.habitHistory as habitHistory, ");
        builder.append("cs.treatment_History as treatment_History, ");
        builder.append("cs.occupation as occupation, ");
        builder.append("cs.extraoralexamination as extraoralexamination, ");
        builder.append("cs.treatmentplan as treatmentplan, ");
        builder.append("cs.treatmentgeneral as treatmentgeneral ");
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
    public DentalCaseSheetData mapRow(ResultSet rs, int i) throws SQLException {
        final Long id = rs.getLong("id");
        final Long patId = rs.getLong("patId");
        final Long vstId = rs.getLong("vstId");
        final Long ipId = rs.getLong("ipId");
        final String historyofpresentIllness = rs.getString("historyofpresentIllness");
        final String medicalHistory = rs.getString("medicalHistory");
        final String past_History = rs.getString("past_History");
        final String habitHistory = rs.getString("habitHistory");
        final String treatment_History = rs.getString("treatment_History");
        final String occupation = rs.getString("occupation");
        final String extraoralexamination = rs.getString("extraoralexamination");
        final String treatmentplan = rs.getString("treatmentplan");
        final String treatmentgeneral = rs.getString("treatmentgeneral");

        return DentalCaseSheetData.createNewInstance(id, patId, vstId, ipId, historyofpresentIllness,
                medicalHistory, past_History, habitHistory, treatment_History, occupation, extraoralexamination,
                treatmentplan, treatmentgeneral
                );
    }
}