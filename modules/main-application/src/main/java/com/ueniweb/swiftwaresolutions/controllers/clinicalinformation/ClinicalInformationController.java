package com.ueniweb.swiftwaresolutions.controllers.clinicalinformation;


import com.ueniweb.swiftwaresolutions.core.exception.HimsApplicationContextException;
import com.ueniweb.swiftwaresolutions.core.response.Response;
import com.ueniweb.swiftwaresolutions.data.*;
import com.ueniweb.swiftwaresolutions.domain.AncDetailsSheet;
import com.ueniweb.swiftwaresolutions.domain.NursingIoSheet;
import com.ueniweb.swiftwaresolutions.domain.PrescTemplate;
import com.ueniweb.swiftwaresolutions.infrastructure.exceptions.ApiResponse;
import com.ueniweb.swiftwaresolutions.request.*;
import com.ueniweb.swiftwaresolutions.security.PlatformSecurityContext;

import com.ueniweb.swiftwaresolutions.services.ClinicalInfoReadPlatformService;
import com.ueniweb.swiftwaresolutions.services.ClinicalInfoWritePlatformService;
import com.ueniweb.swiftwaresolutions.services.ProductDetailsReadPlatformService;
import com.ueniweb.swiftwaresolutions.services.UserReadPlatformService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.tags.Param;

import java.io.File;
import java.nio.file.Files;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
@Slf4j
public class ClinicalInformationController {

    private final ClinicalInfoWritePlatformService clinicalInfoWritePlatformService;

    private final PlatformSecurityContext platformSecurityContext;

    private final ProductDetailsReadPlatformService productDetailsReadPlatformService;

    private final ClinicalInfoReadPlatformService clinicalInfoReadPlatformService;

    private final UserReadPlatformService userReadPlatformService;

    @PostMapping("/saveGeneralCaseSheet")
    public Response saveGeneralCaseSheet(@RequestBody GeneralCaseSheetRequest generalCaseSheetRequest) {
        final AppUser appUser = this.platformSecurityContext.authenticateUser();
        if (appUser.getUser().getIsDoctor() != 1) {
            throw new HimsApplicationContextException("Access Only For Doctors !");
        }
        return this.clinicalInfoWritePlatformService.saveGeneralCaseSheet(generalCaseSheetRequest);
    }

    @PostMapping("/savePrescription")
    public List<PrescriptionData> savePrescription(@RequestBody CreatePrescriptionRequest createPrescriptionRequest) {
        final AppUser appUser = this.platformSecurityContext.authenticateUser();
        if (appUser.getUser().getIsDoctor() != 1) {
            throw new HimsApplicationContextException("Access Only For Doctors !");
        }
        return this.clinicalInfoWritePlatformService.savePrescription(createPrescriptionRequest, appUser.getUser().getDoctor_id());
    }

    @PutMapping("/updateGeneralCaseSheet/{id}/{caseSheetType}")
    public void updatePrescription(@PathVariable(name = "id") Long id,
                                   @PathVariable(name = "caseSheetType") Integer caseSheetType,
                                   @RequestBody GeneralCaseSheetRequest generalCaseSheetRequest) {
        final AppUser appUser = this.platformSecurityContext.authenticateUser();
        if (appUser.getUser().getIsDoctor() != 1) {
            throw new HimsApplicationContextException("Access Only For Doctors !");
        }
        this.clinicalInfoWritePlatformService.updateGeneralCaseSheet(id, generalCaseSheetRequest, caseSheetType);
    }

    @PostMapping("/saveInvestigationOrder")
    public void saveInvestigationOrder(@RequestBody List<CreateInvestigationOrderRequest> createInvestigationOrderRequest) {
        final AppUser appUser = this.platformSecurityContext.authenticateUser();
        if (appUser.getUser().getIsDoctor() != 1) {
            throw new HimsApplicationContextException("Access Only For Doctors !");
        }
        this.clinicalInfoWritePlatformService.saveInvestigationOrder(createInvestigationOrderRequest, appUser.getUser().getDoctor_id(),appUser.getUser().getId());
    }

    @PutMapping("/updatePrescription/{id}")
    public List<PrescriptionData> updatePrescription(@PathVariable(name = "id") Long id, @RequestBody UpdatePrescriptionRequest prescriptionRequest) {
        final AppUser appUser = this.platformSecurityContext.authenticateUser();
        if (appUser.getUser().getIsDoctor() != 1) {
            throw new HimsApplicationContextException("Access Only For Doctors !");
        }
        return this.clinicalInfoWritePlatformService.updatePrescription(id, prescriptionRequest, appUser.getUser().getDoctor_id());
    }

    @PostMapping("/saveLabOrder")
    public void saveLabOrder(@RequestBody List<CreateLabOrderRequest> createLabOrderRequests) {
        final AppUser appUser = this.platformSecurityContext.authenticateUser();
        if (appUser.getUser().getIsDoctor() != 1) {
            throw new HimsApplicationContextException("Access Only For Doctors !");
        }
        this.clinicalInfoWritePlatformService.saveLabOrder(createLabOrderRequests, appUser.getUser().getDoctor_id());
    }

    @GetMapping("/fetchPrevPrescriptionDetails/{patId}/{storeId}")
    public List<PrevPrescriptionDetailsData> fetchPatientLastPrescription(@PathVariable(name = "patId") Long patId,
                                                                          @PathVariable(name = "storeId") Integer storeId) {
        return this.clinicalInfoReadPlatformService.fetchPrevPrescriptionDetails(patId, storeId);
    }
    @GetMapping("/fetchPrevPrescriptionDetailsByVstId/{vstId}/{storeId}")
    public List<PrevPrescriptionDetailsData> fetchPrevPrescriptionDetailsByVstId(@PathVariable(name = "vstId") Long vstId,
                                                                          @PathVariable(name = "storeId") Integer storeId) {
        return this.clinicalInfoReadPlatformService.fetchPrevPrescriptionDetailsByVstId(vstId, storeId);
    }

    @GetMapping("/fetchPrescriptionDetailsByVstId/{vstId}/{isFromSummary}")
    public List<PrevPrescriptionDetailsData> fetchPrescriptionDetailsByVstId(@PathVariable(name = "vstId") Long vstId,
                                                                             @PathVariable(name = "isFromSummary") Integer isFromSummary) {
        return this.clinicalInfoReadPlatformService.fetchPrescriptionDetailsByVstId(vstId, isFromSummary);
    }

    @GetMapping("/fetchPatientLastPrescriptionDetails/{patId}/{storeId}")
    public List<PrevPrescriptionDetailsData> fetchPrescriptionDetails(@PathVariable(name = "patId") Long patId,
                                                                      @PathVariable(name = "storeId") Integer storeId) {

        final AppUser appUser = this.platformSecurityContext.authenticateUser();
        return this.clinicalInfoReadPlatformService.fetchPatientLastPrescription(patId, storeId, appUser.getUser().getId());
    }

    @GetMapping("/fetchComplaintDetails/{complaintName}")
    public List<ComplaintData> fetchComplaintDetails(@PathVariable(name = "complaintName") String complaintName) {
        return this.clinicalInfoReadPlatformService.fetchComplaintDetails(complaintName);
    }

    @GetMapping("/fetchDiagnosisDetails/{diagName}")
    public List<DiagnosisData> fetchDiagnosisDetails(@PathVariable(name = "diagName") String diagName) {
        return this.clinicalInfoReadPlatformService.fetchDiagnosisDetails(diagName);
    }

    @GetMapping("/fetchGenericDetails/{genName}")
    public List<GenericData> fetchGenericDetails(@PathVariable(name = "genName") String genName) {
        return this.clinicalInfoReadPlatformService.fetchGenericDetails(genName);
    }

    @GetMapping("/fetchTimingDetails")
    public List<TimingData> fetchTimingDetails() {
        return this.clinicalInfoReadPlatformService.fetchTimingDetails();
    }

    @GetMapping("/fetchDurationDetails")
    public List<DurationData> fetchDurationDetails() {
        return this.clinicalInfoReadPlatformService.fetchDurationDetails();
    }

    @GetMapping("/fetchConsultant/{consultantName}")
    public List<ConsultantData> fetchConsultant(@PathVariable(name = "consultantName") String consultantName) {
        return this.clinicalInfoReadPlatformService.fetchConsultant(consultantName);
    }

    @GetMapping("/fetchUnitDetails")
    public List<UnitData> fetchUnitDetails() {
        return this.clinicalInfoReadPlatformService.fetchUnitDetails();
    }

    @DeleteMapping("/deleteLabOrderByLabId/{labId}")
    public Response deleteLabOrderByLabId(@PathVariable(name = "labId") Long labId) {
        final AppUser appUser = this.platformSecurityContext.authenticateUser();
        if (appUser.getUser().getIsDoctor() != 1) {
            throw new HimsApplicationContextException("Access  Only For Doctors !");
        }
        return this.clinicalInfoWritePlatformService.deleteLabOrderByLabId(labId, appUser.getUser().getId());
    }

    @DeleteMapping("/deleteLabOrderByPatientId/{patientId}")
    public Response deleteLabOrderByPatientId(@PathVariable(name = "patientId") Long patientId) {
        final AppUser appUser = this.platformSecurityContext.authenticateUser();
        if (appUser.getUser().getIsDoctor() != 1) {
            throw new HimsApplicationContextException("Access  Only For Doctors !");
        }
        return this.clinicalInfoWritePlatformService.deleteLabOrderByPatientId(patientId, appUser.getUser().getId());
    }

    @DeleteMapping("/deleteInvestigationOrderById/{id}")
    public Response deleteInvestigationOrderByOrderId(@PathVariable(name = "id") Long id) {
        final AppUser appUser = this.platformSecurityContext.authenticateUser();
        if (appUser.getUser().getIsDoctor() != 1) {
            throw new HimsApplicationContextException("Access Only For Doctors !");
        }
        return this.clinicalInfoWritePlatformService.deleteInvestigationOrderById(id, appUser.getUser().getId());
    }

    @PutMapping("/blockInvestigationByOrderId/{orderId}")
    public Response blockInvestigationByOrderId(@PathVariable(name = "orderId") Long orderId) {
        final AppUser appUser = this.platformSecurityContext.authenticateUser();
        if (appUser.getUser().getIsDoctor() != 1) {
            throw new HimsApplicationContextException("Access Only For Doctors !");
        }
        return this.clinicalInfoWritePlatformService.blockInvestigationByOrderId(orderId, appUser.getUser().getId());
    }

    @DeleteMapping("/deleteInvestigationOrderByPatientId/{patientId}")
    public Response deleteInvestigationOrderByPatientId(@PathVariable(name = "patientId") Long patientId) {
        final AppUser appUser = this.platformSecurityContext.authenticateUser();
        if (appUser.getUser().getIsDoctor() != 1) {
            throw new HimsApplicationContextException("Access  Only For Doctors !");
        }
        return this.clinicalInfoWritePlatformService.deleteInvestigationOrderByPatientId(patientId, appUser.getUser().getId());
    }

    @GetMapping("/fetchLabDepartment")
    public List<LabDepartmentData> fetchLabDepartment() {
        return this.clinicalInfoReadPlatformService.fetchLabDepartment();
    }

    @GetMapping("/fetchInvestigationDepartment")
    public List<InvDepartmentData> fetchInvestigationDepartment() {
        return this.clinicalInfoReadPlatformService.fetchInvestigationDepartment();
    }

    @GetMapping("fetchLabResultsByVisitId/{visitId}")
    public List<LabResultData> fetchLabResultsDetailsByVisitId(@PathVariable(name = "visitId") Long visitId) {
        return this.clinicalInfoReadPlatformService.fetchLabResultDetailsByVisitId(visitId);
    }

    @GetMapping("fetchInvestigationNamesByGroupId/{groupId}")
    public List<InvestigationData> fetchInvestigationDataByGroupId(@PathVariable(name = "groupId") Long groupId) {
        return this.clinicalInfoReadPlatformService.fetchInvestigationDetailsByGroupId(groupId);
    }

    @PostMapping("saveCaseSheetTemplate")
    public Response saveCaseSheetTemplate(@RequestBody CreateCaseSheetTemplateRequest createCaseSheetTemplateRequest) {
        final AppUser appUser = this.platformSecurityContext.authenticateUser();
        if (appUser.getUser().getIsDoctor() != 1) {
            throw new HimsApplicationContextException("Access  Only For Doctors !");
        }
        return this.clinicalInfoWritePlatformService.saveCaseSheetTemplate(createCaseSheetTemplateRequest);
    }

    @GetMapping("fetchLabTestNameByGroupId/{deptId}")
    public List<LabTestNameData> fetchLabTestNameByGroupId(@PathVariable(name = "deptId") Long deptId) {
        return this.clinicalInfoReadPlatformService.fetchLabTestNameByGroupId(deptId);
    }

    @GetMapping("/fetchMedicineNames/{medName}/{storeId}")
    public List<MedicineNameData> fetchMedicineNames(@PathVariable(name = "medName") String medName,
                                                     @PathVariable(name = "storeId") Integer storeId) {
        return this.productDetailsReadPlatformService.fetchMedicineNames(medName, storeId);
    }

    @GetMapping("/fetchCaseSheetTemplates/{casesheetType}/{templateFieldId}")
    public List<CaseSheetTemplateData> fetchCaseSheetTemplates(
            @PathVariable(name = "casesheetType") Integer casesheetType,
            @PathVariable(name = "templateFieldId") Integer templateFieldId,
            @RequestParam(name = "docId",required = false) Long docId
        ) {
        return this.productDetailsReadPlatformService.fetchCaseSheetTemplates(casesheetType, templateFieldId,docId);
    }

    @GetMapping("/fetchStoreWiseAvailableStock/{prodsId}")
    public List<StoreWiseAvailableStockData> fetchStoreWiseAvailableStock(@PathVariable(name = "prodsId") Integer prodsId) {
        return this.productDetailsReadPlatformService.fetchStoreWiseAvailableStock(prodsId);
    }

    @GetMapping("/fetchPrescriptionTemplates/{templateType}")
    public List<TemplateData> fetchPrescriptionTemplates(@PathVariable(name = "templateType") Long templateType) {
        return this.clinicalInfoReadPlatformService.fetchPrescriptionTemplates(templateType);
    }

    @GetMapping("/fetchPrescriptionTemplateDetailsById/{id}/{storeId}")
    public List<PrescTemplateDetailsData> fetchPrescriptionTemplateDetailsById(@PathVariable(name = "id") Long id,
                                                                               @PathVariable(name = "storeId") Integer storeId) {
        return this.clinicalInfoReadPlatformService.fetchPrescriptionTemplateDetailsById(id, storeId);
    }

    @GetMapping("/fetchMedicineUnitsById/{prodsId}")
    public List<ProdsUnitData> fetchMedicineUnitsById(@PathVariable(name = "prodsId") Integer prodsId) {
        return this.productDetailsReadPlatformService.fetchMedicineUnitsById(prodsId);
    }

    @GetMapping("/fetchEqualentDrugsByGenericId/{genericId}")
    public List<EqualantDrugsData> fetchEqualentDrugsByGenericId(@PathVariable(name = "genericId") Integer genericId) {
        return this.productDetailsReadPlatformService.fetchEqualentDrugsByGenericId(genericId);
    }

    @PostMapping("saveOrderDiscount")
    public Response saveOrderDiscount(@RequestBody CreateOrderDiscountRequest createOrderDiscountRequest) {
        final AppUser appUser = this.platformSecurityContext.authenticateUser();
        if (appUser.getUser().getIsDoctor() != 1) {
            throw new HimsApplicationContextException("Access  Only For Doctors !");
        }
        return this.clinicalInfoWritePlatformService.saveOrderDiscount(createOrderDiscountRequest);
    }

    @GetMapping("/fetchGeneralCaseSheetByVstId/{vstId}")
    public List<GeneralCaseSheetData> fetchGeneralCaseSheetByVstId(@PathVariable(name = "vstId") Long vstId) {
        return this.clinicalInfoReadPlatformService.fetchGeneralCaseSheetByVstId(vstId);
    }

    @PostMapping("/savePrescriptionTemplate")
    public Response savePrescriptionTemplate(@RequestBody CreatePrescTemplateRequest createPrescTemplateRequest) {
        final AppUser appUser = this.platformSecurityContext.authenticateUser();
        if (appUser.getUser().getIsDoctor() != 1) {
            throw new HimsApplicationContextException("Access  Only For Doctors !");
        }
        return this.clinicalInfoWritePlatformService.savePrescriptionTemplate(createPrescTemplateRequest);
    }

    @GetMapping("/fetchLabOrderedDetails/{patId}")
    public List<LabOrderedData> fetchLabOrderedDetails(@PathVariable(name = "patId") Long patId) {
        return this.clinicalInfoReadPlatformService.fetchLabOrderedDetails(patId);
    }

    @GetMapping("/fetchInvestigationOrderedDetails/{patId}")
    public List<com.ueniweb.swiftwaresolutions.data.OrderWithDetailsData> fetchInvestigationOrderedDetails(@PathVariable(name = "patId") Long patId) {
        return this.clinicalInfoReadPlatformService.fetchInvestigationOrderedDetails(patId);
    }

    @GetMapping("/fetchOrderDiscountAmount/{patId}")
    public List<DiscountData> fetchOrderDiscountAmount(@PathVariable(name = "patId") Long patId) {
        return this.clinicalInfoReadPlatformService.fetchOrderDiscountAmount(patId);
    }

    @DeleteMapping("/deleteOrderDiscById/{patId}")
    public Response deleteOrderDiscByPatId(@PathVariable(name = "patId") Long patId) {
        return this.clinicalInfoWritePlatformService.deleteOrderDiscByPatId(patId);
    }

    @PostMapping("/saveLabInvOrderTemplate")
    public void saveProcOrderTemplate(@RequestBody CreateOrderTemplateRequest createOrderTemplateRequest) {
        System.out.println("temp " + createOrderTemplateRequest);
        this.clinicalInfoWritePlatformService.saveProcOrderTemplate(createOrderTemplateRequest);
    }

    @GetMapping("/fetchOrderTemplates/{tempType}")
    public List<TemplateData> fetchOrderTemplates(@PathVariable(name = "tempType") Long type) {
        return this.clinicalInfoReadPlatformService.fetchOrderTemplates(type);
    }

    @GetMapping("fetchLabOrderTemplatesById/{templateId}")
    public List<LabTestNameData> fetchLabOrderTemplatesById(@PathVariable(name = "templateId") Long templateId) {
        return this.clinicalInfoReadPlatformService.fetchLabOrderTemplatesById(templateId);
    }

    @GetMapping("fetchInvOrderTemplatesById/{templateId}")
    public List<InvestigationData> fetchInvOrderTemplatesById(@PathVariable(name = "templateId") Long templateId) {
        //AppUser appUser = this.platformSecurityContext.authenticateUser();
        //Long userId = appUser.getUser().getId();
        //UserRightsData userRightsData = this.userReadPlatformService.CheckUserRight(userId,6,11,182);
//        if (userRightsData == null) {
//            throw new HimsApplicationContextException("Access Denied for this user");
//        }
        return this.clinicalInfoReadPlatformService.fetchInvOrderTemplatesById(templateId);
    }


    @PostMapping("/savePediatricCaseSheet")
    public Response savePediatricCaseSheet(@RequestBody CreatePeadiatricCaseSheetRequest createPeadiatricCaseSheetRequest) {
        final AppUser appUser = this.platformSecurityContext.authenticateUser();
        if (appUser.getUser().getIsDoctor() != 1) {
            throw new HimsApplicationContextException("Access Only For Doctors !");
        }
        return this.clinicalInfoWritePlatformService.savePediatricCaseSheet(createPeadiatricCaseSheetRequest);
    }

    @PostMapping("/saveDischargeSummary")
    public Response saveDischargeSummary(@RequestBody CreateDischargeSummaryRequest createDischargeSummaryRequest) {

//    final AppUser appUser = this.platformSecurityContext.authenticateUser();
        //if (appUser.getUser().getIsDoctor() != 1) {
        //throw new HimsApplicationContextException("Access Only For Doctors !");
        //}

        return this.clinicalInfoWritePlatformService.saveDischargeSummary(createDischargeSummaryRequest);
    }

    @PutMapping("/updateDischargeSummary/{id}")
    public void updateDischargeSummary(@PathVariable(name = "id") Long id, @RequestBody CreateDischargeSummaryRequest createDischargeSummaryRequest) {
//        final AppUser appUser = this.platformSecurityContext.authenticateUser();
//        if (appUser.getUser().getIsDoctor() != 1) {
//            throw new HimsApplicationContextException("Access Only For Doctors !");
//        }
        this.clinicalInfoWritePlatformService.updateDischargeSummary(id, createDischargeSummaryRequest);
    }

    @PutMapping("/updatePediatricCaseSheet/{id}/{caseSheetType}")
    public void updatePediatricCaseSheet(@PathVariable(name = "id") Long id,
                                         @RequestBody CreatePeadiatricCaseSheetRequest createPeadiatricCaseSheetRequest,
                                         @PathVariable(name = "caseSheetType") Integer caseSheetType) {
        final AppUser appUser = this.platformSecurityContext.authenticateUser();
        if (appUser.getUser().getIsDoctor() != 1) {
            throw new HimsApplicationContextException("Access Only For Doctors !");
        }
        this.clinicalInfoWritePlatformService.updatePediatricCaseSheet(id, createPeadiatricCaseSheetRequest, caseSheetType);
    }

    @GetMapping("/fetchPediatricCaseSheetByVstId/{vstId}")
    public List<PediatricCaseSheetData> fetchPediatricCaseSheetByVstId(@PathVariable(name = "vstId") Long vstId) {
        return this.clinicalInfoReadPlatformService.fetchPediatricCaseSheetByVstId(vstId);
    }

    @PostMapping("/saveNeonateCaseSheet")
    public Response saveNeonateCaseSheet(@RequestBody CreateNeoNateCaseSheetRequest createNeoNateCaseSheetRequest) {
        final AppUser appUser = this.platformSecurityContext.authenticateUser();
        if (appUser.getUser().getIsDoctor() != 1) {
            throw new HimsApplicationContextException("Access Only For Doctors !");
        }
        return this.clinicalInfoWritePlatformService.saveNeonateCaseSheet(createNeoNateCaseSheetRequest);
    }

    @PutMapping("/updateNeonateCaseSheet/{id}/{caseSheetType}")
    public void updateNeonateCaseSheet(@PathVariable(name = "id") Long id, @RequestBody CreateNeoNateCaseSheetRequest createNeoNateCaseSheetRequest,
                                       @PathVariable(name = "caseSheetType") Integer caseSheetType) {
        final AppUser appUser = this.platformSecurityContext.authenticateUser();
        if (appUser.getUser().getIsDoctor() != 1) {
            throw new HimsApplicationContextException("Access Only For Doctors !");
        }
        this.clinicalInfoWritePlatformService.updateNeonateCaseSheet(id, createNeoNateCaseSheetRequest, caseSheetType);
    }

    @GetMapping("/fetchNeonateCaseSheetByVstId/{vstId}")
    public List<NeonateCaseSheetData> fetchNeonateCaseSheetByVstId(@PathVariable(name = "vstId") Long vstId) {
        return this.clinicalInfoReadPlatformService.fetchNeonateCaseSheetByVstId(vstId);
    }

    @PostMapping("/saveAnthropometry")
    public void saveAnthropometry(@RequestBody List<CreateAnthropometryRequest> createAnthropometryRequests) {
        final AppUser appUser = this.platformSecurityContext.authenticateUser();
        if (appUser.getUser().getIsDoctor() != 1) {
            throw new HimsApplicationContextException("Access Only For Doctors !");
        }
        this.clinicalInfoWritePlatformService.saveAnthropometry(createAnthropometryRequests);
    }

    @PutMapping("/updateAnthropometry/{vstId}")
    public void updateAnthropometry(@PathVariable(name = "vstId") Long vstId, @RequestBody List<CreateAnthropometryRequest> createAnthropometryRequest) {
        final AppUser appUser = this.platformSecurityContext.authenticateUser();
        if (appUser.getUser().getIsDoctor() != 1) {
            throw new HimsApplicationContextException("Access Only For Doctors !");
        }
        this.clinicalInfoWritePlatformService.updateAnthropometry(vstId, createAnthropometryRequest);
    }

    @GetMapping("/fetchAnthropometryByVstId/{vstId}")
    public List<AnthropometryData> fetchAnthropometryByVstId(@PathVariable(name = "vstId") Long vstId) {
        return this.clinicalInfoReadPlatformService.fetchAnthropometryByVstId(vstId);
    }

    @PostMapping("saveOpVitals")
    public Response saveOpVitals(@RequestBody CreateOPVitalsRequest createOPVitalsRequest) {
        return this.clinicalInfoWritePlatformService.saveOpVitals(createOPVitalsRequest);
    }

    @PutMapping("/updateOPVitals/{id}")
    public void updatePediatricCaseSheet(@PathVariable(name = "id") Long id, @RequestBody CreateOPVitalsRequest createOPVitalsRequest) {
        this.clinicalInfoWritePlatformService.updateOPVitals(id, createOPVitalsRequest);
    }

    @GetMapping("/fetchOpVitalsByVstId/{vstId}")
    public List<OPVitalsData> fetchOpVitalsByVstId(@PathVariable(name = "vstId") Long vstId) {
        return this.clinicalInfoReadPlatformService.fetchOpVitalsByVstId(vstId);
    }

    @PostMapping("saveSummaryTemplates")
    public Response saveSummaryTemplates(@RequestBody CreateSummaryTemplateRequest createSummaryTemplateRequest) {
        return this.clinicalInfoWritePlatformService.saveSummaryTemplates(createSummaryTemplateRequest);
    }

    @GetMapping("/fetchSummaryTemplate/{fieldId}")
    public List<SummaryTemplateData> fetchSummaryTemplate(@PathVariable(name = "fieldId") Long fieldId) {
        return this.clinicalInfoReadPlatformService.fetchSummaryTemplate(fieldId);
    }

    @GetMapping("/fetchDentalCaseSheetByVstId/{vstId}")
    public Map<String, Object> fetchDentalCaseSheetByVstId(@PathVariable(name = "vstId") Long vstId) {
        return this.clinicalInfoReadPlatformService.fetchDentalCaseSheetByVstId(vstId);
    }

    @PostMapping("saveDentalCaseSheet")
    public Response saveDental(@RequestBody CreateDentalCasesheetRequest createDentalCasesheetRequest) {
        final AppUser appUser = this.platformSecurityContext.authenticateUser();
        if (appUser.getUser().getIsDoctor() != 1) {
            throw new HimsApplicationContextException("Access Only For Doctors !");
        }
        return this.clinicalInfoWritePlatformService.saveDentalCaseSheet(createDentalCasesheetRequest);
    }

    @PutMapping("/updateDentalCaseSheet/{id}")
    public void updateDentalCaseSheet(@PathVariable(name = "id") Long id, @RequestBody CreateDentalCasesheetRequest createdentalCaseSheetRequest) {
        final AppUser appUser = this.platformSecurityContext.authenticateUser();
        if (appUser.getUser().getIsDoctor() != 1) {
            throw new HimsApplicationContextException("Access Only For Doctors !");
        }
        this.clinicalInfoWritePlatformService.updateDentalCaseSheet(id, createdentalCaseSheetRequest);
    }

    @PostMapping("/saveAntenatalCaseSheet")
    public Response saveAntenatelCaseSheet(@RequestBody CreateAntenatalCaseSheetRequest createAntenatalCaseSheetRequest) {
        final AppUser appUser = this.platformSecurityContext.authenticateUser();
        if (appUser.getUser().getIsDoctor() != 1) {
            throw new HimsApplicationContextException("Access Only For Doctors !");
        }
        return this.clinicalInfoWritePlatformService.saveAntenatalCaseSheet(createAntenatalCaseSheetRequest);
    }

    @GetMapping("/fetchAntenatalCaseSheetByVstId/{vstId}")
    public List<AntenatelCaseSheetData> fetchAntenatalCaseSheetByVstId(@PathVariable(name = "vstId") Long vstId) {
        return this.clinicalInfoReadPlatformService.fetchAntenatalCaseSheetByVstId(vstId);
    }

    @PutMapping("/updateAntenatalCaseSheet/{id}")
    public void updateAntenatalCaseSheet(@PathVariable(name = "id") Long id, @RequestBody CreateAntenatalCaseSheetRequest createAntenatalCaseSheetRequest) {
        final AppUser appUser = this.platformSecurityContext.authenticateUser();
        if (appUser.getUser().getIsDoctor() != 1) {
            throw new HimsApplicationContextException("Access Only For Doctors !");
        }
        this.clinicalInfoWritePlatformService.updateAntenatalCaseSheet(id, createAntenatalCaseSheetRequest);
    }

    @GetMapping("/fetchDischargeSummaryByVstId/{vstId}")
    public Map<String, Object> fetchDischargeSummaryByVstId(@PathVariable(name = "vstId") Long vstId) {
        return this.clinicalInfoReadPlatformService.fetchDischargeSummaryByVstId(vstId);
    }

    @GetMapping("/fetchPatientImageDetails/{patId}")
    public List<PatientUploadImageData> fetchXrayImageDetails(@PathVariable(name = "patId") String patId) {
        return this.clinicalInfoReadPlatformService.fetchPatientImageDetails(patId);
    }

    @Value("${xrayImage.folder}")
    private String xrayImageFolderLocation;

    @GetMapping("/fetchPatientImage/{imageName}")
    public ResponseEntity<byte[]> fetchAFile(@PathVariable(name = "imageName") String imageName) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/octet-stream");
        try {
            File file = new File(xrayImageFolderLocation + imageName);
            if (file.isFile()) {
                byte[] fileContent = Files.readAllBytes(file.toPath());
                return ResponseEntity.ok()
                        .headers(headers)
                        .contentType(MediaType.APPLICATION_OCTET_STREAM)
                        .body(fileContent)
                        ;
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/saveSurgeryCaseSheet")
    public Response saveSurgeryCaseSheet(@RequestBody CreateSurgeryCaseSheetRequest createSurgeryCaseSheetRequest) {
        //  final AppUser appUser = this.platformSecurityContext.authenticateUser();
        //   if (appUser.getUser().getIsDoctor() != 1) {
        //       throw new HimsApplicationContextException("Access Only For Doctors !");
        //   }
        return this.clinicalInfoWritePlatformService.saveSurgeryCaseSheet(createSurgeryCaseSheetRequest);
    }

    @GetMapping("/fetchSurgeryCaseSheetByVstId/{visitId}")
    public List<SurgeryCaseSheetData> fetchSurgeryCaseSheetByVstId(@PathVariable(name = "visitId") Long visitId) {
        return this.clinicalInfoReadPlatformService.fetchSurgeryCaseSheetByVstId(visitId);

    }

    @PutMapping("/updateSurgeryCaseSheet/{id}")
    public void updateSurgerylCaseSheet(@PathVariable(name = "id") Long id, @RequestBody CreateSurgeryCaseSheetRequest createSurgeryCaseSheetRequest) {
//        final AppUser appUser = this.platformSecurityContext.authenticateUser();
//        if (appUser.getUser().getIsDoctor() != 1) {
//            throw new HimsApplicationContextException("Access Only For Doctors !");
//        }
        this.clinicalInfoWritePlatformService.updatSurgeryCaseSheet(id, createSurgeryCaseSheetRequest);
    }

    @GetMapping("/fetchPrescriptionInstruction")
    public List<PhInstructionData> fetchPrescriptionInstruction() {
        return this.clinicalInfoReadPlatformService.fetchPrescriptionInstruction();
    }

    @GetMapping("/fetchPrescriptionRoutes")
    public List<PhRouteData> fetchPrescriptionRoutes() {
        return this.clinicalInfoReadPlatformService.fetchPrescriptionRoutes();
    }

    @PutMapping("/updatePrescriptionDetailsNotes/{id}")
    public ResponseEntity<ApiResponse<String>> updatePrescriptionNotes(@PathVariable(name = "id") Long id, @RequestBody UpdatePrescriptionDetailsNotes requestBody) {
        return this.clinicalInfoWritePlatformService.updatePrescriptionNotes(id, requestBody.getNotes());
    }

    @PostMapping("saveNursingIo")
    public Response saveNursingIo(@RequestBody CreateNursingIoReuest createNursingIoReuest) {
        return this.clinicalInfoWritePlatformService.saveNursingIoSheet(createNursingIoReuest);
    }
    @GetMapping("/fetchNursingIOByVstId/{vstId}")
    public List<NursingIoData> fetchNursingIoByVstId(@PathVariable(name = "vstId") Long vstId) {
        return this.clinicalInfoReadPlatformService.fetchNursingIoByVstId(vstId);
    }

    @PostMapping("/saveIpProcedureCaseSheet")
    public Response saveIpProcedureCaseSheet (@RequestBody CreateIpProcedureCaseSheetRequest createIpProcedureCaseSheetRequest){
        final AppUser appUser = this.platformSecurityContext.authenticateUser();
        if (appUser.getUser().getIsDoctor() != 1) {
            throw new HimsApplicationContextException("Access Only for Doctors !");
        }
        return this.clinicalInfoWritePlatformService.saveIpProcedureCaseSheet(createIpProcedureCaseSheetRequest);
    }


    @GetMapping("/fetchIpProcedureCaseSheetByVstId/{vstId}")
    public List<IpProcedureCaseSheetData> fetchIpProcedureCaseSheetByVstId(@PathVariable(name = "vstId") Long vstId){
        return this.clinicalInfoReadPlatformService.fetchIpProcedureCaseSheetByVstId(vstId);
    }

    @PutMapping("/updateIpProcedureCaseSheet/{id}")
    public void updateIpProcedureCaseSheet(@PathVariable(name = "id") Long id, @RequestBody CreateIpProcedureCaseSheetRequest createIpProcedureCaseSheetRequest) {
        final AppUser appUser = this.platformSecurityContext.authenticateUser();
        if (appUser.getUser().getIsDoctor() != 1) {
            throw new HimsApplicationContextException("Access Only For Doctors !");
        }
        this.clinicalInfoWritePlatformService.updateIpProcedureCaseSheet(id, createIpProcedureCaseSheetRequest);
    }
    @PostMapping("/saveAncCaseSheet")
    public Response saveAncCasesheet (@RequestBody CreateAncRequest createAncRequest){
//        final AppUser appUser = this.platformSecurityContext.authenticateUser();
//        if (appUser.getUser().getIsDoctor() != 1) {
//            throw new HimsApplicationContextException("Access Only for Doctors !");
//        }
        return this.clinicalInfoWritePlatformService.saveAncCaseSheet(createAncRequest);
    }

    @PostMapping("/saveAncDetailsCaseSheet")
    public Response saveAncDetailsCaseSheet (@RequestBody CreateAncDetailsRequest createAncDetailsRequest){
//        final AppUser appUser = this.platformSecurityContext.authenticateUser();
//        if (appUser.getUser().getIsDoctor() != 1) {
//            throw new HimsApplicationContextException("Access Only for Doctors !");
//        }
        return this.clinicalInfoWritePlatformService.saveAncDetailsCaseSheet(createAncDetailsRequest);
    }

    @GetMapping("/fetchAncCaseSheetByVstId/{vstId}")
    public List<AncData> fetchAncCaseSheetByVstId(@PathVariable(name = "vstId") Long vstId){
        return this.clinicalInfoReadPlatformService.fetchAncCaseSheetByVstId(vstId);
    }

    @GetMapping("/fetchAncCaseSheetByPatId/{patId}")
    public List<AncData> fetchAncCaseSheetByPatId(@PathVariable(name = "patId") Long patId){
        return this.clinicalInfoReadPlatformService.fetchAncCaseSheetByPatId(patId);
    }

    @GetMapping("/fetchAncDetialsByVstId/{vstId}")
    public List<AncDetialsData> fetchAncDetialsByVstId(@PathVariable(name = "vstId") Long vstId){
        return this.clinicalInfoReadPlatformService.fetchAncDetialsByVstId(vstId);
    }

    @GetMapping("/fetchPrevAncDetialsByAncId/{ancId}")
    public List<AncDetialsData> fetchPrevAncDetialsByAncId(@PathVariable(name = "ancId") Long ancId){
        return this.clinicalInfoReadPlatformService.fetchPrevAncDetialsByAncId(ancId);
    }

    @PutMapping("/updateAncCaseSheet/{id}")
    public void updateAncCaseSheet(@PathVariable(name = "id") Long id, @RequestBody CreateAncRequest createAncRequest) {
//        final AppUser appUser = this.platformSecurityContext.authenticateUser();
//        if (appUser.getUser().getIsDoctor() != 1) {
//            throw new HimsApplicationContextException("Access Only For Doctors !");
//        }
        this.clinicalInfoWritePlatformService.updateAncCaseSheet(id, createAncRequest);
    }

    @PutMapping("/updateAncDetailsCaseSheet/{id}")
    public void updateAncDetailsCaseSheet(@PathVariable(name = "id") Long id, @RequestBody CreateAncDetailsRequest createAncDetailsRequest) {
//        final AppUser appUser = this.platformSecurityContext.authenticateUser();
//        if (appUser.getUser().getIsDoctor() != 1) {
//            throw new HimsApplicationContextException("Access Only For Doctors !");
//        }
        this.clinicalInfoWritePlatformService.updateAncDetailsCaseSheet(id, createAncDetailsRequest);
    }
    @PostMapping("/saveDeliveryDetails")
    public Response saveDeliveryDetails (@RequestBody CreateAncDeliveryRequest createAncDeliveryRequest){
//        final AppUser appUser = this.platformSecurityContext.authenticateUser();
//        if (appUser.getUser().getIsDoctor() != 1) {
//            throw new HimsApplicationContextException("Access Only for Doctors !");
//        }
        return this.clinicalInfoWritePlatformService.saveDeliveryDetails(createAncDeliveryRequest);
    }
    @GetMapping("/fetchAncDeliveryDetials/{vstId}")
    public List<AncDeliveryData> fetchAncDeliveryDetialsByVstId(@PathVariable(name = "vstId") Long vstId){
        return this.clinicalInfoReadPlatformService.fetchAncDeliveryDetialsByVstId(vstId);
    }

    @PutMapping("/updateDeliveryDetails/{id}")
    public void updateDeliveryDetails(@PathVariable(name = "id") Long id, @RequestBody CreateAncDeliveryRequest createAncDeliveryRequest) {
//        final AppUser appUser = this.platformSecurityContext.authenticateUser();
//        if (appUser.getUser().getIsDoctor() != 1) {
//            throw new HimsApplicationContextException("Access Only For Doctors !");
//        }
        this.clinicalInfoWritePlatformService.updateDeliveryDetails(id, createAncDeliveryRequest);
    }

    @PutMapping("/updateNursingIO/{id}")
    public void updateNursingIoSheet(@PathVariable(name = "id") Long id, @RequestBody CreateNursingIoReuest createNursingIoReuest) {
        this.clinicalInfoWritePlatformService.updateNursingIoSheet(id,createNursingIoReuest);
    }
    @PostMapping("saveSurgeryChecklist")
    public Response saveSurgeryChecklist(@RequestBody CreateSurgeryChecklistReuest createSurgeryChecklistReuest) {
        return this.clinicalInfoWritePlatformService.saveSurgeryChecklist(createSurgeryChecklistReuest);
    }
    @GetMapping("/fetchSurgeryChecklistByVatId/{vstId}")
    public List<SurgeryCheckListData> fetchSurgeryChecklistByVatId(@PathVariable(name = "vstId") Long vstId) {
        return this.clinicalInfoReadPlatformService.fetchSurgeryChecklistByVatId(vstId);
    }
    @PutMapping("/updateSurgeryChecklist/{id}")
    public void updateSurgeryChecklist(@PathVariable(name = "id") Long id, @RequestBody CreateSurgeryChecklistReuest createSurgeryChecklistReuest) {
        this.clinicalInfoWritePlatformService.updateSurgeryChecklist(id,createSurgeryChecklistReuest);
    }


    @PostMapping("/saveAldreteScoreChart")
    public Response saveAldreteScoreChart(@RequestBody CreateAldreteScoreChartReuest createAldreteScoreChartReuest) {
        return this.clinicalInfoWritePlatformService.saveAldreteScoreChart(createAldreteScoreChartReuest);
    }
    @GetMapping("/fetchAldreteScoreChartByVatId/{vstId}")
    public List<AldreteScoreChartData> fetchAldreteScoreChartByVstId(@PathVariable(name = "vstId") Long vstId) {
        return this.clinicalInfoReadPlatformService.fetchAldreteScoreChartByVstId(vstId);
    }
    @PutMapping("/updateAldreteScoreChart/{id}")
    public void updateAldreteScoreChart(@PathVariable(name = "id") Long id, @RequestBody CreateAldreteScoreChartReuest createAldreteScoreChartReuest) {
        this.clinicalInfoWritePlatformService.updateAldreteScoreChart(id,createAldreteScoreChartReuest);
    }

    @PostMapping("/saveDermatologyCaseSheet")
    public Response saveDermatologyCaseSheet(@RequestBody CreateDermatologyCaseSheetRequest createDermatologyCaseSheetRequest) {
        final AppUser appUser = this.platformSecurityContext.authenticateUser();
        if (appUser.getUser().getIsDoctor() != 1) {
            throw new HimsApplicationContextException("Access Only For Doctors !");
        }
        return this.clinicalInfoWritePlatformService.saveDermatologyCaseSheet(createDermatologyCaseSheetRequest);
    }

    @GetMapping("/fetchDermatologyCaseSheetByVstId/{vstId}")
    public Map<String, Object> fetchDermatologyCaseSheetByVstId(@PathVariable(name = "vstId") Long vstId) {
        return this.clinicalInfoReadPlatformService.fetchDermatologyCaseSheetByVstId(vstId);
    }

    @PutMapping("/updateDermatologyCaseSheet/{id}/{caseSheetType}")
    public void updateDermatologyCaseSheet(@PathVariable(name = "id") Long id,
                                           @PathVariable(name = "caseSheetType") Integer caseSheetType,
                                           @RequestBody CreateDermatologyCaseSheetRequest createDermatologyCaseSheetRequest) {
        final AppUser appUser = this.platformSecurityContext.authenticateUser();
        if (appUser.getUser().getIsDoctor() != 1) {
            throw new HimsApplicationContextException("Access Only For Doctors !");
        }
        this.clinicalInfoWritePlatformService.updateDermatologyCaseSheet(id,createDermatologyCaseSheetRequest,caseSheetType);
    }

    @PostMapping("/saveOpthamologyCaseSheet")
    public Response saveOpthamologyCaseSheet(@RequestBody CreateOpthamologyCaseSheetRequest createOpthamologyCaseSheetRequest) {
        final AppUser appUser = this.platformSecurityContext.authenticateUser();
        if (appUser.getUser().getIsDoctor() != 1) {
            throw new HimsApplicationContextException("Access Only For Doctors !");
        }
        return this.clinicalInfoWritePlatformService.saveOpthamologyCaseSheet(createOpthamologyCaseSheetRequest);
    }

    @GetMapping("/fetchOpthamologyCaseSheetByVstId/{vstId}")
    public Map<String, Object> fetchOpthamologyCaseSheetByVstId(@PathVariable(name = "vstId") Long vstId) {
        return this.clinicalInfoReadPlatformService.fetchOpthamologyCaseSheetByVstId(vstId);
    }

    @PutMapping("/updateOpthamologyCaseSheet/{id}/{caseSheetType}")
    public void updateOpthamologyCaseSheet(@PathVariable(name = "id") Long id,
                                           @PathVariable(name = "caseSheetType") Integer caseSheetType,
                                           @RequestBody CreateOpthamologyCaseSheetRequest createOpthamologyCaseSheetRequest) {
        final AppUser appUser = this.platformSecurityContext.authenticateUser();
        if (appUser.getUser().getIsDoctor() != 1) {
            throw new HimsApplicationContextException("Access Only For Doctors !");
        }
        this.clinicalInfoWritePlatformService.updateOpthamologyCaseSheet(id,createOpthamologyCaseSheetRequest,caseSheetType);
    }

    @PostMapping("/saveENTCaseSheet")
    public Response saveENTCaseSheet(@RequestBody CreateENTCaseSheetRequest createENTCaseSheetRequest) {
        final AppUser appUser = this.platformSecurityContext.authenticateUser();
        if (appUser.getUser().getIsDoctor() != 1) {
            throw new HimsApplicationContextException("Access Only For Doctors !");
        }
        return this.clinicalInfoWritePlatformService.saveENTCaseSheet(createENTCaseSheetRequest);
    }

    @GetMapping("/fetchENTCaseSheetByVstId/{vstId}")
    public Map<String, Object> fetchENTCaseSheetByVstId(@PathVariable(name = "vstId") Long vstId) {
        return this.clinicalInfoReadPlatformService.fetchENTCaseSheetByVstId(vstId);
    }

    @PutMapping("/updateENTCaseSheet/{id}/{caseSheetType}")
    public void updateENTCaseSheet(@PathVariable(name = "id") Long id,
                                   @PathVariable(name = "caseSheetType") Integer caseSheetType,
                                   @RequestBody CreateENTCaseSheetRequest createENTCaseSheetRequest) {
        final AppUser appUser = this.platformSecurityContext.authenticateUser();
        if (appUser.getUser().getIsDoctor() != 1) {
            throw new HimsApplicationContextException("Access Only For Doctors !");
        }
        this.clinicalInfoWritePlatformService.updateENTCaseSheet(id,createENTCaseSheetRequest,caseSheetType);
    }
    @GetMapping("/fetchLabTestFields/{tstId}")
    public List<LabTestFieldData> fetchLabTestFields(@PathVariable(name = "tstId") Long tstId) {
        return this.clinicalInfoReadPlatformService.fetchLabTestFields(tstId);
    }

    @GetMapping("fetchOutsideLabResultDetailsByVistiId/{visitId}")
    public List<OutsideLabData> fetchOutsideLabResultDetailsByVistiId(@PathVariable(name = "visitId") Long visitId) {
        return this.clinicalInfoReadPlatformService.fetchOutsideLabResultDetailsByVistiId(visitId);
    }

    @GetMapping("fetchOutsideLabPrevResultByVisitId/{vstId}")
    public List<OutsideLabPrevResultData> fetchOutsideLabPrevResultByVisitId(@PathVariable(name = "vstId") Long vstId) {
        return this.clinicalInfoReadPlatformService.fetchOutsideLabPrevResultByVisitId(vstId);
    }

    @PostMapping("/saveOutsideLabResult")
    public List<OutsideLabResultData> saveOutsideLabResult(@RequestBody CreateOutsideLabRequest createOutsideLabRequest) {
        return this.clinicalInfoWritePlatformService.saveOutsideLabResult((createOutsideLabRequest));
    }

    @PutMapping("/updateOutsideLabResult/{disp}")
    public List<OutsideLabResultData> updateOutsideLabResult(@PathVariable(name = "disp") Long disp, @RequestBody CreateOutsideLabRequest createOutsideLabRequest) {
        return this.clinicalInfoWritePlatformService.updateOutsideLabResult(disp,createOutsideLabRequest);
    }

    @GetMapping("/fetchOutsideLabPrevResultDetails/{display}")
    public List<OutsideLabPrevResultDetailsData> fetchOutsideLabPrevResultDetails(@PathVariable(name = "display") Long display) {
        return this.clinicalInfoReadPlatformService.fetchOutsideLabPrevResultDetails(display);
    }

    @PostMapping("/saveOutsideInvDetails")
    public List<OutsideLabResultData> saveOutsideInvDetails(@RequestBody CreateOutsideInvRequest createOutsideInvRequest) {
        return this.clinicalInfoWritePlatformService.saveOutsideInvDetails(createOutsideInvRequest);
    }

    @PutMapping("/updateOutsideInvDetails/{disp}")
    public List<OutsideLabResultData> updateOutsideInvDetails(@PathVariable(name = "disp") Long disp, @RequestBody CreateOutsideInvRequest createOutsideInvRequest) {
        return this.clinicalInfoWritePlatformService.updateOutsideInvDetails(disp,createOutsideInvRequest);
    }

    @GetMapping("fetchOutsideInvPrevResultByVisitId/{vstId}")
    public List<OutsideLabPrevResultData> fetchOutsideInvPrevResultByVisitId(@PathVariable(name = "vstId") Long vstId) {
        return this.clinicalInfoReadPlatformService.fetchOutsideInvPrevResultByVisitId(vstId);
    }

    @GetMapping("/fetchOutsideInvPrevResultDetails/{display}")
    public List<OutsideInvPrevDetailsData> fetchOutsideInvPrevResultDetails(@PathVariable(name = "display") Long display) {
        return this.clinicalInfoReadPlatformService.fetchOutsideInvPrevResultDetails(display);
    }

    @GetMapping("/fetchAllInvDetailsByVisitId/{vstId}")
    public List<OutsideInvData> fetchAllInvDetailsByVisitId(@PathVariable(name = "vstId") Long vstId) {
        return this.clinicalInfoReadPlatformService.fetchAllInvDetailsByVisitId(vstId);
    }

    @GetMapping("fetchOutsideLabResultDetailsByPatId/{patId}")
    public List<OutsideLabData> fetchOutsideLabResultDetailsByPatId(@PathVariable(name = "patId") Long patId) {
        return this.clinicalInfoReadPlatformService.fetchOutsideLabResultDetailsByPatId(patId);
    }

    @GetMapping("/fetchAllInvDetailsByPatId/{patId}")
    public List<OutsideInvData> fetchAllInvDetailsByPatId(@PathVariable(name = "patId") Long patId) {
        return this.clinicalInfoReadPlatformService.fetchAllInvDetailsByPatId(patId);
    }

    @GetMapping("/fetchPatientInvImageDetailsByVstId/{vstId}")
    public List<ImgInvData> fetchPatientInvImageDetailsByVstId(@PathVariable(name = "vstId") String vstId) {
        return this.clinicalInfoReadPlatformService.fetchPatientInvImageDetailsByVstId(vstId);
    }

    @GetMapping("/fetchPatientInvImageDetailsByPatId/{patId}")
    public List<ImgInvData> fetchPatientInvImageDetailsByPatId(@PathVariable(name = "patId") String patId) {
        return this.clinicalInfoReadPlatformService.fetchPatientInvImageDetailsByPatId(patId);
    }
    @PutMapping("/updateSelectedImage/{id}/{blockedId}")
    public void updateSelectedImage(@PathVariable(name = "id") Long id,@PathVariable(name = "blockedId") Long blockedId,
            @RequestBody CreateImgInvUploadRequest createImgInvUploadRequest) {
//        final AppUser appUser = this.platformSecurityContext.authenticateUser();
//        if (appUser.getUser().getIsDoctor() != 1) {
//            throw new HimsApplicationContextException("Access Only For Doctors !");
//        }
        this.clinicalInfoWritePlatformService.updateSelectedImage(id,blockedId,createImgInvUploadRequest);
    }

    @GetMapping("/uploadedPdf/{id}")
    public  List<Map<String, Object>> getUploadePdf(@PathVariable(name = "id") Long id) {
        return this.clinicalInfoReadPlatformService.fetchUploadePdf(id);
    }

    @GetMapping("/fetchPatientAppointmentByVstId/{vstId}/{type}")
    public List<AppointmentData> fetchPatientAppointmentByVstId (@PathVariable(name = "vstId") Long vstId,
                                                                 @PathVariable(name = "type") Long type) {
        return this.clinicalInfoReadPlatformService.fetchPatientAppointmentByVstId(vstId,type);
    }

    @PostMapping("/savePatientAppointmentRegister")
    public Response savePatientAppointmentRegister(@RequestBody AppointmentRequest appointmentRequest) {
        final AppUser appUser = this.platformSecurityContext.authenticateUser();
        if (appUser.getUser().getIsDoctor() !=1) {
            throw  new HimsApplicationContextException(("Access Only For Doctors !"));
        }
        return this.clinicalInfoWritePlatformService.savePatientAppointmentRegister(appointmentRequest);
    }

    @PutMapping("/updatePatientAppointmentRegister/{id}")
    public void updatePatientAppointmentRegister(@PathVariable(name = "id") Long id, @RequestBody AppointmentRequest appointmentRequest) {
        final AppUser appUser = this.platformSecurityContext.authenticateUser();
        if (appUser.getUser().getIsDoctor() != 1) {
            throw new HimsApplicationContextException("Access Only For Doctors !");
        }
        this.clinicalInfoWritePlatformService.updatePatientAppointmentRegister(id,appointmentRequest);
    }

    @GetMapping("/fetchPatientAppointmentRegister")
    public List<AppointmentRegisterData> fetchPatientAppointmentRegister () {
        return this.clinicalInfoReadPlatformService.fetchPatientAppointmentRegister();
    }

    @GetMapping("/fetchOpVitalsHeightByPatId/{patId}")
    public  List<Map<String, Object>> fetchOpVitalsHeightByPatId(@PathVariable(name = "patId") Long patId) {
        return this.clinicalInfoReadPlatformService.fetchOpVitalsHeightByPatId(patId);
    }

    @PutMapping("/deleteCaseSheetTemplate/{id}")
    public String deleteCaseSheetTemplate (@PathVariable(name = "id") Long id) {
        return this.clinicalInfoWritePlatformService.deleteCaseSheetTemplateById(id);
    }

    @PutMapping("deleteOutsideLabResult/{id}")
    public String deleteOutsideLabResult (@PathVariable(name = "id") Long id) {
        return this.clinicalInfoWritePlatformService.blockOutsideLabResultById(id);
    }

    @GetMapping("/fetchLabResultsByPatientId/{patId}")
    public List<Map<String,Object>> fetchLabResultsByPatientId (@PathVariable("patId") Long patId){
        return this.clinicalInfoReadPlatformService.fetchLabResultsByPatientId(patId);
    }

    @PutMapping("deleteOutsideInvResult/{id}")
    public String deleteOutsideInvResult (@PathVariable(name = "id") Long id) {
        return this.clinicalInfoWritePlatformService.blockOutsideInvResultById(id);
    }

    @PutMapping("editPrescriptionTemplate")
    public String editPrescriptionTemplate (@RequestBody CreatePrescTemplateEditRequest createPrescTemplateRequest) {
        return this.clinicalInfoWritePlatformService.editPrescriptionTemplate(createPrescTemplateRequest);
    }
    @PutMapping("editLabTemplate/{id}")
    public String editLabTemplate (@PathVariable(name = "id") Long id) {
        return this.clinicalInfoWritePlatformService.editLabTemplate(id);
    }
    @GetMapping("/fetchGeneralInstructionByPrescId/{prescId}")
    public String fetchGeneralInstructionByPrescId (@PathVariable("prescId") Long prescId){
        return this.clinicalInfoReadPlatformService.fetchGeneralInstructionByPrescId(prescId);
    }

    @PutMapping("/updateRiskFactors/{id}")
    public String updateRiskFactors(@PathVariable(name = "id") Long id,@RequestParam String riskFactors,@RequestParam String personalInfo) {
        return this.clinicalInfoWritePlatformService.updateRiskFactors(id,riskFactors,personalInfo);
    }

    @PutMapping("updatePatientDelivery/{ancId}")
    public String updatePatientDelivery (@PathVariable(name = "ancId") Long ancId) {
        return this.clinicalInfoWritePlatformService.updatePatientDelivery(ancId);
    }

    @PutMapping("/updateCaseSheetTemplate/{id}")
    public Response updateCaseSheetTemplate (@RequestBody CreateCaseSheetTemplateRequest createCaseSheetTemplateRequest, @PathVariable(name = "id") Long id) {
        return this.clinicalInfoWritePlatformService.updateCaseSheetTemplate(createCaseSheetTemplateRequest,id);
    }

    @PutMapping("updateAncChildDetails")
    public Response updateAncChildDetails (@RequestBody CreateAncChildRequest createAncChildRequest) {
        return this.clinicalInfoWritePlatformService.updateAncChildDetails(createAncChildRequest);
    }

    @PostMapping("/saveDoctorTransfer")
    public Response transferDoctorAndSaveInvestigation(@RequestBody CreateDoctorTransferRequest createDoctorTransferRequest,  HttpServletRequest httpRequest) {

        final AppUser appUser = this.platformSecurityContext.authenticateUser();
        if (appUser.getUser().getIsDoctor() != 1) {
            throw new HimsApplicationContextException("Access Only For Doctors !");
        }

        String clientIp = getClientIp(httpRequest);
        return this.clinicalInfoWritePlatformService.saveDoctorTransferDetails(createDoctorTransferRequest , appUser.getUser().getId(), appUser.getUser().getDoctor_id(),clientIp);
//       return this.clinicalInfoWritePlatformService.saveDoctorTransferDetails(createDoctorTransferRequest , 1L , 1L);
    }

    private String getClientIp(HttpServletRequest request) {
        String xfHeader = request.getHeader("X-Forwarded-For");
        if (xfHeader == null) {
            return request.getRemoteAddr();
        }
        return xfHeader.split(",")[0];
    }

    @GetMapping("/fetchDoctorTransfer/{visitId}")
    public List<DoctorTransferData> fetchDoctorTransfer (@PathVariable("visitId") Long visitId){
        return this.clinicalInfoReadPlatformService.fetchDoctorTransfer(visitId);
    }

    @PutMapping("removeDoctorTransfer/{transferId}")
    public Response removeDoctorTransfer (@PathVariable("transferId") Long transferId) {

        final AppUser appUser = this.platformSecurityContext.authenticateUser();
        if (appUser.getUser().getIsDoctor() != 1) {
            throw new HimsApplicationContextException("Access Only For Doctors !");
        }
        return this.clinicalInfoWritePlatformService.removeDoctorTransfer(transferId,appUser.getUser().getId());
    }

    @PutMapping("receiveDoctorTransfer/{transferId}")
    public Response receiveDoctorTransfer (@PathVariable("transferId") Long transferId) {

        final AppUser appUser = this.platformSecurityContext.authenticateUser();
        if (appUser.getUser().getIsDoctor() != 1) {
            throw new HimsApplicationContextException("Access Only For Doctors !");
        }
        return this.clinicalInfoWritePlatformService.receiveDoctorTransfer(transferId,appUser.getUser().getDoctor_id());
    }
    @PutMapping("completeDoctorTransfer/{transferId}/{reviewDate}")
    public Response completeDoctorTransfer (@PathVariable("transferId") Long transferId, @PathVariable("reviewDate") String  reviewDate) {

        final AppUser appUser = this.platformSecurityContext.authenticateUser();
        if (appUser.getUser().getIsDoctor() != 1) {
            throw new HimsApplicationContextException("Access Only For Doctors !");
        }
        return this.clinicalInfoWritePlatformService.completeDoctorTransfer(transferId, reviewDate ,appUser.getUser().getDoctor_id());
    }

    @PutMapping("reOpenDoctorTransfer/{transferId}")
    public Response reOpenDoctorTransfer (@PathVariable("transferId") Long transferId) {

        final AppUser appUser = this.platformSecurityContext.authenticateUser();
        if (appUser.getUser().getIsDoctor() != 1) {
            throw new HimsApplicationContextException("Access Only For Doctors !");
        }
        return this.clinicalInfoWritePlatformService.reOpenDoctorTransfer(transferId,appUser.getUser().getDoctor_id());
    }

    @GetMapping("/fetchDocPatientList/{toDoc}")
    public List<DocPatientListData> fetchDocPatientList(@PathVariable("toDoc") Long toDoc) {
        return this.clinicalInfoReadPlatformService.fetchDocPatientList(toDoc);
    }

    @GetMapping("/fetchDocPatientListByDate/{toDoc}/{date}")
    public List<DocPatientListData> fetchDocPatientListByDate(@PathVariable("toDoc") Long toDoc,
                                                               @PathVariable("date") String date) {
        return this.clinicalInfoReadPlatformService.fetchDocPatientListByDate(toDoc, date);
    }

    @GetMapping("/fetchDocStatus/{doctor_id}")
    public DoctorScheduleStatusData fetchDocStatus(@PathVariable("doctor_id") Long doctorId) {
        log.debug("REST request to fetchDocStatus doctorId {}", doctorId);
        return this.clinicalInfoReadPlatformService.fetchDocStatus(doctorId);
    }

    @RequestMapping(value = "/updateDocStatus/{doctor_id}/{status}",
                    method = {RequestMethod.PUT, RequestMethod.POST})
    public Response updateDocStatus(@PathVariable("doctor_id") Long doctorId,
                                    @PathVariable("status") String status) {
        log.debug("REST request to updateDocStatus doctorId {} status {}", doctorId, status);
        return this.clinicalInfoWritePlatformService.updateDocStatus(doctorId, status);
    }

    @PutMapping("/updateDoctorViewing/{patId}/{vstId}")
    public Response updateDoctorViewing(@PathVariable("patId") Long patId,
                                        @PathVariable("vstId") Long vstId) {
        final AppUser appUser = this.platformSecurityContext.authenticateUser();
        if (appUser.getUser().getIsDoctor() != 1) {
            throw new HimsApplicationContextException("Access Only For Doctors !");
        }
        log.debug("REST request to updateDoctorViewing patId={} vstId={}", patId, vstId);
        return this.clinicalInfoWritePlatformService.updateDoctorViewing(
                patId, vstId, appUser.getUser().getDoctor_id());
    }

}

