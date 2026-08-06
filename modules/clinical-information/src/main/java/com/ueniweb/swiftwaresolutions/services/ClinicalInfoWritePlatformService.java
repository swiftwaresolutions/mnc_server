package com.ueniweb.swiftwaresolutions.services;

import com.ueniweb.swiftwaresolutions.core.response.Response;
import com.ueniweb.swiftwaresolutions.data.OutsideLabResultData;
import com.ueniweb.swiftwaresolutions.data.PrescriptionData;
import com.ueniweb.swiftwaresolutions.domain.PrescTemplate;
import com.ueniweb.swiftwaresolutions.infrastructure.exceptions.ApiResponse;
import com.ueniweb.swiftwaresolutions.request.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface ClinicalInfoWritePlatformService {

    Response saveGeneralCaseSheet(final GeneralCaseSheetRequest generalCaseSheetRequest);

    Response updateGeneralCaseSheet(final Long id, final GeneralCaseSheetRequest generalCaseSheetRequest,final Integer caseSheetType);

    List<PrescriptionData>  savePrescription(final CreatePrescriptionRequest createPrescriptionRequest, final Long doctorId);

    void saveInvestigationOrder(final List<CreateInvestigationOrderRequest> createInvestigationOrderRequest,Long docId, Long userId);

    List<PrescriptionData> updatePrescription(final Long id, final UpdatePrescriptionRequest createPrescriptionRequest, final Long doctorId);

    void saveLabOrder(final List<CreateLabOrderRequest> labOrderRequests, final Long userId);

    Response deleteLabOrderByLabId(final Long labId , final Long userId);

    Response deleteLabOrderByPatientId(final Long patientId , final Long userId);

    Response deleteInvestigationOrderById(final Long orderId, final Long userId);

    Response deleteInvestigationOrderByPatientId(final Long patientId , final Long userId);

    Response blockInvestigationByOrderId(final Long orderId, final Long userId);

    Response saveCaseSheetTemplate(final CreateCaseSheetTemplateRequest createCaseSheetTemplateRequest);

    Response saveOrderDiscount(final CreateOrderDiscountRequest createOrderDiscountRequest);

    Response savePrescriptionTemplate(final CreatePrescTemplateRequest createPrescTemplateRequest);

    Response deleteOrderDiscByPatId(final Long patId);

    void saveProcOrderTemplate(final CreateOrderTemplateRequest createOrderTemplateRequest);



  //  Response savePediatricCaseSheet(final CreatePeadiatricCaseSheetRequest createPeadiatricCaseSheetRequest);

    Response saveDischargeSummary(final CreateDischargeSummaryRequest createDischargeSummaryRequest);

    Response savePediatricCaseSheet(final CreatePeadiatricCaseSheetRequest createPeadiatricCaseSheetRequest);

    Response updatePediatricCaseSheet(final Long id, final CreatePeadiatricCaseSheetRequest createPeadiatricCaseSheetRequest, final Integer caseSheetType);

    Response saveNeonateCaseSheet(final CreateNeoNateCaseSheetRequest createNeoNateCaseSheetRequest);

    Response updateNeonateCaseSheet(final Long id, final CreateNeoNateCaseSheetRequest createNeoNateCaseSheetRequest,final Integer caseSheetType);

    void saveAnthropometry(final List<CreateAnthropometryRequest> anthropometryRequests);

    void updateAnthropometry(final Long vstId, final List<CreateAnthropometryRequest> createAnthropometryRequest);

    Response saveOpVitals(final CreateOPVitalsRequest createOPVitalsRequest);

    Response updateOPVitals(final Long id, final CreateOPVitalsRequest createOPVitalsRequest);

    Response saveSummaryTemplates(final CreateSummaryTemplateRequest createSummaryTemplateRequest);

    Response saveDentalCaseSheet(final CreateDentalCasesheetRequest createDentalCasesheetRequest);

    Response updateDentalCaseSheet(final Long id, final CreateDentalCasesheetRequest createdentalCaseSheetRequest);

    Response saveAntenatalCaseSheet(final CreateAntenatalCaseSheetRequest createAntenatalCaseSheetRequest);

    Response updateAntenatalCaseSheet(final Long id, final CreateAntenatalCaseSheetRequest createAntenatalCaseSheetRequest);

    Response updateDischargeSummary(final Long id, final CreateDischargeSummaryRequest createDischargeSummaryRequest);

    Response saveSurgeryCaseSheet(final CreateSurgeryCaseSheetRequest createSurgeryCaseSheetRequest);

    Response  updatSurgeryCaseSheet(final Long id, final CreateSurgeryCaseSheetRequest createSurgeryCaseSheetRequest);
    ResponseEntity<ApiResponse<String>> updatePrescriptionNotes(final Long id, final String notes);

    Response saveNursingIoSheet(final CreateNursingIoReuest createNursingIoReuest);

    Response saveIpProcedureCaseSheet(final CreateIpProcedureCaseSheetRequest createIpProcedureCaseSheetRequest);

    Response updateIpProcedureCaseSheet(final Long id, final CreateIpProcedureCaseSheetRequest createIpProcedureCaseSheetRequest);

    Response saveAncCaseSheet(final CreateAncRequest createAncRequest);

    Response saveAncDetailsCaseSheet(final CreateAncDetailsRequest createAncDetailsRequest);

    Response updateAncCaseSheet(final Long id, final CreateAncRequest createAncRequest);

    Response updateAncDetailsCaseSheet(final Long id, final CreateAncDetailsRequest createAncDetailsRequest);

    Response updateNursingIoSheet(final Long id, final CreateNursingIoReuest createNursingIoReuest);

    Response saveSurgeryChecklist(final CreateSurgeryChecklistReuest createSurgeryChecklistReuest);

    Response updateSurgeryChecklist(final Long id, final CreateSurgeryChecklistReuest createSurgeryChecklistReuest);

    Response saveAldreteScoreChart(final CreateAldreteScoreChartReuest createAldreteScoreChartReuest);

    Response updateAldreteScoreChart(final Long id, final CreateAldreteScoreChartReuest createAldreteScoreChartReuest);

    Response saveDermatologyCaseSheet(final CreateDermatologyCaseSheetRequest createDermatologyCaseSheetRequest);

    Response updateDermatologyCaseSheet(final Long id, final CreateDermatologyCaseSheetRequest createDermatologyCaseSheetRequest,final Integer caseSheetType);

    Response saveOpthamologyCaseSheet(final CreateOpthamologyCaseSheetRequest createOpthamologyCaseSheetRequest);

    Response updateOpthamologyCaseSheet(final Long id, final CreateOpthamologyCaseSheetRequest createOpthamologyCaseSheetRequest,final Integer caseSheetType);

    Response saveENTCaseSheet(final CreateENTCaseSheetRequest createENTCaseSheetRequest);

    Response updateENTCaseSheet(final Long id, final CreateENTCaseSheetRequest createENTCaseSheetRequest,final Integer caseSheetType);

    Response updateDeliveryDetails(final Long id, final CreateAncDeliveryRequest createAncDeliveryRequest);

    Response saveDeliveryDetails(final CreateAncDeliveryRequest createAncDeliveryRequest);

    List<OutsideLabResultData> saveOutsideLabResult(final CreateOutsideLabRequest createOutsideLabRequest);

    List<OutsideLabResultData> updateOutsideLabResult(final Long disp,final CreateOutsideLabRequest createOutsideLabRequest);

    List<OutsideLabResultData> saveOutsideInvDetails(final CreateOutsideInvRequest createOutsideInvRequest);

    List<OutsideLabResultData> updateOutsideInvDetails(final Long disp,final CreateOutsideInvRequest createOutsideInvRequest);

    ResponseEntity<String> uploadInvImage(final List<MultipartFile> multipartFile, final String createImgInvUploadRequest);

    Response updateSelectedImage(final Long id, final Long blockedId, final CreateImgInvUploadRequest createImgInvUploadRequest);

    Response savePatientAppointmentRegister(final AppointmentRequest appointmentRequest);

    Response updatePatientAppointmentRegister(final Long id, final AppointmentRequest appointmentRequest);

    String deleteCaseSheetTemplateById (final Long id);

    String blockOutsideLabResultById (final Long id);

    String blockOutsideInvResultById (final Long id);

    String editPrescriptionTemplate(final CreatePrescTemplateEditRequest createPrescTemplateEditRequest);

    String editLabTemplate(final Long tempId);

    String updateRiskFactors(final Long id, final String riskFactors, final String personalInfo);

    String updatePatientDelivery(final Long ancId);

    Response updateCaseSheetTemplate(final CreateCaseSheetTemplateRequest createCaseSheetTemplateRequest, final Long id);

    Response updateAncChildDetails(final CreateAncChildRequest createAncChildRequest);

    Response saveDoctorTransferDetails(final CreateDoctorTransferRequest createDoctorTransferRequest, final Long userId , final Long doctorId, final String clientIp);

    Response removeDoctorTransfer(final Long transferId , final Long userId);

    Response receiveDoctorTransfer(final Long transferId, final Long docId);

    Response updateDocStatus(final Long doctorId, final String status);

    Response completeDoctorTransfer(final Long transferId, final String reviewDate, final Long docId);

    Response reOpenDoctorTransfer(final Long transferId, final Long docId);

    Response updateDoctorViewing(final Long patId, final Long vstId, final Long toDoc);
}
