package com.ueniweb.swiftwaresolutions.rowmapper;

import com.ueniweb.swiftwaresolutions.data.SurgeryData;
import com.ueniweb.swiftwaresolutions.data.SurgerySurgonData;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
public class SurgeryNameRowMapper implements RowMapper<SurgeryData> {
    private final String schema;

    public SurgeryNameRowMapper(){
        final StringBuilder builder = new StringBuilder(200);
        builder.append(" FROM cli_ot_surgeryname a");
        this.schema = builder.toString();
    }

    public String schema() {
        return this.schema;
    }

    public String tableSchema() {
        final StringBuilder builder = new StringBuilder(200);
        builder.append("a.id as id,a.surId as surId,a.surgeryName as surgeryName,a.isValid as isValid");
        builder.append(this.schema);
        return builder.toString();
    }
    @Override
    public SurgeryData mapRow(ResultSet rs,int rowNum) throws SQLException {
        final Long id = rs.getLong("id");
        final Long surId = rs.getLong("surId");
        final String surgeryName = rs.getString("surgeryName");
        final Long isValid = rs.getLong("isValid");

        return SurgeryData.createNewInstance(id,surId,surgeryName,isValid);
    }

}
