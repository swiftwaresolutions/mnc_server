package com.ueniweb.swiftwaresolutions.rowmapper;

import com.ueniweb.swiftwaresolutions.data.ClinicalModData;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ClinicalModRowmapper  implements RowMapper<ClinicalModData> {

    @Override
    public ClinicalModData mapRow(ResultSet rs, int i) throws SQLException {

        final String group = rs.getString("group");

        final String menuName = rs.getString("menuName");

        final String dispName = rs.getString("dispName");

        final String menuCode = rs.getString("menuCode");

        return ClinicalModData.newInstance(group,menuName,dispName,menuCode);
    }
}
