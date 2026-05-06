package com.ueniweb.swiftwaresolutions.rowmapper;

import com.ueniweb.swiftwaresolutions.data.PatientVisitData;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class VisitDetailsRowMapper implements RowMapper<PatientVisitData> {
    private final String schema;

    public VisitDetailsRowMapper() {
        final StringBuilder tableBuilder = new StringBuilder(200);
        tableBuilder.append(" FROM rec_patient_opvisits a ");
        tableBuilder.append("LEFT OUTER JOIN rec_config_msc_departments b ON a.`service_id` = b.`id` ");
        tableBuilder.append("LEFT OUTER JOIN rec_config_msc_consultants c ON a.`doctor_id` = c.`id` ");
        this.schema = "a.id AS visitId,a.`datetime` AS date,c.name AS doctorName,b.name AS departmentName " + tableBuilder;
//                "(CASE WHEN d.id IS NOT NULL THEN 1 ELSE 0 END) AS ancStatus" + tableBuilder;
    }

    public String schema() {
        return this.schema;
    }
    @Override
    public PatientVisitData mapRow(ResultSet rs, int i) throws SQLException {
        final Long visitId = rs.getLong("visitId");
        final String date = rs.getString("date");
        final String doctorName = rs.getString("doctorName");
        final String departmentName = rs.getString("departmentName");

        return PatientVisitData.newInstance(visitId, date, doctorName, departmentName);
    }
}
