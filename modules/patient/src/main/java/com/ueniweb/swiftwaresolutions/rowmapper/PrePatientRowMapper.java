package com.ueniweb.swiftwaresolutions.rowmapper;

import com.ueniweb.swiftwaresolutions.data.PrePatientData;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PrePatientRowMapper implements RowMapper<PrePatientData> {

    private final String schema;

    public PrePatientRowMapper(){
        final StringBuilder builder = new StringBuilder(200);
        builder.append(" FROM   `rec_patient` d,`rec_patient_details` b,`rec_patient_opvisits` a LEFT OUTER JOIN  `ip_visit` c  ON  c.`opvisit_id` = a.id  ");
       // builder.append(" `rec_patient_details` b, ");
        //builder.append(" `rec_patient_opvisits` a LEFT OUTER JOIN  `ip_visit` c  ON  c.`opvisit_id` = a.id");


        this.schema = builder.toString();
    }

    public String schema() {
        return this.schema;
    }


    public String tableSchema() {
        final StringBuilder builder = new StringBuilder(200);
        builder.append(" d.name AS NAME,calcAge(b.`dob`)  AS dob,b.`sex` AS sex,IFNULL( c.`date`, '#') AS admDate,\n" +
                "IFNULL( c.`discharged_date`, 'Not yet Discharged')AS dDate ,d.display_number ");
        builder.append(this.schema);
        return builder.toString();
    }

    @Override
    public PrePatientData mapRow(ResultSet rs, int rowNum) throws SQLException {
        final String name        = rs.getString("name");
        final String dob        = rs.getString("dob");
        final String sex        = rs.getString("sex");
        final String admDate        = rs.getString("admDate");
        final String dDate        = rs.getString("dDate");
        final String displayNumber        = rs.getString("display_number");


        return PrePatientData.createNewInstance(name, dob, sex, admDate, dDate,displayNumber);
    }
}
