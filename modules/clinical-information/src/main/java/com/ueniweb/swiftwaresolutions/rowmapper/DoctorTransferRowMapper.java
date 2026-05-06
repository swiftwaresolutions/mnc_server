package com.ueniweb.swiftwaresolutions.rowmapper;

import com.ueniweb.swiftwaresolutions.data.DoctorTransferData;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DoctorTransferRowMapper implements RowMapper<DoctorTransferData> {

    private final String schema;

    private final String tableSchema;

    public DoctorTransferRowMapper() {
        final StringBuilder tableBuilder = new StringBuilder(200);
        tableBuilder.append(" FROM rec_doctor_transfer a\n" +
                "left JOIN rec_config_msc_consultants b ON a.from_doc = b.id\n" +
                "left JOIN rec_config_msc_consultants c ON a.to_doc = c.id  ");

        final StringBuilder builder = new StringBuilder(200);
        builder.append("a.id AS transferId, ");
        builder.append("b.name AS fromDoctor, ");
        builder.append("c.name AS toDoctor,  ");
        builder.append("a.is_completed AS isCompleted,  ");
        builder.append("a.next_review AS nextReview  ");

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
    public DoctorTransferData mapRow(ResultSet rs, int i) throws SQLException {
        final Long transferId = rs.getLong("transferId");
        final String fromDoctor = rs.getString("fromDoctor");
        final String toDoctor = rs.getString("toDoctor");
        final int isCompleted = rs.getInt("isCompleted");
        final String nextReview = rs.getString("nextReview");

        return DoctorTransferData.newInstance(transferId,fromDoctor , toDoctor ,isCompleted,nextReview);
    }
}
