package com.ueniweb.swiftwaresolutions.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ueniweb.swiftwaresolutions.core.exception.HimsApplicationContextException;
import com.ueniweb.swiftwaresolutions.core.response.Response;
import com.ueniweb.swiftwaresolutions.data.AncChildDetialsData;
import com.ueniweb.swiftwaresolutions.data.OutsideLabResultData;
import com.ueniweb.swiftwaresolutions.data.PrescriptionData;
import com.ueniweb.swiftwaresolutions.data.validator.CaseSheetValidator;
import com.ueniweb.swiftwaresolutions.data.validator.PrescriptionValidator;
import com.ueniweb.swiftwaresolutions.domain.*;
import com.ueniweb.swiftwaresolutions.infrastructure.exceptions.ApiResponse;
import com.ueniweb.swiftwaresolutions.infrastructure.exceptions.NoRecordFoundException;
import com.ueniweb.swiftwaresolutions.infrastructure.exceptions.NotFoundException;
import com.ueniweb.swiftwaresolutions.repository.*;
import com.ueniweb.swiftwaresolutions.request.*;
import com.ueniweb.swiftwaresolutions.utils.DateTimeUtils;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Enumeration;
import java.util.List;
import java.util.Map;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@Service
@RequiredArgsConstructor
@Slf4j

public class ClinicalInfoWritePlatformServiceImpl implements ClinicalInfoWritePlatformService {

    private final JdbcTemplate jdbcTemplate;

    private final GeneralCaseSheetRepositoryWrapper generalCaseSheetRepositoryWrapper;

    private final GeneralCaseSheetRepository generalCaseSheetRepository;

    private final PrescriptionRepository prescriptionRepository;

    private final PrescriptionRepositoryWrapper prescriptionRepositoryWrapper;

    private final PrescriptionDetailsRepository prescriptionDetailsRepository;

    private final InvestigationOrderRepository investigationOrderRepository;

    private final TempCashBillRepository tempCashBillRepository;

    private final LabOrderRepository labOrderRepository;

    private final LabAndInvSummaryRepository labAndInvSummaryRepository;

    private final NeonateCaseSheetRepository neonateCaseSheetRepository;

    private final NeonateCaseSheetRepositoryWrapper neonateCaseSheetRepositoryWrapper;

    private final LabOrderRepositoryWrapper labOrderRepositoryWrapper;

    private final LabDeleteDetailsWritePlatformService labDeleteDetailsWritePlatformService;

    private final ClinicalInfoReadPlatformService clinicalInfoReadPlatformService;

    private final InvestigationOrderRepositoryWrapper investigationOrderRepositoryWrapper;

    private final PediatricCaseSheetWrapper pediatricCaseSheetWrapper;

    private final CaseSheetTemplateRepository caseSheetTemplateRepository;

    private final OrderDiscountRepository orderDiscountRepository;

    private final DisSumConsultantRepository disSumConsultantRepository;

    private  final AncSheetDeliveryRepository ancSheetDeliveryRepository;

    private final DisSumDeptRepository disSumDeptRepository;

    private final ComplaintDetailsRepository complaintDetailsRepository;

    private final DiagnosisDetailsRepository diagnosisDetailsRepository;

    private final DiagnosisDetailsSummaryRepository diagnosisDetailsSummaryRepository;

    private final OrderDiscountRepositoryWrapper orderDiscountRepositoryWrapper;

    private final PrescTemplateRepository prescTemplateRepository;

    private final PrescTemplateRepositoryWrapper prescTemplateRepositoryWrapper;

    private final OrderTemplateRepository orderTemplateRepository;

    private final AnthropometryRepository anthropometryRepository;

    private final DischargeSummaryRepository dischargeSummaryRepository;

    private final DisSummaryRepositoryWrapper disSummaryRepositoryWrapper;

    private final CaseSheetValidator caseSheetValidator;

    private final PrescriptionValidator prescriptionValidator;

    private final EntityManager entityManager;

    private final PediatricCaseSheetRepository pediatricCaseSheetRepository;

    private final OPVitalsRepository opVitalsRepository;

    private final OPVitalsRepositoryWrapper opVitalsRepositoryWrapper;

    private final SummaryTemplateRepository summaryTemplateRepository;

    private final AntenatalCaseSheetRepository antenatalCaseSheetRepository;

    private final DentalCaseSheetRepository dentalCaseSheetRepository;

    private final DentalCaseSheetRepositoryWrapper dentalCaseSheetRepositoryWrapper;

    private final DentalComplaintDetailsRepository dentalcomplaintDetailsRepository;

    private final DentalTeethExamDetailsRepository dentalTeethExamDetailsRepository;

    private final DentalTeethTreatDetailsRepository dentalTeethTreatDetailsRepository;

    private final AntenatalCaseSheetRepositotyWrapper antenatalCaseSheetRepositotyWrapper;

    private final AncRepositoryWrapper ancRepositoryWrapper;

    private final AncDeliveryDetialsRepositoryWrapper ancDeliveryDetialsRepositoryWrapper;

    private final AncDeliveryInductionRepository ancDeliveryInductionRepository;

    private final AntenatalCaseSheetPreRepository antenatalCaseSheetPreRepository;

    private final SurgeryCaseSheetRepository surgeryCaseSheetRepository;

    private final AncCasesheetRepository ancCasesheetRepository;

    private final AncDetailsRepository ancDetailsRepository;

    private final AncDetailsRepositoryWrapper ancDetailsRepositoryWrapper;

    private final SurgeryCaseSheetRepositoryWrapper surgeryCaseSheetRepositoryWrapper;

    private final SurgeryNurseRepository surgeryNurseRepository;

    private final SurgerySurgonRepository surgerySurgonRepository;

    private final SurgeryNAmeRepository surgeryNAmeRepository;

    private final NursingIoRepository nursingIoRepository;

    private final IpProcedureCaseSheetRepository ipProcedureCaseSheetRepository;

    private final IpProcedureCaseSheetRepositoryWrapper ipProcedureCaseSheetRepositoryWrapper;

    private final PrescriptionDiscountRepository prescriptionDiscountRepository;

    private final PrescriptionDiscountRepositoryWrapper prescriptionDiscountRepositoryWrapper;

    private final NursingIoRepositoryWrapper nursingIoRepositoryWrapper;

    private final SurgeryChecklistRepository surgeryChecklistRepository;

    private final SurgeryChecklistRepositoryWrapper surgeryChecklistRepositoryWrapper;

    private final AldreteScoreChartRepository aldreteScoreChartRepository;

    private final AldreteScoreChartRepositoryWrapper aldreteScoreChartRepositoryWrapper;

    private final DermatologyCaseSheetRepository dermatologyCaseSheetRepository;

    private final DermatologyCaseSheetRepositoryWrapper dermatologyCaseSheetRepositoryWrapper;

    private final DermatologyComplainDetailsRepository dermatologyComplainDetailsRepository;

    private final DermatologyDiagnosisDetailsRepository dermatologyDiagnosisDetailsRepository;

    private final OpthamologyCaseSheetRepository opthamologyCaseSheetRepository;

    private final OpthamologyCaseSheetRepositoryWrapper opthamologyCaseSheetRepositoryWrapper;

    private final OpthamologyComplainDetailsRepository opthamologyComplainDetailsRepository;

    private final OpthamologyDiagnosisDetailsRepository opthamologyDiagnosisDetailsRepository;

    private final ENTCaseSheetRepository entCaseSheetRepository;

    private final ENTCaseSheetRepositoryWrapper entCaseSheetRepositoryWrapper;

    private final ENTComplainDetailsRepository entComplainDetailsRepository;

    private final ENTDiagnosisDetailsRepository entDiagnosisDetailsRepository;

    private final OutsideLabRepository outsideLabRepository;

    private final OutsideInvRepository outsideInvRepository;

    private final ImgInvRepository imgInvRepository;

    private final ImgInvRepositoryWrapper imgInvRepositoryWrapper;

    private final AppointmentRepository appointmentRepository;

    private final AppointmentRepositoryWrapper appointmentRepositoryWrapper;

    private final AncChildRepository ancChildRepository ;

    private final RecDoctorTransferRepository recDoctorTransferRepository;

//    private final String imageUploadDirectory = "D:/APPLICATION/RFH/HIS_rfh/XrayImages/";

//    @Value("${invImage.directory}")
//    private String uploadDir;

    private String uploadDir = "\\\\192.168.1.60\\d\\APPLICATION\\GDH\\HIS_gdh\\uploadImages";

    private String uploadDirct = "\\\\192.168.1.60\\d\\APPLICATION\\GDH\\HIS_gdh";

//    private String uploadDir = "D:\\Application\\GDH\\HIS_gdh\\uploadImages";

//   private String uploadDirct = "D:\\Application\\GDH\\HIS_gdh";

    @Transactional
    @Override
    public Response saveGeneralCaseSheet(final GeneralCaseSheetRequest generalCaseSheetRequest) {
        try {
            log.debug("START saveGeneralCaseSheet request {}", generalCaseSheetRequest);
            this.caseSheetValidator.validateComplaintData(generalCaseSheetRequest.getCreateComplaintDetailsRequestList());
            this.caseSheetValidator.GeneralCaseSheetDate(generalCaseSheetRequest);
            if (generalCaseSheetRequest.getVisitId() == 0 || generalCaseSheetRequest.getPatientId() == 0) {
                throw new NullPointerException("Choose Proper Patient!");
            }

            final GeneralCaseSheet newGeneralCaseSheet = GeneralCaseSheet.to(generalCaseSheetRequest);
            newGeneralCaseSheet.setComplaintDetailsList(ComplaintDetails.to(newGeneralCaseSheet, generalCaseSheetRequest.getCreateComplaintDetailsRequestList()));
            newGeneralCaseSheet.setDiagnosisDetailsList(DiagnosisDetails.to(newGeneralCaseSheet, generalCaseSheetRequest.getCreateDiagnosisDetailsRequestList()));
            generalCaseSheetRepository.saveAndFlush(newGeneralCaseSheet);
            log.debug("END saveGeneralCaseSheet id ");
            return new Response(newGeneralCaseSheet.getId());
        } catch (Exception e) {
            log.error("Caught with exception while saving GeneralCaseSheet {}", e.getMessage());
            throw new RuntimeException(e);

        }

    }

    @Transactional
    @Override
    public List<PrescriptionData> savePrescription(final CreatePrescriptionRequest createPrescriptionRequest, final Long doctorId) {
        try {
            log.debug("START savePrescription request {}", createPrescriptionRequest);
            this.prescriptionValidator.validatePrescriptionData(createPrescriptionRequest.getCreatePrescriptionDetailsRequestList());
            final Prescription prescription = Prescription.to(createPrescriptionRequest, doctorId);
            this.entityManager.persist(prescription);  // for inserting display
            prescription.setDisplay(prescription.getId().toString());// for inserting display
            prescription.setPhDescriptionDetailsList(PrescriptionDetails.to(prescription, createPrescriptionRequest.getCreatePrescriptionDetailsRequestList()));
            final PrescDiscount prescDiscount =  PrescDiscount.to(prescription.getId(),createPrescriptionRequest);
            prescriptionDiscountRepository.saveAndFlush(prescDiscount);
            final Prescription newPrescription = prescriptionRepository.saveAndFlush(prescription);
            log.debug("END savePrescription id ");
            return this.clinicalInfoReadPlatformService.fetchPrescriptionDetailsById(newPrescription.getId());
        } catch (Exception e) {
            log.error("Caught with exception while saving savePrescription {}", e.getMessage());
            throw e;
        }
    }

    @Transactional
    @Override
    public void saveInvestigationOrder(final List<CreateInvestigationOrderRequest> createInvestigationOrderRequest , Long docId , Long userId) {
        try {
            log.debug("START SAVE InvestigationOrder request {}", createInvestigationOrderRequest);

            if (createInvestigationOrderRequest == null || createInvestigationOrderRequest.isEmpty()) {
                log.debug("No investigation orders to save");
                return;
            }

            // compute total and get patient/visit from first request (assume same patient/visit for the batch)
            double total = 0.0;
            Long patId = createInvestigationOrderRequest.get(0).getPatId();
            Long visitId = createInvestigationOrderRequest.get(0).getVstId();

            for (CreateInvestigationOrderRequest req : createInvestigationOrderRequest) {
                double unit = req.getUnit() == null ? 0.0 : req.getUnit();
                double returnUnit = req.getReturnUnit() == null ? 0.0 : req.getReturnUnit();
                double rate = req.getRate() == null ? 0.0 : req.getRate();
                double disc = req.getDisc() == null ? 0.0 : req.getDisc();
                double effectiveUnits = unit - returnUnit;
                double lineAmount = effectiveUnits * rate - disc;
                total += lineAmount;
            }

            TempCashBill tempCashBill = new TempCashBill();
            tempCashBill.setTotal(total);
            tempCashBill.setOrderDisplay("");
            tempCashBill.setStoreId(1);
            tempCashBill.setOrderUid(userId);
            tempCashBill.setOrderDatetime(DateTimeUtils.convertLocalDateToDateTimeFormat(LocalDateTime.now()));
            tempCashBill.setIsCancelled(false);
            tempCashBill.setIsBilled(false);
            tempCashBill.setBillUid(0L);
            tempCashBill.setBillDatetime("0000-00-00 00:00:00");
            tempCashBill.setPatId(patId);
            tempCashBill.setVisitId(visitId);
            tempCashBill.setIpId(0L);
            tempCashBill.setIsOrdered(true);
            tempCashBill.setFinalBillId(0L);
            tempCashBill.setDoctId(docId);

            TempCashBill savedBill = this.tempCashBillRepository.saveAndFlush(tempCashBill);

            // update order_display to include prefix using generated id
            try {
                savedBill.setOrderDisplay("INV" + savedBill.getId());
                this.tempCashBillRepository.saveAndFlush(savedBill);
            } catch (Exception ex) {
                log.warn("Failed to update order_display for bill {}: {}", savedBill.getId(), ex.getMessage());
            }

            final List<InvestigationOrder> investigationOrderList = InvestigationOrder.to(createInvestigationOrderRequest, docId, userId);
            // set bill id on each investigation order
            for (InvestigationOrder io : investigationOrderList) {
                io.setBillId(savedBill.getId());
                io.setFinalBillId(0L);
            }

            this.investigationOrderRepository.saveAllAndFlush(investigationOrderList);
            log.debug("END SAVE InvestigationOrder id ");
        } catch (Exception e) {
            log.error("Caught with exception while saving Investigation Order {}", e.getMessage());
        }
    }

    @Transactional
    @Override
    public Response updateGeneralCaseSheet(Long id, GeneralCaseSheetRequest generalCaseSheetRequest, Integer caseSheetType) {
        try {
            log.debug("START of updateGeneralCaseSheet() id {} request {} caseSheetType{}", id, generalCaseSheetRequest, caseSheetType);
            final GeneralCaseSheet generalCaseSheet = this.generalCaseSheetRepositoryWrapper.findOneWithNotFoundDetection(id);
            generalCaseSheet.update(generalCaseSheetRequest);
            this.generalCaseSheetRepository.saveAndFlush(generalCaseSheet);

            final List<ComplaintDetails> complaintDetailsList = this.complaintDetailsRepository.fetchComplaintDetailsBycaseSheetId(generalCaseSheet.getId(), caseSheetType);
            for (ComplaintDetails complaintDetails : complaintDetailsList) {
                complaintDetails.setIsValid(0L);
                complaintDetailsRepository.save(complaintDetails);
            }

            final List<DiagnosisDetails> diagnosisDetailsList = this.diagnosisDetailsRepository.fetchDiagnosisDetailsBycaseSheetId(generalCaseSheet.getId());
            for (DiagnosisDetails diagnosisDetails : diagnosisDetailsList) {
                diagnosisDetails.setIsValid(0L);
                diagnosisDetailsRepository.save(diagnosisDetails);
            }

            generalCaseSheet.setComplaintDetailsList(ComplaintDetails.to(generalCaseSheet, generalCaseSheetRequest.getCreateComplaintDetailsRequestList()));
            generalCaseSheet.setDiagnosisDetailsList(DiagnosisDetails.to(generalCaseSheet, generalCaseSheetRequest.getCreateDiagnosisDetailsRequestList()));
            generalCaseSheetRepository.saveAndFlush(generalCaseSheet);

            log.debug("END of updateGeneralCaseSheet() id {} request {}", id, generalCaseSheetRequest);
            return new Response(generalCaseSheet.getId());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Transactional
    @Override
    public List<PrescriptionData> updatePrescription(Long id, UpdatePrescriptionRequest updatePrescriptionRequest, Long doctorId) {
        try {
            log.debug("START updatePrescription id {} request {}", id, updatePrescriptionRequest);
            this.prescriptionValidator.validatePrescriptionData(updatePrescriptionRequest.getCreatePrescriptionDetailsRequestList());
            final Prescription prescription = this.prescriptionRepositoryWrapper.findOneWithNotFoundDetection(id);
            final List<PrescriptionDetails> prescriptionDetailsList = this.prescriptionDetailsRepository.fetchPrescriptionDetailsByPrescriptionId(prescription.getId());
            final PrescDiscount prescDiscount=this.prescriptionDiscountRepositoryWrapper.findOneWithNotFoundDetectionByPresId(id,updatePrescriptionRequest.getDiscAmt());
            prescDiscount.update(updatePrescriptionRequest);
            this.prescriptionDiscountRepository.saveAndFlush(prescDiscount);
            for (PrescriptionDetails prescriptionDetails : prescriptionDetailsList) {
                prescriptionDetails.setIsCancelled(1L);
            }
            this.prescriptionDetailsRepository.saveAllAndFlush(prescriptionDetailsList);
            prescription.setNotes(updatePrescriptionRequest.getNotes());

            prescription.setPhDescriptionDetailsList(PrescriptionDetails.to(prescription, updatePrescriptionRequest.getCreatePrescriptionDetailsRequestList()));
            this.prescriptionRepository.saveAndFlush(prescription);

            log.debug("END updatePrescription id {} request {}", id, updatePrescriptionRequest);
            return this.clinicalInfoReadPlatformService.fetchPrescriptionDetailsById(prescription.getId());
        } catch (Exception e) {
            log.error("Caught with exception while saving updatePrescription {}", e.getMessage());
            throw e;
        }
    }

    @Override
    public void saveLabOrder(List<CreateLabOrderRequest> createLabOrderRequests, Long docId) {

        try {
            log.debug("START SAVE LabOrder request {}", createLabOrderRequests);

            final List<LabOrder> labOrderList = LabOrder.to(createLabOrderRequests, docId);
            this.labOrderRepository.saveAllAndFlush(labOrderList);
            log.debug("END SAVE LabOrder id ");
        } catch (Exception e) {
            log.error("Caught with exception while saving Lab Order {}", e.getMessage());
        }
    }

    @Override
    @Transactional
    public Response deleteLabOrderByLabId(Long labId , Long userId) {
        try {
            log.debug("START deleteLabOrderByLabId labId {}", labId);
            final LabOrder labOrder = this.labOrderRepositoryWrapper.findOneWithNotFoundDetection(labId);
            CreateLabDeleteDetailsRequest createLabDeleteDetailsRequest = new CreateLabDeleteDetailsRequest();
            createLabDeleteDetailsRequest.setPatId(labOrder.getPatId());
            createLabDeleteDetailsRequest.setTestId(labOrder.getTestId());
            createLabDeleteDetailsRequest.setOrderDate(Date.valueOf(LocalDate.now()));
            createLabDeleteDetailsRequest.setOrderUid(labOrder.getUid());
            createLabDeleteDetailsRequest.setUid(labOrder.getUid());
            createLabDeleteDetailsRequest.setUnits(labOrder.getUnit());
            createLabDeleteDetailsRequest.setDate(Date.valueOf(LocalDate.now()));
            createLabDeleteDetailsRequest.setTime(Time.valueOf(LocalTime.now()));
            this.labDeleteDetailsWritePlatformService.saveLabDeleteDetails(createLabDeleteDetailsRequest);
//            this.labOrderRepository.deleteById(labOrder.getId());
//            log.debug("END deleteLabOrderByLabId ");
//            return new Response(labId);

            int updatedRows = labOrderRepository.cancelLabOrder(labId, userId);

            if (updatedRows == 0) {
                throw new RuntimeException(
                        "Lab order already cancelled or billed"
                );
            }

            log.debug("END cancelLabOrder");
            return new Response(labId);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Response deleteLabOrderByPatientId(Long patientId , Long userId) {
        try {
            log.debug("START deleteLabOrderByPatientId patientId {}", patientId);
//            final List<LabOrder> labOrderList = this.labOrderRepositoryWrapper.findOneWithNotFoundDetectionByPatientId(patientId);
            List<LabOrder> labOrderList = null;
//                    labOrderRepositoryWrapper
//                            .findActiveUnbilledByPatientId(patientId);
            if (labOrderList == null || labOrderList.isEmpty()) {
                throw new NotFoundException("This patient doesn't have any lab order");
            }
            for (LabOrder labOrder : labOrderList) {
                CreateLabDeleteDetailsRequest createLabDeleteDetailsRequest = new CreateLabDeleteDetailsRequest();
                createLabDeleteDetailsRequest.setPatId(labOrder.getPatId());
                createLabDeleteDetailsRequest.setTestId(labOrder.getTestId());
                createLabDeleteDetailsRequest.setOrderDate(Date.valueOf(LocalDate.now()));
                createLabDeleteDetailsRequest.setOrderUid(labOrder.getUid());
                createLabDeleteDetailsRequest.setUid(labOrder.getUid());
                createLabDeleteDetailsRequest.setUnits(labOrder.getUnit());
                createLabDeleteDetailsRequest.setDate(Date.valueOf(LocalDate.now()));
                createLabDeleteDetailsRequest.setTime(Time.valueOf(LocalTime.now()));
                this.labDeleteDetailsWritePlatformService.saveLabDeleteDetails(createLabDeleteDetailsRequest);
//                log.debug("END deleteLabOrderByPatientId ");
//                this.labOrderRepository.delete(labOrder);
                int updatedRows =
                        labOrderRepository
                                .cancelLabOrdersByPatientId(patientId, userId);

                if (updatedRows == 0) {
                    throw new RuntimeException(
                            "Lab orders already cancelled or billed"
                    );
                }

                log.debug("END cancelLabOrdersByPatientId");
                return new Response(patientId);
            }
            return new Response(patientId);
        } catch (RuntimeException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Response deleteInvestigationOrderById(Long orderId, Long userId) {
        try {
            log.debug("START deleteInvestigationOrderById orderId {}", orderId);
//            final InvestigationOrder investigationOrder = this.investigationOrderRepositoryWrapper.findOneWithNotFoundDetection(orderId);
          //  this.investigationOrderRepository.deleteById(investigationOrder.getId());
           // log.debug("END deleteLabOrderByLabId ");
           // return new Response(orderId);

            int updatedRows = investigationOrderRepository.cancelInvestigationOrder(orderId, userId);

            if (updatedRows == 0) {
                throw new RuntimeException("Investigation order not found");
            }

            log.debug("END cancelInvestigationOrder");
            return new Response(orderId);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Response deleteInvestigationOrderByPatientId(Long patientId, Long userId) {
        try {
            log.debug("START deleteInvestigationOrderByPatientId patientId {}", patientId);
//            final List<InvestigationOrder> investigationOrders = this.investigationOrderRepositoryWrapper.findOneWithNotFoundDetectionByPatientId(patientId);
//            if (investigationOrders == null) {
//                throw new NotFoundException("This patientId doesn't have any investigation order");
//            }
//            for (InvestigationOrder investigationOrder : investigationOrders) {
//                this.investigationOrderRepository.deleteById(investigationOrder.getId());
//            }
//            log.debug("END deleteLabOrderByLabId ");
//            return new Response(patientId);

            int updatedRows =
                    investigationOrderRepository.cancelInvestigationOrdersByPatientId(patientId, userId);

            if (updatedRows == 0) {
                throw new NotFoundException(
                        "No active investigation orders found for this patient."
                );
            }

            log.debug("END cancelInvestigationOrdersByPatientId");
            return new Response(patientId);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public Response saveCaseSheetTemplate(CreateCaseSheetTemplateRequest createCaseSheetTemplateRequest) {
        try {
            log.debug("START saveCaseSheetTemplate createCaseSheetTemplateRequest {}", createCaseSheetTemplateRequest);
            final CaseSheetTemplate caseSheetTemplate = CaseSheetTemplate.to(createCaseSheetTemplateRequest);
            this.caseSheetTemplateRepository.saveAndFlush(caseSheetTemplate);
            log.debug("END saveCaseSheetTemplate id ");
            return new Response(caseSheetTemplate.getId());
        } catch (Exception e) {
            log.error("Caught with exception while saving createCaseSheetTemplateRequest {}", e.getMessage());
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public Response saveOrderDiscount(CreateOrderDiscountRequest createOrderDiscountRequest) {
        try {
            log.debug("START saveOrderDiscount CreateOrderDiscountRequest {}", createOrderDiscountRequest);
            final OrderDiscount orderDiscount = OrderDiscount.to(createOrderDiscountRequest);
            this.orderDiscountRepository.saveAndFlush(orderDiscount);
            log.debug("END saveOrderDiscount id ");
            return new Response(orderDiscount.getId());
        } catch (Exception e) {
            log.error("Caught with exception while savingOrderDiscount {}", e.getMessage());
            throw new RuntimeException(e.getMessage());
        }
    }

    @Transactional
    @Override
    public Response savePrescriptionTemplate(final CreatePrescTemplateRequest createPrescTemplateRequest) {
        try {
            log.debug("START savePrescriptionTemplate request {}", createPrescTemplateRequest);
            final PrescTemplate prescTemplate = PrescTemplate.to(createPrescTemplateRequest);
            prescTemplate.setPrescTemplateDetailsList(PrescTemplateDetails.to(prescTemplate, createPrescTemplateRequest.getCreatePrescTemplateRequestList()));
            this.prescTemplateRepository.saveAndFlush(prescTemplate);
            log.debug("END savePrescription id ");
            return new Response(prescTemplate.getId());
        } catch (Exception e) {
            log.error("Caught with exception while saving PrescriptionTemplate {}", e.getMessage());
            throw e;
        }
    }

    @Override
    @Transactional
    public Response deleteOrderDiscByPatId(Long patId) {
        try {
            log.debug("START deleteOrderDiscByPatId patId {}", patId);
            OrderDiscount orderDiscount = this.orderDiscountRepositoryWrapper.findOneWithNotFoundDetectionByPatId(patId);
            if (orderDiscount == null) {
                throw new NoRecordFoundException("Order discount not found for this patient Id:" + patId);
            }
            this.orderDiscountRepository.deleteById(orderDiscount.getId());
            log.debug("END deleteOrderDiscByPatId ");
            return new Response(patId);
        } catch (Exception e) {
            throw new HimsApplicationContextException(e.getMessage());
        }
    }

    @Transactional
    @Override
    public void saveProcOrderTemplate(final CreateOrderTemplateRequest createOrderTemplateRequest) {
        try {
            log.debug("START saveProcOrderTemplate request {}", createOrderTemplateRequest);

            final OrderTemplate orderTemplate = OrderTemplate.to(createOrderTemplateRequest);
            orderTemplate.setOrderTemplateDetailsList(OrderTemplateDetails.to(orderTemplate, createOrderTemplateRequest.getCreateOrderTemplateDetailsRequestsList()));
            orderTemplateRepository.saveAndFlush(orderTemplate);
            log.debug("END saveProcOrderTemplate id ");
        } catch (Exception e) {
            log.error("Caught with exception while saving ProcOrderTemplate {}", e.getMessage());
            throw e;
        }
    }

    //@Transactional
    //@Override


    @Transactional
    @Override
    public Response savePediatricCaseSheet(final CreatePeadiatricCaseSheetRequest createPeadiatricCaseSheetRequest) {
        try {
            log.debug("START savePediatricCaseSheet request {}", createPeadiatricCaseSheetRequest);

            final PediatricCaseSheet newpediatricCaseSheet = PediatricCaseSheet.to(createPeadiatricCaseSheetRequest);
            newpediatricCaseSheet.setPediatricComplaintDetailsList(PediatricComplaintDetails.to(newpediatricCaseSheet, createPeadiatricCaseSheetRequest.getCreateComplaintDetailsRequestList()));
            pediatricCaseSheetRepository.saveAndFlush(newpediatricCaseSheet);

            log.debug("END savePediatricCaseSheet id ");
            return new Response(newpediatricCaseSheet.getId());
        } catch (Exception e) {
            log.error("Caught with exception while saving PediatricCaseSheet {}", e.getMessage());
            throw new RuntimeException(e);

        }

    }

    @Transactional
    @Override
    public Response updatePediatricCaseSheet(Long id, CreatePeadiatricCaseSheetRequest createPeadiatricCaseSheetRequest, Integer caseSheetType) {
        try {
            log.debug("START of updatePediatricCaseSheet() id {} request {}", id, createPeadiatricCaseSheetRequest);
            final PediatricCaseSheet pediatricCaseSheet = this.pediatricCaseSheetWrapper.findOneWithNotFoundDetection(id);
            pediatricCaseSheet.update(createPeadiatricCaseSheetRequest);
            this.pediatricCaseSheetRepository.saveAndFlush(pediatricCaseSheet);

            final List<ComplaintDetails> complaintDetailsList = this.complaintDetailsRepository.fetchComplaintDetailsBycaseSheetId(pediatricCaseSheet.getId(), caseSheetType);
            for (ComplaintDetails complaintDetails : complaintDetailsList) {
                complaintDetails.setIsValid(0L);
                complaintDetailsRepository.save(complaintDetails);
            }

            pediatricCaseSheet.setPediatricComplaintDetailsList(PediatricComplaintDetails.to(pediatricCaseSheet, createPeadiatricCaseSheetRequest.getCreateComplaintDetailsRequestList()));
            pediatricCaseSheetRepository.saveAndFlush(pediatricCaseSheet);

            log.debug("END of updatePediatricCaseSheet() id {} request {}", id, createPeadiatricCaseSheetRequest);
            return new Response(pediatricCaseSheet.getId());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Transactional
    @Override
    public Response saveNeonateCaseSheet(final CreateNeoNateCaseSheetRequest createNeoNateCaseSheetRequest) {
        try {
            log.debug("START saveNeonateCaseSheet request {}", createNeoNateCaseSheetRequest);

            final NeonateCaseSheet newNeonateCaseSheet = NeonateCaseSheet.to(createNeoNateCaseSheetRequest);
            newNeonateCaseSheet.setNeoNateComplaintDetailsList(NeoNateComplaintDetails.to(newNeonateCaseSheet, createNeoNateCaseSheetRequest.getCreateComplaintDetailsRequestList()));
            neonateCaseSheetRepository.saveAndFlush(newNeonateCaseSheet);

            log.debug("END saveNeonateCaseSheet id ");
            return new Response(newNeonateCaseSheet.getId());
        } catch (Exception e) {
            log.error("Caught with exception while saving PediatricCaseSheet {}", e.getMessage());
            throw new RuntimeException(e);

        }

    }

    @Transactional
    @Override
    public Response updateNeonateCaseSheet(Long id, CreateNeoNateCaseSheetRequest createNeoNateCaseSheetRequest, Integer caseSheetType) {
        try {
            log.debug("START of updateNeonateCaseSheet() id {} request {}", id, createNeoNateCaseSheetRequest);
            final NeonateCaseSheet neonateCaseSheet = this.neonateCaseSheetRepositoryWrapper.findOneWithNotFoundDetection(id);
            neonateCaseSheet.update(createNeoNateCaseSheetRequest);
            this.neonateCaseSheetRepository.saveAndFlush(neonateCaseSheet);

            final List<ComplaintDetails> complaintDetailsList = this.complaintDetailsRepository.fetchComplaintDetailsBycaseSheetId(neonateCaseSheet.getId(), caseSheetType);
            for (ComplaintDetails complaintDetails : complaintDetailsList) {
                complaintDetails.setIsValid(0L);
                complaintDetailsRepository.save(complaintDetails);
            }

            neonateCaseSheet.setNeoNateComplaintDetailsList(NeoNateComplaintDetails.to(neonateCaseSheet, createNeoNateCaseSheetRequest.getCreateComplaintDetailsRequestList()));
            neonateCaseSheetRepository.saveAndFlush(neonateCaseSheet);

            log.debug("END of updateNeonateCaseSheet() id {} request {}", id, createNeoNateCaseSheetRequest);
            return new Response(neonateCaseSheet.getId());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    @Override
    public void saveAnthropometry(List<CreateAnthropometryRequest> createAnthropometryRequests) {

        try {
            log.debug("START SAVE LabOrder request {}", createAnthropometryRequests);

            final List<Anthropometry> anthropometryList = Anthropometry.to(createAnthropometryRequests);
            this.anthropometryRepository.saveAllAndFlush(anthropometryList);
            log.debug("END SAVE createAnthropometryRequests id ");
        } catch (Exception e) {
            log.error("Caught with exception while saving Lab Order {}", e.getMessage());
        }
    }

    @Override
    public void updateAnthropometry(Long vstId, List<CreateAnthropometryRequest> createAnthropometryRequest) {
        try {
            log.debug("START updateAnthropometry id {} request {}", vstId, createAnthropometryRequest);

            final List<Anthropometry> anthropometryList = this.anthropometryRepository.fetchanthropometryListByvstId(vstId);
            for (Anthropometry anthropometry : anthropometryList) {
                anthropometry.setIsValid(0);
            }
            this.anthropometryRepository.saveAllAndFlush(anthropometryList);

            final List<Anthropometry> anthropometryList1 = Anthropometry.to(createAnthropometryRequest);
            this.anthropometryRepository.saveAllAndFlush(anthropometryList1);
            log.debug("END updatePrescription id {} request {}", id, createAnthropometryRequest);

        } catch (Exception e) {
            log.error("Caught with exception while updateAnthropometry {}", e.getMessage());
            throw e;
        }
    }

    @Override
    public Response saveOpVitals(CreateOPVitalsRequest createOPVitalsRequest) {
        try {
            log.debug("START saveOpVitals CreateOPVitalsRequest {}", createOPVitalsRequest);
            final Opvitals opvitals = Opvitals.to(createOPVitalsRequest);
            this.opVitalsRepository.saveAndFlush(opvitals);
            log.debug("END saveOpVitals id ");
            return new Response(opvitals.getId());
        } catch (Exception e) {
            log.error("Caught with exception while savingOrderDiscount {}", e.getMessage());
            throw new RuntimeException(e.getMessage());
        }
    }

    @Transactional
    @Override
    public Response updateOPVitals(Long id, CreateOPVitalsRequest createOPVitalsRequest) {
        try {
            log.debug("START of updateOPVitals() id {} request {}", id, createOPVitalsRequest);
            final Opvitals opvitals = this.opVitalsRepositoryWrapper.findOneWithNotFoundDetection(id);
            opvitals.update(createOPVitalsRequest);
            this.opVitalsRepository.saveAndFlush(opvitals);

            log.debug("END of updateOPVitals() id {} request {}", id, createOPVitalsRequest);
            return new Response(opvitals.getId());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Response saveSummaryTemplates(CreateSummaryTemplateRequest createSummaryTemplateRequest) {
        try {
            log.debug("START saveSummaryTemplates CreateSummaryTemplateRequest {}", createSummaryTemplateRequest);
            final SummaryTemplate summaryTemplate = SummaryTemplate.to(createSummaryTemplateRequest);
            this.summaryTemplateRepository.saveAndFlush(summaryTemplate);
            log.debug("END saveSummaryTemplates id ");
            return new Response(summaryTemplate.getId());
        } catch (Exception e) {
            log.error("Caught with exception while saveSummaryTemplates {}", e.getMessage());
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public Response saveDentalCaseSheet(CreateDentalCasesheetRequest createDentalCasesheetRequest) {
        try {
            log.debug("START saveDentalCasesheet CreateDentalRequest {}", createDentalCasesheetRequest);

            final DentalCaseSheet newDentalCaseSheet = DentalCaseSheet.to(createDentalCasesheetRequest);
            newDentalCaseSheet.setDentalcomplaintDetailsList(DentalComplaintDetails.to(newDentalCaseSheet, createDentalCasesheetRequest.getCreateComplaintDetailsRequestList()));
            newDentalCaseSheet.setDentalTeethExamDetailsList(DentalTeethExamDetails.to(newDentalCaseSheet, createDentalCasesheetRequest.getCreateTeethExamDetailsRequestList()));
            newDentalCaseSheet.setDentalTeethTreatDetailsList(DentalTeethTreatDetails.to(newDentalCaseSheet, createDentalCasesheetRequest.getCreateTeethTreatDetailsRequestList()));
            dentalCaseSheetRepository.saveAndFlush(newDentalCaseSheet);

            log.debug("END saveDentalCasesheet id ");
            return new Response(newDentalCaseSheet.getId());
        } catch (Exception e) {
            log.error("Caught with exception while saving DentalCasesheet {}", e.getMessage());
            throw new RuntimeException(e.getMessage());
        }
    }

    @Transactional
    @Override
    public Response updateDentalCaseSheet(Long id, CreateDentalCasesheetRequest createdentalCaseSheetRequest) {
        try {

            log.debug("START of updateDentalCaseSheet() id {} request {}", id, createdentalCaseSheetRequest);
            final DentalCaseSheet dentalCaseSheet = this.dentalCaseSheetRepositoryWrapper.findOneWithNotFoundDetection(id);
            dentalCaseSheet.update(createdentalCaseSheetRequest);
            this.dentalCaseSheetRepository.saveAndFlush(dentalCaseSheet);

            final List<DentalComplaintDetails> complaintDetailsList = this.dentalcomplaintDetailsRepository.fetchComplaintDetailsBycaseSheetId(dentalCaseSheet.getId());
            for (DentalComplaintDetails complaintDetails : complaintDetailsList) {
                complaintDetails.setIsValid(0L);
                dentalcomplaintDetailsRepository.save(complaintDetails);
            }

            final List<DentalTeethExamDetails> teethexamDetailsList = this.dentalTeethExamDetailsRepository.fetchTeethExamDetailsBycaseSheetId(dentalCaseSheet.getId());
            for (DentalTeethExamDetails teethexamDetails : teethexamDetailsList) {
                teethexamDetails.setIsValid(0L);
                dentalTeethExamDetailsRepository.save(teethexamDetails);
            }

            final List<DentalTeethTreatDetails> teethTreatDetailsList = this.dentalTeethTreatDetailsRepository.fetchTeethTreatDetailsBycaseSheetId(dentalCaseSheet.getId());
            for (DentalTeethTreatDetails teethTreatDetails : teethTreatDetailsList) {
                teethTreatDetails.setIsValid(0L);
                dentalTeethTreatDetailsRepository.save(teethTreatDetails);
            }

            dentalCaseSheet.setDentalcomplaintDetailsList(DentalComplaintDetails.to(dentalCaseSheet, createdentalCaseSheetRequest.getCreateComplaintDetailsRequestList()));
            dentalCaseSheet.setDentalTeethExamDetailsList(DentalTeethExamDetails.to(dentalCaseSheet, createdentalCaseSheetRequest.getCreateTeethExamDetailsRequestList()));
            dentalCaseSheet.setDentalTeethTreatDetailsList(DentalTeethTreatDetails.to(dentalCaseSheet, createdentalCaseSheetRequest.getCreateTeethTreatDetailsRequestList()));
            dentalCaseSheetRepository.saveAndFlush(dentalCaseSheet);

            log.debug("END of updateDentalCaseSheet() id {} request {}", id, createdentalCaseSheetRequest);
            return new Response(dentalCaseSheet.getId());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Transactional
    @Override
    public Response saveDischargeSummary(final CreateDischargeSummaryRequest createDischargeSummaryRequest) {
        try {
            log.debug("START saveDischargeSummary request {}", createDischargeSummaryRequest);

            final DischargeSummary newDischargeSummary = DischargeSummary.to(createDischargeSummaryRequest);
            newDischargeSummary.setSummaryDiagnosisDetailsList(SummaryDiagnosisDetails.to(newDischargeSummary, createDischargeSummaryRequest.getCreateSummaryDiagnosisDetailsRequestList()));
            newDischargeSummary.setLabAndInvestigationSummaryList(LabAndInvestigationSummary.to(newDischargeSummary, createDischargeSummaryRequest.getCreateLabAndInvSummaryRequestList()));
            newDischargeSummary.setDischargeSummaryConsultantList(DischargeSummaryConsultant.to(newDischargeSummary, createDischargeSummaryRequest.getCreateDisSumConsRequestList()));
            newDischargeSummary.setDischargeSummaryDeptList(DischargeSummaryDept.to(newDischargeSummary, createDischargeSummaryRequest.getCreateDisSumDeptRequestList()));
            dischargeSummaryRepository.saveAndFlush(newDischargeSummary);

            log.debug("END saveDischargeSummary id ");
            return new Response(newDischargeSummary.getId());
        } catch (Exception e) {
            log.error("Caught with exception while saving saveDischargeSummary {}", e.getMessage());
            throw new RuntimeException(e);

        }

    }

    @Transactional
    @Override
    public Response updateDischargeSummary(Long id, CreateDischargeSummaryRequest createDischargeSummaryRequest) {
        try {
            log.debug("START of updateDischargeSummary() id {} request {}", id, createDischargeSummaryRequest);
            final DischargeSummary dischargeSummary = this.disSummaryRepositoryWrapper.findOneWithNotFoundDetection(id);
            dischargeSummary.update(createDischargeSummaryRequest);
            this.dischargeSummaryRepository.saveAndFlush(dischargeSummary);

            final List<DiagnosisDetailsSummary> summaryDiagnosisDetailsList = this.diagnosisDetailsSummaryRepository.fetchDiagnosisDetailsBySumId(dischargeSummary.getId());
            for (DiagnosisDetailsSummary diagnosisDetailsSummary : summaryDiagnosisDetailsList) {
                diagnosisDetailsSummary.setIsValid(0L);
                diagnosisDetailsSummaryRepository.save(diagnosisDetailsSummary);
            }

            final List<LabAndInvestigationSummary> labAndInvestigationSummaryList = this.labAndInvSummaryRepository.fetchLabAndInvBySumId(dischargeSummary.getId());
            for (LabAndInvestigationSummary labAndInvestigationSummary : labAndInvestigationSummaryList) {
                labAndInvestigationSummary.setIsActive(0);
                labAndInvSummaryRepository.save(labAndInvestigationSummary);
            }

            final List<DischargeSummaryConsultant> dischargeSummaryConsultantList = this.disSumConsultantRepository.fetchConsultantDetailsBySumId(dischargeSummary.getId());
            for (DischargeSummaryConsultant dischargeSummaryConsultant : dischargeSummaryConsultantList) {
                dischargeSummaryConsultant.setIsValid(0);
                disSumConsultantRepository.save(dischargeSummaryConsultant);
            }

            final List<DischargeSummaryDept> dischargeSummaryDeptList = this.disSumDeptRepository.fetchDeptDetailsBySumId(dischargeSummary.getId());
            for (DischargeSummaryDept dischargeSummaryDept : dischargeSummaryDeptList) {
                dischargeSummaryDept.setIsValid(0);
                disSumDeptRepository.save(dischargeSummaryDept);
            }


            dischargeSummary.setSummaryDiagnosisDetailsList(SummaryDiagnosisDetails.to(dischargeSummary, createDischargeSummaryRequest.getCreateSummaryDiagnosisDetailsRequestList()));
            dischargeSummary.setLabAndInvestigationSummaryList(LabAndInvestigationSummary.to(dischargeSummary, createDischargeSummaryRequest.getCreateLabAndInvSummaryRequestList()));
            dischargeSummary.setDischargeSummaryConsultantList(DischargeSummaryConsultant.to(dischargeSummary, createDischargeSummaryRequest.getCreateDisSumConsRequestList()));
            dischargeSummary.setDischargeSummaryDeptList(DischargeSummaryDept.to(dischargeSummary, createDischargeSummaryRequest.getCreateDisSumDeptRequestList()));

            dischargeSummaryRepository.saveAndFlush(dischargeSummary);

            log.debug("END of updateDischargeSummary() id {} request {}", id, createDischargeSummaryRequest);
            return new Response(dischargeSummary.getId());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    @Transactional
    public Response saveAntenatalCaseSheet(final CreateAntenatalCaseSheetRequest createAntenatalCaseSheetRequest) {
        try {
            log.debug("START saveAntenatalCaseSheet request {}", createAntenatalCaseSheetRequest);
//            this.caseSheetValidator.validateComplaintData(createAntenatalCaseSheetRequest.getCreateAntenatalPreviousCaseSheetRequests());
//            this.caseSheetValidator.GeneralCaseSheetDate(createAntenatalCaseSheetRequest);
//            if (generalCaseSheetRequest.getVisitId()==0 || generalCaseSheetRequest.getPatientId() ==0) {
//                throw new NullPointerException("Choose Proper Patient!");
//            }

            final AntenatalCaseSheet newAntenatalCaseSheet = AntenatalCaseSheet.to(createAntenatalCaseSheetRequest);
            newAntenatalCaseSheet.setAntenatalCaseSheetPreviousList(AntenatalCaseSheetPrevious.to(newAntenatalCaseSheet, createAntenatalCaseSheetRequest.getCreateAntenatalPreviousCaseSheetRequests()));
            // newAntenatalCaseSheet.setAntenatalCaseSheetCurrentSet(AntenatalCaseSheetCurrent.to(newAntenatalCaseSheet, createAntenatalCaseSheetRequest.getCreateAntenatalCurrentCaseSheetRequests()));
            this.antenatalCaseSheetRepository.saveAndFlush(newAntenatalCaseSheet);
            log.debug("END saveAntenatal id ");
            return new Response(newAntenatalCaseSheet.getId());
        } catch (Exception e) {
            log.error("Caught with exception while saving GeneralCaseSheet {}", e.getMessage());
            throw new RuntimeException(e);
        }

    }

    @Transactional
    @Override
    public Response updateAntenatalCaseSheet(Long id, CreateAntenatalCaseSheetRequest createAntenatalCaseSheetRequest) {
        try {
            log.debug("START of updateAntenatalCaseSheet() id {} request {}", id, createAntenatalCaseSheetRequest);
            final AntenatalCaseSheet antenatalCaseSheet = this.antenatalCaseSheetRepositotyWrapper.findOneWithNotFoundDetection(id);
            antenatalCaseSheet.update(createAntenatalCaseSheetRequest);
            this.antenatalCaseSheetRepository.saveAndFlush(antenatalCaseSheet);

            final List<AntenatalCaseSheetPrevious> antenatalCaseSheetPreviousList = this.antenatalCaseSheetPreRepository.fetchAntenatalPreviousBycaseSheetId(antenatalCaseSheet.getId());
            for (AntenatalCaseSheetPrevious antenatalCaseSheetPrevious : antenatalCaseSheetPreviousList) {
                antenatalCaseSheetPrevious.setIsValid(0L);
                antenatalCaseSheetPreRepository.save(antenatalCaseSheetPrevious);
            }

            antenatalCaseSheet.setAntenatalCaseSheetPreviousList(AntenatalCaseSheetPrevious.to(antenatalCaseSheet, createAntenatalCaseSheetRequest.getCreateAntenatalPreviousCaseSheetRequests()));
            antenatalCaseSheetRepository.saveAndFlush(antenatalCaseSheet);

            log.debug("END of updateAntenatalCaseSheet() id {} request {}", id, createAntenatalCaseSheetRequest);
            return new Response(antenatalCaseSheet.getId());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    @Transactional
    public Response saveSurgeryCaseSheet(final CreateSurgeryCaseSheetRequest createSurgeryCaseSheetRequest) {
        try {
            log.debug("START saveAntenatalCaseSheet request {}", createSurgeryCaseSheetRequest);

            final SurgeryCaseSheet newSurgeryCaseSheet = SurgeryCaseSheet.to(createSurgeryCaseSheetRequest);
            newSurgeryCaseSheet.setSurgerySurgonList(SurgerySurgon.to(newSurgeryCaseSheet, createSurgeryCaseSheetRequest.getCreateSurigicalSurgonRequests()));
            newSurgeryCaseSheet.setSurgeryNurseList(SurgeryNurse.to(newSurgeryCaseSheet, createSurgeryCaseSheetRequest.getCreateSurigicalNurseRequests()));
            newSurgeryCaseSheet.setSurgeryDataList(SurgeryName.to(newSurgeryCaseSheet, createSurgeryCaseSheetRequest.getCreateSurgicalSurgeryRequests()));
            this.surgeryCaseSheetRepository.saveAndFlush(newSurgeryCaseSheet);
            log.debug("END saveAntenatal id ");
            return new Response(newSurgeryCaseSheet.getId());
        } catch (Exception e) {
            log.error("Caught with exception while saving GeneralCaseSheet {}", e.getMessage());
            throw new RuntimeException(e);
        }

    }


    @Transactional
    @Override
    public Response updatSurgeryCaseSheet(Long id, CreateSurgeryCaseSheetRequest createSurgeryCaseSheetRequest) {
        try {
            log.debug("START of updateSurgeryCaseSheet() id {} request {}", id, createSurgeryCaseSheetRequest);

            final SurgeryCaseSheet surgeryCaseSheet = this.surgeryCaseSheetRepositoryWrapper.findOneWithNotFoundDetection(id);
            surgeryCaseSheet.update(createSurgeryCaseSheetRequest);
            this.surgeryCaseSheetRepository.saveAndFlush(surgeryCaseSheet);

            final List<SurgeryNurse> surgeryNurseList = this.surgeryNurseRepository.fetchSurgeryNurseBycaseSheetId(surgeryCaseSheet.getId());
            for (SurgeryNurse surgeryNurse : surgeryNurseList) {
                surgeryNurse.setIsValid(0L);
                surgeryNurseRepository.save(surgeryNurse);
            }
            final List<SurgeryName> surgeryNameList = this.surgeryNAmeRepository.fetchSurgeryNameBycaseSheetId(surgeryCaseSheet.getId());
            for (SurgeryName surgeryName : surgeryNameList) {
                surgeryName.setIsValid(0L);
                surgeryNAmeRepository.save(surgeryName);
            }
            final List<SurgerySurgon> surgerySurgonList = this.surgerySurgonRepository.fetchSurgerySurgonBycaseSheetId(surgeryCaseSheet.getId());
            for (SurgerySurgon surgerySurgon : surgerySurgonList) {
                surgerySurgon.setIsVAlid(0L);
                surgerySurgonRepository.save(surgerySurgon);
            }

            surgeryCaseSheet.setSurgeryNurseList(SurgeryNurse.to(surgeryCaseSheet, createSurgeryCaseSheetRequest.getCreateSurigicalNurseRequests()));
            surgeryCaseSheet.setSurgeryDataList(SurgeryName.to(surgeryCaseSheet, createSurgeryCaseSheetRequest.getCreateSurgicalSurgeryRequests()));
            surgeryCaseSheet.setSurgerySurgonList(SurgerySurgon.to(surgeryCaseSheet, createSurgeryCaseSheetRequest.getCreateSurigicalSurgonRequests()));
            surgeryCaseSheetRepository.saveAndFlush(surgeryCaseSheet);


            log.debug("END of updateAntenatalCaseSheet() id {} request {}", id, createSurgeryCaseSheetRequest);
            return new Response(surgeryCaseSheet.getId());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    @Transactional
    public ResponseEntity<ApiResponse<String>> updatePrescriptionNotes(Long id, String notes) {
        ApiResponse<String> response = new ApiResponse<>();
        try {
            if (notes == null) {
                throw new IllegalArgumentException("DataRequest or data is empty");
            }

            int updatedRows = this.prescriptionDetailsRepository.updatePrescriptionNotes(id, notes);

            if (updatedRows > 0) {
                response.setStatus("success");
                response.setData("Notes updated successfully on "+ id);
                return ResponseEntity.ok(response);
            } else {
                throw new RuntimeException("No rows updated for id: " + id);
            }
        } catch (IllegalArgumentException e) {
            response.setStatus("error");
            response.setMessage(e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        } catch (Exception e) {
            response.setStatus("error");
            response.setMessage("An unexpected error occurred: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }

    @Override
    public Response saveNursingIoSheet(CreateNursingIoReuest createNursingIoReuest) {
        try {
            log.debug("START saveNursingIo CreateNursing io {}", createNursingIoReuest);
            final NursingIoSheet nursingIoSheet = NursingIoSheet.to(createNursingIoReuest);

            this.nursingIoRepository.saveAndFlush(nursingIoSheet);
            log.debug("END saveNursingIo id ");
            return new Response(nursingIoSheet.getId());
        } catch (Exception e) {
            log.error("Caught with exception while savingOrderDiscount {}", e.getMessage());
            throw new RuntimeException(e.getMessage());
        }
    }

    @Transactional
    @Override
    public Response saveIpProcedureCaseSheet(final CreateIpProcedureCaseSheetRequest createIpProcedureCaseSheetRequest){
        try {
            log.debug("START saveGeneralCaseSheet request {}", createIpProcedureCaseSheetRequest);
            if (createIpProcedureCaseSheetRequest.getVisitId()==0 || createIpProcedureCaseSheetRequest.getPatientId()==0){
                throw new NullPointerException("Choose Proper Patient!");
            }
            final IpProcedureCaseSheet newIpProcedureCaseSheet = IpProcedureCaseSheet.to(createIpProcedureCaseSheetRequest);
            ipProcedureCaseSheetRepository.saveAndFlush(newIpProcedureCaseSheet);
            log.debug("End saveIpProcedureCaseSheet");
            return new Response(newIpProcedureCaseSheet.getId());
        }
        catch (Exception e) {
            log.error("Caught with exception while saving GeneralCaseSheet {}", e.getMessage());
            throw new RuntimeException(e);

        }
    }

    @Transactional
    @Override
    public Response updateIpProcedureCaseSheet(Long id, CreateIpProcedureCaseSheetRequest createIpProcedureCaseSheetRequest) {
        try {
            log.debug("START updateIpProcedureCaseSheet() id {} request {}", id, createIpProcedureCaseSheetRequest);
            final IpProcedureCaseSheet ipProcedureCaseSheet = this.ipProcedureCaseSheetRepositoryWrapper.findOneWithNotFoundDetection(id);
            ipProcedureCaseSheet.update(createIpProcedureCaseSheetRequest);
            this.ipProcedureCaseSheetRepository.saveAndFlush(ipProcedureCaseSheet);

            log.debug("END of updateIpProcedureCaseSheet() id {} request {}", id, createIpProcedureCaseSheetRequest);
            return new Response(ipProcedureCaseSheet.getId());
        }
        catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    @Override
    @Transactional
    public Response saveAncCaseSheet(final CreateAncRequest createAncRequest) {
        try {
            log.debug("START saveAncCaseSheet request {}", createAncRequest);
            final AncCaseSheet ancCaseSheet = AncCaseSheet.to(createAncRequest);
//            ancCaseSheet.setAncDetailsSheetList(AncDetailsSheet.to(ancCaseSheet, createAncRequest.getCreateAncDetailsRequestList()));
            ancCaseSheet.setAncChildDetialsSheetList(AncChildDetialsSheet.to(ancCaseSheet, createAncRequest.getCreateAncChildRequests()));
            this.ancCasesheetRepository.saveAndFlush(ancCaseSheet);
            log.debug("END saveAncCaseSheet id ");
            return new Response(ancCaseSheet.getId());
        } catch (Exception e) {
            log.error("Caught with exception while saving ancCaseSheet {}", e.getMessage());
            throw new RuntimeException(e);
        }
    }

    @Override
    @Transactional
    public Response saveAncDetailsCaseSheet(final CreateAncDetailsRequest createAncDetailsRequest) {
        try {
            log.debug("START saveSubsequentAncCaseSheet request {}", createAncDetailsRequest);
            final AncDetailsSheet ancDetailsSheet = AncDetailsSheet.to(createAncDetailsRequest);
//            ancCaseSheet.setAncDetailsSheetList(AncDetailsSheet.to(ancCaseSheet, createAncRequest.getCreateAncDetailsRequestList()));
            this.ancDetailsRepository.saveAndFlush(ancDetailsSheet);
            log.debug("END saveSubsequentAncCaseSheet id ");
            return new Response(ancDetailsSheet.getId());
        } catch (Exception e) {
            log.error("Caught with exception while saving Subsequent  ancCaseSheet {}", e.getMessage());
            throw new RuntimeException(e);
        }
    }
    @Transactional
    @Override
    public Response updateAncCaseSheet(Long id, CreateAncRequest createAncRequest) {
        try {
            log.debug("START updateAncCaseSheet() id {} request {}", id, createAncRequest );
            final AncCaseSheet ancCaseSheet = this.ancRepositoryWrapper.findOneWithNotFoundDetection(id);
            ancCaseSheet.update(createAncRequest );
            this.ancCasesheetRepository.saveAndFlush(ancCaseSheet);
            final List<AncDetailsSheet> ancDetailsSheetList = this.ancDetailsRepository.fetchAncDetials(ancCaseSheet.getVstId());
            for (AncDetailsSheet ancDetailsSheet : ancDetailsSheetList) {
                ancDetailsSheet.setIsValid(0L);
                ancCasesheetRepository.save(ancCaseSheet);
            }
            Long anc_Id      = ancCaseSheet.getId();
            String AncchildUpdateQry = "UPDATE `cli_anc_child` SET isValid=0 WHERE anc_id="+anc_Id;
            this.jdbcTemplate.update(AncchildUpdateQry);
//            ancCaseSheet.setAncDetailsSheetList(AncDetailsSheet.to(ancCaseSheet, createAncRequest.getCreateAncDetailsRequestList()));
            ancCaseSheet.setAncChildDetialsSheetList(AncChildDetialsSheet.to(ancCaseSheet, createAncRequest.getCreateAncChildRequests()));
            ancCasesheetRepository.saveAndFlush(ancCaseSheet);

            log.debug("END of updateIpProcedureCaseSheet() id {} request {}", id, createAncRequest );
            return new Response(ancCaseSheet.getId());
        }
        catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    @Transactional
    @Override
    public Response updateAncDetailsCaseSheet(Long id, CreateAncDetailsRequest createAncDetailsRequest) {
        try {
            log.debug("START updateAncDetailsCaseSheet() id {} request {}", id, createAncDetailsRequest );
            final AncDetailsSheet ancDetailsSheet = this.ancDetailsRepositoryWrapper.findOneWithNotFoundDetection(id);
            ancDetailsSheet.update(createAncDetailsRequest );
            this.ancDetailsRepository.saveAndFlush(ancDetailsSheet);

            log.debug("END of updateAncDetailsCaseSheet() id {} request {}", id, createAncDetailsRequest );
            return new Response(ancDetailsSheet.getId());
        }
        catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    @Transactional
    @Override
    public Response updateNursingIoSheet(Long id, CreateNursingIoReuest createNursingIoReuest) {
        try {
            log.debug("START of CreateNursingIoReuest() id {} request {}", id, createNursingIoReuest);
            final NursingIoSheet nursingIoSheet = this.nursingIoRepositoryWrapper.findOneWithNotFoundDetection(id);
            nursingIoSheet.update(createNursingIoReuest);
            this.nursingIoRepository.saveAndFlush(nursingIoSheet);

            log.debug("END of updateNursingIoReuest() id {} request {}", id, createNursingIoReuest);
            return new Response(nursingIoSheet.getId());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    public Response saveSurgeryChecklist(CreateSurgeryChecklistReuest createSurgeryChecklistReuest) {
        try {
            log.debug("START saveSurgeryChecklist CreateSurgeryChecklistReuest {}", createSurgeryChecklistReuest);
            final SurgeryCheck surgeryCheck = SurgeryCheck.to(createSurgeryChecklistReuest);

            this.surgeryChecklistRepository.saveAndFlush(surgeryCheck);
            log.debug("END saveSurgeryChecklist id ");
            return new Response(surgeryCheck.getId());
        } catch (Exception e) {
            log.error("Caught with exception while saveSurgeryChecklist {}", e.getMessage());
            throw new RuntimeException(e.getMessage());
        }


    }
    @Transactional
    @Override
    public Response updateSurgeryChecklist(Long id, CreateSurgeryChecklistReuest createSurgeryChecklistReuest) {
        try {
            log.debug("START of updateSurgeryChecklist() id {} request {}", id, createSurgeryChecklistReuest);
            final SurgeryCheck surgeryCheck = this.surgeryChecklistRepositoryWrapper.findOneWithNotFoundDetection(id);
            surgeryCheck.update(createSurgeryChecklistReuest);
            this.surgeryChecklistRepository.saveAndFlush(surgeryCheck);

            log.debug("END of updateSurgeryChecklist() id {} request {}", id, createSurgeryChecklistReuest);
            return new Response(surgeryCheck.getId());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }




    @Override
    public Response saveAldreteScoreChart(CreateAldreteScoreChartReuest createAldreteScoreChartReuest) {
        try {
            log.debug("START saveAldreteScoreChart CreateAldreteScoreChartReuest {}", createAldreteScoreChartReuest);
            final AldreteScoreChart aldreteScoreChart = AldreteScoreChart.to(createAldreteScoreChartReuest);

            this.aldreteScoreChartRepository.saveAndFlush(aldreteScoreChart);
            log.debug("END saveAldreteScoreChart id ");
            return new Response(aldreteScoreChart.getId());
        } catch (Exception e) {
            log.error("Caught with exception while saveSurgeryChecklist {}", e.getMessage());
            throw new RuntimeException(e.getMessage());
        }


    }

    @Transactional
    @Override
    public Response updateAldreteScoreChart(Long id, CreateAldreteScoreChartReuest createAldreteScoreChartReuest) {
        try {
            log.debug("START of updateAldreteScoreChart() id {} request {}", id, createAldreteScoreChartReuest);
            final AldreteScoreChart aldreteScoreChart = this.aldreteScoreChartRepositoryWrapper.findOneWithNotFoundDetection(id);
            aldreteScoreChart.update(createAldreteScoreChartReuest);
            this.aldreteScoreChartRepository.saveAndFlush(aldreteScoreChart);

            log.debug("END of updateSurgeryChecklist() id {} request {}", id, createAldreteScoreChartReuest);
            return new Response(aldreteScoreChart.getId());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Transactional
    @Override
    public Response saveDermatologyCaseSheet(final CreateDermatologyCaseSheetRequest createDermatologyCaseSheetRequest) {
        try {
            log.debug("START saveDermatologyCaseSheet request {}", createDermatologyCaseSheetRequest);
            this.caseSheetValidator.validateComplaintData(createDermatologyCaseSheetRequest.getCreateComplaintDetailsRequestList());
            //this.caseSheetValidator.DermatologyCaseSheetDate(createDermatologyCaseSheetRequest);
            if (createDermatologyCaseSheetRequest.getVisitId()==0 || createDermatologyCaseSheetRequest.getPatientId() ==0) {
                throw new NullPointerException("Choose Proper Patient!");
            }

            final DermatologyCaseSheet newDermatologyCaseSheet = DermatologyCaseSheet.to(createDermatologyCaseSheetRequest);
            newDermatologyCaseSheet.setDermatologyComplaintDetailsList(DermatologyComplaintDetails.to(newDermatologyCaseSheet,createDermatologyCaseSheetRequest.getCreateComplaintDetailsRequestList()));
            newDermatologyCaseSheet.setDermatologyDiagnosisDetailsList(DermatologyDiagnosisDetails.to(newDermatologyCaseSheet,createDermatologyCaseSheetRequest.getCreateDiagnosisDetailsRequestList()));
            dermatologyCaseSheetRepository.saveAndFlush(newDermatologyCaseSheet);
            log.debug("END saveDermatologyCaseSheet id ");
            return new Response(newDermatologyCaseSheet.getId());
        } catch (Exception e) {
            log.error("Caught with exception while saving GeneralCaseSheet {}", e.getMessage());
            throw new RuntimeException(e);

        }

    }

    @Transactional
    @Override
    public Response updateDermatologyCaseSheet(Long id, CreateDermatologyCaseSheetRequest createDermatologyCaseSheetRequest,Integer caseSheetType) {
        try {
            log.debug("START of updateDermatologyCaseSheet() id {} request {} caseSheetType{}", id, createDermatologyCaseSheetRequest,caseSheetType);
            final DermatologyCaseSheet dermatologyCaseSheet = this.dermatologyCaseSheetRepositoryWrapper.findOneWithNotFoundDetection(id);
            dermatologyCaseSheet.update(createDermatologyCaseSheetRequest);
            this.dermatologyCaseSheetRepository.saveAndFlush(dermatologyCaseSheet);

            final List<DermatologyComplaintDetails> complaintDetailsList = this.dermatologyComplainDetailsRepository.fetchDermatologyComplaintDetailsBycaseSheetId(dermatologyCaseSheet.getId(),caseSheetType);
            for (DermatologyComplaintDetails dermatologyComplaintDetails : complaintDetailsList) {
                dermatologyComplaintDetails.setIsValid(0L);
                dermatologyComplainDetailsRepository.save(dermatologyComplaintDetails);
            }


            final List<DermatologyDiagnosisDetails> dermatologyDiagnosisDetailsList = this.dermatologyDiagnosisDetailsRepository.fetchDermatologyDiagnosisDetailsBycaseSheetId(dermatologyCaseSheet.getId());
            for (DermatologyDiagnosisDetails dermatologyDiagnosisDetails : dermatologyDiagnosisDetailsList) {
                dermatologyDiagnosisDetails.setIsValid(0L);
                dermatologyDiagnosisDetailsRepository.save(dermatologyDiagnosisDetails);
            }

            dermatologyCaseSheet.setDermatologyComplaintDetailsList(DermatologyComplaintDetails.to(dermatologyCaseSheet,createDermatologyCaseSheetRequest.getCreateComplaintDetailsRequestList()));
            dermatologyCaseSheet.setDermatologyDiagnosisDetailsList(DermatologyDiagnosisDetails.to(dermatologyCaseSheet, createDermatologyCaseSheetRequest.getCreateDiagnosisDetailsRequestList()));
            dermatologyCaseSheetRepository.saveAndFlush(dermatologyCaseSheet);

            log.debug("END of updateDermatologyCaseSheet() id {} request {}", id, createDermatologyCaseSheetRequest);
            return new Response(dermatologyCaseSheet.getId());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Transactional
    @Override
    public Response saveOpthamologyCaseSheet(final CreateOpthamologyCaseSheetRequest createOpthamologyCaseSheetRequest) {
        try {
            log.debug("START saveOpthamologyCaseSheet request {}", createOpthamologyCaseSheetRequest);
            this.caseSheetValidator.validateComplaintData(createOpthamologyCaseSheetRequest.getCreateComplaintDetailsRequestList());
            //this.caseSheetValidator.DermatologyCaseSheetDate(createDermatologyCaseSheetRequest);
            if (createOpthamologyCaseSheetRequest.getVisitId()==0 || createOpthamologyCaseSheetRequest.getPatientId() ==0) {
                throw new NullPointerException("Choose Proper Patient!");
            }

            final OpthamologyCaseSheet newOpthamologyCaseSheet = OpthamologyCaseSheet.to(createOpthamologyCaseSheetRequest);
            newOpthamologyCaseSheet.setOpthamologyComplaintDetailsList(OpthamologyComplaintDetails.to(newOpthamologyCaseSheet,createOpthamologyCaseSheetRequest.getCreateComplaintDetailsRequestList()));
            newOpthamologyCaseSheet.setOpthamologyDiagnosisDetailsList(OpthamologyDiagnosisDetails.to(newOpthamologyCaseSheet,createOpthamologyCaseSheetRequest.getCreateDiagnosisDetailsRequestList()));
            opthamologyCaseSheetRepository.saveAndFlush(newOpthamologyCaseSheet);
            log.debug("END saveDermatologyCaseSheet id ");
            return new Response(newOpthamologyCaseSheet.getId());
        } catch (Exception e) {
            log.error("Caught with exception while saving GeneralCaseSheet {}", e.getMessage());
            throw new RuntimeException(e);

        }

    }

    @Transactional
    @Override
    public Response updateOpthamologyCaseSheet(Long id, CreateOpthamologyCaseSheetRequest createOpthamologyCaseSheetRequest,Integer caseSheetType) {
        try {
            log.debug("START of updateOpthamologyCaseSheet() id {} request {} caseSheetType{}", id, createOpthamologyCaseSheetRequest,caseSheetType);
            final OpthamologyCaseSheet opthamologyCaseSheet = this.opthamologyCaseSheetRepositoryWrapper.findOneWithNotFoundDetection(id);
            opthamologyCaseSheet.update(createOpthamologyCaseSheetRequest);
            this.opthamologyCaseSheetRepository.saveAndFlush(opthamologyCaseSheet);

            final List<OpthamologyComplaintDetails> complaintDetailsList = this.opthamologyComplainDetailsRepository.fetchOpthamologyComplaintDetailsBycaseSheetId(opthamologyCaseSheet.getId(),caseSheetType);
            for (OpthamologyComplaintDetails opthamologyComplaintDetails : complaintDetailsList) {
                opthamologyComplaintDetails.setIsValid(0L);
                opthamologyComplainDetailsRepository.save(opthamologyComplaintDetails);
            }


            final List<OpthamologyDiagnosisDetails> opthamologyDiagnosisDetailsList = this.opthamologyDiagnosisDetailsRepository.fetchOpthamologyDiagnosisDetailsBycaseSheetId(opthamologyCaseSheet.getId());
            for (OpthamologyDiagnosisDetails opthamologyDiagnosisDetails : opthamologyDiagnosisDetailsList) {
                opthamologyDiagnosisDetails.setIsValid(0L);
                opthamologyDiagnosisDetailsRepository.save(opthamologyDiagnosisDetails);
            }

            opthamologyCaseSheet.setOpthamologyComplaintDetailsList(OpthamologyComplaintDetails.to(opthamologyCaseSheet,createOpthamologyCaseSheetRequest.getCreateComplaintDetailsRequestList()));
            opthamologyCaseSheet.setOpthamologyDiagnosisDetailsList(OpthamologyDiagnosisDetails.to(opthamologyCaseSheet, createOpthamologyCaseSheetRequest.getCreateDiagnosisDetailsRequestList()));
            opthamologyCaseSheetRepository.saveAndFlush(opthamologyCaseSheet);

            log.debug("END of updateOpthamologyCaseSheet() id {} request {}", id, createOpthamologyCaseSheetRequest);
            return new Response(opthamologyCaseSheet.getId());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Transactional
    @Override
    public Response saveENTCaseSheet(final CreateENTCaseSheetRequest createENTCaseSheetRequest) {
        try {
            log.debug("START saveENTCaseSheet request {}", createENTCaseSheetRequest);
            this.caseSheetValidator.validateComplaintData(createENTCaseSheetRequest.getCreateComplaintDetailsRequestList());
            //this.caseSheetValidator.DermatologyCaseSheetDate(createDermatologyCaseSheetRequest);
            if (createENTCaseSheetRequest.getVisitId()==0 || createENTCaseSheetRequest.getPatientId() ==0) {
                throw new NullPointerException("Choose Proper Patient!");
            }

            final ENTCaseSheet newENTCaseSheet = ENTCaseSheet.to(createENTCaseSheetRequest);
            newENTCaseSheet.setEntComplaintDetailsList(ENTComplaintDetails.to(newENTCaseSheet,createENTCaseSheetRequest.getCreateComplaintDetailsRequestList()));
            newENTCaseSheet.setEntDiagnosisDetailsList(ENTDiagnosisDetails.to(newENTCaseSheet,createENTCaseSheetRequest.getCreateDiagnosisDetailsRequestList()));
            entCaseSheetRepository.saveAndFlush(newENTCaseSheet);
            log.debug("END saveENTCaseSheet id ");
            return new Response(newENTCaseSheet.getId());
        } catch (Exception e) {
            log.error("Caught with exception while saving GeneralCaseSheet {}", e.getMessage());
            throw new RuntimeException(e);

        }

    }

    @Transactional
    @Override
    public Response updateENTCaseSheet(Long id, CreateENTCaseSheetRequest createENTCaseSheetRequest,Integer caseSheetType) {
        try {
            log.debug("START of updateENTCaseSheet() id {} request {} caseSheetType{}", id, createENTCaseSheetRequest,caseSheetType);
            final ENTCaseSheet entCaseSheet = this.entCaseSheetRepositoryWrapper.findOneWithNotFoundDetection(id);
            entCaseSheet.update(createENTCaseSheetRequest);
            this.entCaseSheetRepository.saveAndFlush(entCaseSheet);

            final List<ENTComplaintDetails> complaintDetailsList = this.entComplainDetailsRepository.fetchENTComplaintDetailsBycaseSheetId(entCaseSheet.getId(),caseSheetType);
            for (ENTComplaintDetails entComplaintDetails : complaintDetailsList) {
                entComplaintDetails.setIsValid(0L);
                entComplainDetailsRepository.save(entComplaintDetails);
            }


            final List<ENTDiagnosisDetails> entDiagnosisDetailsList = this.entDiagnosisDetailsRepository.fetchENTDiagnosisDetailsBycaseSheetId(entCaseSheet.getId());
            for (ENTDiagnosisDetails entDiagnosisDetails : entDiagnosisDetailsList) {
                entDiagnosisDetails.setIsValid(0L);
                entDiagnosisDetailsRepository.save(entDiagnosisDetails);
            }

            entCaseSheet.setEntComplaintDetailsList(ENTComplaintDetails.to(entCaseSheet,createENTCaseSheetRequest.getCreateComplaintDetailsRequestList()));
            entCaseSheet.setEntDiagnosisDetailsList(ENTDiagnosisDetails.to(entCaseSheet, createENTCaseSheetRequest.getCreateDiagnosisDetailsRequestList()));
            entCaseSheetRepository.saveAndFlush(entCaseSheet);

            log.debug("END of updateDermatologyCaseSheet() id {} request {}", id, createENTCaseSheetRequest);
            return new Response(entCaseSheet.getId());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    @Transactional
    @Override
    public Response saveDeliveryDetails(final CreateAncDeliveryRequest createAncDeliveryRequest){

        try {
            log.debug("START saveDeliveryDetails request {}", createAncDeliveryRequest);
//            if (createAncDeliveryRequest.getVstId()==0 || createAncDeliveryRequest.getPatId()==0){
//                throw new NullPointerException("Choose Proper Patient!");
//            }
            final AncDeliverySheet ancDeliverySheet = AncDeliverySheet.to(createAncDeliveryRequest);
            ancDeliverySheet.setAncDeliveryInductionList(AncDeliveryInduction.to(ancDeliverySheet, createAncDeliveryRequest.getCreateAncDeliveryInductionRequestList()));

            //          final List<AncData> ancDataList = this.ancDeliveryDetilsAncRepository.fetchAncDeliveryDischarged(ancDeliverySheet.getPatId());
//            System.out.print(ancDataList);
//            for (AncData ancData1 : ancData) {
//               // ancData1.setIsDelivered(1L);
//                ancDeliveryDetilsAncRepository.save(ancData1);
//            }
            Long PatId      = ancDeliverySheet.getPatId();
            String AncIsDeriveredUpdateQry = "UPDATE `cli_anc` SET isDelivered=1 where patId="+PatId;
            this.jdbcTemplate.update(AncIsDeriveredUpdateQry);

            ancSheetDeliveryRepository.saveAndFlush(ancDeliverySheet);
            log.debug("End saveDeliveryDetails");
            return new Response(ancDeliverySheet.getId());
        }
        catch (Exception e) {
            log.error("Caught with exception while saving GeneralCaseSheet {}", e.getMessage());
            throw new RuntimeException(e);

        }
    }


    @Transactional
    @Override
    public Response updateDeliveryDetails(Long id, CreateAncDeliveryRequest createAncDeliveryRequest) {
        try {
            log.debug("START of updateDeliveryDetails() id {} request {}", id, createAncDeliveryRequest);
            final AncDeliverySheet ancDeliverySheet = this.ancDeliveryDetialsRepositoryWrapper.findOneWithNotFoundDetection(id);
            ancDeliverySheet.update(createAncDeliveryRequest);
            this.ancSheetDeliveryRepository.saveAndFlush(ancDeliverySheet);

            final List<AncDeliveryInduction> ancDeliveryInductionList = this.ancDeliveryInductionRepository.fetchAncDeliveryInductionDetials(ancDeliverySheet.getId());
            for (AncDeliveryInduction ancDeliveryInduction : ancDeliveryInductionList) {
                ancDeliveryInduction.setIsValid(0L);
                ancDeliveryInductionRepository.save(ancDeliveryInduction);
            }

            ancDeliverySheet.setAncDeliveryInductionList(AncDeliveryInduction.to(ancDeliverySheet, createAncDeliveryRequest.getCreateAncDeliveryInductionRequestList()));
            ancSheetDeliveryRepository.saveAndFlush(ancDeliverySheet);

            log.debug("END of updateDeliveryDetails() id {} request {}", id, createAncDeliveryRequest);
            return new Response(ancDeliverySheet.getId());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    @Transactional
    @Override
    public  List<OutsideLabResultData> saveOutsideLabResult(final CreateOutsideLabRequest createOutsideLabRequest) {
        try {
            log.debug("START saveOutsideLabResult request {}", createOutsideLabRequest);
            final OutsideLab outsideLab = OutsideLab.to(createOutsideLabRequest);
            this.entityManager.persist(outsideLab);
            outsideLab.setDisplay((outsideLab.getId()));
            //outsideLab.setOutsideLabResultList((OutsideLabResult.to(outsideLab, createOutsideLabRequest.getCreateOutsideLabResultRequestList())));

            List<OutsideLabResult> outsideLabResultList = OutsideLabResult.to(outsideLab, createOutsideLabRequest.getCreateOutsideLabResultRequestList());
            outsideLab.setOutsideLabResultList(outsideLabResultList);

            // Persist OutsideLabResult entities
            for (OutsideLabResult result : outsideLabResultList) {
                this.entityManager.persist(result);

                // Now persist the OutsideLabResultDetails for each OutsideLabResult
                for (OutsideLabResultDetails resultDetails : result.getOutsideLabResultDetailsList()) {
                    this.entityManager.persist(resultDetails);
                }
            }

            final OutsideLab newOutsideLab = outsideLabRepository.saveAndFlush(outsideLab);
            log.debug("END saveOutsideLabResult id ");
            return this.clinicalInfoReadPlatformService.fetchOutsideLabResultDetailsById(newOutsideLab.getId());

        } catch (Exception e) {
            log.error("Caught with exception while saving SaveOutsideLabResult {}", e.getMessage());
            throw e;
        }
    }

    @Transactional
    @Override
    public List<OutsideLabResultData> updateOutsideLabResult(final Long outsideLabId, final CreateOutsideLabRequest createOutsideLabRequest) {
        try {
            log.debug("START updateOutsideLabResult for id {} with request {}", outsideLabId, createOutsideLabRequest);


            OutsideLab outsideLab = outsideLabRepository.findById(outsideLabId)
                    .orElseThrow(() -> new Exception("OutsideLab with ID " + outsideLabId + " not found"));


            outsideLab.setDisplay(createOutsideLabRequest.getDisplay());
            outsideLab.setPatId(createOutsideLabRequest.getPatId());
            outsideLab.setVstId(createOutsideLabRequest.getVstId());
            outsideLab.setIpId(createOutsideLabRequest.getIpId());
            outsideLab.setLabName(createOutsideLabRequest.getLabName());
            outsideLab.setConsultantId(createOutsideLabRequest.getConsultantId());
            outsideLab.setSuggestDoc(createOutsideLabRequest.getSuggestDoc());
            outsideLab.setType(createOutsideLabRequest.getType());
            outsideLab.setDateTime(DateTimeUtils.convertLocalDateToDateTimeFormat(LocalDateTime.now()));
            outsideLab.setSelDateTime(createOutsideLabRequest.getSelDateTime());
            outsideLab.setIsValid(1L);


            List<CreateOutsideLabResultRequest> resultRequestList = createOutsideLabRequest.getCreateOutsideLabResultRequestList();
            if (resultRequestList != null) {

                for (CreateOutsideLabResultRequest resultRequest : resultRequestList) {

                    OutsideLabResult existingResult = outsideLab.getOutsideLabResultList().stream()
                            .filter(result -> result.getTestId().equals(resultRequest.getTestId()))
                            .findFirst()
                            .orElse(null);

                    if (existingResult != null) {

                        existingResult.setDeptId(resultRequest.getDeptId());
                        existingResult.setNotes(resultRequest.getNotes());
                        existingResult.setIsValid(1L);


                        if (resultRequest.getCreateOutsideLabResultDetailsRequestList() != null) {
                            for (CreateOutsideLabResultDetailsRequest resultDetailsRequest : resultRequest.getCreateOutsideLabResultDetailsRequestList()) {

                                OutsideLabResultDetails existingDetail = existingResult.getOutsideLabResultDetailsList().stream()
                                        .filter(detail -> detail.getFldId().equals(resultDetailsRequest.getFldId()))  // Update by fldId or another key
                                        .findFirst()
                                        .orElse(null);

                                if (existingDetail != null) {

                                    existingDetail.setValue(resultDetailsRequest.getValue());
                                    existingDetail.setIsValid(1L);
                                } else {
                                    throw new RuntimeException("FieldId : "+ resultDetailsRequest.getFldId() + " not found");
                                }
                            }
                        }
                    } else {

                        OutsideLabResult newResult = OutsideLabResult.to(outsideLab, resultRequest);
                        outsideLab.getOutsideLabResultList().add(newResult);


                        if (resultRequest.getCreateOutsideLabResultDetailsRequestList() != null) {
                            List<OutsideLabResultDetails> newDetails = OutsideLabResultDetails.to(newResult, resultRequest.getCreateOutsideLabResultDetailsRequestList());
                            newResult.setOutsideLabResultDetailsList(newDetails);
                        }
                    }
                }
            }


            outsideLabRepository.saveAndFlush(outsideLab);


            log.debug("END updateOutsideLabResult for id {}", outsideLabId);
            return clinicalInfoReadPlatformService.fetchOutsideLabResultDetailsById(outsideLabId);

        } catch (Exception e) {
            log.error("Caught exception while updating OutsideLabResult for id {}: {}", outsideLabId, e.getMessage(), e);
            throw new RuntimeException("Error occurred while updating outside lab result.", e);
        }
    }

    @Transactional
    @Override
    public List<OutsideLabResultData> saveOutsideInvDetails(final CreateOutsideInvRequest createOutsideInvRequest) {
        try {
            log.debug("START saveOutisideInvDetails request {}", createOutsideInvRequest);
            final OutsideInv outsideInv = OutsideInv.to(createOutsideInvRequest);
            this.entityManager.persist(outsideInv);
            outsideInv.setDisplay(outsideInv.getId());
            outsideInv.setOutsideInvResultList(OutsideInvResult.to(outsideInv,createOutsideInvRequest.getCreateOutsideInvDetailsRequestList()));
            final OutsideInv outsideInv1 = outsideInvRepository.saveAndFlush(outsideInv);
            log.debug("END saveOutisideInvDetails id ");
            return null;
        }
        catch (Exception e) {
            log.error("Caught with exception while saving saveOutsideInvDetails {}", e.getMessage());
            throw e;
        }
    }

    @Transactional
    @Override
    public List<OutsideLabResultData> updateOutsideInvDetails(final Long outsideInvId, final CreateOutsideInvRequest createOutsideInvRequest){
        try {
            OutsideInv outsideInv = outsideInvRepository.findById(outsideInvId)
                    .orElseThrow(() -> new Exception("OutsideInv with ID " + outsideInvId + " not found"));

            outsideInv.setDisplay(createOutsideInvRequest.getDisplay());
            outsideInv.setPatId(createOutsideInvRequest.getPatId());
            outsideInv.setVstId(createOutsideInvRequest.getVstId());
            outsideInv.setIpId(createOutsideInvRequest.getIpId());
            outsideInv.setLabName(createOutsideInvRequest.getLabName());
            outsideInv.setConsultantId(createOutsideInvRequest.getConsultantId());
            outsideInv.setSuggestDoc(createOutsideInvRequest.getSuggestDoc());
            outsideInv.setType(createOutsideInvRequest.getType());
            outsideInv.setDateTime(DateTimeUtils.convertLocalDateToDateTimeFormat(LocalDateTime.now()));  // Update date/time
            outsideInv.setSelDateTime(createOutsideInvRequest.getSelDateTime());
            outsideInv.setIsValid(1L);

            List<CreateOutsideInvDetailsRequest> invDetailsRequestList = createOutsideInvRequest.getCreateOutsideInvDetailsRequestList();

            if (invDetailsRequestList != null) {
                for (CreateOutsideInvDetailsRequest createOutsideInvDetailsRequest : invDetailsRequestList) {
                    OutsideInvResult outsideInvResult = outsideInv.getOutsideInvResultList().stream()
                            .filter(result -> result.getInvId().equals(createOutsideInvDetailsRequest.getInvId()))
                            .findFirst()
                            .orElse(null);

                    if (outsideInvResult != null) {
                        outsideInvResult.setDeptId(createOutsideInvDetailsRequest.getDeptId());
                        outsideInvResult.setFindings(createOutsideInvDetailsRequest.getFindings());
                        outsideInvResult.setInvId(createOutsideInvDetailsRequest.getInvId());
                        outsideInvResult.setIsValid(1L);
                    }
                    else {
                        throw new RuntimeException("Error occurred while updating outside lab result.");
                    }
                }
            }
            outsideInvRepository.saveAndFlush(outsideInv);
            log.debug("END updateOutsideInvDetails for id {}", outsideInvId);

            return null;
        } catch (Exception e) {
            log.error("Caught exception while updating updateOutsideInvDetails for id {}: {}", outsideInvId, e.getMessage(), e);
            throw new RuntimeException("Error occurred while updating updateOutsideInvDetails.", e);
        }
    }

    @Override
    public ResponseEntity<String> uploadInvImage(final List<MultipartFile> files, final String createImgInvUploadRequest) {
        if(files == null || files.isEmpty()) {
            return ResponseEntity.badRequest().body("No files Selected");
        }

        try {
            CreateImgInvUploadRequest patientDetails = new ObjectMapper().readValue(createImgInvUploadRequest, CreateImgInvUploadRequest.class);

            String opPath = uploadDir + File.separator + patientDetails.getPatId();
            File opDir = new File(opPath);
            if(!opDir.exists()) {
                opDir.mkdirs();
            }
            for (MultipartFile file : files) {
                if (files.isEmpty()) continue;

                String originalImgName = file.getOriginalFilename();
                if(originalImgName == null) continue;

                final InvImgUpload invImgUpload = InvImgUpload.to(patientDetails);
                imgInvRepository.save(invImgUpload);

                String imgName = originalImgName.substring(0,originalImgName.lastIndexOf('.'));
                String extension = originalImgName.substring(originalImgName.lastIndexOf('.')+1);

                String updatedImgName = imgName + "_" + invImgUpload.getId() + "." + extension;
                String relPath = "uploadImages/" + patientDetails.getPatId() + "/"+updatedImgName;

                Path path = Paths.get(opPath + File.separator + updatedImgName);
                System.out.println("path : " + path);
                Files.createDirectories(path.getParent());
                file.transferTo(path.toFile());

                invImgUpload.setPath(relPath);
                invImgUpload.setImgName(updatedImgName);
                imgInvRepository.saveAndFlush(invImgUpload);
            }
            return ResponseEntity.ok().body("Image uploaded successuflly.");

        } catch (IOException e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body("Error uploading image");
        }
    }

    @Transactional
    @Override
    public Response updateSelectedImage(final Long id, final Long blockedId, final CreateImgInvUploadRequest createImgInvUploadRequest) {
        try {
            log.debug("START of updateSelectedImage() request {}", createImgInvUploadRequest);
            final InvImgUpload invImgUpload = this.imgInvRepositoryWrapper.findOneWithNotFoundDetection(id);

            String filePath = invImgUpload.getPath();
            if (filePath != null && !filePath.isEmpty()) {
                Path path = Paths.get(uploadDirct, filePath); // Construct full file path
                File file = path.toFile();

                if (file.exists()) {
                    boolean deleted = file.delete();
                    if (!deleted) {
                        log.warn("Failed to delete the file: {}", filePath);
                    } else {
                        log.debug("Successfully deleted the file: {}", filePath);
                    }
                }
            }

            invImgUpload.update(id,blockedId,createImgInvUploadRequest);
            this.imgInvRepository.saveAndFlush(invImgUpload);

            log.debug("END of updateSelectedImage() id {} request {}", id, createImgInvUploadRequest);
            return new Response(invImgUpload.getId());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    @Transactional
    public Response savePatientAppointmentRegister(final AppointmentRequest appointmentRequest) {
        try {
            log.debug("START Appointment Register {}", appointmentRequest);

            if (appointmentRequest.getVstId() == 0 || appointmentRequest.getPatId() == 0) {
                throw new NullPointerException("Choose Proper Patient!");
            }
            final Appointment appointment = Appointment.to(appointmentRequest);
            appointmentRepository.saveAndFlush(appointment);
            log.debug("END of Appointment Register CaseSheet");
            return new Response(appointment.getId());
        } catch (Exception e) {
            log.error("Caught with exception while saving Appointment Register {}", e.getMessage());
            throw new RuntimeException(e);
        }
    }

    @Transactional
    @Override
    public Response updatePatientAppointmentRegister(Long id, AppointmentRequest appointmentRequest) {
        try {
            log.debug("START of updatePatientAppointmentRegister() id {} request {}",id,appointmentRequest);
            final Appointment appointment = this.appointmentRepositoryWrapper.findOneWithNotFoundDetection(id);
            appointment.update(appointmentRequest);
            this.appointmentRepository.saveAndFlush(appointment);

            log.debug("END of updatePatientAppointmentRegister() id {} request {}",id, appointmentRequest);
            return new Response(appointment.getId());
        } catch (Exception e) {
            log.error("Caught with exception while updating PatientAppointmentRegister {}", e.getMessage());
            throw new RuntimeException(e);
        }
    }

    @Override
    @Transactional
    public String deleteCaseSheetTemplateById (Long id) {
        try {
            log.debug("START of deleting Template request {} ",id);
            String qry = "UPDATE cli_patient_casesheet_templates SET isValid = 0 WHERE id = :id" ;
            this.caseSheetTemplateRepository.deleteTemplateById(id);
            return "Template Deleted Successfully !";
        } catch (Exception e) {
            log.error("Error while deleting Template {} ", e.getMessage());
            throw new RuntimeException(e);
        }
    }

    @Override
    @Transactional
    public String blockOutsideLabResultById(final Long id) {
        try {
            log.debug("START deleting outside Lab Result for id {} ", id);

            OutsideLab outsideLab = outsideLabRepository.findById(id)
                    .orElseThrow(() -> new Exception(("Lab Result for " + id + " not found")));
            outsideLab.setIsValid(0L);

            if(outsideLab.getOutsideLabResultList() != null) {
                for(OutsideLabResult result : outsideLab.getOutsideLabResultList()) {
                    result.setIsValid(0L);

                    if(result.getOutsideLabResultDetailsList() != null) {
                        for (OutsideLabResultDetails details : result.getOutsideLabResultDetailsList()) {
                            details.setIsValid(0L);
                        }
                    }
                }
            }
            outsideLabRepository.saveAndFlush(outsideLab);
            log.debug("END deleting Outside Lab Result for Id {}", id);

            return "Lab Result Deleted successfully!";
        } catch (Exception e) {
            log.error("Caught exception while deleting Lab Result for id {}", id);
            throw new RuntimeException("Error occured while deleting Outside Lab Result, ",e);
        }
    }

    @Override
    @Transactional
    public String blockOutsideInvResultById(final Long id) {
        try {
            log.debug("START deleting outside Inv Result for id {} ", id);

            OutsideInv outsideInv = outsideInvRepository.findById(id)
                    .orElseThrow(() -> new Exception(("Inv Result for " + id + " not found")));
            outsideInv.setIsValid(0L);

            if(outsideInv.getOutsideInvResultList() != null) {
                for(OutsideInvResult result : outsideInv.getOutsideInvResultList()) {
                    result.setIsValid(0L);
                }
            }
            outsideInvRepository.saveAndFlush(outsideInv);
            log.debug("END deleting Outside Inv Result for Id {}", id);

            return "Inv Result Deleted successfully!";
        } catch (Exception e) {
            log.error("Caught exception while deleting Inv Result for id {}", id);
            throw new RuntimeException("Error occured while deleting Outside Inv Result, ",e);
        }
    }

    @Transactional
    @Override
    public String editPrescriptionTemplate(CreatePrescTemplateEditRequest createPrescTemplateEditRequest) {
        try {
            log.debug("START of editPrescriptionTemplate() request {}",createPrescTemplateEditRequest);
            final PrescTemplate prescTemplate = this.prescTemplateRepositoryWrapper.findOneWithNotFoundDetection(createPrescTemplateEditRequest.getId());

            boolean nameExists = prescTemplateRepository.existsByNameAndIdNot(
                    createPrescTemplateEditRequest.getTemplateName(),
                    createPrescTemplateEditRequest.getId()
            );

            if(createPrescTemplateEditRequest.getIsValid() == 0){
                prescTemplate.setIsValid(0L);
                prescTemplate.setEditUid(createPrescTemplateEditRequest.getEditUid());
                prescTemplate.setEditDate(DateTimeUtils.convertLocalDateToDateFormat(LocalDate.now()));
                prescTemplate.setEditTime(DateTimeUtils.convertLocalDateToTimeFormat(LocalTime.now()));
                this.prescTemplateRepository.saveAndFlush(prescTemplate);
                return new String("Template Blocked Successfully");
            }
            if (nameExists) {
                return new String("Template name already exists");
            }

            prescTemplate.update(createPrescTemplateEditRequest);
            this.prescTemplateRepository.saveAndFlush(prescTemplate);

            log.debug("END of editPrescriptionTemplate() request {}", createPrescTemplateEditRequest);
            return new String("Template Edited Successfully.");
        } catch (Exception e) {
            log.error("Caught with exception while editing PrescriptionTemplate {}", e.getMessage());
            throw new RuntimeException(e);
        }
    }

    @Override
    @Transactional
    public String editLabTemplate (Long id) {
        try {
            log.debug("START of deleting Template request {} ",id);

            boolean idAvailable = orderTemplateRepository.existsById(id);
            if (!idAvailable) {
                return new String("Template Id is InCorrect.");
            }

            this.orderTemplateRepository.deleteTemplateById(id);
            return "Template Deleted Successfully !";
        } catch (Exception e) {
            log.error("Error while deleting Template {} ", e.getMessage());
            throw new RuntimeException(e);
        }
    }

    @Override
    @Transactional
    public String updateRiskFactors (Long id, String riskFactors, String personalInfo) {
        try {
            log.debug("START of updateRiskFactors {} ",id);

            boolean idAvailable = ancCasesheetRepository.existsById(id);
            if (!idAvailable) {
                return new String("Antenatal Id is InCorrect.");
            }

            int rows = ancCasesheetRepository.updateRiskFactorsById(id, riskFactors,personalInfo);

            if (rows == 0) {
                return "Update failed. No rows updated.";
            }


//            String updatedRiskFactor = ancCasesheetRepository.findRiskFactorsById(id);
            String updatedRiskFactor = "PersonalInfo or Risk Factors updated Successfully." ;
            return updatedRiskFactor;
        } catch (Exception e) {
            log.error("Error while updating RiskFactors {} ", e.getMessage());
            throw new RuntimeException(e);
        }
    }

    @Override
    @Transactional
    public String updatePatientDelivery (Long ancId) {
        try {
            log.debug("START of updatePatientDelivery {} ",ancId);

            boolean idAvailable = ancCasesheetRepository.existsById(ancId);
            if (!idAvailable) {
                return new String("Antenatal Id is InCorrect.");
            }

            this.ancCasesheetRepository.updateDeliveryStatus(ancId);
            return "Delivery Status Updated Successfully !";
        } catch (Exception e) {
            log.error("Error while updating Delivery Status {} ", e.getMessage());
            throw new RuntimeException(e);
        }
    }

    @Override
    @Transactional
    public Response updateCaseSheetTemplate (CreateCaseSheetTemplateRequest createCaseSheetTemplateRequest, Long id) {
        try {
            log.debug("START of updateCaseSheetTemplate {} ",id);

            final CaseSheetTemplate caseSheetTemplate = caseSheetTemplateRepository.findById(id).orElseThrow(()-> new NotFoundException("Case Sheet Template not found for id : "+id));
            caseSheetTemplate.update(createCaseSheetTemplateRequest);
            this.caseSheetTemplateRepository.saveAndFlush(caseSheetTemplate);

            log.debug("END updateCaseSheetTemplate id ");
            return new Response(caseSheetTemplate.getId());
        } catch (Exception e) {
            log.error("Error while deleting Template {} ", e.getMessage());
            throw new RuntimeException(e);
        }
    }

    @Override
    @Transactional
    public Response updateAncChildDetails (final CreateAncChildRequest createAncChildRequest) {
        try {
            log.debug("START of updating AncChild Details {},",createAncChildRequest.getId());
            final AncChildDetialsSheet ancChildDetialsSheet = ancChildRepository.findById(createAncChildRequest.getId()).orElseThrow(()-> new NotFoundException("Anc Child Details not found for id : "+ createAncChildRequest.getId()));
            ancChildDetialsSheet.update(createAncChildRequest);
            this.ancChildRepository.saveAndFlush(ancChildDetialsSheet);
            log.debug("End of updating Anc Child Details");

            return new Response(ancChildDetialsSheet.getId());
        } catch (Exception e) {
            log.error("Error while updating Anc Child Details {} " , e.getMessage());
            throw new RuntimeException(e);
        }
    }

    public String getLocalIpAddress() {
        try {
            Enumeration<NetworkInterface> interfaces = NetworkInterface.getNetworkInterfaces();
            while (interfaces.hasMoreElements()) {
                NetworkInterface iface = interfaces.nextElement();
                if (iface.isLoopback() || !iface.isUp())
                    continue;

                Enumeration<InetAddress> addresses = iface.getInetAddresses();
                while (addresses.hasMoreElements()) {
                    InetAddress addr = addresses.nextElement();
                    if (addr.isLoopbackAddress())
                        continue;
                    if (addr instanceof java.net.Inet4Address) // prefer IPv4
                        return addr.getHostAddress();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "UNKNOWN";
    }


    @Override
    @Transactional
    public Response saveDoctorTransferDetails(CreateDoctorTransferRequest request, Long userId , Long doctorId , String clientIp) {

       try {

           log.debug("START doctor transfer with investigation order");

           CreateInvestigationOrderRequest investigationOrderRequest =
                   request.getInvestigationOrders().get(0);

           int currentMaxToken = recDoctorTransferRepository.findMaxDoctorTokenByToDoc(request.getToDoc());

           RecDoctorTransfer transfer = new RecDoctorTransfer();
           transfer.setPatId(investigationOrderRequest.getPatId());
           transfer.setVstId(investigationOrderRequest.getVstId());
           transfer.setFromDoc(doctorId);
           transfer.setToDoc(request.getToDoc());
           transfer.setEntUid(userId);
           transfer.setEntDateTime(LocalDateTime.now());
           transfer.setIsCancelled(false);
           transfer.setSystemIp(getLocalIpAddress());
           transfer.setIsCompleted(0);
           transfer.setNextReview("0000-00-00");
           transfer.setDoctorToken(currentMaxToken + 1);

           recDoctorTransferRepository.save(transfer);
           investigationOrderRequest.setUid(userId);
           investigationOrderRequest.setUnit(1.00);
           // 2️⃣ Call existing API (NO CHANGE)
           saveInvestigationOrder(
                   request.getInvestigationOrders(),
                   request.getToDoc(), userId
           );

           log.debug("END doctor transfer with investigation order");
           return new Response(transfer.getId());
       } catch (Exception e) {
           log.error("Error while saving doctor transfer {} " , e.getMessage());
           throw new RuntimeException(e);
       }
    }

    @Override
    @Transactional
    public Response removeDoctorTransfer(final Long transferId, final Long userId) {

        log.debug("START of removeDoctorTransfer, transferId={}", transferId);

        RecDoctorTransfer recDoctorTransfer =
                recDoctorTransferRepository.findById(transferId)
                        .orElseThrow(() ->
                                new NotFoundException("Doctor transfer not found for id: " + transferId));

        // Soft delete doctor transfer
//        recDoctorTransfer.setIsCancelled(true);
//        recDoctorTransferRepository.save(recDoctorTransfer);
        int update = recDoctorTransferRepository.cancelTransferOrder(transferId, userId);

        if (update == 0) {
            log.warn("No transfer orders found for docId={}", transferId);
        }
        // Cancel investigation orders for the transferred doctor
        int updatedRows = investigationOrderRepository
                .cancelByDocId(recDoctorTransfer.getToDoc(), userId,recDoctorTransfer.getVstId());

        if (updatedRows == 0) {
            log.warn("No investigation orders found for docId={}", recDoctorTransfer.getToDoc());
        }

        log.debug("END of removeDoctorTransfer, transferId={}", transferId);

        return new Response(transferId);
    }

    @Override
    @Transactional
    public Response receiveDoctorTransfer(final Long transferId, final Long docId) {

        log.debug("START of receiving patient, transferId={}", transferId);

        RecDoctorTransfer recDoctorTransfer =
                recDoctorTransferRepository.findByIdAndToDocAndIsCancelledFalse(transferId,docId)
                        .orElseThrow(() ->
                                new NotFoundException("Doctor transfer not found for id: " + transferId));

        // Mark the transfer as completed
        int update = recDoctorTransferRepository.markTransferAsReceived(transferId, docId);

        if (update == 0) {
            log.warn("No transfer orders updated for transferId={}", transferId);
        }

        log.debug("END of receiving patient , transferId={}", transferId);

        return new Response(transferId);
    }

    @Override
    @Transactional
    public Response completeDoctorTransfer(final Long transferId, final String nextReview, final Long docId) {

        log.debug("START of completing patient, transferId={}", transferId);

        RecDoctorTransfer recDoctorTransfer =
                recDoctorTransferRepository.findByIdAndToDocAndIsCancelledFalse(transferId,docId)
                        .orElseThrow(() ->
                                new NotFoundException("Doctor transfer not found for id: " + transferId));

        recDoctorTransfer.setIsCompleted(2);
        recDoctorTransfer.setNextReview(nextReview);
        // Mark the transfer as completed
//        int update = recDoctorTransferRepository.markTransferAsReceived(transferId, docId);

//        if (update == 0) {
//            log.warn("No transfer orders updated for transferId={}", transferId);
//        }

        log.debug("END of receiving patient , transferId={}", transferId);

        return new Response(transferId);
    }

    @Override
    @Transactional
    public Response reOpenDoctorTransfer(final Long transferId, final Long docId) {

        log.debug("START of receiving patient, transferId={}", transferId);

        RecDoctorTransfer recDoctorTransfer =
                recDoctorTransferRepository.findByIdAndToDocAndIsCancelledFalse(transferId,docId)
                        .orElseThrow(() ->
                                new NotFoundException("Doctor transfer not found for id: " + transferId));

        int update = recDoctorTransferRepository.markTransferAsReopened(transferId, docId);

        if (update == 0) {
            log.warn("No transfer orders updated for transferId={}", transferId);
        }

        log.debug("END of receiving patient , transferId={}", transferId);

        return new Response(transferId);
    }

    @Override
    @Transactional
    public Response blockInvestigationByOrderId(Long orderId, Long userId) {
        try {
            log.debug("START blockInvestigationByOrderId orderId {} by user {}", orderId, userId);

            // Update header: mark x_temp_cash_bill as cancelled
            final String updateHeader = "UPDATE x_temp_cash_bill SET is_cancelled = 1 WHERE id = ?";
            int headerUpdated = this.jdbcTemplate.update(updateHeader, orderId);

            // Update details: mark details cancelled and set cancel metadata
            final String updateDetails = "UPDATE x_temp_cash_bill_details SET is_cancelled = 1, cancel_uid = ?, cancel_date = CURDATE(), cancel_time = CURTIME() WHERE bill_id = ?";
            int detailsUpdated = this.jdbcTemplate.update(updateDetails, userId, orderId);

            if (headerUpdated == 0 && detailsUpdated == 0) {
                throw new NotFoundException("Order not found or already cancelled");
            }

            log.debug("END blockInvestigationByOrderId orderId {}", orderId);
            return new Response(orderId);
        } catch (Exception ex) {
            log.error("Error in blockInvestigationByOrderId for order {} : {}", orderId, ex.getMessage());
            throw ex;
        }
    }

    @Transactional
    @Override
    public Response updateDocStatus(Long doctorId, String status) {
        try {
            // ── STEP 1: log incoming params ──────────────────────────────────
            log.info("[DEBUG] updateDocStatus CALLED  doctorId={} status='{}'", doctorId, status);

            // ── STEP 2: find today's record ───────────────────────────────────
            String checkQry = "SELECT id, attendance_date, status, scheduled_end_time " +
                              "FROM doctor_daily_schedule " +
                              "WHERE doctor_id = ? " +
                              "AND DATE(attendance_date) = CURDATE() " +
                              "ORDER BY id DESC LIMIT 1";
            log.info("[DEBUG] SELECT query: {}", checkQry);
            List<Map<String, Object>> records = this.jdbcTemplate.queryForList(checkQry, doctorId);

            log.info("[DEBUG] SELECT returned {} row(s)", records.size());
            if (records.isEmpty()) {
                log.warn("[DEBUG] No record found for doctorId={} today — throwing PLEASE CHECK IN", doctorId);
                throw new NoRecordFoundException("PLEASE CHECK IN");
            }

            Map<String, Object> row = records.get(0);
            Long recordId = ((Number) row.get("id")).longValue();
            log.info("[DEBUG] Record found: id={} attendance_date={} current_status={} scheduled_end_time={}",
                    recordId, row.get("attendance_date"), row.get("status"), row.get("scheduled_end_time"));

            // ── STEP 3: run update ─────────────────────────────────────────────
            int rowsAffected;
            if ("COMPLETED".equalsIgnoreCase(status) || "COMPLETE".equalsIgnoreCase(status)) {
                log.info("[DEBUG] Status is COMPLETED — will set scheduled_end_time = CURTIME()");
                String updateQry = "UPDATE doctor_daily_schedule " +
                                   "SET status = ?, scheduled_end_time = CURTIME() " +
                                   "WHERE id = ?";
                log.info("[DEBUG] UPDATE query: {}  params=[status='{}', id={}]", updateQry, status, recordId);
                rowsAffected = this.jdbcTemplate.update(updateQry, status, recordId);
            } else {
                log.info("[DEBUG] Status is '{}' — updating status only", status);
                String updateQry = "UPDATE doctor_daily_schedule SET status = ? WHERE id = ?";
                log.info("[DEBUG] UPDATE query: {}  params=[status='{}', id={}]", updateQry, status, recordId);
                rowsAffected = this.jdbcTemplate.update(updateQry, status, recordId);
            }
            log.info("[DEBUG] UPDATE affected {} row(s)", rowsAffected);

            // ── STEP 4: verify — re-read the row to confirm what was saved ─────
            String verifyQry = "SELECT id, status, scheduled_end_time FROM doctor_daily_schedule WHERE id = ?";
            List<Map<String, Object>> verify = this.jdbcTemplate.queryForList(verifyQry, recordId);
            if (!verify.isEmpty()) {
                log.info("[DEBUG] VERIFY after update: id={} status={} scheduled_end_time={}",
                        verify.get(0).get("id"),
                        verify.get(0).get("status"),
                        verify.get(0).get("scheduled_end_time"));
            }

            log.info("[DEBUG] updateDocStatus DONE  doctorId={} status='{}' recordId={}", doctorId, status, recordId);
            return new Response(recordId);

        } catch (NoRecordFoundException e) {
            throw e;
        } catch (Exception e) {
            log.error("[DEBUG] EXCEPTION in updateDocStatus doctorId={} status='{}' error={}", doctorId, status, e.getMessage(), e);
            throw new RuntimeException(e);
        }
    }

    @Override
    @Transactional
    public Response updateDoctorViewing(final Long patId, final Long vstId, final Long toDoc) {
        try {
            log.debug("START updateDoctorViewing patId={} vstId={} toDoc={}", patId, vstId, toDoc);

            recDoctorTransferRepository.resetDoctorViewing(toDoc);


            int updated = recDoctorTransferRepository.setDoctorViewing(patId, vstId, toDoc);

            if (updated == 0) {
                throw new NotFoundException(
                        "No active transfer record found for patId=" + patId +
                        ", vstId=" + vstId + ", toDoc=" + toDoc);
            }

            log.debug("END updateDoctorViewing patId={} vstId={} toDoc={}", patId, vstId, toDoc);
            return new Response(patId);
        } catch (NotFoundException e) {
            throw e;
        } catch (Exception e) {
            log.error("Error in updateDoctorViewing patId={} vstId={} toDoc={}: {}", patId, vstId, toDoc, e.getMessage());
            throw new RuntimeException(e);
        }
    }
}
