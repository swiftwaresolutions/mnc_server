package com.ueniweb.swiftwaresolutions.rowmapper;

import com.ueniweb.swiftwaresolutions.data.DisSumDeptData;
import lombok.Data;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

@Data
public class DisSumDeptRowMapper implements RowMapper<DisSumDeptData> {

    @Override
    public DisSumDeptData mapRow(ResultSet rs, int rowNum) throws SQLException {
        final Long id                = rs.getLong("id");
        final Integer summaryId    = rs.getInt("summaryId");
        final Integer deptId       = rs.getInt("deptId");
        final String name           = rs.getString("name");
        return DisSumDeptData.createNewInstance(id,summaryId,deptId,name);
    }
}
