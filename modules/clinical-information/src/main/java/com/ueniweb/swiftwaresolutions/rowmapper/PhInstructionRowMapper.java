package com.ueniweb.swiftwaresolutions.rowmapper;

import com.ueniweb.swiftwaresolutions.data.PhInstructionData;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PhInstructionRowMapper implements RowMapper<PhInstructionData>{
    @Override
    public PhInstructionData mapRow(ResultSet rs, int rowNum) throws SQLException {
        final int id = rs.getInt("id");
        final String name = rs.getString("name");
        return  PhInstructionData.createNewInstruction(id,name);
    }
}