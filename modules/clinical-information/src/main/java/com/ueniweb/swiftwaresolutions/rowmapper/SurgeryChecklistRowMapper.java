package com.ueniweb.swiftwaresolutions.rowmapper;

import com.ueniweb.swiftwaresolutions.data.SurgeryCheckListData;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
public class SurgeryChecklistRowMapper implements RowMapper<SurgeryCheckListData> {
    private final String schema;

    public SurgeryChecklistRowMapper(){
        final StringBuilder builder = new StringBuilder(200);
        builder.append(" FROM cli_ot_surgery_checklist a ");
        this.schema = builder.toString();
    }
    public String schema() {
        return this.schema;
    }

    public String tableSchema() {
        final StringBuilder builder = new StringBuilder(200);
        builder.append("a.id,a.patId,a.visitId,a.ipId,a.airway,a.allergy,a.anticipatedBlood,a.bloodloss,a.confermation,a.critical,a.equipmentIssues,a.equipmentProblems,a.imaging,a.incision,a.marked,a.medication,a.oximeter,a.patientSpecific,a.procedures,a.prophylaxis,a.recovery,a.specimen,a.sponge,a.sterility,a.teamMembers,a.timeTaken,a.dtm,a.surgName,a.docId");
        builder.append(this.schema);
        return builder.toString();
    }
    @Override
    public SurgeryCheckListData mapRow(ResultSet rs, int rowNum) throws SQLException {

        final Long id = rs.getLong("id");
        final Long patId = rs.getLong("patId");
        final Long visitId = rs.getLong("visitId");
        final Long ipId = rs.getLong("ipId");
        final Long airway = rs.getLong("airway");
        final Long allergy = rs.getLong("allergy");
        final Long anticipatedBlood = rs.getLong("anticipatedBlood");
        final Long bloodloss = rs.getLong("bloodloss");
        final Long confermation = rs.getLong("confermation");
        final Long critical = rs.getLong("critical");
        final Long equipmentIssues = rs.getLong("equipmentIssues");
        final Long equipmentProblems = rs.getLong("equipmentProblems");
        final Long imaging = rs.getLong("imaging");
        final Long incision = rs.getLong("incision");
        final Long marked = rs.getLong("marked");
        final Long medication = rs.getLong("medication");
        final Long oximeter = rs.getLong("oximeter");
        final Long patientSpecific = rs.getLong("patientSpecific");
        final Long procedures = rs.getLong("procedures");
        final Long prophylaxis = rs.getLong("prophylaxis");
        final Long recovery = rs.getLong("recovery");
        final Long specimen = rs.getLong("specimen");
        final Long sponge = rs.getLong("sponge");
        final Long sterility = rs.getLong("sterility");
        final Long teamMembers = rs.getLong("teamMembers");
        final Long timeTaken = rs.getLong("timeTaken");
        final String dtm = rs.getString("dtm");
        final String surgName=rs.getString("surgName");
        final Long docId=rs.getLong("docId");


        return SurgeryCheckListData.createNewInstance(id, patId, visitId, ipId, airway, allergy,
                anticipatedBlood, bloodloss, confermation, critical, equipmentIssues, equipmentProblems,
                imaging, incision, marked, medication, oximeter, patientSpecific, procedures, prophylaxis,
                recovery, specimen, sponge, sterility, teamMembers, timeTaken, dtm,surgName,docId);
    }

}

