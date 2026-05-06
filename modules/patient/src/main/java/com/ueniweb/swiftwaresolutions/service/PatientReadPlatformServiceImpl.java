package com.ueniweb.swiftwaresolutions.service;

import com.ueniweb.swiftwaresolutions.data.PatientData;
import com.ueniweb.swiftwaresolutions.data.PatientIpData;
import com.ueniweb.swiftwaresolutions.data.TransferData;
import com.ueniweb.swiftwaresolutions.rowmapper.IpPatientsRowMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class PatientReadPlatformServiceImpl implements PatientReadPlatformService {

    private final JdbcTemplate jdbcTemplate;

    @Override
    public List<PatientData> fetchAllPatientData() {

        try {

            String whereCondition =
                    " WHERE c.is_cardin_rack = 0 " +
                            " AND b.date = CURRENT_DATE " +
                            " AND c.loc_id = 1 " +
                            " ORDER BY b.date DESC, b.time DESC ";

            String qry =
                    " SELECT " +
                            " d.name as name, " +
                            " c.display_number as displayNumber, " +
                            " CONCAT(p.name1, ' ', p.name2) AS full_name, " +
                            " calcAge(p.dob) AS age, " +
                            " IF(p.sex = 'M', 'Male', 'Female') AS gender, " +
                            " b.token_no_doctor, " +
                            " TIME_FORMAT(b.time, '%h:%i %p') AS formatted_time, " +
                            " d.id AS doctor_id, " +
                            " c.id AS patient_id, " +
                            " b.id AS visit_id, " +
                            " b.isnew as isNew, " +
                            " dep.name AS departmentName, " +
                            " (CASE WHEN h.vstId IS NULL THEN 0 ELSE 1 END) AS casesheet_status, " +
                            " (CASE WHEN vital.id IS NULL THEN 0 ELSE 1 END) AS vital_status, " +
                            " p.add1 AS patientAddress, " +
                            " p.phone AS mobileNumber, " +
                            " dt.id as transfer_id, " +
                            " dt.from_doc, " +
                            " dt.to_doc, " +
                            " dt.is_completed, " +
                            " dt.next_review " +

                            " FROM rec_patient_details p " +
                            " INNER JOIN rec_patient_opvisits b ON p.pat_id = b.pat_id " +
                            " INNER JOIN rec_patient c ON b.pat_id = c.id " +
                            " INNER JOIN rec_config_msc_consultants d ON d.id = b.doctor_id " +
                            " LEFT JOIN rec_doctor_transfer dt ON dt.vst_id = b.id AND dt.is_cancelled = 0 " +
                            " LEFT JOIN rec_config_msc_departments dep ON dep.id = b.service_id " +
                            " LEFT JOIN cli_patient_general_casesheet h ON h.vstId = b.id " +
                            " LEFT JOIN cli_patient_vital_details vital ON b.id = vital.vstId " +

                            whereCondition;

            System.out.println("qry is " + qry);
            return jdbcTemplate.query(qry, rs -> {

                Map<Long, PatientData> patientMap = new LinkedHashMap<>();

                while (rs.next()) {

                    Long visitId = rs.getLong("visit_id");

                    PatientData patient = patientMap.get(visitId);

                    if (patient == null) {

                        patient = PatientData.newInstance(
                                rs.getString("name"),
                                rs.getString("displayNumber"),
                                rs.getString("full_name"),
                                rs.getString("age"),
                                rs.getString("gender"),
                                rs.getString("token_no_doctor"),
                                rs.getString("formatted_time"),
                                rs.getLong("doctor_id"),
                                rs.getLong("patient_id"),
                                visitId,
                                rs.getBoolean("isNew"),
                                rs.getInt("casesheet_status"),
                                0,  // labStatus
                                0,  // procStatus
                                0,  // prescriptionStatus
                                rs.getString("departmentName"),
                                rs.getInt("vital_status"),
                                rs.getString("patientAddress"),
                                rs.getString("mobileNumber"),
                                new ArrayList<>()
                        );

                        patientMap.put(visitId, patient);
                    }

                    Long transferId = rs.getLong("transfer_id");

                    if (!rs.wasNull()) {

                        TransferData transfer = new TransferData(
                                transferId,
                                rs.getLong("from_doc"),
                                rs.getLong("to_doc"),
                                rs.getLong("is_completed"),
                                rs.getString("next_review")
                        );

                        patient.getTransfers().add(transfer);
                    }
                }

                return new ArrayList<>(patientMap.values());
            });

        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public List<PatientData> fetchAllPatientDataForUser(Long uid, int pageSize, int page) {
        try {
            String whereCondition =
                    " WHERE c.is_cardin_rack = 0 " +
                            " AND b.date = CURRENT_DATE " +
                            " AND c.loc_id = 1 " +
                            " ORDER BY b.date DESC, b.time DESC ";

            // We left join x_temp_cash_bill and ph_prescription but only for rows that belong to the authenticated user (uid)
            // Compute labStatus: if x.id IS NULL => 0, else if x.is_billed = 1 => 2, else 1
            // Compute prescriptionStatus: if ph.id IS NULL => 0, else if ph.is_billed = 1 => 2, else if ph.isIssued = 1 THEN 3 else 1

            String qry =
                    " SELECT " +
                            " d.name as name, " +
                            " c.display_number as displayNumber, " +
                            " CONCAT(p.name1, ' ', p.name2) AS full_name, " +
                            " calcAge(p.dob) AS age, " +
                            " IF(p.sex = 'M', 'Male', 'Female') AS gender, " +
                            " b.token_no_doctor, " +
                            " TIME_FORMAT(b.time, '%h:%i %p') AS formatted_time, " +
                            " d.id AS doctor_id, " +
                            " c.id AS patient_id, " +
                            " b.id AS visit_id, " +
                            " b.isnew as isNew, " +
                            " dep.name AS departmentName, " +
                            " (CASE WHEN h.vstId IS NULL THEN 0 ELSE 1 END) AS casesheet_status, " +
                            " (CASE WHEN vital.id IS NULL THEN 0 ELSE 1 END) AS vital_status, " +
                            " p.add1 AS patientAddress, " +
                            " p.phone AS mobileNumber, " +
                            " dt.id as transfer_id, " +
                            // labStatus derived from x_temp_cash_bill (alias x)
                            " (CASE WHEN x.id IS NULL THEN 0 WHEN x.is_billed = 1 THEN 2 ELSE 1 END) AS labStatus, " +
                            // prescriptionStatus derived from ph_prescription (alias ph)
                            " (CASE WHEN ph.id IS NULL THEN 0 WHEN ph.isIssued = 1 THEN 3 WHEN ph.is_billed = 1 THEN 2 ELSE 1 END) AS prescriptionStatus, " +
                            " dt.from_doc, " +
                            " dt.to_doc, " +
                            " dt.is_completed, " +
                            " dt.next_review " +

                            " FROM rec_patient_details p " +
                            " INNER JOIN rec_patient_opvisits b ON p.pat_id = b.pat_id " +
                            " INNER JOIN rec_patient c ON b.pat_id = c.id " +
                            " INNER JOIN rec_config_msc_consultants d ON d.id = b.doctor_id " +
                            " LEFT JOIN rec_doctor_transfer dt ON dt.vst_id = b.id AND dt.is_cancelled = 0 " +
                            " LEFT JOIN rec_config_msc_departments dep ON dep.id = b.service_id " +
                            " LEFT JOIN cli_patient_general_casesheet h ON h.vstId = b.id " +
                            " LEFT JOIN cli_patient_vital_details vital ON b.id = vital.vstId " +
                            // left join x_temp_cash_bill for this user (uid) - use order_uid column from the table and ignore cancelled rows
                            " LEFT JOIN x_temp_cash_bill x ON x.visit_id = b.id AND x.order_uid = ? AND x.is_cancelled = 0 " +
                            // left join ph_prescription for this user (uid) and only valid prescriptions
                            " LEFT JOIN ph_prescription ph ON ph.visit_id = b.id AND ph.uid = ? AND ph.is_valid = 1 " +

                            whereCondition;

            System.out.println("qry is " + qry);

            // Use the ResultSetExtractor overload with varargs parameters to avoid deprecated signature
            return jdbcTemplate.query(qry, (rs) -> {

                Map<Long, PatientData> patientMap = new LinkedHashMap<>();

                while (rs.next()) {

                    Long visitId = rs.getLong("visit_id");

                    PatientData patient = patientMap.get(visitId);

                    if (patient == null) {

                        patient = PatientData.newInstance(
                                rs.getString("name"),
                                rs.getString("displayNumber"),
                                rs.getString("full_name"),
                                rs.getString("age"),
                                rs.getString("gender"),
                                rs.getString("token_no_doctor"),
                                rs.getString("formatted_time"),
                                rs.getLong("doctor_id"),
                                rs.getLong("patient_id"),
                                visitId,
                                rs.getBoolean("isNew"),
                                rs.getInt("casesheet_status"),
                                rs.getInt("labStatus"),
                                0,  // procStatus
                                rs.getInt("prescriptionStatus"),
                                rs.getString("departmentName"),
                                rs.getInt("vital_status"),
                                rs.getString("patientAddress"),
                                rs.getString("mobileNumber"),
                                new ArrayList<>()
                        );

                        patientMap.put(visitId, patient);
                    }

                    Long transferId = rs.getLong("transfer_id");

                    if (!rs.wasNull()) {

                        TransferData transfer = new TransferData(
                                transferId,
                                rs.getLong("from_doc"),
                                rs.getLong("to_doc"),
                                rs.getLong("is_completed"),
                                rs.getString("next_review")
                        );

                        patient.getTransfers().add(transfer);
                    }
                }

                return new ArrayList<>(patientMap.values());
            }, uid, uid);

        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public List<PatientIpData> fetchAllIpPatientData() {
        try {
            final IpPatientsRowMapper ipPatientsRowMapper = new IpPatientsRowMapper();
            String whereCondition = " a1.pat_id = a2.pat_id AND a2.id = a3.opvisit_id AND a3.id = a4.ip_id AND \n" +
                    "  a4.rb_id = a6.id AND a6.ward_id = a5.id AND a4.is_dis = 0 AND a3.is_dis = 0";
            String qry = " SELECT " + ipPatientsRowMapper.schema() + "FROM " + ipPatientsRowMapper.tableSchema() + "WHERE " + whereCondition;

            return this.jdbcTemplate.query(qry, ipPatientsRowMapper);

        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

}
