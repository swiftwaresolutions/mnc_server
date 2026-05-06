package com.ueniweb.swiftwaresolutions.rowmapper;

import com.ueniweb.swiftwaresolutions.data.DischargeSummaryData;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DischargeSummaryRowMapper implements RowMapper<DischargeSummaryData> {

    private final String schema;

    private final String tableSchema;

    public DischargeSummaryRowMapper() {
        final StringBuilder tableBuilder = new StringBuilder(200);
        tableBuilder.append(" FROM cli_discharge_summary cs LEFT OUTER JOIN rec_config_msc_consultants con ON cs.consultantId = con.`id`");

        final StringBuilder builder = new StringBuilder(200);
        builder.append("cs.id as id, ");
        builder.append("cs.patId as patId, ");
        builder.append("cs.vstId as vstId, ");
        builder.append("cs.ipId as ipId, ");
        builder.append("cs.consultantId as consultantId, ");
        builder.append("con.name AS consultantName, ");
        builder.append("cs.diagnosis as diagnosis, ");
        builder.append("cs.history as history, ");
        builder.append("cs.examination as examination, ");
        builder.append("cs.treatment as treatment, ");
        builder.append("cs.hospitalCourse as courseInTheHospital, ");
        builder.append("cs.operationFindings as operativeFindings, ");
        builder.append("cs.disCondition as conditionOfPatient, ");
        builder.append("cs.emergencyIndication as emergencyIndication, ");
        builder.append("cs.advice as dischargeAdvice, ");
        builder.append("cs.gynaecology as gynaecology, ");
        builder.append("cs.obstetrics as obstetrics, ");
        builder.append("cs.neonatal as neonatal, ");
        builder.append("cs.babyDetails as babyDetail, ");
        builder.append("cs.date as date, ");
        builder.append("cs.time as time, ");
        builder.append("cs.uId as uId, ");
        builder.append("cs.reviewDTM as reviewDTM, ");
        builder.append("cs.isActive as is_active, ");
        builder.append("cs.outSideMedicine as outSideMedicine ");

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
    public DischargeSummaryData mapRow(ResultSet rs, int i) throws SQLException {
        final Long id = rs.getLong("id");
        final Long patId = rs.getLong("patId");
        final Long vstId = rs.getLong("vstId");
        final Long ipId = rs.getLong("ipId");
        final Long consultantId = rs.getLong("consultantId");
        final String consultantName = rs.getString("consultantName");
        final String diagnosis = rs.getString("diagnosis");
        final String history = rs.getString("history");
        final String examination = rs.getString("examination");
        final String treatment = rs.getString("treatment");
        final String courseInTheHospital = rs.getString("courseInTheHospital");
        final String operativeFindings = rs.getString("operativeFindings");
        final String conditionOfPatient = rs.getString("conditionOfPatient");
        final String emergencyIndication = rs.getString("emergencyIndication");
        final String dischargeAdvice = rs.getString("dischargeAdvice");
        final String gynaecology = rs.getString("gynaecology");
        final String obstetrics = rs.getString("obstetrics");
        final String neonatal = rs.getString("neonatal");
        final String babyDetail = rs.getString("babyDetail");
        final String date = rs.getString("date");
        final String time = rs.getString("time");
        final Long uId = rs.getLong("uId");
        final String reviewDTM = rs.getString("reviewDTM");
        final Long is_active = rs.getLong("is_active");
        final String outSideMedicine = rs.getString("outSideMedicine");


        return DischargeSummaryData.createNewInstance(id, patId, vstId, ipId, consultantId,consultantName, diagnosis,
                history, examination, treatment, courseInTheHospital, operativeFindings, conditionOfPatient, emergencyIndication,
                dischargeAdvice, gynaecology, obstetrics, neonatal, babyDetail, date, time, uId, reviewDTM, is_active,outSideMedicine
        );
    }
}
