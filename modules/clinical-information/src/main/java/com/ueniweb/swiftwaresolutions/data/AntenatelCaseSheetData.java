package com.ueniweb.swiftwaresolutions.data;
import jakarta.persistence.Column;
import lombok.Data;

import java.util.List;
@Data
public class AntenatelCaseSheetData {

    private Long id;

    private Long patId;

    private Long vstId;

    private Long ipId;

    private String time;

    private String date;

    private String durationofmarriage;

    private String Consanguinity;

    private String Conception;

    private String Menstrualhistory;

    private String Hypertension;

    private String DiabetesMellitus;

    private String TwinGestation;

    private String Chiefcomplaints;

    private String Historyofpresentillness;

    private String Menstrualhistroy;

    private String Martialhistroy;

    private String FamilyHistory;

    private String SurgicalHistory;

    private String Allergichistory;

    private String Others;

    private String Instrumentaldelivery;

    private String Eclampsia;

    private String PostPartumHaemorrhage;

    private String ormoreabortions;

    private String Previouspretermdelivery;

    private String Stillbirthneonataldeath;

    private String CaesareanSection;

    private String examDate;

    private String weight;

    private String PedalOdema;

    private String Bp;

    private String Fundalheight;

    private String Presentation;

    private String fhs;

    private String pallor;

    private String iceturs;

    private String cyanosis;

    private String clubbing;

    private String lymphadenopathy;

    private String edama;

    private String Lmp;

    private String Edd;

    private String Ga;

    private String G;

    private String P;

    private String L;

    private String A;

    private String Modeofconception;

    private String RedDischange;

    private String RedDischangeInput;

    private String Vomiting;

    private String VomitingInput;

    private String UrinComp;

    private String UrinCompInput;

    private String TakeFolSupplement;

    private String TakeFolSupplementInput;

    private String HisFoldFever;

    private String HisFoldFeverInput;

    private String Quidceing;

    private String Quidceinginput;

    private String AnyHistory;


    private String stDose;


    private String ndDose;


    private String dose3;


    private String PerFutalmovement;


    private String PerFutalMovementIn;


    private String bleeding;


    private String bleedingInput;


    private String AnyComplaints;


    private String AnyComplaintsInput;


    private String PrimiUnder;


    private String PrimiAbove;


    private String AgeAbove;


    private String PregnanceAfter;


    private String Infertility;


    private String FifthPregancy;


    private String HeightD;


    private String SystemicDisease;


    private String ThreatenedAbortion;


    private String GestationExceeding;


    private String PrematureLabour;


    private String Apa;


    private String Abnormalpresentation;


    private String IUGR;


    private String Multiplepregnancy;


    private String Hydraminos;


    private String PIH;


    private String ServerAnaemia;


    private String CardiacDisease;


    private String GDMonOHA;


    private String GDMoninsulin;

    private String temperature;

    private String Pulse;

    private String rr;

    private String Fhr;

    private String Engagement;

    private String lie;

    private String FinalGestationalAge;

    private String usgAge;

    private String Cervicaldilation;

    private String Cervicaleffacement;

    private String Membrane;

    private String Clrfluid;

    private String Station;

    private String Pelvisadequate;

    private String LabExam;

    private String USGExam;

    private String otherExam;

    private String comboteim2;

    private String comboteim2In;

    private String comboteim3;

    private String comboteim3In;

    private String medicalHis;

    private String anemiaPre;

    private String obstructedlabour;

    private String aphpph;

    private String congenitalAnomaly;

    private String othesPreRisk;

    private String ifCaesarean;

    private String stDose2;

    private String stDoseIn;

    private String ndDose2;

    private String ndDoseIn;

    private String booster;

    private String boosterIn;

    private String trimester1;

    private String trimester2;

    private String trimester3;

    private String shortgravida;

    private String teenagePrimi;

    private String pregnancyInfertility;

    private String gth;

    private String elderlyGravida;

    private String grandmulti;

    private String gawks;

    private String anemiaCur;

    private String chronicDisease;

    private String othesCurRisk;

    private String dtm;

    private List<AntenatalPreData> antenatalPreData;

    public AntenatelCaseSheetData(Long id, Long patId,Long vstId,Long ipId,String time,String date,String durationofmarriage,String Consanguinity,String Conception,String Menstrualhistory,String Hypertension,String DiabetesMellitus, String TwinGestation,
                                  String Chiefcomplaints,String Historyofpresentillness,String Menstrualhistroy,String Martialhistroy, String FamilyHistory,String SurgicalHistory,String Allergichistory,String Others,String Instrumentaldelivery,String Eclampsia,String PostPartumHaemorrhage,
                                  String ormoreabortions,String Previouspretermdelivery,String Stillbirthneonataldeath,String CaesareanSection,String examDate,String weight,String PedalOdema,String Bp,String Fundalheight,String Presentation,String fhs,String pallor,String iceturs,String cyanosis,String clubbing,String lymphadenopathy,String edama,String Lmp,String Edd,
                                  String Ga,String G,String P,String L,String A,String Modeofconception,String RedDischange,String RedDischangeInput,String Vomiting,String VomitingInput,String UrinComp,String UrinCompInput, String TakeFolSupplement,String TakeFolSupplementInput,String HisFoldFever,String HisFoldFeverInput,String Quidceing,String Quidceinginput,
                                  String AnyHistory,String stDose,String ndDose,String dose3,String PerFutalmovement,String PerFutalMovementIn,String bleeding,String bleedingInput,String AnyComplaints,String AnyComplaintsInput,String PrimiUnder,String PrimiAbove,String AgeAbove,String PregnanceAfter,String Infertility,String FifthPregancy,String HeightD,
                                  String SystemicDisease,String ThreatenedAbortion,String GestationExceeding,String PrematureLabour,String Apa,String Abnormalpresentation,String IUGR,String Multiplepregnancy,String Hydraminos,String PIH,String ServerAnaemia,String CardiacDisease,String GDMonOHA,String GDMoninsulin,String temperature,
                                  String  Pulse,String rr,String Fhr,String Engagement,String lie,String FinalGestationalAge,String usgAge,String Cervicaldilation,String Cervicaleffacement,String Membrane,String Clrfluid,String Station,String Pelvisadequate,String LabExam,String USGExam,String otherExam,
                                   String comboteim2,String comboteim2In,String comboteim3,String comboteim3In, String medicalHis,String anemiaPre, String obstructedlabour, String aphpph, String congenitalAnomaly, String othesPreRisk, String ifCaesarean, String stDose2, String stDoseIn, String ndDose2, String ndDoseIn, String booster, String boosterIn, String trimester1, String trimester2, String trimester3, String shortgravida, String teenagePrimi, String pregnancyInfertility, String gth, String elderlyGravida, String grandmulti, String gawks, String anemiaCur, String chronicDisease, String othesCurRisk,  String dtm)
    {


        this.id=id;

        this.patId=patId;


        this.vstId=vstId;


        this.ipId=ipId;


        this.time=time;


        this.date=date;


        this.durationofmarriage=durationofmarriage;


        this.Consanguinity=Consanguinity;


        this.Conception=Conception;


        this.Menstrualhistory=Menstrualhistory;


        this.Hypertension=Hypertension;


        this.DiabetesMellitus=DiabetesMellitus;


        this.TwinGestation=TwinGestation;


        this.Chiefcomplaints=Chiefcomplaints;


        this.Historyofpresentillness=Historyofpresentillness;


        this.Menstrualhistroy=Menstrualhistroy;


        this.Martialhistroy=Martialhistroy;


        this.FamilyHistory=FamilyHistory;


        this.SurgicalHistory=SurgicalHistory;


        this.Allergichistory=Allergichistory;


        this.Others=Others;


        this.Instrumentaldelivery=Instrumentaldelivery;


        this.Eclampsia=Eclampsia;


        this.PostPartumHaemorrhage=PostPartumHaemorrhage;


        this.ormoreabortions=ormoreabortions;


        this.Previouspretermdelivery=Previouspretermdelivery;


        this.Stillbirthneonataldeath=Stillbirthneonataldeath;


        this.CaesareanSection=CaesareanSection;


        this.examDate=examDate;


        this.weight=weight;


        this.PedalOdema=PedalOdema;


        this.Bp=Bp;


        this.Fundalheight=Fundalheight;


        this.Presentation=Presentation;


        this.fhs=fhs;


        this.pallor=pallor;


        this.iceturs=iceturs;

        this.cyanosis=cyanosis;

        this.clubbing=clubbing;


        this.lymphadenopathy=lymphadenopathy;


        this.edama=edama;

        this.Lmp=Lmp;


        this.Edd=Edd;


        this.Ga=Ga;


        this.G=G;


        this.P=P;

        this.L=L;


        this.A=A;


        this.Modeofconception=Modeofconception;


        this.RedDischange=RedDischange;


        this.RedDischangeInput=RedDischangeInput;


        this.Vomiting=Vomiting;

        this.VomitingInput=VomitingInput;


        this.UrinComp=UrinComp;


        this.UrinCompInput=UrinCompInput;


        this.TakeFolSupplement=TakeFolSupplement;


        this.TakeFolSupplementInput=TakeFolSupplementInput;


        this.HisFoldFever=HisFoldFever;


        this.HisFoldFeverInput=HisFoldFeverInput;


        this.Quidceing=Quidceing;


        this.Quidceinginput=Quidceinginput;


        this.AnyHistory=AnyHistory;


        this.stDose=stDose;


        this.ndDose=ndDose;


        this.dose3=dose3;


        this.PerFutalmovement=PerFutalmovement;


        this.PerFutalMovementIn=PerFutalMovementIn;


        this.bleeding=bleeding;


        this.bleedingInput=bleedingInput;


        this.AnyComplaints=AnyComplaints;


        this.AnyComplaintsInput=AnyComplaintsInput;


        this.PrimiUnder=PrimiUnder;


        this.PrimiAbove=PrimiAbove;


        this.AgeAbove=AgeAbove;


        this.PregnanceAfter=PregnanceAfter;


        this.Infertility=Infertility;


        this.FifthPregancy=FifthPregancy;


        this.HeightD=HeightD;


        this.SystemicDisease=SystemicDisease;


        this.ThreatenedAbortion=ThreatenedAbortion;


        this.GestationExceeding=GestationExceeding;


        this.PrematureLabour=PrematureLabour;


        this.Apa=Apa;


        this.Abnormalpresentation=Abnormalpresentation;


        this.IUGR=IUGR;


        this.Multiplepregnancy=Multiplepregnancy;


        this.Hydraminos=Hydraminos;


        this.PIH=PIH;


        this.ServerAnaemia=ServerAnaemia;


        this.CardiacDisease=CardiacDisease;


        this.GDMonOHA=GDMonOHA;


        this.GDMoninsulin=GDMoninsulin;

        this.temperature=temperature;

        this.Pulse=Pulse;

        this.rr=rr;

        this.Fhr=Fhr;

        this.Engagement=Engagement;

        this.lie=lie;

        this.FinalGestationalAge=FinalGestationalAge;

        this.usgAge=usgAge;

        this.Cervicaldilation=Cervicaldilation;

        this.Cervicaleffacement=Cervicaleffacement;

        this.Membrane=Membrane;

        this.Clrfluid=Clrfluid;

        this.Station=Station;

        this.Pelvisadequate=Pelvisadequate;

        this.LabExam=LabExam;

        this.USGExam=USGExam;

        this.comboteim2=comboteim2;

        this.comboteim2In=comboteim2In;

        this.comboteim3=comboteim3;

        this.comboteim3In=comboteim3In;

        this.otherExam=otherExam;

        this.medicalHis=medicalHis;

        this.anemiaPre=anemiaPre;

        this.obstructedlabour=obstructedlabour;

        this.aphpph=aphpph;

        this.congenitalAnomaly=congenitalAnomaly;

        this.othesPreRisk=othesPreRisk;

        this.ifCaesarean=ifCaesarean;

        this.stDose2=stDose2;

        this.stDoseIn=stDoseIn;

        this.ndDose2=ndDose2;

        this.ndDoseIn=ndDoseIn;

        this.booster=booster;

        this.boosterIn=boosterIn;

        this.trimester1=trimester1;

        this.trimester2=trimester2;

        this.trimester3=trimester3;

        this.shortgravida=shortgravida;

        this.teenagePrimi=teenagePrimi;

        this.pregnancyInfertility=pregnancyInfertility;

        this.gth=gth;

        this.elderlyGravida=elderlyGravida;

        this.grandmulti=grandmulti;

        this.gawks=gawks;

        this.anemiaCur=anemiaCur;

        this.chronicDisease=chronicDisease;

        this.othesCurRisk=othesCurRisk;

        this.dtm=dtm;

    }
    public static AntenatelCaseSheetData newInstance(Long id, Long patId,Long vstId,Long ipId,String time,String date,String durationofmarriage,String Consanguinity,String Conception,String Menstrualhistory,String Hypertension,String DiabetesMellitus, String TwinGestation,
                                                   String Chiefcomplaints,String Historyofpresentillness,String Menstrualhistroy,String Martialhistroy, String FamilyHistory,String SurgicalHistory,String Allergichistory,String Others,String Instrumentaldelivery,String Eclampsia,String PostPartumHaemorrhage,
                                                   String ormoreabortions,String Previouspretermdelivery,String Stillbirthneonataldeath,String CaesareanSection,String examDate,String weight,String PedalOdema,String Bp,String Fundalheight,String Presentation,String fhs,String pallor,String iceturs,String cyanosis,String clubbing,String lymphadenopathy,String edama,String Lmp,String Edd,
                                                   String Ga,String G,String P,String L,String A,String Modeofconception,String RedDischange,String RedDischangeInput,String Vomiting,String VomitingInput,String UrinComp,String UrinCompInput, String TakeFolSupplement,String TakeFolSupplementInput,String HisFoldFever,String HisFoldFeverInput,String Quidceing,String Quidceinginput,
                                                   String AnyHistory,String stDose,String ndDose,String dose3,String PerFutalmovement,String PerFutalMovementIn,String bleeding,String bleedingInput,String AnyComplaints,String AnyComplaintsInput,String PrimiUnder,String PrimiAbove,String AgeAbove,String PregnanceAfter,String Infertility,String FifthPregancy,String HeightD,
                                                   String SystemicDisease,String ThreatenedAbortion,String GestationExceeding,String PrematureLabour,String Apa,String Abnormalpresentation,String IUGR,String Multiplepregnancy,String Hydraminos,String PIH,String ServerAnaemia,String CardiacDisease,String GDMonOHA,String GDMoninsulin,String temperature,
                                                     String  Pulse,String rr,String Fhr,String Engagement,String lie,String FinalGestationalAge,String usgAge,String Cervicaldilation,String Cervicaleffacement,String Membrane,String Clrfluid,String Station,String Pelvisadequate,String LabExam,String USGExam,String otherExam
                                                        , String comboteim2, String comboteim2In, String comboteim3, String comboteim3In, String medicalHis,String anemiaPre, String obstructedlabour, String aphpph, String congenitalAnomaly, String othesPreRisk, String ifCaesarean, String stDose2, String stDoseIn, String ndDose2, String ndDoseIn, String booster, String boosterIn, String trimester1, String trimester2, String trimester3, String shortgravida, String teenagePrimi, String pregnancyInfertility, String gth, String elderlyGravida, String grandmulti, String gawks, String anemiaCur, String chronicDisease, String othesCurRisk,String dtm) {

        return new AntenatelCaseSheetData(  id,  patId, vstId, ipId, time, date, durationofmarriage, Consanguinity, Conception, Menstrualhistory, Hypertension, DiabetesMellitus,  TwinGestation,
                 Chiefcomplaints, Historyofpresentillness, Menstrualhistroy, Martialhistroy,  FamilyHistory, SurgicalHistory, Allergichistory, Others, Instrumentaldelivery, Eclampsia, PostPartumHaemorrhage,
                 ormoreabortions, Previouspretermdelivery, Stillbirthneonataldeath, CaesareanSection, examDate, weight, PedalOdema, Bp, Fundalheight, Presentation, fhs, pallor, iceturs, cyanosis, clubbing, lymphadenopathy, edama, Lmp, Edd,
                 Ga, G, P, L, A, Modeofconception, RedDischange, RedDischangeInput, Vomiting, VomitingInput, UrinComp, UrinCompInput,  TakeFolSupplement, TakeFolSupplementInput, HisFoldFever, HisFoldFeverInput, Quidceing, Quidceinginput,
                 AnyHistory, stDose, ndDose, dose3, PerFutalmovement, PerFutalMovementIn, bleeding, bleedingInput, AnyComplaints, AnyComplaintsInput, PrimiUnder, PrimiAbove, AgeAbove, PregnanceAfter, Infertility, FifthPregancy, HeightD,
                 SystemicDisease, ThreatenedAbortion, GestationExceeding, PrematureLabour, Apa, Abnormalpresentation, IUGR, Multiplepregnancy, Hydraminos, PIH, ServerAnaemia, CardiacDisease, GDMonOHA, GDMoninsulin, temperature,
                  Pulse, rr, Fhr, Engagement, lie, FinalGestationalAge, usgAge, Cervicaldilation, Cervicaleffacement, Membrane, Clrfluid, Station, Pelvisadequate, LabExam, USGExam, otherExam, comboteim2,  comboteim2In,  comboteim3,  comboteim3In,
                medicalHis, anemiaPre,  obstructedlabour,  aphpph,  congenitalAnomaly,  othesPreRisk,  ifCaesarean,  stDose2,  stDoseIn,  ndDose2,  ndDoseIn,  booster,  boosterIn,  trimester1,  trimester2,  trimester3,  shortgravida,  teenagePrimi,  pregnancyInfertility,  gth,  elderlyGravida,  grandmulti,  gawks,  anemiaCur,  chronicDisease,  othesCurRisk,dtm);
    }
}
