package com.ueniweb.swiftwaresolutions.rowmapper;

import com.ueniweb.swiftwaresolutions.data.AppointmentData;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AppointmentRowMapper implements RowMapper<AppointmentData> {

    private final String schema;

    private final String tableSchema;

    public AppointmentRowMapper () {

        final StringBuilder tableBuilder = new StringBuilder(200);
        tableBuilder.append(" FROM cli_patient_appointment a ");

        final StringBuilder builder = new StringBuilder(200);
        builder.append(" a.id as id,");
        builder.append(" a.appDate as appointmentDate,");
        builder.append(" a.appPlan as appointmentPlan ");
        builder.append(tableBuilder);
        this.tableSchema = tableBuilder.toString();
        this.schema = builder.toString();
    }


    public String schema() { return this.schema;}

    public String tableSchema() { return this.tableSchema;}

    @Override
    public AppointmentData mapRow(ResultSet rs, int rowNum) throws SQLException {
        final Long id = rs.getLong("id");
        final String appointmentDate = rs.getString("appointmentDate");
        final String appointmentPlan = rs.getString("appointmentPlan");

        return AppointmentData.NewInstance(id,appointmentDate,appointmentPlan);
    }
}
