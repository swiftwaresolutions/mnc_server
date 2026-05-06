package com.ueniweb.swiftwaresolutions.rowmapper;

import com.ueniweb.swiftwaresolutions.data.UnitData;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UnitRowMapper  implements RowMapper<UnitData>  {

    private final String schema;

    public UnitRowMapper(){
        final StringBuilder builder = new StringBuilder(200);
        builder.append(" FROM ph_prods_unit a ");
        this.schema = builder.toString();
    }

    public String schema() {
        return this.schema;
    }

    public String tableSchema() {
        final StringBuilder builder = new StringBuilder(200);
        builder.append("a.id, ");
        builder.append("a.name as unit,");
        builder.append("a.Type_ID as typeId ");
        builder.append(this.schema);
        return builder.toString();
    }

    @Override
    public UnitData mapRow(ResultSet rs, int rowNum) throws SQLException {
        final Integer id        = rs.getInt("id");
        final String unit       = rs.getString("unit");
        final Integer typeId    = rs.getInt("typeId");

        return UnitData.createNewInstance(id,unit,typeId);
    }
}
