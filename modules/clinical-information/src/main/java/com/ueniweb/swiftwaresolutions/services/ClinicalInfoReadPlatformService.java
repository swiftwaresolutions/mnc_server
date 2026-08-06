package com.ueniweb.swiftwaresolutions.services;


import com.ueniweb.swiftwaresolutions.core.response.Response;
import com.ueniweb.swiftwaresolutions.core.services.Page;
import com.ueniweb.swiftwaresolutions.data.*;
import com.ueniweb.swiftwaresolutions.data.DoctorScheduleStatusData;
import com.ueniweb.swiftwaresolutions.domain.AncDetailsSheet;
import com.ueniweb.swiftwaresolutions.domain.NeonateCaseSheet;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Map;

public interface ClinicalInfoReadPlatformService {

    List<PrevPrescriptionDetailsData> fetchPrevPrescriptionDetails(Long patId,Integer storeId);

    List<PrevPrescriptionDetailsData> fetchPrevPrescriptionDetailsByVstId(Long vstId,Integer storeId);

    List<PrevPrescriptionDetailsData> fetchPrescriptionDetailsByVstId(Long vstId,Integer isFromSummary);

    List<PrevPrescriptionDetailsData> fetchPatientLastPrescription(Long patId,Integer storeId, Long userId);

    List<ComplaintData> fetchComplaintDetails(String complaintName);

    List<DiagnosisData> fetchDiagnosisDetails(String diagName);

    List<GenericData> fetchGenericDetails(String genName);

    List<TimingData> fetchTimingDetails();

    List<DurationData> fetchDurationDetails();

    List<ConsultantData> fetchConsultant(String consultantName);

    List<UnitData> fetchUnitDetails();

    List<LabDepartmentData> fetchLabDepartment();

    List<InvDepartmentData> fetchInvestigationDepartment();

    List<LabResultData> fetchLabResultDetailsByVisitId(Long visitId);

    List<InvestigationData> fetchInvestigationDetailsByGroupId(Long groupId);

    List<LabTestNameData> fetchLabTestNameByGroupId(Long deptId);

    List<TemplateData> fetchPrescriptionTemplates(Long templateType);

    List<PrescTemplateDetailsData> fetchPrescriptionTemplateDetailsById(Long id,Integer storeId);

    List<PrescriptionData> fetchPrescriptionDetailsById(Long id);

    List<GeneralCaseSheetData> fetchGeneralCaseSheetByVstId(Long vstId);

    List<LabOrderedData> fetchLabOrderedDetails(Long patId);

    List<com.ueniweb.swiftwaresolutions.data.OrderWithDetailsData> fetchInvestigationOrderedDetails(Long patId);

    List<TemplateData> fetchOrderTemplates(Long type);

    List<LabTestNameData> fetchLabOrderTemplatesById(Long templateId);

    List<InvestigationData> fetchInvOrderTemplatesById(Long templateId);

    List <PediatricCaseSheetData>fetchPediatricCaseSheetByVstId(Long vstId);

    List<DiscountData> fetchOrderDiscountAmount(Long patId);

    List <NeonateCaseSheetData>fetchNeonateCaseSheetByVstId(Long vstId);

    List <AnthropometryData>fetchAnthropometryByVstId(Long vstId);

    List <OPVitalsData>fetchOpVitalsByVstId(Long vstId);

    List <SummaryTemplateData>fetchSummaryTemplate(Long fieldId);

    Map<String, Object> fetchDentalCaseSheetByVstId(Long vstId);

    List <AntenatelCaseSheetData>fetchAntenatalCaseSheetByVstId(Long vstId);

    Map<String, Object>fetchDischargeSummaryByVstId(Long vstId);

    List <PatientUploadImageData>fetchPatientImageDetails(String patId);

    List <SurgeryCaseSheetData>fetchSurgeryCaseSheetByVstId(Long visitId);

    List <PhInstructionData>fetchPrescriptionInstruction();

    List <PhRouteData>fetchPrescriptionRoutes();


    List<AncData> fetchAncCaseSheetByVstId(Long vstId);

    List<AncData> fetchAncCaseSheetByPatId(Long patId);

    List<AncDetialsData> fetchAncDetialsByVstId(Long vstId);

    List<AncDetialsData> fetchPrevAncDetialsByAncId(Long ancId);

    List<AncDeliveryData> fetchAncDeliveryDetialsByVstId(Long vstId);

    List <NursingIoData>fetchNursingIoByVstId(Long vstId);

    List <SurgeryCheckListData>fetchSurgeryChecklistByVatId(Long vstId);

    List<IpProcedureCaseSheetData> fetchIpProcedureCaseSheetByVstId(Long vstId);

    List <AldreteScoreChartData>fetchAldreteScoreChartByVstId(Long vstId);

    Map<String, Object> fetchDermatologyCaseSheetByVstId(Long vstId);

    Map<String, Object> fetchOpthamologyCaseSheetByVstId(Long vstId);

    Map<String, Object> fetchENTCaseSheetByVstId(Long vstId);

    List<LabTestFieldData> fetchLabTestFields(Long tstId);

    List<OutsideLabResultData> fetchOutsideLabResultDetailsById (Long id);

    List<OutsideLabData> fetchOutsideLabResultDetailsByVistiId(Long visitId);

    List<OutsideLabPrevResultData> fetchOutsideLabPrevResultByVisitId(Long vstId);

    List<OutsideLabPrevResultDetailsData> fetchOutsideLabPrevResultDetails(Long display);

    List<OutsideLabPrevResultData> fetchOutsideInvPrevResultByVisitId(Long vstId);

    List<OutsideInvPrevDetailsData> fetchOutsideInvPrevResultDetails(Long display);

    List<OutsideInvData> fetchAllInvDetailsByVisitId(Long vstId);

    List<OutsideLabData> fetchOutsideLabResultDetailsByPatId(Long patId);

    List<OutsideInvData> fetchAllInvDetailsByPatId(Long patId);

    ResponseEntity<byte[]> getImageById(Long id);

    List <ImgInvData> fetchPatientInvImageDetailsByVstId(String vstId);

    List <ImgInvData> fetchPatientInvImageDetailsByPatId(String patId);

    List<Map<String, Object>> fetchUploadePdf(Long patId);

    List<AppointmentData> fetchPatientAppointmentByVstId(Long vstId, Long Type);

    List<AppointmentRegisterData> fetchPatientAppointmentRegister();

    List<Map<String, Object>> fetchOpVitalsHeightByPatId(Long patId);

    List<Map<String,Object>> fetchLabResultsByPatientId (Long patId);

    String fetchGeneralInstructionByPrescId(Long prescId);

    List<DoctorTransferData> fetchDoctorTransfer(Long vstId);

    List<DocPatientListData> fetchDocPatientList(Long toDoc);

    List<DocPatientListData> fetchDocPatientListByDate(Long toDoc, String date);

    DoctorScheduleStatusData fetchDocStatus(Long doctorId);

}
