package com.ueniweb.swiftwaresolutions.rowmapper;

import com.ueniweb.swiftwaresolutions.data.AntenatalPreData;

import com.ueniweb.swiftwaresolutions.data.ComplaintData;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AntenatalPreRowMapper implements RowMapper<AntenatalPreData>{

    private final String schema;

    public AntenatalPreRowMapper(){
        final StringBuilder builder = new StringBuilder(200);
        builder.append(" FROM cli_antenatal_previous a ");
        this.schema = builder.toString();
    }

    public String schema() {
        return this.schema;
    }

    public String tableSchema() {
        final StringBuilder builder = new StringBuilder(200);
        builder.append("a.id as id, ");
        builder.append("a.ancId as ancId, ");
        builder.append("a.ChildNo as ChildNo, ");
        builder.append("a.YrOfBirth as YrOfBirth, ");
        builder.append("a.Gender as Gender, ");
        builder.append("a.PregDuration as PregDuration, ");
        builder.append("a.PlaceDelivery as PlaceDelivery, ");
        builder.append("a.ModeDelivery as ModeDelivery, ");
        builder.append("a.Birthweight as Birthweight, ");
        builder.append("a.ChildStatus as ChildStatus, ");
        builder.append("a.isValid as isValid ");
        builder.append(this.schema);
        return builder.toString();
    }
    @Override
    public AntenatalPreData mapRow(ResultSet rs, int rowNum) throws SQLException {
        final Long id = rs.getLong("id");
        final Long ancId = rs.getLong("ancId");
        final Long ChildNo = rs.getLong("ChildNo");
        final String YrOfBirth = rs.getString("YrOfBirth");
        final String Gender = rs.getString("Gender");
        final String PregDuration =rs.getString("PregDuration");
        final String PlaceDelivery = rs.getString("PlaceDelivery");
        final String ModeDelivery = rs.getString("ModeDelivery");
        final String Birthweight = rs.getString("Birthweight");
        final String ChildStatus = rs.getString("ChildStatus");
        final Long isValid = rs.getLong("isValid");


        return AntenatalPreData.createNewInstance(id, ancId, ChildNo, YrOfBirth, Gender,
                PregDuration, PlaceDelivery,  ModeDelivery,  Birthweight,
                ChildStatus,isValid);
    }



}
