package com.ueniweb.swiftwaresolutions.rowmapper;

import com.ueniweb.swiftwaresolutions.data.OPVitalsData;
import com.ueniweb.swiftwaresolutions.data.UnitData;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class OPVitalsRowMapper  implements RowMapper<OPVitalsData> {

    private final String schema;

    public OPVitalsRowMapper(){
        final StringBuilder builder = new StringBuilder(200);
        builder.append(" FROM cli_patient_vital_details a ");
        this.schema = builder.toString();
    }

    public String schema() {
        return this.schema;
    }

    public String tableSchema() {
        final StringBuilder builder = new StringBuilder(200);
        builder.append("a.id,a.patId,a.vstId,a.temperature,a.pulse,a.rr,a.bp,a.spo2,a.height,a.weight,a.bmi,a.dateTime,a.grbs ");
        builder.append(this.schema);
        return builder.toString();
    }

    @Override
    public OPVitalsData mapRow(ResultSet rs, int rowNum) throws SQLException {
        final Long id        = rs.getLong("id");
        final Long patId        = rs.getLong("patId");
        final Long vstId        = rs.getLong("vstId");
        final String temperature        = rs.getString("temperature");
        final String pulse        = rs.getString("pulse");
        final String rr        = rs.getString("rr");
        final String bp        = rs.getString("bp");
        final String spo2        = rs.getString("spo2");
        final String height        = rs.getString("height");
        final String weight        = rs.getString("weight");
        final String bmi        = rs.getString("bmi");
        final String datetime        = rs.getString("dateTime");
        final String grbs        = rs.getString("grbs");



        return OPVitalsData.createNewInstance(id,patId,vstId,temperature,pulse,rr,bp,spo2,height,weight,bmi,datetime,grbs);
    }
}
