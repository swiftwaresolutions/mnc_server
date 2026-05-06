package com.ueniweb.swiftwaresolutions.rowmapper;

import com.ueniweb.swiftwaresolutions.data.DischargeLabInvSummaryData;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DischargeInvLabSumRowMapper implements RowMapper<DischargeLabInvSummaryData> {

    private final String schema;

    public DischargeInvLabSumRowMapper(){
        final StringBuilder builder = new StringBuilder(200);
        builder.append(" FROM `cli_discharge_summary_labandinv` a, `cli_discharge_summary` b ");
        this.schema = builder.toString();
    }

    public String schema() {
        return this.schema;
    }

    public String tableSchema() {
        final StringBuilder builder = new StringBuilder(200);
        builder.append(" a.`id`, a.`summaryId`, a.`procName`, a.`procDate`, a.`report`, a.`date`, a.`time`, a.`uid`, a.`isActive` ");
        builder.append(this.schema);
        return builder.toString();
    }

    @Override
    public DischargeLabInvSummaryData mapRow(ResultSet rs, int rowNum) throws SQLException {
        final Integer id = rs.getInt("id");
        final Integer summaryId = rs.getInt("summaryId");
        final String procName = rs.getString("procName");
        final String procDate = rs.getString("procDate");
        final String report = rs.getString("report");
        final String date = rs.getString("date");
        final String time = rs.getString("time");
        final Integer uid = rs.getInt("uid");
        final Integer isActive = rs.getInt("isActive");


        return DischargeLabInvSummaryData.createNewInstance(id,summaryId,procName,procDate,report,date,time,uid,isActive);
    }

}
