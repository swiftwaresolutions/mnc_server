package com.ueniweb.swiftwaresolutions.rowmapper;

import com.ueniweb.swiftwaresolutions.data.OrganizationData;
import org.springframework.jdbc.core.RowMapper;


import java.sql.ResultSet;
import java.sql.SQLException;

public class OrganizationRowMapper implements RowMapper<OrganizationData> {
    private String schema;
    private String tableSchema;

    public String schema() {
        return this.schema;
    }

    public String tableSchema() {
        return this.tableSchema;
    }


    @Override
    public OrganizationData mapRow(ResultSet rs, int i) throws SQLException {

        final String name           = rs.getString("name");

        final String code           = rs.getString("code");

        final int port = rs.getInt("port");

        final Integer salesStoreId  = rs.getInt("salesStoreId");

        return OrganizationData.newInstance(name, code,port ,salesStoreId);
    }
}
