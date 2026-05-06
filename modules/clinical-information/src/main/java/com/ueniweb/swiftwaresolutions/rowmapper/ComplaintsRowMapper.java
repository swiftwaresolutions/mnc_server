package com.ueniweb.swiftwaresolutions.rowmapper;

import com.ueniweb.swiftwaresolutions.data.ComplaintData;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ComplaintsRowMapper implements RowMapper<ComplaintData> {

    private final String schema;

    public ComplaintsRowMapper(){
        final StringBuilder builder = new StringBuilder(200);
        builder.append(" FROM rec_config_msc_complaint a ");
        this.schema = builder.toString();
    }

    public String schema() {
        return this.schema;
    }

    public String tableSchema() {
        final StringBuilder builder = new StringBuilder(200);
        builder.append("a.id, ");
        builder.append("a.name as complaint ");
        builder.append(this.schema);
        return builder.toString();
    }

    @Override
    public ComplaintData mapRow(ResultSet rs, int rowNum) throws SQLException {
        final Integer id = rs.getInt("id");
        final String complaint = rs.getString("complaint");

        return ComplaintData.createNewInstance(id,complaint);
    }
}
