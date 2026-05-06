package com.ueniweb.swiftwaresolutions.rowmapper;

import com.ueniweb.swiftwaresolutions.data.AntenatelCaseSheetData;
import com.ueniweb.swiftwaresolutions.data.SurgeryCaseSheetData;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class SurgeryCaseSheetRowmapper  implements RowMapper<SurgeryCaseSheetData> {
    private final String schema;

    private final String tableSchema;

    public SurgeryCaseSheetRowmapper() {
        final StringBuilder tableBuilder = new StringBuilder(200);
        tableBuilder.append(" FROM cli_ot_surgery a ");

        final StringBuilder builder = new StringBuilder(200);
        builder.append("a.id as id, ");
        builder.append("a.patId as patId, ");
        builder.append("a.visitId as visitId , ");
        builder.append("a.ipId as ipId, ");
        builder.append("a.entDate as entDate, ");
        builder.append("a.entTime as entTime, ");
        builder.append("a.surgeryDate as surgeryDate, ");
        builder.append("a.surgeryTime as surgeryTime, ");
        builder.append("a.durSurgery as durSurgery, ");
        builder.append("a.preOtDiagnosis as preOtDiagnosis, ");
        builder.append("a.postOtDiagnosis as postOtDiagnosis, ");
        builder.append("a.DetSurgery as DetSurgery, ");
        builder.append("a.ProcedureNotes as ProcedureNotes, ");
        builder.append("a.ProgressNotes as ProgressNotes, ");
        builder.append("a.AnestDoc as AnestDoc ");

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
    public SurgeryCaseSheetData mapRow(ResultSet rs, int i) throws SQLException {
        final Long id = rs.getLong("id");
        final Long patId = rs.getLong("patId");
        final Long visitId = rs.getLong("visitId");
        final Long ipId = rs.getLong("ipId");
        final String entDate = rs.getString("entDate");
        final String entTime =rs.getString("entTime");
        final String surgeryDate = rs.getString("surgeryDate");
        final String surgeryTime = rs.getString("surgeryTime");
        final String durSurgery = rs.getString("durSurgery");
        final String preOtDiagnosis = rs.getString("preOtDiagnosis");
        final String postOtDiagnosis = rs.getString("postOtDiagnosis");
        final String DetSurgery = rs.getString("DetSurgery");
        final String ProcedureNotes = rs.getString("ProcedureNotes");
        final String ProgressNotes = rs.getString("ProgressNotes");
        final String AnestDoc = rs.getString("AnestDoc");


        return SurgeryCaseSheetData.newInstance(id,patId,visitId,ipId,entDate, entTime, surgeryDate,surgeryTime,
                durSurgery, preOtDiagnosis, postOtDiagnosis,DetSurgery,ProcedureNotes,ProgressNotes,AnestDoc);
    }
}
