package com.ueniweb.swiftwaresolutions.rowmapper;

import com.ueniweb.swiftwaresolutions.data.CaseSheetTemplateData;
import lombok.Data;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

@Data
public class CaseSheetTemplateRowMapper implements RowMapper<CaseSheetTemplateData>  {

    @Override
    public CaseSheetTemplateData mapRow(ResultSet rs, int rowNum) throws SQLException {
        final Integer id                = rs.getInt("id");
        final String templateName       = rs.getString("templateName");
        final String templateDetails    = rs.getString("templateDetails");
        return CaseSheetTemplateData.createNewInstance(id,templateName,templateDetails);
    }
}
