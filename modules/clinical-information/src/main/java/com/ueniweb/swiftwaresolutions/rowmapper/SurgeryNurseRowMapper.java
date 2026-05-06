package com.ueniweb.swiftwaresolutions.rowmapper;

import com.ueniweb.swiftwaresolutions.data.AntenatalPreData;
import com.ueniweb.swiftwaresolutions.data.ComplaintData;
import com.ueniweb.swiftwaresolutions.data.SurgeryNurseData;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
public class SurgeryNurseRowMapper implements RowMapper<SurgeryNurseData>{
    private final String schema;

    public SurgeryNurseRowMapper(){
        final StringBuilder builder = new StringBuilder(200);
        builder.append(" FROM cli_ot_nurse a ");
        this.schema = builder.toString();
    }

    public String schema() {
        return this.schema;
    }

    public String tableSchema() {
        final StringBuilder builder = new StringBuilder(200);
        builder.append("a.id as id, ");
        builder.append("a.surId as surId, ");
        builder.append("a.nurse as nurse, ");
        builder.append("a.isAssNurse as isAssNurse,");
        builder.append("a.isValid as isValid ");
        builder.append(this.schema);
        return builder.toString();
    }
    @Override
    public SurgeryNurseData mapRow(ResultSet rs, int rowNum) throws SQLException {
        final Long id = rs.getLong("id");
        final Long surId = rs.getLong("surId");
        final String nurse = rs.getString("nurse");
        final Long isAssNurse = rs.getLong("isAssNurse");
        final Long isValid = rs.getLong("isValid");


        return SurgeryNurseData.createNewInstance(id,surId,nurse,isAssNurse,isValid);
    }


}
