package com.ueniweb.swiftwaresolutions.rowmapper;

import com.ueniweb.swiftwaresolutions.data.TemplateData;
import lombok.Data;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
@Data
public class OrderTemplateRowMapper implements RowMapper<TemplateData> {
    @Override
    public TemplateData mapRow(ResultSet rs, int rowNum) throws SQLException {
        final Integer id                = rs.getInt("id");
        final String templateName       = rs.getString("templateName");
        return TemplateData.createNewInstance(id,templateName);
    }

}
