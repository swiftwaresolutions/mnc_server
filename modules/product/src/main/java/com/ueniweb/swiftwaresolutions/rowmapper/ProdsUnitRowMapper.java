package com.ueniweb.swiftwaresolutions.rowmapper;


import com.ueniweb.swiftwaresolutions.data.CaseSheetTemplateData;
import com.ueniweb.swiftwaresolutions.data.ProdsUnitData;
import lombok.Data;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

@Data
public class ProdsUnitRowMapper implements RowMapper<ProdsUnitData> {

    @Override
    public ProdsUnitData mapRow(ResultSet rs, int rowNum) throws SQLException {
        final String units       = rs.getString("units");
        return ProdsUnitData.createNewInstance(units);
    }
}
