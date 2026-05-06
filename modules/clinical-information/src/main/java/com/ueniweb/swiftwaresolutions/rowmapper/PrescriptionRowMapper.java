package com.ueniweb.swiftwaresolutions.rowmapper;

import com.ueniweb.swiftwaresolutions.data.PrescriptionData;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PrescriptionRowMapper implements RowMapper<PrescriptionData> {

    private final String schema;

    public PrescriptionRowMapper(){
        final StringBuilder builder = new StringBuilder(200);
        builder.append("FROM ph_prescription pr ");
        builder.append("INNER JOIN ph_prescription_details prd on pr.id=prd.prescription_id ");
        builder.append("INNER JOIN ph_prods pd on pd.id=prd.prods_id ");
        builder.append("LEFT OUTER JOIN nur_master_timing mt on prd.timing=mt.id ");
        builder.append("INNER JOIN ph_prods_unit u on u.id=prd.unit ");
        builder.append("LEFT OUTER JOIN ph_config_duration cd on cd.id=prd.period ");
        builder.append("LEFT OUTER JOIN ph_config_instruction k ON prd.instruction=k.id ");
        builder.append("LEFT OUTER JOIN ph_config_route l ON prd.route=l.id ");
        this.schema = builder.toString();
    }

    public String schema() {
        return this.schema;
    }

    public String tableSchema() {
        final StringBuilder builder = new StringBuilder(200);
        builder.append("prd.id AS id, ");
        builder.append("pr.display AS display, ");
        builder.append("pd.id AS prodsId,");
        builder.append("pd.name AS prodName, ");
        builder.append("prd.quantity AS quantity, ");
        builder.append("u.name AS unit, ");
        builder.append("mt.name AS timingName, ");
        builder.append("prd.duration as prescriptionDuration, ");
        builder.append("cd.name AS configDurationName,");
        builder.append("prd.timingUnits,prd.qno as totalNo, ");
        builder.append("prd.is_own ,");
        builder.append("k.`name` AS instruction ,");
        builder.append("l.`name` AS route ,");
        builder.append("prd.notes AS notes ");
        builder.append(this.schema);
        return builder.toString();
    }

    @Override
    public PrescriptionData mapRow(ResultSet rs, int rowNum) throws SQLException {
        final Long prodsId = rs.getLong("prodsId");
        final Long id = rs.getLong("id");
        final String display = rs.getString("display");
        final String prodName = rs.getString("prodName");
        final String quantity = rs.getString("quantity");
        final String unit = rs.getString("unit");
        final String timingName = rs.getString("timingName");
        final String prescriptionDuration = rs.getString("prescriptionDuration");
        final String configDurationName = rs.getString("configDurationName");
        final String timingUnits = rs.getString("timingUnits");
        final Integer totalNo    = rs.getInt("totalNo");
        final Integer isOwn    = rs.getInt("is_own");
        final String instruction    = rs.getString("instruction");
        final String route    = rs.getString("route");
        final String notes    = rs.getString("notes");
        return PrescriptionData.createNewInstance(id,prodsId, display,prodName, quantity, unit, timingName,
                prescriptionDuration,configDurationName,timingUnits,totalNo,isOwn,route,instruction,notes);
    }
}
