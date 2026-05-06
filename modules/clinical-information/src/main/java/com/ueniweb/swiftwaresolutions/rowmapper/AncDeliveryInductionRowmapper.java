package com.ueniweb.swiftwaresolutions.rowmapper;

import com.ueniweb.swiftwaresolutions.data.AncDeliveryInductionData;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AncDeliveryInductionRowmapper  implements RowMapper<AncDeliveryInductionData> {

    private final String schema;

    private final String tableSchema;

    public AncDeliveryInductionRowmapper  (){

        final StringBuilder tableBuilder = new StringBuilder(200);
        tableBuilder.append(" FROM cli_anc_delivery_induction a ");

        final StringBuilder builder = new StringBuilder(200);
        builder.append("a.id as id,");
        builder.append("a.anc_Delivery_id as anc_Delivery_id,");
        builder.append("a.indDate as indDate ,");
        builder.append("a.indName as indName, ");
        builder.append("a.indNumber as indNumber, ");
        builder.append("a.indTime as indTime, ");
        builder.append("a.isValid as isValid ");

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
    public AncDeliveryInductionData mapRow(ResultSet rs, int i) throws SQLException {
        final Long id = rs.getLong("id");
        final Long anc_Delivery_id = rs.getLong("anc_Delivery_id");
        final String indDate =rs.getString("indDate");
        final String indName = rs.getString("indName");
        final Long indNumber = rs.getLong("indNumber");
        final String indTime = rs.getString("indTime");
        final Long isValid = rs.getLong("isValid");

        return AncDeliveryInductionData.createNewInstance( id, anc_Delivery_id, indDate, indName, indNumber, indTime,isValid);
    }
}
