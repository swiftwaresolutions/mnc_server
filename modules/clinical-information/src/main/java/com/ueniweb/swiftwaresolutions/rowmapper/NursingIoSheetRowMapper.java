package com.ueniweb.swiftwaresolutions.rowmapper;

import com.ueniweb.swiftwaresolutions.data.NursingIoData;
import com.ueniweb.swiftwaresolutions.data.OPVitalsData;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
public class NursingIoSheetRowMapper   implements RowMapper<NursingIoData>{
    private final String schema;

    public NursingIoSheetRowMapper(){
        final StringBuilder builder = new StringBuilder(200);
        builder.append(" FROM cli_nursing_io a ");
        this.schema = builder.toString();
    }
    public String schema() {
        return this.schema;
    }

    public String tableSchema() {
        final StringBuilder builder = new StringBuilder(200);
        builder.append("a.id,a.patId,a.visitId,a.ipId,a.drain,a.drainDetails,a.inOther,a.inOtherDetails,a.ivf,a.ivfDetails,a.nurseDtmIo,a.oral,a.oralDetails,a.outOther,a.outOtherDetails,a.urine,a.urineDetails,a.inTotal,a.outTotal,a.curDtm ");
        builder.append(this.schema);
        return builder.toString();
    }
    @Override
    public NursingIoData mapRow(ResultSet rs, int rowNum) throws SQLException {
        final Long id        = rs.getLong("id");
        final Long patId        = rs.getLong("patId");
        final Long visitId        = rs.getLong("visitId");
        final Long ipId        = rs.getLong("ipId");
        final String drain        = rs.getString("drain");
        final String drainDetails        = rs.getString("drainDetails");
        final String inOther        = rs.getString("inOther");
        final String inOtherDetails        = rs.getString("inOtherDetails");
        final String ivf        = rs.getString("ivf");
        final String ivfDetails        = rs.getString("ivfDetails");
        final String nurseDtmIo        = rs.getString("nurseDtmIo");
        final String oral        = rs.getString("oral");
        final String oralDetails        = rs.getString("oralDetails");
        final String outOther        = rs.getString("outOther");
        final String outOtherDetails        = rs.getString("outOtherDetails");
        final String urine        = rs.getString("urine");
        final String urineDetails        = rs.getString("urineDetails");
        final Long inTotal        = rs.getLong("inTotal");
        final Long outTotal        = rs.getLong("outTotal");
        final String curDtm        = rs.getString("curDtm");

        return NursingIoData.createNewInstance(  id,  patId,  visitId,  ipId,  drain,  drainDetails,  inOther,  inOtherDetails,  ivf,  ivfDetails,  nurseDtmIo,
                oral,  oralDetails,  outOther,  outOtherDetails,  urine,  urineDetails,  inTotal,  outTotal,curDtm);
    }
}
