package com.ueniweb.swiftwaresolutions.rowmapper;


import com.ueniweb.swiftwaresolutions.data.SurgerySurgonData;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
public class SurgerySergonRowMaper implements RowMapper<SurgerySurgonData>{
    private final String schema;

    public SurgerySergonRowMaper(){
        final StringBuilder builder = new StringBuilder(200);
        builder.append(" FROM cli_ot_surgon a, rec_config_msc_consultants b");
        this.schema = builder.toString();
    }

    public String schema() {
        return this.schema;
    }

    public String tableSchema() {
        final StringBuilder builder = new StringBuilder(200);
        builder.append("a.id as id,a.surgonId as surgonId,a.isAssSurgon as isAssSurgon,b.name as name");
        builder.append(this.schema);
        return builder.toString();
    }

    @Override
    public SurgerySurgonData mapRow(ResultSet rs,int rowNum) throws SQLException {
        final Long id = rs.getLong("id");
        final Long surgonId = rs.getLong("surgonId");
        final Long isAssSurgon = rs.getLong("isAssSurgon");
        final String name = rs.getString("name");


        return SurgerySurgonData.createNewInstance(id,surgonId,isAssSurgon,name);
    }


}
