package com.ueniweb.swiftwaresolutions.rowmapper;

import com.ueniweb.swiftwaresolutions.data.DocPatientListData;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DocPatientListRowMapper implements RowMapper<DocPatientListData> {

    private final String schema;
    private final String tableSchema;

    public DocPatientListRowMapper() {
        final StringBuilder tableBuilder = new StringBuilder(500);
        tableBuilder.append(" FROM rec_doctor_transfer c ")
                .append(" LEFT JOIN rec_patient_opvisits b ON b.id = c.vst_id ")
                .append(" LEFT JOIN rec_patient a ON a.id = b.pat_id ")
                .append(" LEFT JOIN rec_patient_details d ON a.id = d.pat_id ")
                .append(" LEFT JOIN rec_config_msc_consultants td ON c.to_doc = td.id ")
                .append(" LEFT JOIN rec_config_msc_consultants fd ON c.from_doc = fd.id ");

        final String selectFields = "a.display_number AS displayNumber, " +
                "a.name AS patientName, " +
                "c.ent_dateTime AS entDateTime, " +
                "td.name AS doctorName, " +
                "fd.name AS referDoctor, " +
                "d.phone AS contactNumber, " +
                "TIMESTAMPDIFF(YEAR, d.dob, CURDATE()) AS age, " +
                "CASE c.is_completed " +
                    "WHEN 0 THEN 'Pending' " +
                    "WHEN 1 THEN 'In Progress' " +
                    "WHEN 2 THEN 'Completed' " +
                    "ELSE 'Unknown' END AS status " +
                tableBuilder;

        this.tableSchema = tableBuilder.toString();
        this.schema = selectFields;
    }

    public String schema() {
        return this.schema;
    }

    public String tableSchema() {
        return this.tableSchema;
    }

    @Override
    public DocPatientListData mapRow(ResultSet rs, int rowNum) throws SQLException {
        final String displayNumber = rs.getString("displayNumber");
        final String patientName   = rs.getString("patientName");
        final String entDateTime   = rs.getString("entDateTime");
        final String doctorName    = rs.getString("doctorName");
        final String referDoctor   = rs.getString("referDoctor");
        final String contactNumber = rs.getString("contactNumber");
        final String age           = rs.getString("age");
        final String status        = rs.getString("status");

        return DocPatientListData.newInstance(displayNumber, patientName, entDateTime,
                doctorName, referDoctor, contactNumber, age, status);
    }
}
