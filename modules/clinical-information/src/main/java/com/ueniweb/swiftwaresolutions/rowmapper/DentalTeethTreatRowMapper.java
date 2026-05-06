package com.ueniweb.swiftwaresolutions.rowmapper;

import com.ueniweb.swiftwaresolutions.data.DentalTeethTreatData;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DentalTeethTreatRowMapper implements RowMapper<DentalTeethTreatData> {

    private final String schema;

    public DentalTeethTreatRowMapper(){
        final StringBuilder builder = new StringBuilder(200);
        builder.append(" FROM `cli_patient_teeth_treatments`a ");
        this.schema = builder.toString();
    }

    public String schema() {
        return this.schema;
    }

    public String tableSchema() {
        final StringBuilder builder = new StringBuilder(200);
        builder.append(" a.`id`,a.`toothnum`,a.teethdetails, a.teethType");
        builder.append(this.schema);
        return builder.toString();
    }

    @Override
    public DentalTeethTreatData mapRow(ResultSet rs, int rowNum) throws SQLException {
        final Integer id = rs.getInt("id");
        final String toothnum = rs.getString("toothnum");
        final String teethdetails = rs.getString("teethdetails");
        final Integer teethType = rs.getInt("teethType");


        return DentalTeethTreatData.createNewInstance(id,toothnum,teethdetails,teethType);
    }

}
