package com.ueniweb.swiftwaresolutions.rowmapper;

import com.ueniweb.swiftwaresolutions.data.ConsultantDetailsData;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class FetchConsultantRowMapper implements RowMapper<ConsultantDetailsData> {

    private final String schema;
    private final String tableSchema;

    public FetchConsultantRowMapper() {

        final StringBuilder tableBuilder = new StringBuilder();
        tableBuilder.append(" FROM rec_config_msc_consultants a ");
        tableBuilder.append(" LEFT JOIN rec_config_msc_consultants_leave l ON a.id = l.dr_id AND CURRENT_DATE BETWEEN l.from_date AND l.to_date  ");
        tableBuilder.append(" LEFT JOIN rec_config_msc_departments d ");
        tableBuilder.append("   ON a.dept_id = d.id ");
        tableBuilder.append(" JOIN cash_config_head c ");
        tableBuilder.append("   ON c.key_id = a.consultant_HIN ");
        tableBuilder.append("  AND c.is_blocked = 0 ");

        final StringBuilder builder = new StringBuilder();
        builder.append(" a.id AS consultantId, ");
        builder.append(" a.name AS consultantName, ");
        builder.append(" a.dept_id AS departmentId, ");
        builder.append(" d.name AS departmentName, ");
//        builder.append(" u.id AS userId, ");
        builder.append(" c.id AS particularId, ");
        builder.append(" c.grp AS groupId, ");
        builder.append(" c.rate AS consultationCharge ");

        builder.append(tableBuilder);

        this.schema = builder.toString();
        this.tableSchema = tableBuilder.toString();
    }

    public String schema() {
        return this.schema;
    }

    public String tableSchema() {
        return this.tableSchema;
    }

    @Override
    public ConsultantDetailsData mapRow(ResultSet rs, int rowNum) throws SQLException {

        return ConsultantDetailsData.newInstance(
                rs.getLong("consultantId"),
                rs.getString("consultantName"),
                rs.getLong("departmentId"),
                rs.getString("departmentName"),
                rs.getLong("particularId"),
                rs.getLong("groupId"),
                rs.getDouble("consultationCharge")
        );
    }

}
