package com.ueniweb.swiftwaresolutions.rowmapper;

import com.ueniweb.swiftwaresolutions.data.AnthropometryData;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
public class AnthropometryRowMapper implements RowMapper<AnthropometryData>  {

    private final String schema;

    public AnthropometryRowMapper(){
        final StringBuilder builder = new StringBuilder(200);
        builder.append(" FROM cli_patient_anthropometry_casesheet a  ");
        this.schema = builder.toString();
    }

    public String schema() {
        return this.schema;
    }

    public String tableSchema() {
        final StringBuilder builder = new StringBuilder(200);
        builder.append("a.id, ");
        builder.append("a.patId, ");
        builder.append("a.vstId, ");
        builder.append("a.ipId, ");
        builder.append("a.visit_date as visitDate, ");
        builder.append("a.age, ");
        builder.append("a.head_circum as headCircum, ");
        builder.append("a.height, ");
        builder.append("a.ht_wt_age_percentile as htWtAgePercentile, ");
        builder.append("a.weight, ");
        builder.append("a.wt_age_percentile as wtAgePercentile, ");
        builder.append("a.ht_age_percentile as htAgePercentile, ");
        builder.append("a.bmi, ");
        builder.append("a.bmi_age_percentile as bmiAgePercentile, ");
        builder.append("a.is_valid as isValid ");
        builder.append(this.schema);
        return builder.toString();
    }

    @Override
    public AnthropometryData mapRow(ResultSet rs, int rowNum) throws SQLException {
        final Long id = rs.getLong("id");
        final Long patId = rs.getLong("patId");
        final Long vstId = rs.getLong("vstId");
        final Long ipId = rs.getLong("ipId");
        final String visitDate = rs.getString("visitDate");
        final Integer age  = rs.getInt("age");
        final Integer headCircum  = rs.getInt("headCircum");
        final Integer height  = rs.getInt("height");
        final Integer htWtAgePercentile  = rs.getInt("htWtAgePercentile");
        final Integer weight  = rs.getInt("weight");
        final Integer wtAgePercentile  = rs.getInt("wtAgePercentile");
        final Integer htAgePercentile  = rs.getInt("htAgePercentile");
        final Integer bmi  = rs.getInt("bmi");
        final Integer bmiAgePercentile  = rs.getInt("bmiAgePercentile");
        final Integer isValid  = rs.getInt("isValid");

        return AnthropometryData.createNewInstance(id,patId,vstId,ipId,visitDate,age,headCircum,height,
                htWtAgePercentile,weight,wtAgePercentile,htAgePercentile,bmi,bmiAgePercentile,isValid);
    }
}
