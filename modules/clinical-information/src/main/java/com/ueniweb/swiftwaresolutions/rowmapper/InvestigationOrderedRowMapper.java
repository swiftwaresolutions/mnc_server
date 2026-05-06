package com.ueniweb.swiftwaresolutions.rowmapper;

import com.ueniweb.swiftwaresolutions.data.InvestigationOrderedData;
import com.ueniweb.swiftwaresolutions.data.LabOrderedData;
import lombok.Data;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

@Data
public class InvestigationOrderedRowMapper  implements RowMapper<InvestigationOrderedData>  {

    @Override
    public InvestigationOrderedData mapRow(ResultSet rs, int rowNum) throws SQLException {
        final Integer id                = rs.getInt("id");
        final Integer patId       = rs.getInt("patId");
        final String pocName       = rs.getString("procName");
        final Integer units       = rs.getInt("units");
        final String date       = rs.getString("date");
        final Long rate       = rs.getLong("rate");
        return InvestigationOrderedData.createNewInstance(id,patId,pocName,units,date,rate);
    }
}
