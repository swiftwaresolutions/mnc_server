package com.ueniweb.swiftwaresolutions.rowmapper;

import com.ueniweb.swiftwaresolutions.data.IpProcedureCaseSheetData;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class IpProcedureCaseSheetRowMapper implements RowMapper<IpProcedureCaseSheetData> {

    private final String schema;

    //private final String tableSchema;

    public IpProcedureCaseSheetRowMapper(){

//        final StringBuilder tableBuilder = new StringBuilder();
//        tableBuilder.append(" FROM cli_patient_ip_procedure_casesheet cs ");

        final StringBuilder builder = new StringBuilder(200);
        builder.append(" FROM cli_ipProcedure_casesheet a ");
        this.schema = builder.toString();
    }

    public String schema() { return this.schema; }

    public String tableSchema(){
        final StringBuilder builder = new StringBuilder(200);
        builder.append("a.id,a.patId,a.vstId,a.ipId,a.consultantId,a.date,a.time,a.temperature,a.pulse,a.rr,a.bp,a.spo2," +
                "a.height,a.weight,a.bmi,a.progressNotes,a.progressPlan,a.isCancelled ");
        builder.append(this.schema);
        return builder.toString();
    }

    @Override
    public IpProcedureCaseSheetData mapRow(ResultSet rs, int i) throws SQLException {
        final Long id              = rs.getLong("id");
        final Long patId           = rs.getLong("patId");
        final Long vstId           = rs.getLong("vstId");
        final Long ipId            = rs.getLong("ipId");
        final Long consultantId    = rs.getLong("consultantId");
        final String date          = rs.getString("date");
        final String time          = rs.getString("time");
        final String temperature   = rs.getString("temperature");
        final String pulse         = rs.getString("pulse");
        final String rr            = rs.getString("rr");
        final String bp            = rs.getString("bp");
        final String spo2          = rs.getString("spo2");
        final String height        = rs.getString("height");
        final String weight        = rs.getString("weight");
        final String bmi           = rs.getString("bmi");
        final String progressNotes = rs.getString("progressNotes");
        final String progressPlan  = rs.getString("progressPlan");
        final Long isCancelled     = rs.getLong("isCancelled");

        return IpProcedureCaseSheetData.newInstance(id, patId, vstId, ipId, consultantId, date, time, temperature,
                pulse, rr, bp, spo2, height, weight, bmi, progressNotes, progressPlan, isCancelled);
    }
}
