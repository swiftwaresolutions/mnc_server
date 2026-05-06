package com.ueniweb.swiftwaresolutions.rowmapper;

import com.ueniweb.swiftwaresolutions.data.PatientData;
import com.ueniweb.swiftwaresolutions.data.TransferData;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PatientRowMapper implements RowMapper<PatientData> {

    private final String schema;

    private final String tableSchema;

    public PatientRowMapper() {
        final StringBuilder tableBuilder = new StringBuilder(200);
        tableBuilder.append(" FROM rec_patient_details p ");
        tableBuilder.append(" INNER JOIN rec_patient_opvisits b ON p.pat_id = b.pat_id ");
        tableBuilder.append(" INNER JOIN rec_patient c ON b.pat_id = c.id \n");
        tableBuilder.append(" INNER JOIN rec_config_msc_consultants d ON d.id = b.doctor_id ");
        tableBuilder.append(" LEFT OUTER JOIN admin_users u ON u.doctor_id = d.id \n");
        tableBuilder.append(" LEFT OUTER JOIN x_temp_lab_bill_details e ON e.pat_id = p.pat_id AND DATE(e.dtm) = CURRENT_DATE");
        tableBuilder.append(" LEFT OUTER JOIN lab_test_reg f ON f.final_bill_id = e.finalBillId \n");
        tableBuilder.append(" LEFT OUTER JOIN x_temp_cash_bill_details i ON i.pat_id = p.pat_id ");
        tableBuilder.append(" LEFT OUTER JOIN ph_prescription j ON j.visit_id = b.id \n");
        tableBuilder.append(" LEFT OUTER JOIN cli_patient_general_casesheet h ON h.vstId = b.id ");
        tableBuilder.append(" LEFT OUTER JOIN rec_config_msc_departments dep ON dep.id = b.service_id \n");
        tableBuilder.append(" LEFT OUTER JOIN `cli_patient_vital_details` vital ON b.id = vital.vstId \n");
        tableBuilder.append(" LEFT JOIN rec_doctor_transfer dt \n" +
                "    ON dt.vst_id = b.id AND dt.is_cancelled = 0\n ");


        final StringBuilder builder = new StringBuilder(200);

        builder.append("d.name as name, ");
        builder.append("c.display_number as displayNumber, ");
        builder.append("c.name as name, ");
        builder.append("CONCAT(p.name1, ' ', p.name2) AS full_name, ");
        builder.append("calcAge(p.dob) AS age, ");
        builder.append("IF(p.sex = 'M', 'Male', 'Female') AS gender, ");
        builder.append("b.token_no_doctor, ");
        builder.append("TIME_FORMAT(b.time, '%h:%i %p') AS formatted_time, ");
        builder.append("d.id AS doctor_id, ");
        builder.append("c.id AS patient_id, ");
        builder.append("b.id AS visit_id, ");
        builder.append("b.isnew as isNew, \n");
        builder.append("dep.name AS departmentName, ");
        builder.append("(CASE WHEN h.vstId IS NULL THEN 0 WHEN h.vstId = b.id THEN 1 ELSE 0 END) AS casesheet_status, \n");
        builder.append("CASE WHEN (MAX(f.`isdone`)> 0 AND DATE(f.`ent_date`)=CURRENT_DATE) THEN 2 WHEN (e.`pat_id` AND DATE(e.`dtm`)=CURRENT_DATE) THEN 1 ELSE 0 END AS lab_status, \n") ;
        builder.append("(CASE WHEN i.pat_id IS NULL THEN 0 WHEN i.finalBillId = 0 THEN 1 ELSE 2 END) AS proc_status, \n");
        builder.append("(CASE WHEN j.pat_id IS NULL THEN 0 WHEN j.final_bill_id > 0 THEN 2 ELSE 1 END) AS prescription_status, \n");
        builder.append("(CASE WHEN vital.id IS NULL THEN 0 ELSE 1 END) AS vital_status, ");
        builder.append(" p.add1 AS patientAddress, p.phone AS mobileNumber, ");
        builder.append(
                "COALESCE(\n" +
                        "    CONCAT(\n" +
                        "        '[',\n" +
                        "        GROUP_CONCAT(\n" +
                        "            DISTINCT CONCAT(\n" +
                        "                '{',\n" +
                        "                '\"id\":', dt.id, ',',\n" +
                        "                '\"from_doc\":', dt.from_doc, ',',\n" +
                        "                '\"to_doc\":', dt.to_doc, ',',\n" +
                        "                '\"is_completed\":', dt.is_completed,\n" +
                        "                '}'\n" +
                        "            )\n" +
                        "            ORDER BY dt.ent_dateTime\n" +
                        "            SEPARATOR ','\n" +
                        "        ),\n" +
                        "        ']'\n" +
                        "    ),\n" +
                        "    '[]'\n" +
                        ") AS transfers  "
        );


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
    public PatientData mapRow(ResultSet rs, int i) throws SQLException {
        final String name = rs.getString("name");
        final String displayNumber = rs.getString("displayNumber");
        final String fullName = rs.getString("full_name");
        final String age = rs.getString("age");
        final String gender = rs.getString("gender");
        final String tokenNoDoctor = rs.getString("token_no_doctor");
        final String formattedTime = rs.getString("formatted_time");
        final Long doctorId = rs.getLong("doctor_id");
        final Long patientId = rs.getLong("patient_id");
        final Long visitId = rs.getLong("visit_id");
        final boolean isNew = rs.getBoolean("isNew");
        final int casesheetStatus = rs.getInt("casesheet_status");
        final int labStatus = rs.getInt("lab_status");
        final int procStatus = rs.getInt("proc_status");
        final int prescriptionStatus = rs.getInt("prescription_status");
        final int vitalStatus = rs.getInt("vital_status");
        final String departmentName = rs.getString("departmentName");
        final String patientAddress = rs.getString("patientAddress");
        final String mobileNumber = rs.getString("mobileNumber");
        List<TransferData> transfers = new ArrayList<>();

        return PatientData.newInstance(name, displayNumber, fullName, age, gender, tokenNoDoctor, formattedTime,
                doctorId, patientId, visitId, isNew, casesheetStatus, labStatus, procStatus,
                prescriptionStatus, departmentName,vitalStatus,patientAddress,mobileNumber,transfers);
    }

}