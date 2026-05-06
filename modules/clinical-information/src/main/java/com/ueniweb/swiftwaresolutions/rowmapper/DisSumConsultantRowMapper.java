package com.ueniweb.swiftwaresolutions.rowmapper;

import com.ueniweb.swiftwaresolutions.data.DisSumConsultantData;
import lombok.Data;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

@Data
public class DisSumConsultantRowMapper implements RowMapper<DisSumConsultantData> {

    @Override
    public DisSumConsultantData mapRow(ResultSet rs, int rowNum) throws SQLException {
        final Long id                = rs.getLong("id");
        final Integer summaryId    = rs.getInt("summaryId");
        final Integer consultantId       = rs.getInt("consultantId");
        final String name              = rs.getString("name");

        return DisSumConsultantData.createNewInstance(id,summaryId,consultantId,name);
    }
}
