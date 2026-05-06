package com.ueniweb.swiftwaresolutions.rowmapper;

import com.ueniweb.swiftwaresolutions.data.TimingData;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class TimingRowMapper implements RowMapper<TimingData>  {

    private final String schema;

    public TimingRowMapper(){
        final StringBuilder builder = new StringBuilder(200);
        builder.append(" FROM nur_master_timing a ");
        this.schema = builder.toString();
    }

    public String schema() {
        return this.schema;
    }

    public String tableSchema() {
        final StringBuilder builder = new StringBuilder(200);
        builder.append("a.id, ");
        builder.append("a.name as timing,");
        builder.append("a.tot_units as totalUnits,");
        builder.append("a.no_of_times as dayQty,");
        builder.append("a.dose_dur as doseDuration,");
        builder.append("a.is_diff_calc as isDiffCalc,");
        builder.append("a.diff_days as diffDays, ");
        builder.append("a.timing_name as timingName, ");
        builder.append("a.description as description ");
        builder.append(this.schema);
        return builder.toString();
    }

@Override
    public TimingData mapRow(ResultSet rs, int rowNum) throws SQLException {
        final Integer id             = rs.getInt("id");
        final String timing          = rs.getString("timing");
        final Double totalUnits      = rs.getDouble("totalUnits");
        final Integer dayQty         = rs.getInt("dayQty");
        final Integer doseDuration   = rs.getInt("doseDuration");
        final Integer isDiffCalc     = rs.getInt("isDiffCalc");
        final Integer diffDays       = rs.getInt("diffDays");
        final String timingName       = rs.getString("timingName");
        final String description       = rs.getString("description");


        return TimingData.createNewInstance(id,timing,totalUnits,dayQty,doseDuration,isDiffCalc,diffDays, timingName , description);
    }

}
