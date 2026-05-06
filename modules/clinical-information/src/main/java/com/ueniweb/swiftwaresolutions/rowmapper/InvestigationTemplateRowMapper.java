package com.ueniweb.swiftwaresolutions.rowmapper;

import com.ueniweb.swiftwaresolutions.data.InvestigationData;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class InvestigationTemplateRowMapper implements RowMapper<InvestigationData> {

    private final String schema;

    public InvestigationTemplateRowMapper(){
        final StringBuilder builder = new StringBuilder(200);
        builder.append(" FROM cash_config_head a1,cash_config_head_rates a3,cash_config_head a2,cli_investigation_template_details a4 ");
        this.schema = builder.toString();
    }

    public String schema() {
        return this.schema;
    }

    public String tableSchema() {
        final StringBuilder builder = new StringBuilder(200);
        builder.append("a1.id AS groupId, ");
        builder.append("a2.id AS id, ");
        builder.append("a1.iseditable AS editable, ");
        builder.append("a1.name AS name1, ");
        builder.append("a2.name AS name, ");
        builder.append("a3.rate, ");
        builder.append("a3.charity,");
        builder.append("'I' AS label ");
        builder.append(this.schema);
        return builder.toString();
    }

    @Override
    public InvestigationData mapRow(ResultSet rs, int rowNum) throws SQLException {
        final Integer groupId = rs.getInt("groupId");
        final Integer id = rs.getInt("id");
        final boolean editable = rs.getBoolean("editable");
        final String name1 = rs.getString("name1");
        final String name = rs.getString("name");
        final Double rate = rs.getDouble("rate");
        final Double charity = rs.getDouble("charity");
        final String label    = rs.getString("label");

        return InvestigationData.createNewInstance(groupId, id, editable, name1, name, rate, charity,label);
    }
}
