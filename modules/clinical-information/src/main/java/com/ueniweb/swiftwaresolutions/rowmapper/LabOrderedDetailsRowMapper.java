package com.ueniweb.swiftwaresolutions.rowmapper;

import com.ueniweb.swiftwaresolutions.data.LabOrderedData;
import lombok.Data;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

@Data
public class LabOrderedDetailsRowMapper  implements RowMapper<LabOrderedData> {

    @Override
    public LabOrderedData mapRow(ResultSet rs, int rowNum) throws SQLException {
        final Integer id                = rs.getInt("id");
        final Integer patId       = rs.getInt("patId");
        final String testName       = rs.getString("testName");
        final Integer units       = rs.getInt("units");
        final String date       = rs.getString("date");
        final Long rate       = rs.getLong("rate");
        return LabOrderedData.createNewInstance(id,patId,testName,units,date,rate);
    }
}
