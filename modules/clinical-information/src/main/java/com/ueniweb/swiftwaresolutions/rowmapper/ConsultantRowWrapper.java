package com.ueniweb.swiftwaresolutions.rowmapper;

import com.ueniweb.swiftwaresolutions.data.ConsultantData;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ConsultantRowWrapper implements RowMapper<ConsultantData>  {

    private final String schema;

    public ConsultantRowWrapper(){
        final StringBuilder builder = new StringBuilder(200);
        builder.append(" FROM rec_config_msc_consultants a ");
        this.schema = builder.toString();
    }

    public String schema() {
        return this.schema;
    }

    public String tableSchema() {
        final StringBuilder builder = new StringBuilder(200);
        builder.append("a.id, ");
        builder.append("a.name as consultant ");
        builder.append(this.schema);
        return builder.toString();
    }

    @Override
    public ConsultantData mapRow(ResultSet rs, int rowNum) throws SQLException {
        final Integer id        = rs.getInt("id");
        final String consultant = rs.getString("consultant");

        return ConsultantData.createNewInstance(id,consultant);
    }
}
