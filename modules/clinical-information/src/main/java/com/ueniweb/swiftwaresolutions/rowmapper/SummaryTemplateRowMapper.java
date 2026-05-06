package com.ueniweb.swiftwaresolutions.rowmapper;

import com.ueniweb.swiftwaresolutions.data.SummaryTemplateData;
import lombok.Data;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

@Data
public class SummaryTemplateRowMapper implements RowMapper<SummaryTemplateData> {
    @Override
    public SummaryTemplateData mapRow(ResultSet rs, int rowNum) throws SQLException {
        final Integer id                = rs.getInt("id");
        final String templateName       = rs.getString("name");
        final String details            = rs.getString("details");
        return SummaryTemplateData.createNewInstance(id,templateName,details);
    }
}
