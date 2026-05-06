package com.ueniweb.swiftwaresolutions.rowmapper;

import com.ueniweb.swiftwaresolutions.data.AncData;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;


public class AncRowmapper implements RowMapper<AncData> {

    private final String schema;

    private final String tableSchema;

    public AncRowmapper(boolean appDateFormat) {
        final StringBuilder tableBuilder = new StringBuilder(200);
        tableBuilder.append(" FROM cli_anc a LEFT JOIN cli_patient_appointment b ON a.vstId = b.vstId AND b.caseSheetType = 2 ");

        final StringBuilder builder = new StringBuilder(200);
        builder.append("a.id as id, ");
        builder.append("a.patId as patId, ");
        builder.append("a.vstId as vstId , ");
        builder.append("a.ctime as Ctime, ");
        builder.append("a.updateDate as Cdate, ");
        builder.append("a.g as g, ");
        builder.append("a.p as p, ");
        builder.append("a.l as l, ");
        builder.append("a.a as a, ");
        builder.append("a.d as d, ");
        builder.append("a.lmp as lmp, ");
        builder.append("a.edd as edd, ");
        builder.append("a.sedd as sedd, ");
        builder.append("a.ga as ga, ");
        builder.append("a.durationofmarriage as durationofmarriage, ");
        builder.append("a.consanguinity as consanguinity, ");
        builder.append("a.conception as conception, ");
        builder.append("a.menstrualHis as menstrualHis, ");
        builder.append("a.menstrualOthers as MenstrualOthers, ");
        builder.append("a.surgicalHistory as surgicalHistory, ");
        builder.append("a.chiefhistory as chiefhistory, ");
        builder.append("a.allergichistory as allergichistory, ");
        builder.append("a.historyPreIll as historyPreIll, ");
        builder.append("a.familyHistory as familyHistory, ");
        builder.append("a.othersHis as othersHis, ");
        builder.append("a.pallor as pallor, ");
        builder.append("a.icterus as icterus, ");
        builder.append("a.edema as edema, ");
        builder.append("a.cvs as cvs, ");
        builder.append("a.rs as rs,");
        builder.append("a.utreusSize as UtreusSize ,");
        builder.append("a.symphosisFundal as SymphosisFundal ,");
        builder.append("a.featolHeartRate as FeatolHeartRate, ");
        builder.append("a.presentationAb as presentationAb ,");
        builder.append("a.engaged as engaged, ");
        builder.append("a.cervix as cervix ,");
        builder.append("a.dilatation as dilatation ,");
        builder.append("a.effacement as effacement ,");
        builder.append("a.presentationPV as presentationPV, ");
        builder.append("a.membrane as membrane ,");
        builder.append("a.station as station ,");
        builder.append("a.pelvis as pelvis, ");
        builder.append("a.diabetes as diabetes, ");
        builder.append("a.hypertension as hypertension ,");
        builder.append("a.asthma as asthma ,");
        builder.append("a.seiure as seiure ,");
        builder.append("a.cardiac as cardiacDisease ,");
        builder.append("a.tb as tb ,");
        builder.append("a.thyroidDisorder as thyroidDisorder ,");
        builder.append("a.stDose1 as stDose1 ,");
        builder.append("a.stDoseIn as stDoseIn, ");
        builder.append("a.ndDose2 as ndDose2, ");
        builder.append("a.ndDoseIn as ndDoseIn, ");
        builder.append("a.riskFactor as riskFactor ,");
        builder.append("a.medicalHistory as medicalHistory ,");
        builder.append("a.others as others ,");
        builder.append("a.isDelivered as isDelivered, ");

        builder.append("IFNULL(a.diabetesNotes,'') as diabetesNotes, ");
        builder.append("IFNULL(a.hypertensionNotes,'') as hypertensionNotes, ");
        builder.append("IFNULL(a.asthmaNotes,'') as asthmaNotes, ");
        builder.append("IFNULL(a.seiureNotes,'') as seiureNotes, ");
        builder.append("IFNULL(a.cardiacNotes,'') as cardiacNotes, ");
        builder.append("IFNULL(a.tbNotes,'') as tbNotes, ");
        builder.append("IFNULL(a.thyroidDisorderNotes,'') as thyroidDisorderNotes, ");
        builder.append("IFNULL(a.othersNotes,'') as othersNotes, ");

        if (appDateFormat) {
            builder.append("DATE_FORMAT(IFNULL(b.`appDate`,\"00/00/0000\"),'%d/%m/%Y') as initialAppointmentDate, ");
        } else {
            builder.append("a.initialAppointmentDate  as initialAppointmentDate, ");
        }

        builder.append("IFNULL(b.`appPlan`,\"\") as initialAppointmentPlan, ");

        builder.append("a.height as height ,");
        builder.append("a.bmi as bmi ,");
        builder.append("a.spo2 as spo2 ,");
        builder.append("a.rr as rr ,");
        builder.append("a.bp as bp ,");
        builder.append("a.weight as weight, ");
        builder.append("a.temperature as temperature, ");
        builder.append("a.pulse as pulse, ");

        builder.append("a.iniSysOther as iniSysOther, ");
        builder.append("a.iniPaOther as iniPaOther, ");
        builder.append("a.iniPvOther as iniPvOther, ");

        builder.append("a.othersPlan as othersPlan, ");
        builder.append("a.personalInfo as personalInfo, ");
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
    public AncData mapRow(ResultSet rs, int i) throws SQLException {
        final Long id = rs.getLong("id");
        final Long patId = rs.getLong("patId");
        final Long vstId = rs.getLong("vstId");
        final String ctime = rs.getString("Ctime");
        final String cdate = rs.getString("Cdate");
        final String g = rs.getString("g");
        final String p = rs.getString("p");
        final String l = rs.getString("l");
        final String a = rs.getString("a");
        final String d = rs.getString("d");
        final String lmp = rs.getString("lmp");
        final String edd = rs.getString("edd");
        final String sedd = rs.getString("sedd");
        final String ga = rs.getString("ga");
        final String durationofmarriage = rs.getString("durationofmarriage");
        final String consanguinity = rs.getString("consanguinity");
        final String conception = rs.getString("conception");
        final String menstrualHis = rs.getString("menstrualHis");
        final String menstrualOthers = rs.getString("MenstrualOthers");
        final String surgicalHistory = rs.getString("surgicalHistory");
        final String chiefhistory = rs.getString("chiefhistory");
        final String allergichistory = rs.getString("allergichistory");
        final String historyPreIll = rs.getString("historyPreIll");
        final String familyHistory = rs.getString("familyHistory");
        final String othersHis = rs.getString("othersHis");
        final String pallor = rs.getString("pallor");
        final String icterus = rs.getString("icterus");
        final String edema = rs.getString("edema");
        final String cvs = rs.getString("cvs");
        final String featolHeartRate = rs.getString("FeatolHeartRate");
        final String presentationAb = rs.getString("presentationAb");
        final String engaged = rs.getString("engaged");
        final String cervix = rs.getString("cervix");
        final String dilatation = rs.getString("dilatation");
        final String effacement = rs.getString("effacement");
        final String presentationPV = rs.getString("presentationPV");
        final String station = rs.getString("station");
        final String membrane = rs.getString("membrane");
        final String pelvis = rs.getString("pelvis");
        final Long diabetes = rs.getLong("diabetes");
        final Long hypertension = rs.getLong("hypertension");
        final Long asthma = rs.getLong("asthma");
        final Long seiure = rs.getLong("seiure");
        final Long cardiacDisease = rs.getLong("cardiacDisease");
        final Long tb = rs.getLong("tb");
        final Long thyroidDisorder = rs.getLong("thyroidDisorder");
        final Long stDose1 = rs.getLong("stDose1");
        final String stDoseIn = rs.getString("stDoseIn");
        final Long ndDose2 = rs.getLong("ndDose2");
        final String ndDoseIn = rs.getString("ndDoseIn");
        final String riskFactor = rs.getString("riskFactor");
        final Long isDelivered = rs.getLong("isDelivered");
        final String utreusSize = rs.getString("UtreusSize");
        final String symphosisFundal = rs.getString("SymphosisFundal");
        final String Rs = rs.getString("rs");
        final String medicalHistory = rs.getString("medicalHistory");
        final String others = rs.getString("others");

        final String diabetesNotes = rs.getString("diabetesNotes");
        final String hypertensionNotes = rs.getString("hypertensionNotes");
        final String asthmaNotes = rs.getString("asthmaNotes");
        final String seiureNotes = rs.getString("seiureNotes");
        final String cardiacNotes = rs.getString("cardiacNotes");
        final String tbNotes = rs.getString("tbNotes");
        final String thyroidDisorderNotes = rs.getString("thyroidDisorderNotes");
        final String othersNotes = rs.getString("othersNotes");
        final String initialAppointmentDate = rs.getString("initialAppointmentDate");
        final String initialAppointmentPlan = rs.getString("initialAppointmentPlan");

        final String height = rs.getString("height");
        final String bmi = rs.getString("bmi");
        final String spo2 = rs.getString("spo2");
        final String rr = rs.getString("rr");
        final String bp = rs.getString("bp");
        final String weight = rs.getString("weight");
        final String temperature = rs.getString("temperature");
        final String pulse = rs.getString("pulse");

        final String iniSysOther=rs.getString("iniSysOther");
        final String iniPaOther=rs.getString("iniPaOther");
        final String iniPvOther=rs.getString("iniPvOther");

        final String othersPlan=rs.getString("othersPlan");
        final String personalInfo = rs.getString("personalInfo");
        final String createdAt=rs.getString("createdAt");


        return AncData.newInstance(id, patId, vstId, ctime, cdate, g, p, l, a, d, lmp, edd, sedd, ga, durationofmarriage,
                consanguinity, conception, menstrualHis, menstrualOthers, surgicalHistory, chiefhistory, allergichistory, historyPreIll, familyHistory, othersHis,
                pallor, icterus, edema, cvs, Rs, utreusSize, symphosisFundal, featolHeartRate, presentationAb, engaged, cervix, dilatation,
                effacement, presentationPV, station, membrane, pelvis, diabetes, hypertension, asthma, seiure,cardiacDisease, tb, thyroidDisorder, stDose1, stDoseIn,
                ndDose2, ndDoseIn, riskFactor, medicalHistory, others, isDelivered,
                diabetesNotes, hypertensionNotes, asthmaNotes, seiureNotes, cardiacNotes, tbNotes, thyroidDisorderNotes,
                othersNotes, initialAppointmentDate, initialAppointmentPlan,height,  bmi,
                spo2,  rr,  bp,  weight,temperature,pulse,iniSysOther,iniPaOther,iniPvOther,othersPlan,personalInfo,createdAt
        );

    }
}
