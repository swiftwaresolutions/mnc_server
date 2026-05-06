package com.ueniweb.swiftwaresolutions.rowmapper;

import com.ueniweb.swiftwaresolutions.data.ComplaintDetailsData;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ComplaintDetailsRowMapper implements RowMapper<ComplaintDetailsData> {


    private final String schema;

    public ComplaintDetailsRowMapper(){
        final StringBuilder builder = new StringBuilder(200);
        builder.append(" FROM `cli_patient_complaint`a,rec_config_msc_complaint b  ");
        this.schema = builder.toString();
    }

    public String schema() {
        return this.schema;
    }

    public String tableSchema() {
        final StringBuilder builder = new StringBuilder(200);
        builder.append(" b.`id`,b.`name`,a.number AS no,a.`period` AS periods ");
        builder.append(this.schema);
        return builder.toString();
    }

    @Override
    public ComplaintDetailsData mapRow(ResultSet rs, int rowNum) throws SQLException {
        final Integer id = rs.getInt("id");
        final String name = rs.getString("name");
        final Double no = rs.getDouble("no");
        final String periods = rs.getString("periods");


        return ComplaintDetailsData.createNewInstance(id,name,no,periods);
    }
}
