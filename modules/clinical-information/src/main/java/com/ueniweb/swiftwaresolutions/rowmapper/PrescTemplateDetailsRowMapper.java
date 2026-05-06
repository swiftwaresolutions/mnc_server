package com.ueniweb.swiftwaresolutions.rowmapper;

import com.ueniweb.swiftwaresolutions.data.LabResultData;
import com.ueniweb.swiftwaresolutions.data.PrescTemplateDetailsData;
import lombok.Data;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

@Data
public class PrescTemplateDetailsRowMapper  implements RowMapper<PrescTemplateDetailsData> {

    private final String schema;

    public PrescTemplateDetailsRowMapper(){
        final StringBuilder builder = new StringBuilder(200);
        builder.append("FROM ph_template_details a " );
        builder.append("LEFT OUTER JOIN ph_prods_unit h ON a.unit=h.id ");
        builder.append("LEFT OUTER JOIN nur_master_timing i ON a.timing=i.id ");
        builder.append("LEFT OUTER JOIN ph_config_duration j ON a.period=j.id ");
        builder.append("LEFT OUTER JOIN ph_config_instruction k ON a.instruction=k.id ");
        builder.append("LEFT OUTER JOIN ph_config_route l ON a.route=l.id,ph_template b,ph_generic d,ph_prods e ");
        builder.append("LEFT OUTER JOIN ph_prods_forms m ON e.`form_id`=m.`id` ,");
        builder.append("ph_batch n,ph_store_batch_totals o ");
        this.schema = builder.toString();
    }

    public String schema() {
        return this.schema;
    }

    public String tableSchema(Integer storeId) {
        final StringBuilder builder = new StringBuilder(200);
        builder.append("d.id AS genId,d.`name` AS genName,e.`id`,e.`name` AS medName,m.`form_type` AS formType,h.`name` AS unit,h.`id` AS unitId,\n" +
                " e.`strength` AS medStrength,e.`quantity` AS medQuantity,IFNULL(SUM(o.stock-getAvailableStockBatch(n.`id`,"+storeId+")),0)  AS stock,i.`name`AS timing,i.id AS timingId,a.`quantity`,a.`duration`,j.`name`AS period,\n" +
                " j.`id`AS periodId,a.`no`,getBatchMrpRate(e.`name`) as mrpPrice ,a.`timingUnit` ,l.id as routeId,l.name as route,k.id as instructionId , k.name as instruction ");
        builder.append(this.schema);
        return builder.toString();
    }

    @Override
    public PrescTemplateDetailsData mapRow(ResultSet rs, int rowNum) throws SQLException {

        final Long genId            = rs.getLong("genId");
        final String genName        = rs.getString("genName");
        final Long id               = rs.getLong("id");
        final String medName        = rs.getString("medName");
        final Long formType         = rs.getLong("formType");
        final String unit           = rs.getString("unit");
        final Long unitId           = rs.getLong("unitId");
        final Integer medStrength   = rs.getInt("medStrength");
        final Integer medQuantity   = rs.getInt("medQuantity");
        final Integer stock         = rs.getInt("stock");
        final String timing         = rs.getString("timing");
        final Long timingId         = rs.getLong("timingId");
        final Long quantity         = rs.getLong("quantity");
        final Double duration       = rs.getDouble("duration");
        final String period         = rs.getString("period");
        final Long periodId         = rs.getLong("periodId");
        final Double no             = rs.getDouble("no");
        final Double mrpPrice       = rs.getDouble("mrpPrice");
        final String timingUnit       = rs.getString("timingUnit");
        final int routeId       = rs.getInt("routeId");
        final String route       = rs.getString("route");
        final int instructionId       = rs.getInt("instructionId");
        final String instruction       = rs.getString("instruction");

        return PrescTemplateDetailsData.createNewInstance(genId,genName,id,medName,formType,unit,unitId,medStrength,medQuantity,stock,timing,timingId,quantity,duration,period,periodId,no,mrpPrice,timingUnit,routeId,route,instructionId,instruction);
    }
}
