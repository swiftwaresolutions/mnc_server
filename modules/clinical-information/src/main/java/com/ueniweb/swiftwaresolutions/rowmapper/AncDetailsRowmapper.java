package com.ueniweb.swiftwaresolutions.rowmapper;

import com.ueniweb.swiftwaresolutions.data.AncDetialsData;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
public class AncDetailsRowmapper implements RowMapper <AncDetialsData> {
    private final String schema;

    private final String tableSchema;

    public AncDetailsRowmapper  (){

        final StringBuilder tableBuilder = new StringBuilder(200);
        tableBuilder.append(" FROM cli_anc_details a LEFT JOIN cli_patient_appointment b ON a.visit_id = b.vstId AND b.caseSheetType = 2 ");

        final StringBuilder builder = new StringBuilder(200);
        builder.append("a.id as id,");
        builder.append("a.anc_id as anc_id,");
        builder.append("a.pat_id as pat_id ,");
        builder.append("a.visit_id as visit_id, ");
        builder.append("a.g as g, ");
        builder.append("a.p as p, ");
        builder.append("a.l as l, ");
        builder.append("a.a as a, ");
        builder.append("a.d as d, ");
        builder.append("a.ga as ga, ");
        builder.append("a.sedd as sedd, ");
        builder.append("a.varBp as varBp, ");
        builder.append("a.varweight as varweight, ");
        builder.append("a.pallor as pallor, ");
        builder.append("a.icterus as icterus, ");
        builder.append("a.edema as edema, ");
        builder.append("a.UtreusSize as utreusSize, ");
        builder.append("a.SymphosisFundal as symphosisFundal, ");
        builder.append("a.FeatolHeartRate as featolHeartRate, ");
        builder.append("a.presentationAb as presentationAb, ");
        builder.append("a.engaged as engaged, ");
        builder.append("a.cervix as cervix, ");
        builder.append("a.dilatation as dilatation, ");
        builder.append("a.effacement as effacement, ");
        builder.append("a.presentationPv as presentationPv, ");
        builder.append("a.station as station, ");
        builder.append("a.membrane as membrane, ");
        builder.append("a.pelvis as pelvis, ");
        builder.append("a.chiefComplaints as chiefComplaints,");
        builder.append("a.HisPreIll as hisPreIll ,");
        builder.append("a.Cdate as cdate ,");
        builder.append("a.Ctime as ctime, ");
        builder.append("a.cvs as cvs ,");
        builder.append("a.rs as rs ,");
        builder.append("a.lmp as lmp ,");
        builder.append("a.edd as edd ,");
        builder.append("a.height as height ,");
        builder.append("a.bmi as bmi ,");
        builder.append("a.spo2 as spo2 ,");
        builder.append("a.rr as rr ,");
        builder.append("a.bp as bp ,");
        builder.append("a.weight as weight, ");
        builder.append("a.temperature as temperature, ");
        builder.append("a.pulse as pulse, ");

        builder.append("IFNULL(b.`appDate`,\"\") as subsequentAppointmentDate, ");
        builder.append("IFNULL(b.`appPlan`,\"\") as subsequentAppointmentPlan, ");
        builder.append("a.subSysOther as subSysOther, ");
        builder.append("a.subPaOther as subPaOther, ");
        builder.append("a.subPvOther as subPvOther, ");

        builder.append("a.subOthersPlan as subOthersPlan, ");
        builder.append("a.subRiskFacter as subRiskFacter, ");
        builder.append("DATE(a.createdAt) as createdAt ");

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
    public AncDetialsData mapRow(ResultSet rs, int i) throws SQLException {
        final Long id = rs.getLong("id");
        final Long anc_id = rs.getLong("anc_id");
        final Long pat_id = rs.getLong("pat_id");
        final Long visit_id = rs.getLong("visit_id");
        final String g =rs.getString("g");
        final String p = rs.getString("p");
        final String l = rs.getString("l");
        final String a = rs.getString("a");
        final String d = rs.getString("d");
        final String ga = rs.getString("ga");
        final String sedd = rs.getString("sedd");
        final String varBp = rs.getString("varBp");
        final String varweight = rs.getString("varweight");
        final String pallor = rs.getString("pallor");
        final String icterus = rs.getString("icterus");
        final String edema = rs.getString("edema");
        final String utreusSize = rs.getString("UtreusSize");
        final String symphosisFundal = rs.getString("SymphosisFundal");
        final String featolHeartRate = rs.getString("FeatolHeartRate");
        final String presentationAb = rs.getString("presentationAb");
        final String engaged = rs.getString("engaged");
        final String cervix = rs.getString("cervix");
        final String dilatation = rs.getString("dilatation");
        final String effacement = rs.getString("effacement");
        final String presentationPv = rs.getString("presentationPv");
        final String station = rs.getString("station");
        final String membrane = rs.getString("membrane");
        final String pelvis = rs.getString("pelvis");
        final String chiefComplaints = rs.getString("chiefComplaints");
        final String hisPreIll = rs.getString("HisPreIll");
        final String cdate = rs.getString("Cdate");
        final String ctime = rs.getString("Ctime");
        final String cvs = rs.getString("cvs");
        final String lmp = rs.getString("lmp");
        final String edd = rs.getString("edd");
        final String height = rs.getString("height");
        final String bmi = rs.getString("bmi");
        final String spo2 = rs.getString("spo2");
        final String rr = rs.getString("rr");
        final String bp = rs.getString("bp");
        final String weight = rs.getString("weight");
        final String temperature = rs.getString("temperature");
        final String pulse = rs.getString("pulse");
        final String Rs = rs.getString("rs");

        final String subsequentAppointmentDate = rs.getString("subsequentAppointmentDate");
        final String subsequentAppointmentPlan = rs.getString("subsequentAppointmentPlan");

        final String subSysOther=rs.getString("subSysOther");
        final String subPaOther=rs.getString("subPaOther");
        final String subPvOther=rs.getString("subPvOther");

        final String subOthersPlan=rs.getString("subOthersPlan");
        final String subRiskFacter=rs.getString("subRiskFacter");
        final String createdAt =rs.getString("createdAt");

        return AncDetialsData.createNewInstance( id,  anc_id,  pat_id,  visit_id,   g,  p,  l,  a,  d,  ga,  sedd,  varBp,  varweight,  pallor,
                icterus,  edema,  utreusSize,  symphosisFundal,  featolHeartRate,  presentationAb,  engaged,  cervix,  dilatation,  effacement,
                presentationPv,  station,  membrane,  pelvis,  chiefComplaints,  hisPreIll,  cdate,  ctime,  cvs,  Rs,  lmp,  edd,  height,  bmi,
                spo2,  rr,  bp,  weight,temperature,pulse, subsequentAppointmentDate, subsequentAppointmentPlan,subSysOther,subPaOther,subPvOther,subOthersPlan,
                subRiskFacter,createdAt
        );
    }
}
