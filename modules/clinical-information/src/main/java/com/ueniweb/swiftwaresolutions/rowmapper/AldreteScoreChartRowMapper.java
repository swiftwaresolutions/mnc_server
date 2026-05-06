package com.ueniweb.swiftwaresolutions.rowmapper;

import com.ueniweb.swiftwaresolutions.data.AldreteScoreChartData;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
public class AldreteScoreChartRowMapper implements RowMapper<AldreteScoreChartData>{

    private final String schema;

    public AldreteScoreChartRowMapper(){
        final StringBuilder builder = new StringBuilder(200);
        builder.append(" FROM cli_ot_scorechart a ");
        this.schema = builder.toString();
    }
    public String schema() {
        return this.schema;
    }

    public String tableSchema() {
        final StringBuilder builder = new StringBuilder(200);
        builder.append("a.id,a. patId,a.visitId,a.ipId,a.userId,a.activity,a.conscious,a.respiration,a.saturation,a.dtm");
        builder.append(this.schema);
        return builder.toString();
    }
    @Override
    public AldreteScoreChartData mapRow(ResultSet rs, int rowNum) throws SQLException {

        final Long id = rs.getLong("id");
        final Long patId = rs.getLong("patId");
        final Long visitId = rs.getLong("visitId");
        final Long ipId = rs.getLong("ipId");
        final Long userId = rs.getLong("userId");
        final Long activity = rs.getLong("activity");
        final Long conscious = rs.getLong("conscious");
        final Long respiration = rs.getLong("respiration");
        final Long saturation = rs.getLong("saturation");
        final String dtm = rs.getString("dtm");

        return AldreteScoreChartData.createNewInstance(id,  patId, visitId, ipId, userId, activity, conscious, respiration, saturation, dtm);
    }
}
