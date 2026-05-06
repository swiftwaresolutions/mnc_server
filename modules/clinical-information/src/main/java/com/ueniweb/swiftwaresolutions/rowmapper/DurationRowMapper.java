package com.ueniweb.swiftwaresolutions.rowmapper;

import com.ueniweb.swiftwaresolutions.data.DurationData;
import com.ueniweb.swiftwaresolutions.data.TimingData;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DurationRowMapper implements RowMapper<DurationData>  {

    private final String schema;

    public DurationRowMapper(){
        final StringBuilder builder = new StringBuilder(200);
        builder.append(" FROM ph_config_duration a ");
        this.schema = builder.toString();
    }

    public String schema() {
        return this.schema;
    }

    public String tableSchema() {
        final StringBuilder builder = new StringBuilder(200);
        builder.append("a.id, ");
        builder.append("a.name as duration,");
        builder.append("a.days ");
        builder.append(this.schema);
        return builder.toString();
    }

    @Override
    public DurationData mapRow(ResultSet rs, int rowNum) throws SQLException {
        final Integer id         = rs.getInt("id");
        final String duration    = rs.getString("duration");
        final Integer days       = rs.getInt("days");

        return DurationData.createNewInstance(id,duration,days);
    }
}
