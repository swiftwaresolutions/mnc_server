package com.ueniweb.swiftwaresolutions.rowmapper;

import com.ueniweb.swiftwaresolutions.data.AncChildDetialsData;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AncChildDetialsRowmapper implements RowMapper<AncChildDetialsData> {
    private final String schema;

    private final String tableSchema;

    public AncChildDetialsRowmapper  (){

        final StringBuilder tableBuilder = new StringBuilder(200);
        tableBuilder.append(" FROM cli_anc_child a ");

        final StringBuilder builder = new StringBuilder(200);
        builder.append("a.id as id,");
        builder.append("a.anc_id as anc_id,");
        builder.append("a.status as status ,");
        builder.append("a.birthdate as birthdate, ");
        builder.append("a.type as type, ");
        builder.append("a.mode as mode, ");
        builder.append("a.place as place, ");
        builder.append("a.others as others ,");
        builder.append("a.sex as sex ,");
        builder.append("a.isValid as isValid , ");
        builder.append("a.riskFacOfThisPre as riskFacOfThisPre ");


        builder.append(tableBuilder);
        this.tableSchema = tableBuilder.toString();
        this.schema = builder.toString();
    }
    public String schema() {
        return this.schema;
    }

    public String tableSchema() {
        return this.tableSchema;
    }

    @Override
    public AncChildDetialsData mapRow(ResultSet rs, int i) throws SQLException {
        final Long id = rs.getLong("id");
        final Long anc_id = rs.getLong("anc_id");
        final Long status = rs.getLong("status");
        final Long type = rs.getLong("type");
        final String birthdate =rs.getString("birthdate");
        final String mode = rs.getString("mode");
        final String place = rs.getString("place");
        final String others = rs.getString("others");
        final Long isValid = rs.getLong("isValid");
        final Long sex = rs.getLong("sex");
        final String riskFacOfThisPre = rs.getString("riskFacOfThisPre");

        return AncChildDetialsData.createNewInstance(  id,  anc_id,  status,  type,  birthdate,  mode,  place,  others,isValid,sex,riskFacOfThisPre);
    }
}
