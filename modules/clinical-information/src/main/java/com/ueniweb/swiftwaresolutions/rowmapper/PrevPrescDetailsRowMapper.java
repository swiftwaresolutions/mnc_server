package com.ueniweb.swiftwaresolutions.rowmapper;
import com.ueniweb.swiftwaresolutions.data.PrevPrescriptionDetailsData;
import lombok.Data;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

@Data
public class PrevPrescDetailsRowMapper  implements RowMapper<PrevPrescriptionDetailsData> {

    private final String schema;

    public PrevPrescDetailsRowMapper(){
        final StringBuilder builder = new StringBuilder(200);
        builder.append("FROM ph_prescription_details a " );
        builder.append("LEFT OUTER JOIN ph_prods_unit h ON a.unit=h.id ");
        builder.append("LEFT OUTER JOIN nur_master_timing i ON a.timing=i.id ");
        builder.append("LEFT OUTER JOIN ph_config_duration j ON a.period=j.id ");
        builder.append("LEFT OUTER JOIN ph_config_instruction k ON a.instruction=k.id ");
        builder.append("LEFT OUTER JOIN ph_config_route l ON a.route=l.id,ph_prescription b,ph_generic d, rec_config_msc_consultants c ,ph_prods e ");
        builder.append("LEFT OUTER JOIN ph_prods_forms m ON e.`form_id`=m.`id` ");

//        builder.append(" FROM ph_prescription_details a\n" +
//                "\n" +
//                "INNER JOIN ph_prescription b \n" +
//                "    ON a.prescription_id = b.id\n" +
//                "\n" +
//                "INNER JOIN ph_generic d \n" +
//                "    ON a.generic_id = d.id\n" +
//                "\n" +
//                "INNER JOIN ph_prods e \n" +
//                "    ON a.prods_id = e.id\n" +
//                "\n" +
//                "LEFT JOIN rec_config_msc_consultants c \n" +
//                "    ON c.id = b.doc_id\n" +
//                "\n" +
//                "LEFT JOIN ph_prods_unit h \n" +
//                "    ON a.unit = h.id\n" +
//                "\n" +
//                "LEFT JOIN nur_master_timing i \n" +
//                "    ON a.timing = i.id\n" +
//                "\n" +
//                "LEFT JOIN ph_config_duration j \n" +
//                "    ON a.period = j.id\n" +
//                "\n" +
//                "LEFT JOIN ph_config_instruction k \n" +
//                "    ON a.instruction = k.id\n" +
//                "\n" +
//                "LEFT JOIN ph_config_route l \n" +
//                "    ON a.route = l.id\n" +
//                "\n" +
//                "LEFT JOIN ph_prods_forms m \n" +
//                "    ON e.form_id = m.id ");

        this.schema = builder.toString();
    }


    public String schema() {
        return this.schema;
    }

    public String tableSchema(Integer storeId) {
        final StringBuilder builder = new StringBuilder(200);
        builder.append("b.display as displayNo,d.id AS genId,d.`name` AS genName,e.`id`,e.`name` AS medName,m.`form_type` AS formType,h.`name` AS unit,h.`id` AS unitId,\n" +
                " e.`strength` AS medStrength,e.`quantity` AS medQuantity,getStoreStock(e.id,"+storeId+")  AS stock,i.`name`AS timing,i.id AS timingId,a.`quantity`,a.`duration`,j.`name`AS period,\n" +
                " j.`id`AS periodId,a.`qno` as no,ifnull(a.timingUnits,'0-0-0-0') as timingUnit,getBatchMrpRate(e.`name`) as mrpPrice,a.is_own as own ,a.date AS DATE,b.isFromSummary,b.is_billed ,l.`id` AS routeId ,l.`name` AS route ,k.`id` AS instructionId,k.`name` AS instruction, a.notes as notes , b.visit_id as visitId, c.name as doctorName  ");
        builder.append(this.schema);
        return builder.toString();
    }

    @Override
    public PrevPrescriptionDetailsData mapRow(ResultSet rs, int rowNum) throws SQLException {

        final String displayNo        = rs.getString("displayNo");
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
        final Double quantity         = rs.getDouble("quantity");
        final Double duration       = rs.getDouble("duration");
        final String period         = rs.getString("period");
        final Long periodId         = rs.getLong("periodId");
        final Double no             = rs.getDouble("no");
        final String timingUnit     = rs.getString("timingUnit");
        final Double mrpPrice       = rs.getDouble("mrpPrice");
        final Integer own           =rs.getInt("own");
        final String date = rs.getString("date");
        final Integer isFromSummary = rs.getInt("isFromSummary");
        final Integer isBilled = rs.getInt("is_billed");
        final int routeId = rs.getInt("routeId");
        final String route = rs.getString("route");
        final int instructionId = rs.getInt("instructionId");
        final String instruction = rs.getString("instruction");
        final String notes = rs.getString("notes");
        final Long visitId = rs.getLong("visitId");
        final String doctorName = rs.getString("doctorName");


        return PrevPrescriptionDetailsData.createNewInstance(displayNo,genId,genName,id,medName,formType,unit,unitId,medStrength,medQuantity,stock,timing,timingId,quantity,duration,period,periodId,no,timingUnit,mrpPrice,own,date,isFromSummary,isBilled, routeId, route, instructionId, instruction,notes, visitId,doctorName);
    }
}
