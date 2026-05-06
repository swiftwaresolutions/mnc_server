package com.ueniweb.swiftwaresolutions.rowmapper;

import com.ueniweb.swiftwaresolutions.data.AncDeliveryData;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AncDeliveryDetialsRowmapper  implements RowMapper<AncDeliveryData> {
    private final String schema;

    private final String tableSchema;
    public AncDeliveryDetialsRowmapper() {
        final StringBuilder tableBuilder = new StringBuilder(200);
        tableBuilder.append(" FROM cli_anc_delivery_entry a ");

        final StringBuilder builder = new StringBuilder(200);
        builder.append("a.id as id, ");
        builder.append("a.patId as patId, ");
        builder.append("a.vstId as vstId , ");
        builder.append("a.Mins1 as Mins1, ");
        builder.append("a.Mins5 as Mins5, ");
        builder.append("a.augmentation as augmentation, ");
        builder.append("a.birth as birth, ");
        builder.append("a.birthWeight as birthWeight, ");
        builder.append("a.complication as complication, ");
        builder.append("a.deliveryDoc as deliveryDoc, ");
        builder.append("a.doa as doa, ");
        builder.append("a.dod as dod, ");
        builder.append("a.dob as dob, ");
        builder.append("a.indication as indication, ");
        builder.append("a.liquor as liquor, ");
        builder.append("a.modeDelivery as modeDelivery, ");
        builder.append("a.other as other, ");
        builder.append("a.overais as overais, ");
        builder.append("a.presentation as presentation, ");
        builder.append("a.riskFactor as riskFactor, ");
        builder.append("a.sex as sex, ");
        builder.append("a.toa as toa, ");
        builder.append("a.tob as tob, ");
        builder.append("a.tod as tod, ");
        builder.append("a.uterus as uterus ");

        builder.append(tableBuilder);
        this.tableSchema = tableBuilder.toString();
        this.schema = builder.toString();
    }
    public String schema() {
        return this.schema;
    }

    public String tableSchema() {
        return this.tableSchema;
    }

    @Override
    public AncDeliveryData mapRow(ResultSet rs, int i) throws SQLException {
        final Long id = rs.getLong("id");
        final Long patId = rs.getLong("patId");
        final Long vstId = rs.getLong("vstId");
        final String Mins1 = rs.getString("Mins1");
        final String Mins5 = rs.getString("Mins5");
        final String augmentation =rs.getString("augmentation");
        final String birth = rs.getString("birth");
        final String birthWeight = rs.getString("birthWeight");
        final String complication = rs.getString("complication");
        final String deliveryDoc = rs.getString("deliveryDoc");
        final String doa = rs.getString("doa");
        final String dod = rs.getString("dod");
        final String dob = rs.getString("dob");
        final String indication = rs.getString("indication");
        final String liquor = rs.getString("liquor");
        final String modeDelivery = rs.getString("modeDelivery");
        final String other = rs.getString("other");
        final String overais = rs.getString("overais");
        final String presentation = rs.getString("presentation");
        final String riskFactor = rs.getString("riskFactor");
        final String sex = rs.getString("sex");
        final String toa = rs.getString("toa");
        final String tob = rs.getString("tob");
        final String tod = rs.getString("tod");
        final String uterus = rs.getString("uterus");



        return AncDeliveryData.newInstance(id,patId,vstId,   Mins1,   Mins5,   augmentation,   birth,   birthWeight,   complication,   deliveryDoc,   doa,   dod, dob,  indication,   liquor,   modeDelivery,   other,   overais,   presentation,   riskFactor,   sex,   toa,   tob,   tod,   uterus);
    }

}
