package com.ueniweb.swiftwaresolutions.rowmapper;
import com.ueniweb.swiftwaresolutions.data.PatientIpData;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class IpPatientsRowMapper implements RowMapper<PatientIpData> {

    private final String schema;

    private final String tableSchema;

    public IpPatientsRowMapper() {
        final StringBuilder tableBuilder = new StringBuilder(200);
        tableBuilder.append(" rec_patient_details a1 LEFT OUTER JOIN `rec_config_ad_village` vil ON vil.`id` = a1.`village_id` LEFT OUTER JOIN `rec_config_ad_post` po ON po.id = a1.`post_id` LEFT OUTER JOIN `rec_config_ad_district` di ON di.id = a1.`district_id` LEFT OUTER JOIN `rec_config_msc_gaurdian_type` g ON g.id = a1.`gtype`,rec_patient_opvisits a2,ip_visit a3,");
        tableBuilder.append(" ip_visit_details a4,ip_config_wards a5,ip_config_ward_details a6 ");

        final StringBuilder builder = new StringBuilder(200);

        builder.append("a1.display_number_2 as displayNumber,CONCAT(a1.name1,' ',name2) as name,calcAge(a1.dob) AS age,a3.opvisit_id AS visitId,a2.pat_id AS patientId,IF(a1.sex = 'M','Male','Female') AS gender,");
        builder.append("a3.display as ipNo,a5.name as ward,CONCAT(a6.type,' ',a6.name) as bedNo,DATE_FORMAT(a3.date,'%d-%m-%Y') AS admissionDate,");
        builder.append("IFNULL(DATE_FORMAT(a3.discharged_date,'%d-%m-%Y'),'') AS dDate,a2.doctor_id AS doctorId,a1.pat_id,a3.id AS ipId , CONCAT(vil.`name`,' ',po.`name`,' ', di.`name` ) AS address ,a1.gname1 AS guardianName ,g.name AS gType ");

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
    public PatientIpData mapRow(ResultSet rs, int i) throws SQLException {
        final String displayNumber = rs.getString("displayNumber");
        final String ipNo = rs.getString("ipNo");
        final Long ipId = rs.getLong("ipId");
        final String name = rs.getString("name");
        final String ward = rs.getString("ward");
        final String bedNo = rs.getString("bedNo");
        final String admissionDate = rs.getString("admissionDate");
        final Long visitId = rs.getLong("visitId");
        final Long patientId = rs.getLong("patientId");
        final String age = rs.getString("age");
        final String gender = rs.getString("gender");
        final Long doctorId = rs.getLong("doctorId");
        final String address = rs.getString("address");
        final String guardianName = rs.getString("guardianName");
        final String gType = rs.getString("gType");
        return PatientIpData.newInstance(displayNumber,ipNo,ipId,name,ward,bedNo,admissionDate,visitId,patientId,age,gender,doctorId,address,guardianName,gType);
    }
}
