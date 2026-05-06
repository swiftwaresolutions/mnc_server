package com.ueniweb.swiftwaresolutions.rowmapper;

import com.ueniweb.swiftwaresolutions.data.GenericData;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class GenericRowMapper implements RowMapper<GenericData> {

    private final String schema;

    public GenericRowMapper(){
        final StringBuilder builder = new StringBuilder(200);
        builder.append(" FROM ph_generic a ");
        this.schema = builder.toString();
    }

    public String schema() {
        return this.schema;
    }

    public String tableSchema() {
        final StringBuilder builder = new StringBuilder(200);
        builder.append("a.id, ");
        builder.append("a.name as generic ");
        builder.append(this.schema);
        return builder.toString();
    }

   @Override
    public GenericData mapRow(ResultSet rs, int rowNum) throws SQLException {
        final Integer id = rs.getInt("id");
        final String generic = rs.getString("generic");

        return GenericData.createNewInstance(id,generic);
    }
}
