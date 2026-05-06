package com.ueniweb.swiftwaresolutions.rowmapper;


import com.ueniweb.swiftwaresolutions.data.CaseSheetTemplateData;
import com.ueniweb.swiftwaresolutions.data.EqualantDrugsData;
import lombok.Data;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

@Data
public class EqualantDrugsRowMapper implements RowMapper<EqualantDrugsData> {

    @Override
    public EqualantDrugsData mapRow(ResultSet rs, int rowNum) throws SQLException {
        final Integer id        = rs.getInt("id");
        final String drugsName  = rs.getString("drugsName");

        return EqualantDrugsData.createNewInstance(id,drugsName);
    }
}
