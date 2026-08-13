package com.ueniweb.swiftwaresolutions.services;

import com.ueniweb.swiftwaresolutions.core.response.Response;
import com.ueniweb.swiftwaresolutions.core.services.PaginationHelper;
import com.ueniweb.swiftwaresolutions.data.*;
import com.ueniweb.swiftwaresolutions.data.DoctorScheduleStatusData;
import com.ueniweb.swiftwaresolutions.domain.InvImgUpload;
import com.ueniweb.swiftwaresolutions.repository.ImgInvRepository;
import com.ueniweb.swiftwaresolutions.repository.PrescriptionRepository;
import com.ueniweb.swiftwaresolutions.rowmapper.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.time.LocalDate;
import java.util.*;


@Service
@RequiredArgsConstructor
@Slf4j
public class ClinicalInfoReadPlatformServiceImpl implements ClinicalInfoReadPlatformService {

    private final JdbcTemplate jdbcTemplate;

    private final PrescriptionRepository prescriptionRepository;
    private final PaginationHelper<PrescriptionData> prescriptionDataPaginationHelper = new PaginationHelper<>();
    private AntenatalCaseSheetRowMapper antenatalCaseSheetRowMapper;

    private final ImgInvRepository imgInvRepository;

     private String uploadDir = "\\\\192.168.1.60\\d\\APPLICATION\\GDH\\HIS_gdh\\uplodImages";

//    private String uploadDir = "D:\\Application\\GDH\\HIS_gdh\\uploadImages";


    @Override
    public List<ComplaintData> fetchComplaintDetails(String complaintName) {
        log.debug("START of fetchComplaintDetails() complaintName{}", complaintName);
        final ComplaintsRowMapper complaintsRowMapper = new ComplaintsRowMapper();

        String qry = "SELECT " + complaintsRowMapper.tableSchema() + " WHERE name like " + "'%" + complaintName + "%'" + " and  is_blocked=0";
        String countQry = "SELECT count(*)" + complaintsRowMapper.schema();
        log.debug("END of fetchComplaintDetails()");
        return this.jdbcTemplate.query(qry, complaintsRowMapper);
    }

    @Override
    public List<DiagnosisData> fetchDiagnosisDetails(String diagName) {
        log.debug("START of fetchDiagnosisDetails() diagName{} ", diagName);
        final DiagnosisRowMapper diagnosisRowMapper = new DiagnosisRowMapper();

        String qry = "SELECT " + diagnosisRowMapper.tableSchema() + " WHERE a.id = b.disease_id AND b.name like " + "'%" + diagName + "%'" + " and a.is_valid = 1 AND b.is_valid = 1  ORDER BY b.name";

        String countQry = "SELECT count(*)" + diagnosisRowMapper.schema();
        log.debug("END of fetchDiagnosisDetails()");
        return this.jdbcTemplate.query(qry, diagnosisRowMapper);
    }

    @Override
    public List<GenericData> fetchGenericDetails(String genName) {
        log.debug("START of fetchGenericDetails()  genName{} ", genName);
        final GenericRowMapper genericRowMapper = new GenericRowMapper();

        String qry = "SELECT " + genericRowMapper.tableSchema() + " WHERE name like " + "'%" + genName + "%'" + " ORDER BY NAME";
        String countQry = "SELECT count(*)" + genericRowMapper.schema();
        log.debug("END of fetchDiagnosisDetails()");
        return this.jdbcTemplate.query(qry, genericRowMapper);
    }

    @Override
    public List<TimingData> fetchTimingDetails() {
        log.debug("START of fetchTimingDetails() ");
        final TimingRowMapper timingRowMapper = new TimingRowMapper();

        String qry = "SELECT " + timingRowMapper.tableSchema() + " WHERE a.is_active=1 ORDER BY a.order";
        String countQry = "SELECT count(*)" + timingRowMapper.schema();
        log.debug("END of fetchTimingDetails()");
        return this.jdbcTemplate.query(qry, timingRowMapper);
    }

    @Override
    public List<DurationData> fetchDurationDetails() {
        log.debug("START of fetchDurationDetails() ");
        final DurationRowMapper durationRowMapper = new DurationRowMapper();

        String qry = "SELECT " + durationRowMapper.tableSchema() + " WHERE a.is_valid=1";
        String countQry = "SELECT count(*)" + durationRowMapper.schema();
        log.debug("END of fetchDurationDetails()");
        return this.jdbcTemplate.query(qry, durationRowMapper);
    }

    @Override
    public List<ConsultantData> fetchConsultant(String consultantName) {
        log.debug("START of fetchConsultant() consultantName{} ", consultantName);
        final ConsultantRowWrapper consultantRowWrapper = new ConsultantRowWrapper();

        String qry = "SELECT " + consultantRowWrapper.tableSchema() + " WHERE name like " + "'%" + consultantName + "%'" + " and  a.is_active=1 ORDER BY a.name";
        String countQry = "SELECT count(*)" + consultantRowWrapper.schema();
        log.debug("END of fetchConsultant()");
        return this.jdbcTemplate.query(qry, consultantRowWrapper);
    }

    @Override
    public List<UnitData> fetchUnitDetails() {
        log.debug("START of fetchUnitDetails() ");
        final UnitRowMapper unitRowMapper = new UnitRowMapper();

        String qry = "SELECT " + unitRowMapper.tableSchema() + " WHERE a.is_valid=1";
        String countQry = "SELECT count(*)" + unitRowMapper.schema();
        log.debug("END of fetchUnitDetails()");
        return this.jdbcTemplate.query(qry, unitRowMapper);
    }

    @Override
    public List<LabDepartmentData> fetchLabDepartment() {
        log.debug("START of fetchLabDepartment() ");
        final LabDepartmentRowMapper labDepartmentRowMapper = new LabDepartmentRowMapper();

        String qry = "SELECT " + labDepartmentRowMapper.tableSchema() + " ORDER BY dept_name";
        String countQry = "SELECT count(*)" + labDepartmentRowMapper.schema();
        log.debug("END of fetchLabDepartment()");
        return this.jdbcTemplate.query(qry, labDepartmentRowMapper);
    }

    @Override
    public List<InvDepartmentData> fetchInvestigationDepartment() {
        log.debug("START of fetchInvestigationDepartment() ");
        final InvDepartmentRowMapper invDepartmentRowMapper = new InvDepartmentRowMapper();

        String qry = "SELECT " + invDepartmentRowMapper.tableSchema() + " WHERE is_group = 1 AND is_display_to_clinical_order = 1 AND is_blocked = 0 ORDER BY NAME";
        System.out.println("inv is "+ qry);
        String countQry = "SELECT count(*)" + invDepartmentRowMapper.schema();

        log.debug("END of fetchInvestigationDepartment()");
        return this.jdbcTemplate.query(qry, invDepartmentRowMapper);
    }


    public List<LabResultData> fetchLabResultDetailsByVisitId(Long visitId) {
        log.debug("START of fetchLabResultDetailsByVisitId() visitId{} ", visitId);
        final LabResultsRowMapper labResultsRowMapper = new LabResultsRowMapper();
        String whereCondition = " WHERE a.id=b.final_bill_id AND b.spec_id=c.spec_code AND b.id=d.testreg_id AND d.testval_id=e.testval_id AND e.field_id=f.fieldid AND" +
                " b.dept_autoid=h.dept_autoid AND h.maj_id=i.maj_id AND b.isverified=1 AND a.is_cancelled=0 AND a.visit_id=" + visitId;
        String qry = labResultsRowMapper.getSelectSchema() + labResultsRowMapper.getTableSchema() + whereCondition + " ORDER BY b.ent_date, b.test_name ";
        log.debug("END of fetchLabResultDetailsByVisitId()");
        return this.jdbcTemplate.query(qry, labResultsRowMapper);
    }

    @Override
    public List<InvestigationData> fetchInvestigationDetailsByGroupId(Long groupId) {
        log.debug("START of fetchInvestigationDetailsByGroupId() groupId{} ", groupId);
        final InvestigationRowMapper investigationRowMapper = new InvestigationRowMapper();

        String whereCondition = " WHERE a1.id = a2.grp AND a2.id = a3.head_id AND a2.is_blocked = 0 AND a1.id = " + groupId + " GROUP BY a2.id";

        if (groupId == 0) {
            whereCondition = " WHERE a1.id = a2.grp AND a2.id = a3.head_id AND a2.is_blocked = 0 AND a1.`is_display_to_clinical_order`= 1 GROUP BY a2.id";
        }
        String qry = " SELECT " + investigationRowMapper.tableSchema() + whereCondition;
        log.debug("END of fetchInvestigationDetailsByGroupId()");
        return this.jdbcTemplate.query(qry, investigationRowMapper);
    }

    @Override
    public List<LabTestNameData> fetchLabTestNameByGroupId(Long deptId) {
        log.debug("START of fetchLabTestNameByGroupId() deptId{} ", deptId);
        final LabTestNameRowMapper labTestNameRowMapper = new LabTestNameRowMapper();
        String whereCondition = " WHERE a1.dept_code = a2.dept_code AND a1.blocked = 0 AND a1.last_value = 1 AND a1.dept_code = " + deptId;
        if (deptId == 0) {
            whereCondition = " WHERE a1.dept_code = a2.dept_code AND a1.blocked = 0 AND a1.last_value = 1";
        }
        String qry = " SELECT " + labTestNameRowMapper.tableSchema() + whereCondition;
        log.debug("END of fetchLabTestNameByGroupId()");
        return this.jdbcTemplate.query(qry, labTestNameRowMapper);
    }

    @Override
    public List<TemplateData> fetchPrescriptionTemplates(Long templateType) {
        log.debug("START of fetchCaseSheetTemplates() templateType{} ", templateType);
        final PrescTemplateRowMapper prescTemplateRowMapper = new PrescTemplateRowMapper();

        String qry = "SELECT a.id,a.name as templateName from ph_template a where a.templateType=" + templateType + " and a.is_valid=1";

        log.debug("END of fetchCaseSheetTemplates()");
        return this.jdbcTemplate.query(qry, prescTemplateRowMapper);

    }

    @Override
    public List<PrescTemplateDetailsData> fetchPrescriptionTemplateDetailsById(Long id, Integer storeId) {
        log.debug("START of fetchPrescriptionTemplateDetailsByPrescId() prescId{} ", id);
        final PrescTemplateDetailsRowMapper prescTemplateDetailsRowMapper = new PrescTemplateDetailsRowMapper();
        String whereCondition = " WHERE e.`generic_id`=d.`id` AND a.prods_id=e.id AND a.template_id=b.id AND e.`id` = n.`prods_id` AND n.`id` = o.`batch_id` AND o.`store_id` =" + storeId + " AND b.id = " + id + " GROUP BY e.id";

        String qry = " SELECT " + prescTemplateDetailsRowMapper.tableSchema(storeId) + whereCondition;
        log.debug("END of fetchPrescriptionTemplateDetailsByPrescId()");
        return this.jdbcTemplate.query(qry, prescTemplateDetailsRowMapper);
    }

    @Override
    public List<PrevPrescriptionDetailsData> fetchPrevPrescriptionDetails(Long patId, Integer storeId) {
        log.debug("START of fetchPrevPrescriptionDetails() patId{} ", patId);
        final PrevPrescDetailsRowMapper prevPrescDetailsRowMapper = new PrevPrescDetailsRowMapper();
        String whereCondition = " WHERE a.generic_id=d.id AND a.prods_id=e.id AND a.prescription_id=b.id and (c.id = b.doc_id OR b.doc_id IS NULL) AND b.pat_id = " + patId + " and a.is_cancelled=0";

        String qry = " SELECT " + prevPrescDetailsRowMapper.tableSchema(storeId) + whereCondition;
        System.out.println("qry is " + qry);
        log.debug("END of fetchPrevPrescriptionDetails()");
        return this.jdbcTemplate.query(qry, prevPrescDetailsRowMapper);
    }

    @Override
    public List<PrevPrescriptionDetailsData> fetchPrevPrescriptionDetailsByVstId(Long vstId, Integer storeId) {
        log.debug("START of fetchPrevPrescriptionDetailsByVstId() vstId{} ", vstId);
        final PrevPrescDetailsRowMapper prevPrescDetailsRowMapper = new PrevPrescDetailsRowMapper();
        String whereCondition = " WHERE a.generic_id=d.id AND a.prods_id=e.id AND a.prescription_id=b.id and (c.id = b.doc_id OR b.doc_id IS NULL) AND b.visit_id = " + vstId + " and a.is_cancelled=0";

        String qry = " SELECT " + prevPrescDetailsRowMapper.tableSchema(storeId) + whereCondition;
        System.out.println("qry is " + qry);
        log.debug("END of fetchPrevPrescriptionDetailsByVstId()");
        return this.jdbcTemplate.query(qry, prevPrescDetailsRowMapper);
    }

    @Override
    public List<PrevPrescriptionDetailsData> fetchPrescriptionDetailsByVstId(Long vstId, Integer isFromSummary) {
        log.debug("START of fetchPrescriptionDetailsByVstId() vstId{} isFromSummary{}", vstId, isFromSummary);
        final PrevPrescDetailsRowMapper prevPrescDetailsRowMapper = new PrevPrescDetailsRowMapper();
        String whereCondition = " WHERE a.generic_id=d.id AND a.prods_id=e.id AND a.prescription_id=b.id and (c.id = b.doc_id OR b.doc_id IS NULL) AND b.visit_id = " + vstId + " and b.isFromSummary=" + isFromSummary + " and a.is_cancelled=0";

        String qry = " SELECT " + prevPrescDetailsRowMapper.tableSchema(1) + whereCondition;
        log.debug("END of fetchPrescriptionDetailsByVstId()");
        return this.jdbcTemplate.query(qry, prevPrescDetailsRowMapper);
    }

    @Override
    public List<PrevPrescriptionDetailsData> fetchPatientLastPrescription(Long patId, Integer storeId ,  Long userId) {
        log.debug("START of fetchPrevPrescriptionDetails() patId{} ", patId);
        final PrevPrescDetailsRowMapper prevPrescDetailsRowMapper = new PrevPrescDetailsRowMapper();
        String display = this.prescriptionRepository.getPrescDisplay(patId, userId);

        String whereCondition = " WHERE a.generic_id=d.id AND a.prods_id=e.id AND a.prescription_id=b.id and (c.id = b.doc_id OR b.doc_id IS NULL) AND b.display =" + display + " and a.is_cancelled=0";

        String qry = " SELECT " + prevPrescDetailsRowMapper.tableSchema(storeId) + whereCondition;
        System.out.println("prev presc : " +qry);
        log.debug("END of fetchPrevPrescriptionDetails()");
        return this.jdbcTemplate.query(qry, prevPrescDetailsRowMapper);
    }

    public List<PrescriptionData> fetchPrescriptionDetailsById(Long id) {
        log.debug("START of fetchPrescriptionDetailsById() id {} ", id);
        final PrescriptionRowMapper prescriptionRowMapper = new PrescriptionRowMapper();
        String whereCond = "";
        if (id != null) {
            whereCond = " WHERE prd.is_cancelled=0 and  pr.id ='" + id + "' ";
        }
        String qry = "SELECT " + prescriptionRowMapper.tableSchema() + whereCond;

        log.debug("END of fetchPrescriptionDetailsById() id {} ", id);
        return this.jdbcTemplate.query(qry, prescriptionRowMapper);
    }

    @Override
    public List<GeneralCaseSheetData> fetchGeneralCaseSheetByVstId(Long vstId) {
        log.debug("START of fetchGeneralCaseSheetByVstId() vstId{} ", vstId);

        final GeneralCaseSheetRowMapper generalCaseSheetRowMapper = new GeneralCaseSheetRowMapper();
        String whereCondition = " WHERE cs.vstId = " + vstId;

        String qry = " SELECT " + generalCaseSheetRowMapper.schema() + whereCondition;
        log.debug("END of fetchGeneralCaseSheetByVstId()");
        final List<GeneralCaseSheetData> generalDataList = this.jdbcTemplate.query(qry, generalCaseSheetRowMapper);
        for (GeneralCaseSheetData generalCaseSheetData : generalDataList) {
            final List<ComplaintDetailsData> complaintDataList = fetchComplaintDetailsByVisitId(generalCaseSheetData.getVstId(), 1L);
            generalCaseSheetData.setComplaintDataList(complaintDataList);
            final List<DiagnosisData> diagnosisDataList = fetchDiagnosisDetailsByVisitId(generalCaseSheetData.getVstId(), 1);
            generalCaseSheetData.setDiagnosisDetailsData(diagnosisDataList);
        }
        return generalDataList;
    }

    public List<ComplaintDetailsData> fetchComplaintDetailsByVisitId(Long vstId, Long caseSheetType) {
        log.debug("START of fetchComplaintDetailsByVisitId() vstId{} caseSheetType{} ", vstId, caseSheetType);
        final ComplaintDetailsRowMapper complaintDetailsRowMapper = new ComplaintDetailsRowMapper();

        String qry = " SELECT " + complaintDetailsRowMapper.tableSchema() + "WHERE a.`complaintId`=b.`id` AND a.isValid=1 AND a.`vstId`=" + vstId + " AND a.`caseSheetType`=" + caseSheetType;
        log.debug("END of fetchComplaintDetailsByVisitId()");
        return this.jdbcTemplate.query(qry, complaintDetailsRowMapper);
    }

    public List<DiagnosisData> fetchDiagnosisDetailsByVisitId(Long vstId, Integer caseSheetType) {
        log.debug("START of fetchDiagnosisDetailsByVisitId() vstId{} caseSheetType{} ", vstId, caseSheetType);
        final DiagnosisDetailsRowMapper diagnosisDetailsRowMapper = new DiagnosisDetailsRowMapper();

        String qry = " SELECT " + diagnosisDetailsRowMapper.tableSchema() + " WHERE a.`id`=b.`diagnosisId` AND b.`vstId`=" + vstId + " AND b.`caseSheetType`=" + caseSheetType + " AND b.`isValid`=1 ";

        log.debug("END of fetchDiagnosisDetailsByVisitId()");
        return this.jdbcTemplate.query(qry, diagnosisDetailsRowMapper);
    }

    @Override
    public List<LabOrderedData> fetchLabOrderedDetails(Long patId) {
        log.debug("START of fetchLabOrderedDetails() patId{} ", patId);
        final LabOrderedDetailsRowMapper labOrderedDetailsRowMapper = new LabOrderedDetailsRowMapper();

        String qry = " SELECT a.id,a.pat_id as patId,b.test_name as testName,a.unit as units,DATE_FORMAT(DATE(a.dtm),'%d/%m/%Y') as date ,b.rate FROM x_temp_lab_bill_details a,lab_config_master_test b WHERE a.test_id=b.test_id and a.finalBillId =0 and a.is_cancelled = 0 AND a.pat_id=" + patId;
        log.debug("END of fetchLabOrderedDetails()");
        return this.jdbcTemplate.query(qry, labOrderedDetailsRowMapper);
    }

    @Override
    public List<DiscountData> fetchOrderDiscountAmount(Long patId) {
        log.debug("START of fetchOrderDiscountAmount() patId{} ", patId);
        final DiscountRowMapper discountRowMapper = new DiscountRowMapper();

        String qry = " SELECT a.id,a.pat_id as patId,a.datetime,a.disc_amt as discAmt FROM `x_temp_inv_lab_disc`a WHERE a.pat_id=" + patId + " AND a.final_bill_id=0";
        log.debug("END of fetchOrderDiscountAmount()");
        return this.jdbcTemplate.query(qry, discountRowMapper);
    }

    @Override
    public List<OrderWithDetailsData> fetchInvestigationOrderedDetails(Long patId) {
        log.debug("START of fetchInvestigationOrderedDetails() patId{} ", patId);
         final InvestigationOrderedRowMapper investigationOrderedRowMapper = new InvestigationOrderedRowMapper();

        // New behavior: fetch orders (x_temp_cash_bill) for patient and then fetch details per order
        String headerSql = "SELECT a.id AS orderId, a.order_display AS orderDisplay, a.total AS totalAmt, "
                + "a.order_uid AS orderUserId, a.doct_id AS doctorId, b.name AS userName, "
                + "CONCAT(c.name, ' ', c.qualification) AS doctorName, d.name AS deptName "
                + "FROM x_temp_cash_bill a "
                + "JOIN admin_users b ON a.order_uid = b.id "
                + "JOIN rec_config_msc_consultants c ON a.doct_id = c.id "
                + "JOIN rec_config_msc_departments d ON d.id = c.dept_id "
                + "WHERE a.pat_id = ? AND a.is_cancelled = 0 AND a.is_billed = 0";

        final List<com.ueniweb.swiftwaresolutions.data.OrderWithDetailsData> orders = this.jdbcTemplate.query(headerSql, new Object[]{patId}, (rs, rowNum) -> {
            com.ueniweb.swiftwaresolutions.data.OrderWithDetailsData o = new com.ueniweb.swiftwaresolutions.data.OrderWithDetailsData();
            o.setOrderId(rs.getLong("orderId"));
            o.setOrderDisplay(rs.getString("orderDisplay"));
            o.setTotalAmt(rs.getDouble("totalAmt"));
            o.setOrderUserId(rs.getLong("orderUserId"));
            o.setDoctorId(rs.getLong("doctorId"));
            o.setUserName(rs.getString("userName"));
            o.setDoctorName(rs.getString("doctorName"));
            o.setDeptName(rs.getString("deptName"));
            return o;
        });

        // details query (reuse InvestigationOrderedRowMapper)
        String detailSql = " select a.id,a.pat_id as patId,b.name as procName,a.unit as units,date_format(date(a.dtm),'%d/%m/%Y') as date,b.rate "
                + "from x_temp_cash_bill_details a,cash_config_head b "
                + "where a.particular_id=b.id AND a.group_id NOT IN (1,2,11) and a.finalBillId =0 and a.is_cancelled = 0 AND a.bill_id = ?";

        List<com.ueniweb.swiftwaresolutions.data.OrderWithDetailsData> filteredOrders = new java.util.ArrayList<>();
        for (com.ueniweb.swiftwaresolutions.data.OrderWithDetailsData order : orders) {
            try {
                List<InvestigationOrderedData> details = this.jdbcTemplate.query(detailSql, new Object[]{order.getOrderId()}, investigationOrderedRowMapper);
                if (details != null && !details.isEmpty()) {
                    order.setDetails(details);
                    filteredOrders.add(order);
                } else {
                    // skip orders with no details
                    log.debug("Skipping order {} as it has no details", order.getOrderId());
                }
            } catch (Exception ex) {
                log.error("Error fetching details for order {} : {}", order.getOrderId(), ex.getMessage());
                // skip on error as well
            }
        }

        log.debug("END of fetchInvestigationOrderedDetails()");
        return filteredOrders;
    }

    @Override
    public List<TemplateData> fetchOrderTemplates(Long type) {
        log.debug("START of fetchOrderTemplates() ");
        final OrderTemplateRowMapper orderTemplateRowMapper = new OrderTemplateRowMapper();

        String qry = "SELECT a.id,a.templateName AS templateName FROM cli_investigation_template a WHERE tempType = " + type + " and isActive=1";

        log.debug("END of fetchOrderTemplates()");
        return this.jdbcTemplate.query(qry, orderTemplateRowMapper);

    }

    @Override
    public List<LabTestNameData> fetchLabOrderTemplatesById(Long templateId) {
        log.debug("START of fetchLabOrderTemplatesById() templateId{} ", templateId);
        final LabOrderTemplateRowMapper labOrderTemplateRowMapper = new LabOrderTemplateRowMapper();
        String whereCondition = " WHERE a1.dept_code = a2.dept_code AND a1.test_id = a3.procedureId AND a3.templateId = " + templateId + " AND a1.blocked = 0 AND a1.last_value = 1";

        String qry = " SELECT " + labOrderTemplateRowMapper.tableSchema() + whereCondition;
        log.debug("END of fetchLabOrderTemplatesById()");
        return this.jdbcTemplate.query(qry, labOrderTemplateRowMapper);
    }

    @Override
    public List<InvestigationData> fetchInvOrderTemplatesById(Long templateId) {
        log.debug("START of fetchInvOrderTemplatesById() templateId{} ", templateId);
        final InvestigationTemplateRowMapper investigationTemplateRowMapper = new InvestigationTemplateRowMapper();
        String whereCondition = " WHERE a1.id = a2.grp AND a2.id = a3.head_id AND a2.id = a4.procedureId AND a4.templateId = " + templateId + " AND a1.is_display_to_clinical_order = 1 AND a2.is_blocked = 0 GROUP BY a2.id";  //  AND a3.acc_head_id = 391

        String qry = " SELECT " + investigationTemplateRowMapper.tableSchema() + whereCondition;
//        System.out.println("temp " + qry);
//        System.out.println("inv " + qry);
        log.debug("END of fetchInvOrderTemplatesById()");
        return this.jdbcTemplate.query(qry, investigationTemplateRowMapper);
    }

    @Override
    public List<PediatricCaseSheetData> fetchPediatricCaseSheetByVstId(Long vstId) {
        log.debug("START of fetchPediatricCaseSheetByVstId() vstId{} ", vstId);
        final PediatricCasesheetRowMapper pediatricCasesheetRowMapper = new PediatricCasesheetRowMapper();
        String whereCondition = " WHERE a.vstId = " + vstId;
        String qry = " SELECT " + pediatricCasesheetRowMapper.schema() + whereCondition;
        final List<PediatricCaseSheetData> pediatricCaseSheetDataList = this.jdbcTemplate.query(qry, pediatricCasesheetRowMapper);
        for (PediatricCaseSheetData pediatricCaseSheetData : pediatricCaseSheetDataList) {
            final List<ComplaintDetailsData> complaintDataList = fetchComplaintDetailsByVisitId(pediatricCaseSheetData.getVisitId(), 2L);
            pediatricCaseSheetData.setComplaintDataList(complaintDataList);
            log.debug("END of fetchPediatricCaseSheetByVstId()");
        }
        return pediatricCaseSheetDataList;
    }


    @Override
    public List<NeonateCaseSheetData> fetchNeonateCaseSheetByVstId(Long vstId) {
        log.debug("START of fetchNeonateCaseSheetByVstId() vstId{} ", vstId);
        final NeonateCasesheetRowMapper neonateCasesheetRowMapper = new NeonateCasesheetRowMapper();
        String whereCondition = " WHERE a.vstId = " + vstId;
        String qry = " SELECT " + neonateCasesheetRowMapper.schema() + whereCondition;
        final List<NeonateCaseSheetData> neonateCaseSheetDataList = this.jdbcTemplate.query(qry, neonateCasesheetRowMapper);
        for (NeonateCaseSheetData neonateCaseSheetData : neonateCaseSheetDataList) {
            final List<ComplaintDetailsData> complaintDataList = fetchComplaintDetailsByVisitId(neonateCaseSheetData.getVisitId(), 3L);
            neonateCaseSheetData.setComplaintDataList(complaintDataList);
            log.debug("END of fetchNeonateCaseSheetByVstId()");

        }
        return neonateCaseSheetDataList;
    }

    public List<AnthropometryData> fetchAnthropometryByVstId(Long vstId) {
        log.debug("START of fetchAnthropometryByVstId() vstId{}", vstId);
        final AnthropometryRowMapper anthropometryRowMapper = new AnthropometryRowMapper();

        String qry = " SELECT " + anthropometryRowMapper.tableSchema() + "WHERE a.is_valid=1 AND a.`vstId`=" + vstId;
        log.debug("END of fetchAnthropometryByVstId()");
        return this.jdbcTemplate.query(qry, anthropometryRowMapper);
    }

    @Override
    public List<OPVitalsData> fetchOpVitalsByVstId(Long vstId) {
        log.debug("START of fetchOpVitalsByVstId()  vstId{} ", vstId);
        final OPVitalsRowMapper opVitalsRowmapper = new OPVitalsRowMapper();

        String qry = "SELECT " + opVitalsRowmapper.tableSchema() + " WHERE vstId = " + vstId + " order by id desc";

        log.debug("END of fetchOpVitalsByVstId()");
        return this.jdbcTemplate.query(qry, opVitalsRowmapper);
    }

    @Override
    public List<SummaryTemplateData> fetchSummaryTemplate(Long fieldId) {
        log.debug("START of fetchSummaryTemplate()  fieldId{} ", fieldId);
        final SummaryTemplateRowMapper summaryTemplateRowMapper = new SummaryTemplateRowMapper();

        String qry = "SELECT id,name,details from cli_discharge_summary_template where fieldId= " + fieldId;

        log.debug("END of fetchSummaryTemplate()");
        return this.jdbcTemplate.query(qry, summaryTemplateRowMapper);
    }

    @Override
    public Map<String, Object> fetchDentalCaseSheetByVstId(Long vstId) {
        log.debug("START of fetchDentalCaseSheetByVstId() vstId{} ", vstId);
        final DentalCaseSheetRowMapper dentalCaseSheetRowMapper = new DentalCaseSheetRowMapper();

        String qry = " SELECT " + dentalCaseSheetRowMapper.schema() + " WHERE vstId = " + vstId;
        log.debug("END of fetchDentalCaseSheetByVstId()");

        final List<DentalCaseSheetData> dentalDataList = this.jdbcTemplate.query(qry, dentalCaseSheetRowMapper);
        for (DentalCaseSheetData dentalCaseSheetData : dentalDataList) {
            final List<ComplaintDetailsData> complaintDataList = fetchComplaintDetailsByVisitId(dentalCaseSheetData.getVstId(), 5L);
            dentalCaseSheetData.setComplaintDataList(complaintDataList);
            final List<DentalTeethData> teethDataList = fetchTeethDetailsByVisitId(dentalCaseSheetData.getVstId());
            dentalCaseSheetData.setTeethDataList(teethDataList);
            final List<DentalTeethTreatData> teethTreatDataList = fetchTeethTreatDetailsByVisitId(dentalCaseSheetData.getVstId());
            dentalCaseSheetData.setTeethTreatDataList(teethTreatDataList);
        }

        Map<String, Object> dentalCaseSheetMap = new HashMap<>();
        dentalCaseSheetMap.put("status", !dentalDataList.isEmpty());
        if (dentalDataList.isEmpty()) {
            dentalCaseSheetMap.put("message", "No Details Found");
        } else {
            dentalCaseSheetMap.put("data", dentalDataList);
        }
        return dentalCaseSheetMap;
    }

    public List<DentalTeethData> fetchTeethDetailsByVisitId(Long vstId) {
        log.debug("START of fetchTeethDetailsByVisitId() vstId{} ", vstId);
        final DentalTeethRowMapper teethRowMapper = new DentalTeethRowMapper();

        String qry = " SELECT " + teethRowMapper.tableSchema() + "WHERE a.isValid=1 AND a.`vstId`=" + vstId;
        log.debug("END of fetchTeethDetailsByVisitId()");
        return this.jdbcTemplate.query(qry, teethRowMapper);
    }

    public List<DentalTeethTreatData> fetchTeethTreatDetailsByVisitId(Long vstId) {
        log.debug("START of fetchTreatTeethDetailsByVisitId() vstId{}  ", vstId);
        final DentalTeethTreatRowMapper teethTreatRowMapper = new DentalTeethTreatRowMapper();

        String qry = " SELECT " + teethTreatRowMapper.tableSchema() + "WHERE a.isValid=1 AND a.`vstId`=" + vstId;
        log.debug("END of fetchTreatTeethDetailsByVisitId()");
        return this.jdbcTemplate.query(qry, teethTreatRowMapper);
    }

    @Override
    public List<AntenatelCaseSheetData> fetchAntenatalCaseSheetByVstId(Long vstId) {
        log.debug("START of fetchAntenatalByVstId() vstId{} ", vstId);
        final AntenatalCaseSheetRowMapper antenatalCaseSheetRowMapper = new AntenatalCaseSheetRowMapper();
        String whereCondition = " WHERE a.vstId = " + vstId;
        String qry = " SELECT " + antenatalCaseSheetRowMapper.schema() + whereCondition;
        final List<AntenatelCaseSheetData> antenatelCaseSheetDataList = this.jdbcTemplate.query(qry, antenatalCaseSheetRowMapper);
        for (AntenatelCaseSheetData antenatelCaseSheetData : antenatelCaseSheetDataList) {
            final List<AntenatalPreData> antenatalPreDataList = fetchAntenatelPreByVstId(antenatelCaseSheetData.getId());
            antenatelCaseSheetData.setAntenatalPreData(antenatalPreDataList);
            log.debug("END of fetchAntenatalCaseSheetByVstId()");

        }
        return antenatelCaseSheetDataList;
    }

    public List<AntenatalPreData> fetchAntenatelPreByVstId(Long ancId) {
        log.debug("START of fetchAntenatelPreByVisitId() vstId{} ", ancId);
        final AntenatalPreRowMapper antenatalPreRowMapper = new AntenatalPreRowMapper();
        String whereCondition = " WHERE a.ancId = " + ancId + " AND a.isValid=1";

        String qry = " SELECT " + antenatalPreRowMapper.tableSchema() + whereCondition;

        log.debug("END of fetchAntenatelPreByVisitId()");
        return this.jdbcTemplate.query(qry, antenatalPreRowMapper);

    }

    public List<DischargeDiagnosisData> fetchDisDiagnosisDetailsByvisitId(Long vstId) {
        log.debug("START of fetchDisDiagnosisDetailsById() vstId{} ", vstId);
        final DischargeDiagnosisRowMapper diagnosisDetailsRowMapper = new DischargeDiagnosisRowMapper();

        String qry = " SELECT " + diagnosisDetailsRowMapper.tableSchema() + "WHERE a.summaryId = b.id AND c.id=a.diagnosisId AND a.isValid=1 AND b.`vstId`=" + vstId;

        log.debug("END of fetchDisDiagnosisDetailsById()");
        return this.jdbcTemplate.query(qry, diagnosisDetailsRowMapper);
    }

    public List<DischargeLabInvSummaryData> fetchDisLabInvSumDetailsByvisitId(Long vstId) {
        log.debug("START of fetchDisLabInvSumDetailsByvisitId() vstId{} ", vstId);
        final DischargeInvLabSumRowMapper disInvLabDetailsRowMapper = new DischargeInvLabSumRowMapper();

        String qry = " SELECT " + disInvLabDetailsRowMapper.tableSchema() + "WHERE a.summaryId = b.id AND a.isActive=1 AND b.`vstId`=" + vstId;

        log.debug("END of fetchDisLabInvSumDetailsByvisitId()");
        return this.jdbcTemplate.query(qry, disInvLabDetailsRowMapper);
    }

    public List<DisSumConsultantData> fetchDisSumConsultantById(Long id) {
        log.debug("START of fetchDisSumConsultantById() id{} ", id);
        final DisSumConsultantRowMapper disSumConsultantRowMapper = new DisSumConsultantRowMapper();

        String qry = " SELECT a.id,a.summaryId,a.consultantId,b.name as name from cli_discharge_summary_consultant a,rec_config_msc_consultants b where a.consultantId=b.id and a.isValid=1 and summaryId=" + id;

        log.debug("END of fetchDisSumConsultantById()");
        return this.jdbcTemplate.query(qry, disSumConsultantRowMapper);
    }

    public List<DisSumDeptData> fetchDisSumDeptById(Long id) {
        log.debug("START of fetchDisSumDeptById() id{} ", id);
        final DisSumDeptRowMapper disSumConsultantRowMapper = new DisSumDeptRowMapper();

        String qry = " SELECT a.id,a.summaryId,a.deptId,b.name as name from cli_discharge_summary_department a,rec_config_msc_departments b where a.deptId=b.id and a.isValid=1 and  summaryId=" + id;

        log.debug("END of fetchDisSumDeptById()");
        return this.jdbcTemplate.query(qry, disSumConsultantRowMapper);
    }

    @Override
    public Map<String, Object> fetchDischargeSummaryByVstId(Long vstId) {
        log.debug("START of fetchDischargeSummaryByVstId() vstId{} ", vstId);
        final DischargeSummaryRowMapper dischargeSummaryRowMapper = new DischargeSummaryRowMapper();

        String qry = " SELECT " + dischargeSummaryRowMapper.schema() + " WHERE isActive=1 and vstId = " + vstId;
        log.debug("END of fetchDischargeSummaryByVstId()");
        final List<DischargeSummaryData> dischargeSummaryDataList = this.jdbcTemplate.query(qry, dischargeSummaryRowMapper);
        for (DischargeSummaryData dischargeSummaryData : dischargeSummaryDataList) {

            final List<DischargeDiagnosisData> diagnosisDataList = fetchDisDiagnosisDetailsByvisitId(dischargeSummaryData.getVstId());
            dischargeSummaryData.setDischargeDiagnosisDataList(diagnosisDataList);

            final List<DischargeLabInvSummaryData> disLabInvSumDataList = fetchDisLabInvSumDetailsByvisitId(dischargeSummaryData.getVstId());
            dischargeSummaryData.setDischargeLabInvSummaryDataList(disLabInvSumDataList);

            final List<DisSumConsultantData> disSumConsultantDataList = fetchDisSumConsultantById(dischargeSummaryData.getId());
            dischargeSummaryData.setDisSumConsultantDataList(disSumConsultantDataList);

            final List<DisSumDeptData> disSumDeptDataList = fetchDisSumDeptById(dischargeSummaryData.getId());
            dischargeSummaryData.setDisSumDeptDataList(disSumDeptDataList);
        }

        Map<String, Object> dischargeSummaryMap = new HashMap<>();
        dischargeSummaryMap.put("status", !dischargeSummaryDataList.isEmpty());
        if (dischargeSummaryDataList.isEmpty()) {
            dischargeSummaryMap.put("message", "No Details Found");
        } else {
            dischargeSummaryMap.put("data", dischargeSummaryDataList);
        }
        return dischargeSummaryMap;

    }

    public List<PatientUploadImageData> fetchPatientImageDetails(String patId) {
        log.debug("START of fetchXrayImageDetails() id{} ", patId);
        final XrayImagesRowMapper xrayImagesRowMapper = new XrayImagesRowMapper();
        String qry = "SELECT " + xrayImagesRowMapper.schema() + "WHERE x.pat_id =" + patId;
        log.debug("END of fetchXrayImageDetails()");
        return this.jdbcTemplate.query(qry, xrayImagesRowMapper);
    }

    public List<PhInstructionData> fetchPrescriptionInstruction() {
        log.debug("START of fetchPrescriptionInstruction() ");
        final PhInstructionRowMapper phInstructionRowMapper = new PhInstructionRowMapper();
        String qry = "SELECT a.id,a.name FROM`ph_config_instruction` a WHERE a.`is_valid`= 1 ";
        log.debug("END of fetchPrescriptionInstruction()");
        return this.jdbcTemplate.query(qry, phInstructionRowMapper);
    }

    public List<PhRouteData> fetchPrescriptionRoutes() {
        log.debug("START of fetchPrescriptionRoutes() ");
        final PhRouteRowMapper phRouteRowMapper = new PhRouteRowMapper();
        String qry = "SELECT a.id,a.name FROM`ph_config_route` a WHERE a.`is_valid`=1";
        log.debug("END of fetchPrescriptionRoutes()");
        return this.jdbcTemplate.query(qry, phRouteRowMapper);
    }

    @Override
    public List<SurgeryCaseSheetData> fetchSurgeryCaseSheetByVstId(Long visitId) {
        //  log.debug("START of fetchSurgeryCaseSheetByVstId() visitId{} ", visitId);
        final SurgeryCaseSheetRowmapper surgeryCaseSheetRowmapper = new SurgeryCaseSheetRowmapper();
        String whereCondition = " WHERE a.visitId = " + visitId;
        String qry = " SELECT " + surgeryCaseSheetRowmapper.schema() + whereCondition;
        final List<SurgeryCaseSheetData> surgeryCaseSheetDataList = this.jdbcTemplate.query(qry, surgeryCaseSheetRowmapper);
        for (SurgeryCaseSheetData surgeryCaseSheetData : surgeryCaseSheetDataList) {
            final List<SurgeryNurseData> surgeryNurseDataList = fetchSurgeryNurseBySurId(surgeryCaseSheetData.getId());
            surgeryCaseSheetData.setSurgeryNurseData(surgeryNurseDataList);
            final List<SurgerySurgonData> surgerySurgonDataList = fetchSurgerySurgonBySurId(surgeryCaseSheetData.getId());
            surgeryCaseSheetData.setSurgerySurgonData(surgerySurgonDataList);
            final List<SurgeryData> surgeryDataList = fetchSurgeryNameBySurId(surgeryCaseSheetData.getId());
            surgeryCaseSheetData.setSurgeryDataList(surgeryDataList);

            // log.debug("END of fetchSurgeryCaseSheetByVstId()");

        }
        return surgeryCaseSheetDataList;
    }

    public List<SurgeryNurseData> fetchSurgeryNurseBySurId(Long surId) {
        log.debug("START of fetchSurgeryNurseBySurId() SurId{} ", surId);
        final SurgeryNurseRowMapper surgeryNurseRowMapper = new SurgeryNurseRowMapper();
        String whereCondition = " WHERE a.surId = " + surId + " AND a.isValid=1";

        String qry = " SELECT " + surgeryNurseRowMapper.tableSchema() + whereCondition;

        log.debug("END of fetchAntenatelPreByVisitId()");
        return this.jdbcTemplate.query(qry, surgeryNurseRowMapper);

    }

    public List<SurgerySurgonData> fetchSurgerySurgonBySurId(Long surId) {

        log.debug("START of fetchSurgerySurgonBySurId() SurId{} ", surId);

        final SurgerySergonRowMaper surgerySergonRowMaper = new SurgerySergonRowMaper();
        String whereCondition = " WHERE a.surId = " + surId + " AND a.isValid=1 AND b.`id`=a.`surgonId`";

        String qry = " SELECT " + surgerySergonRowMaper.tableSchema() + whereCondition;

        log.debug("END of fetchSurgerySurgonBySurId()");
        return this.jdbcTemplate.query(qry, surgerySergonRowMaper);
    }

    public List<SurgeryData> fetchSurgeryNameBySurId(Long surId) {

        log.debug("START of fetchSurgeryNameBySurId() SurId{} ", surId);

        final SurgeryNameRowMapper surgeryNameRowMapper = new SurgeryNameRowMapper();
        String whereCondition = " WHERE a.surId = " + surId + " AND a.isValid=1 ";

        String qry = " SELECT " + surgeryNameRowMapper.tableSchema() + whereCondition;

        log.debug("END of fetchSurgeryNameBySurId()");
        return this.jdbcTemplate.query(qry, surgeryNameRowMapper);
    }

    @Override
    public List<NursingIoData> fetchNursingIoByVstId(Long vstId) {
        log.debug("START of fetchNursingIoByVstId()  vstId{} ", vstId);
        final NursingIoSheetRowMapper nursingIoSheetRowMapper = new NursingIoSheetRowMapper();

        String qry = "SELECT " + nursingIoSheetRowMapper.tableSchema() + " WHERE visitId = " + vstId;

        log.debug("END of fetchNursingIoByVstId()");
        return this.jdbcTemplate.query(qry, nursingIoSheetRowMapper);
    }

    @Override
    public List<IpProcedureCaseSheetData> fetchIpProcedureCaseSheetByVstId(Long vstId) {
        log.debug("START of fetchIpProcedureCaseSheetByVstId()  vstId{} ", vstId);
        final IpProcedureCaseSheetRowMapper ipProcedureCaseSheetRowMapper = new IpProcedureCaseSheetRowMapper();

        String qry = "SELECT " + ipProcedureCaseSheetRowMapper.tableSchema() + "WHERE vstId = " + vstId;

        log.debug("END of fetchIpProcedureCaseSheetByVstId()");
        return this.jdbcTemplate.query(qry, ipProcedureCaseSheetRowMapper);
    }

    @Override
    public List<AncData> fetchAncCaseSheetByPatId(Long patId) {
        log.debug("START of fetchAncCaseSheetByVstId() patId{} ", patId);
        final AncRowmapper ancRowmapper = new AncRowmapper(false);
        String whereCondition = " WHERE a.patId = " + patId + " and a.isDelivered = 0";
        String qry = " SELECT " + ancRowmapper.schema() + whereCondition;
        final List<AncData> ancData = this.jdbcTemplate.query(qry, ancRowmapper);
//        for (AncData ancDataList : ancData) {
//            final List<AncDetialsData> ancDetialsDataList = fetchAntenatelDetialByVstId(ancDataList.getId());
//            ancDataList.setAncDetialsDataList(ancDetialsDataList);
//            log.debug("END of fetchAncCaseSheetByVstId()");
//        }
        System.out.println("ryu is " + qry);
        for (AncData ancDataList : ancData) {
            final List<AncChildDetialsData> ancChildDetialsData = fetchAncChildDetials(ancDataList.getId());
            ancDataList.setAncChildDetialsDataList(ancChildDetialsData);
            log.debug("END of fetchAncCaseSheetByPatId()");
        }
        return ancData;
    }

    @Override
    public List<AncData> fetchAncCaseSheetByVstId(Long vstId) {
        log.debug("START of fetchAncCaseSheetByVstId() vstId{} ", vstId);
        final AncRowmapper ancRowmapper = new AncRowmapper(true);
        String whereCondition = " WHERE a.vstId = " + vstId;
        String qry = " SELECT " + ancRowmapper.schema() + whereCondition;
        final List<AncData> ancData = this.jdbcTemplate.query(qry, ancRowmapper);
//        for (AncData ancDataList : ancData) {
//            final List<AncDetialsData> ancDetialsDataList = fetchAntenatelDetialByVstId(ancDataList.getId());
//            ancDataList.setAncDetialsDataList(ancDetialsDataList);
//            log.debug("END of fetchAncCaseSheetByVstId()");
//        }
        for (AncData ancDataList : ancData) {
            final List<AncChildDetialsData> ancChildDetialsData = fetchAncChildDetials(ancDataList.getId());
            ancDataList.setAncChildDetialsDataList(ancChildDetialsData);
            log.debug("END of fetchAncCaseSheetByVstId()");
        }
        return ancData;
    }

    public List<AncChildDetialsData> fetchAncChildDetials(Long ancId) {
        log.debug("START of fetchAncChildDetials() vstId{} ", ancId);
        final AncChildDetialsRowmapper ancChildDetialsRowmapper = new AncChildDetialsRowmapper();
        String whereCondition = " WHERE a.anc_id = " + ancId + " AND a.isValid=1";
        //+ " AND a.isValid=1"
        String qry = " SELECT " + ancChildDetialsRowmapper.schema() + whereCondition;
        log.debug("END of fetchAncChildDetials()");
        return this.jdbcTemplate.query(qry, ancChildDetialsRowmapper);

    }

    public List<AncDetialsData> fetchAntenatelDetialByVstId(Long ancId) {
        log.debug("START of fetchAntenatelDetialByVstId() vstId{} ", ancId);
        final AncDetailsRowmapper ancDetailsRowmapper = new AncDetailsRowmapper();
        String whereCondition = " WHERE a.anc_id = " + ancId + " AND a.isValid=1";
        String qry = " SELECT " + ancDetailsRowmapper.schema() + whereCondition;
        log.debug("END of fetchAntenatelDetialByVstId()");
        return this.jdbcTemplate.query(qry, ancDetailsRowmapper);

    }

    public List<AncDetialsData> fetchAncDetialsByVstId(Long vstId) {
        log.debug("START of fetchAncDetialsByVstId() vstId{} ", vstId);
        final AncDetailsRowmapper ancDetailsRowmapper = new AncDetailsRowmapper();
        String whereCondition = " WHERE a.visit_id = " + vstId + " AND a.isValid=1";
        String qry = " SELECT " + ancDetailsRowmapper.schema() + whereCondition;
        log.debug("END of fetchAncDetialsByVstId()");
        return this.jdbcTemplate.query(qry, ancDetailsRowmapper);

    }

    public List<AncDetialsData> fetchPrevAncDetialsByAncId(Long ancId) {
        log.debug("START of fetchPrevAncDetialsByAncId() ancId{} ", ancId);
        final AncDetailsRowmapper ancDetailsRowmapper = new AncDetailsRowmapper();
        String whereCondition = " WHERE a.anc_id = " + ancId + " AND a.isValid=1 order by a.visit_id DESC limit 1";
        String qry = " SELECT " + ancDetailsRowmapper.schema() + whereCondition;
        log.debug("END of fetchPrevAncDetialsByAncId()");
        return this.jdbcTemplate.query(qry, ancDetailsRowmapper);

    }

    @Override
    public List<SurgeryCheckListData> fetchSurgeryChecklistByVatId(Long vstId) {
        log.debug("START of fetchSurgeryChecklistByVatId()  vstId{} ", vstId);
        final SurgeryChecklistRowMapper surgeryChecklistRowMapper = new SurgeryChecklistRowMapper();

        String qry = "SELECT " + surgeryChecklistRowMapper.tableSchema() + " WHERE visitId = " + vstId;

        log.debug("END of fetchSurgeryChecklistByVatId()");
        return this.jdbcTemplate.query(qry, surgeryChecklistRowMapper);
    }

    @Override
    public List<AldreteScoreChartData> fetchAldreteScoreChartByVstId(Long vstId) {
        log.debug("START of fetchAldreteScoreChartByVstId()  vstId{} ", vstId);
        final AldreteScoreChartRowMapper aldreteScoreChartRowMapper = new AldreteScoreChartRowMapper();

        String qry = "SELECT " + aldreteScoreChartRowMapper.tableSchema() + " WHERE visitId = " + vstId;

        log.debug("END of fetchAldreteScoreChartByVstId()");
        return this.jdbcTemplate.query(qry, aldreteScoreChartRowMapper);
    }

    @Override
    public Map<String, Object> fetchDermatologyCaseSheetByVstId(Long vstId) {
        log.debug("START of fetchDermatologyCaseSheetByVstId() vstId{} ", vstId);
        final DermatologyCaseSheetRowMapper dermatologyCaseSheetRowMapper = new DermatologyCaseSheetRowMapper();
        String whereCondition = " WHERE cs.vstId = " + vstId;

        String qry = " SELECT " + dermatologyCaseSheetRowMapper.schema() + whereCondition;

        log.debug("END of fetchDermatologyCaseSheetByVstId()");
        final List<DermatologyCaseSheetData> dermatologyCaseSheetDataList = this.jdbcTemplate.query(qry, dermatologyCaseSheetRowMapper);
        for (DermatologyCaseSheetData dermatologyCaseSheetData : dermatologyCaseSheetDataList) {
            final List<ComplaintDetailsData> complaintDataList = fetchComplaintDetailsByVisitId(dermatologyCaseSheetData.getVstId(), 6L);
            dermatologyCaseSheetData.setComplaintDataList(complaintDataList);
            final List<DiagnosisData> diagnosisDataList = fetchDiagnosisDetailsByVisitId(dermatologyCaseSheetData.getVstId(), 6);
            dermatologyCaseSheetData.setDiagnosisDetailsData(diagnosisDataList);
        }
        Map<String, Object> dermatologyCaseSheetMap = new HashMap<>();
        dermatologyCaseSheetMap.put("status", !dermatologyCaseSheetDataList.isEmpty());
        if (dermatologyCaseSheetDataList.isEmpty()) {
            dermatologyCaseSheetMap.put("message", "No Details Found");
        } else {
            dermatologyCaseSheetMap.put("data", dermatologyCaseSheetDataList);
        }
        return dermatologyCaseSheetMap;
    }

    @Override
    public Map<String, Object> fetchOpthamologyCaseSheetByVstId(Long vstId) {
        log.debug("START of fetchDermatologyCaseSheetByVstId() vstId{} ", vstId);
        final OpthamologyCaseSheetRowMapper opthamologyCaseSheetRowMapper = new OpthamologyCaseSheetRowMapper();
        String whereCondition = " WHERE cs.vstId = " + vstId;

        String qry = " SELECT " + opthamologyCaseSheetRowMapper.schema() + whereCondition;

        log.debug("END of fetchOpthamologyCaseSheetByVstId()");
        final List<OpthamologyCaseSheetData> opthamologyCaseSheetDataList = this.jdbcTemplate.query(qry, opthamologyCaseSheetRowMapper);
        for (OpthamologyCaseSheetData opthamologyCaseSheetData : opthamologyCaseSheetDataList) {
            final List<ComplaintDetailsData> complaintDataList = fetchComplaintDetailsByVisitId(opthamologyCaseSheetData.getVstId(), 8L);
            opthamologyCaseSheetData.setComplaintDataList(complaintDataList);
            final List<DiagnosisData> diagnosisDataList = fetchDiagnosisDetailsByVisitId(opthamologyCaseSheetData.getVstId(), 8);
            opthamologyCaseSheetData.setDiagnosisDetailsData(diagnosisDataList);
        }
        Map<String, Object> opthamologyCaseSheetMap = new HashMap<>();
        opthamologyCaseSheetMap.put("status", !opthamologyCaseSheetDataList.isEmpty());
        if (opthamologyCaseSheetDataList.isEmpty()) {
            opthamologyCaseSheetMap.put("message", "No Details Found");
        } else {
            opthamologyCaseSheetMap.put("data", opthamologyCaseSheetDataList);
        }
        return opthamologyCaseSheetMap;
    }

    @Override
    public Map<String, Object> fetchENTCaseSheetByVstId(Long vstId) {
        log.debug("START of fetchENTCaseSheetByVstId() vstId{} ", vstId);
        final ENTCaseSheetRowMapper entCaseSheetRowMapper = new ENTCaseSheetRowMapper();
        String whereCondition = " WHERE cs.vstId = " + vstId;

        String qry = " SELECT " + entCaseSheetRowMapper.schema() + whereCondition;

        log.debug("END of fetchENTCaseSheetByVstId()");
        final List<ENTCaseSheetData> entCaseSheetDataList = this.jdbcTemplate.query(qry, entCaseSheetRowMapper);
        for (ENTCaseSheetData entCaseSheetData : entCaseSheetDataList) {
            final List<ComplaintDetailsData> complaintDataList = fetchComplaintDetailsByVisitId(entCaseSheetData.getVstId(), 9L);
            entCaseSheetData.setComplaintDataList(complaintDataList);
            final List<DiagnosisData> diagnosisDataList = fetchDiagnosisDetailsByVisitId(entCaseSheetData.getVstId(), 9);
            entCaseSheetData.setDiagnosisDetailsData(diagnosisDataList);
        }
        Map<String, Object> entCaseSheetMap = new HashMap<>();
        entCaseSheetMap.put("status", !entCaseSheetDataList.isEmpty());
        if (entCaseSheetDataList.isEmpty()) {
            entCaseSheetMap.put("message", "No Details Found");
        } else {
            entCaseSheetMap.put("data", entCaseSheetDataList);
        }
        return entCaseSheetMap;
    }

    @Override
    public List<AncDeliveryData> fetchAncDeliveryDetialsByVstId(Long vstId) {
        log.debug("START of fetchAncDeliveryDetialsByVstId() vstId{} ", vstId);
        final AncDeliveryDetialsRowmapper ancDeliveryDetialsRowmapper = new AncDeliveryDetialsRowmapper();
        String whereCondition = " WHERE a.vstId = " + vstId;
        String qry = " SELECT " + ancDeliveryDetialsRowmapper.schema() + whereCondition;
        final List<AncDeliveryData> ancDeliveryData = this.jdbcTemplate.query(qry, ancDeliveryDetialsRowmapper);
        for (AncDeliveryData ancDeliveryDataList : ancDeliveryData) {
            final List<AncDeliveryInductionData> ancDeliveryInductionData = fetchAncInductionByVstId(ancDeliveryDataList.getId());
            ancDeliveryDataList.setAncDeliveryInductionList(ancDeliveryInductionData);
        }
        log.debug("END of fetchAncCaseSheetByVstId()");

        return ancDeliveryData;
    }

    public List<AncDeliveryInductionData> fetchAncInductionByVstId(Long ancId) {
        log.debug("START of fetchAncInductionByVstId() vstId{} ", ancId);
        final AncDeliveryInductionRowmapper ancDeliveryInductionRowmapper = new AncDeliveryInductionRowmapper();
        String whereCondition = " WHERE a.anc_Delivery_id = " + ancId + " AND a.isValid=1";
        //+ " AND a.isValid=1"

        String qry = " SELECT " + ancDeliveryInductionRowmapper.schema() + whereCondition;
        log.debug("END of fetchAncInductionByVstId()");
        return this.jdbcTemplate.query(qry, ancDeliveryInductionRowmapper);

    }

    @Override
    public List<LabTestFieldData> fetchLabTestFields(Long tstId) {
        log.debug("START of fetLabTestFields() tstId{} ", tstId);
        final LabTestFieldsRowMapper labTestFieldsRowMapper = new LabTestFieldsRowMapper();

        String qry = "SELECT " + labTestFieldsRowMapper.tableSchema() + " Where a.fieldid = b.field_id and a.testid = " + tstId;

        log.debug("END of fetchLabTestFields()");
        return this.jdbcTemplate.query(qry, labTestFieldsRowMapper);
    }

    public List<OutsideLabResultData> fetchOutsideLabResultDetailsById(Long id) {
        log.debug("START of fetchOutsideLabResultDetailsById() id {} ", id);
        final OutsideLabRowMapper outsideLabRowMapper = new OutsideLabRowMapper();
        String whereCondition = " WHERE lr.id = '" + id + "' ";
        String qry = "SELECT " + outsideLabRowMapper.tableSchema() + whereCondition;
        log.debug("END of fetchOutsideLabResultDetailsById() id{} ", id);
        return this.jdbcTemplate.query(qry, outsideLabRowMapper);
    }

    public List<OutsideLabData> fetchOutsideLabResultDetailsByVistiId(Long visitId) {
        log.debug("START of fetOutsideLabResultDetailsByVisitId() visitId{} ", visitId);
        final OutsideLabResultRowMapper outsideLabResultRowMapper = new OutsideLabResultRowMapper();
        String whereCondition = " WHERE a.display = b.labDisplay AND b.id = d.labTestDisplay And a.isValid = 1 AND a.vstId = " + visitId + " order by date, c.test_name";
        String qry = "SELECT " + outsideLabResultRowMapper.tableSchema() + whereCondition;
        log.debug("END of fetchOutsideLabResultDetailsByVistiId()");
        return this.jdbcTemplate.query(qry, outsideLabResultRowMapper);
    }

    public List<OutsideLabPrevResultData> fetchOutsideLabPrevResultByVisitId(Long vstId) {
        log.debug("START of fetchOutsideLabPrevResultByVisit() visitId{} ", vstId);
        final OutsideLabPrevResultRowMapper outsideLabPrevResultRowMapper = new OutsideLabPrevResultRowMapper();
        String whereCondition = " WHERE a.vstId = " + vstId + " AND a.type=1 AND a.isValid = 1 ";
        String qry = "SELECT " + outsideLabPrevResultRowMapper.tableSchma() + whereCondition;
        log.debug("END of fetchOutsideLabPrevResultByVisit()");
        return this.jdbcTemplate.query(qry, outsideLabPrevResultRowMapper);
    }

    @Override
    public List<OutsideLabPrevResultDetailsData> fetchOutsideLabPrevResultDetails(Long display) {
        log.debug("START of fetchOutsideLabPrevResultDetails() display{} ", display);
        final OutsideLabPrevResultDetailsRowMapper outsideLabPrevResultDetailsRowMapper = new OutsideLabPrevResultDetailsRowMapper();

        String whereCondition = "WHERE a.`display` = b.`labDisplay` AND b.`id` = c.`labTestDisplay` AND b.`isValid` = 1 AND c.`isValid` = 1 AND a.`display` = ";
        String qry = "SELECT " + outsideLabPrevResultDetailsRowMapper.tableSchema() + whereCondition + display;

        log.debug("END of fetchOutsideLabPrevResultDetails()");
        return this.jdbcTemplate.query(qry, outsideLabPrevResultDetailsRowMapper);
    }

    public List<OutsideLabPrevResultData> fetchOutsideInvPrevResultByVisitId(Long vstId) {
        log.debug("START of fetchOutsideInvPrevResultByVisitId() visitId{} ", vstId);
        final OutsideLabPrevResultRowMapper outsideLabPrevResultRowMapper = new OutsideLabPrevResultRowMapper();
        String whereCondition = " WHERE a.vstId = " + vstId + " AND a.type = 2 AND a.isValid = 1 ";
        String qry = "SELECT " + outsideLabPrevResultRowMapper.tableSchma() + whereCondition;
        log.debug("END of fetchOutsideInvPrevResultByVisitId()");
        return this.jdbcTemplate.query(qry, outsideLabPrevResultRowMapper);
    }

    @Override
    public List<OutsideInvPrevDetailsData> fetchOutsideInvPrevResultDetails(Long display) {
        log.debug("START of fetchOutsideInvPrevResultDetails() display{} ", display);
        final OutsideInvPrevResultDetailsRowMapper outsideInvPrevResultDetailsRowMapper = new OutsideInvPrevResultDetailsRowMapper();

        String whereCondition = " WHERE a.display = b.invDisplay AND b.isValid = 1 AND a.display = ";
        String qry = "SELECT " + outsideInvPrevResultDetailsRowMapper.tableSchema() + whereCondition + display;

        log.debug("END of fetchOutsideInvPrevResultDetails()");
        return this.jdbcTemplate.query(qry, outsideInvPrevResultDetailsRowMapper);
    }

    @Override
    public List<OutsideInvData> fetchAllInvDetailsByVisitId(Long vstId) {
        log.debug("START of fetchAllInvDetilsByVisitId() vstId{} ", vstId);
        final OutsideInvResultRowMapper outsideInvResultRowMapper = new OutsideInvResultRowMapper();

        String whereCondition = " WHERE a.display = b.invDisplay AND a.type = 2 AND a.isValid = 1 AND a.vstId = ";
        String qry = "SELECT " + outsideInvResultRowMapper.tableSchema() + whereCondition + vstId;

        log.debug("END of fetchAllInvDetailsByVisitId()");
        return this.jdbcTemplate.query(qry, outsideInvResultRowMapper);
    }

    public List<OutsideLabData> fetchOutsideLabResultDetailsByPatId(Long patId) {
        log.debug("START of fetchOutsideLabResultDetailsByPatId() visitId{} ", patId);
        final OutsideLabResultRowMapper outsideLabResultRowMapper = new OutsideLabResultRowMapper();
        String whereCondition = " WHERE a.display = b.labDisplay AND b.id = d.labTestDisplay And a.isValid = 1 AND a.patId = " + patId + " order by STR_TO_DATE(DATE_FORMAT(a.selDateTime, '%d-%m-%Y'), '%d-%m-%Y') DESC, c.test_name";
        String qry = "SELECT " + outsideLabResultRowMapper.tableSchema() + whereCondition;
        log.debug("END of fetchOutsideLabResultDetailsByPatId()");
        return this.jdbcTemplate.query(qry, outsideLabResultRowMapper);
    }

    @Override
    public List<OutsideInvData> fetchAllInvDetailsByPatId(Long patId) {
        log.debug("START of fetchAllInvDetailsByPatId() vstId{} ", patId);
        final OutsideInvResultRowMapper outsideInvResultRowMapper = new OutsideInvResultRowMapper();

        String whereCondition = " WHERE a.display = b.invDisplay AND a.type = 2 AND a.isValid = 1 AND a.patId = ";
        String qry = "SELECT " + outsideInvResultRowMapper.tableSchema() + whereCondition + patId;
        log.debug("END of fetchAllInvDetailsByPatId()");
        return this.jdbcTemplate.query(qry, outsideInvResultRowMapper);
    }

    @Override
    public ResponseEntity<byte[]> getImageById(Long id) {
        Optional<InvImgUpload> findImg = imgInvRepository.findById(id);

        if (findImg.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .header("message", "Image Path Not Found")
                    .body(new byte[0]);
        }

        InvImgUpload image = findImg.get();
        if (image.getImgName() == null || image.getImgName().trim().isEmpty()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .header("message", "Image Path Is Empty or Null")
                    .body(new byte[0]);
        }
        String filePath = uploadDir + File.separator + image.getImgName();

        try {
            File imgFile = new File(filePath);

            if (!imgFile.exists()) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .header("message", "Image not Found")
                        .body(new byte[0]);
            }
            byte[] imageBytes = Files.readAllBytes(imgFile.toPath());
            String contentType = Files.probeContentType(imgFile.toPath());

            return ResponseEntity.ok()
                    .header("Content-Disposition", "inline; filename=\"" + imgFile.getName() + "\"")
                    .contentType(MediaType.parseMediaType(contentType != null ? contentType : "application/octet-stream"))
                    .body(imageBytes);
        } catch (IOException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new byte[0]);
        }
    }

    public List<ImgInvData> fetchPatientInvImageDetailsByVstId(String vstId) {
        log.debug("START of fetchPatientInvImageDetailsByVstId() id{} ", vstId);
        final ImgInvRowMapper imgInvRowMapper = new ImgInvRowMapper();
        String qry = "SELECT " + imgInvRowMapper.schema() + "WHERE x.is_blocked = 0 and x.visit_id =" + vstId + " order by x.id desc";
        log.debug("END of fetchPatientInvImageDetailsByVstId()");
        return this.jdbcTemplate.query(qry, imgInvRowMapper);
    }

    public List<ImgInvData> fetchPatientInvImageDetailsByPatId(String patId) {
        log.debug("START of fetchPatientInvImageDetailsByPatId() id{} ", patId);
        final ImgInvRowMapper imgInvRowMapper = new ImgInvRowMapper();
        String qry = "SELECT " + imgInvRowMapper.schema() + "WHERE x.is_blocked = 0 and x.pat_id =" + patId + " order by x.id desc";
        log.debug("END of fetchPatientInvImageDetailsByPatId()");
        return this.jdbcTemplate.query(qry, imgInvRowMapper);
    }

    public List<Map<String, Object>> fetchUploadePdf(Long patId) {
        String qry = " " +
                " SELECT u.original_file_name AS originalFileName, u.stored_file_name AS storedFileName, u.path, ac.name AS invName, u.visit_id AS visitId, " +
                "   DATE_FORMAT(v.date, '%d-%m-%Y') AS visitedDate, " +
                "   DATE_FORMAT(u.createdAt, '%d-%m-%Y') AS createdDate, DATE_FORMAT(u.createdAt, '%h:%i %p') AS createdTime " +
                " FROM cli_patient_pdf_upload u " +
                "   LEFT JOIN cash_config_head ac ON ac.id = u.inv_id " +
                "   LEFT JOIN rec_patient_opvisits v ON v.id = u.visit_id " +
                " WHERE u.pat_id = ? AND u.status = 1 ;";

        List<Object> params = new ArrayList<>();
        params.add(patId);
        return this.jdbcTemplate.queryForList(qry, params.toArray());
    }

    @Override
    public List<AppointmentData> fetchPatientAppointmentByVstId(Long vstId, Long Type) {

        log.debug("START of fetchPatientAppointmentByVstId() vstId{} Type{}", vstId, Type);

        final AppointmentRowMapper appointmentRowMapper = new AppointmentRowMapper();
        String whereCondition = "where  a.vstId = " + vstId + " AND a.caseSheetType = " + Type + " and a.isValid = 1";
        String qry = "SELECT " + appointmentRowMapper.schema() + whereCondition;
        log.debug("END of fetchPatientAppointmentByVstId()");
        return this.jdbcTemplate.query(qry, appointmentRowMapper);
    }

    @Override
    public List<AppointmentRegisterData> fetchPatientAppointmentRegister() {

        log.debug("START of fetchPatientAppointment Register");

        final AppointmentRegisterRowMapper appointmentRegisterRowMapper = new AppointmentRegisterRowMapper();
        String whereCondition = " WHERE a.appDate = CURDATE()  AND a.isValid = 1 ORDER BY b.id DESC;";
        String qry = "SELECT " + appointmentRegisterRowMapper.schema() + whereCondition;
        log.debug("END of fetchPatientAppointment");
        return this.jdbcTemplate.query(qry, appointmentRegisterRowMapper);
    }

    public List<Map<String, Object>> fetchOpVitalsHeightByPatId(Long patId) {
        String qry = " SELECT height FROM cli_patient_vital_details  WHERE patId = ? ORDER BY id DESC LIMIT 1 ";

        return this.jdbcTemplate.queryForList(qry, patId);
    }

    public List<Map<String,Object>> fetchLabResultsByPatientId (Long patId){
        String qry = " " +
                "SELECT DATE_FORMAT(b.ent_date,'%d-%m-%Y') AS visitDate,c.spec_name AS specName,b.test_name AS testName, e.value,f.unit,f.fieldname AS fieldName,i.normalpat_id,b.dept_autoid," +
                "       e.field_id AS fieldId, a.visit_id\n" +
                "FROM cash_final_bill a, lab_test_reg b, lab_config_master_specimen c, lab_reg_test_value d,\n" +
                "       lab_test_value e, lab_config_master_test_fld f,lab_reg_dept_regno h,lab_reg_maj_regno i\n" +
                "WHERE a.id=b.final_bill_id AND b.spec_id=c.spec_code AND b.id=d.testreg_id AND d.testval_id=e.testval_id AND e.field_id=f.fieldid AND\n" +
                "        b.dept_autoid=h.dept_autoid AND h.maj_id=i.maj_id AND b.isverified=1 AND a.is_cancelled=0 AND a.pat_id = ?\n" +
                " GROUP BY  i.normalpat_id, b.dept_autoid, e.field_id ORDER BY b.ent_date , b.test_name";
        List<Object> params = new ArrayList<>();
        params.add(patId);
        return this.jdbcTemplate.queryForList(qry, params.toArray());
    }

    @Override
    public String fetchGeneralInstructionByPrescId(Long prescId) {
        String qry = "SELECT notes FROM ph_prescription WHERE id = ? ";
        try {
            return this.jdbcTemplate.queryForObject(qry, String.class, prescId);
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }


    @Override
    public List<DoctorTransferData> fetchDoctorTransfer(Long visitId) {

        log.debug("START of fetching Doctor Transfer ");

        final DoctorTransferRowMapper doctorTransferRowMapper = new DoctorTransferRowMapper();
        String whereCondition = " WHERE a.is_cancelled = 0 AND a.vst_id = " + visitId + " order by a.id desc ";
        String qry = "SELECT " + doctorTransferRowMapper.schema() + whereCondition;
        System.out.println("det " + qry);
        log.debug("END of fetching Doctor Transfer");
        return this.jdbcTemplate.query(qry, doctorTransferRowMapper);
    }

    @Override
    public List<DocPatientListData> fetchDocPatientList(Long toDoc) {
        log.debug("START of fetchDocPatientList() toDoc{} ", toDoc);
        final DocPatientListRowMapper docPatientListRowMapper = new DocPatientListRowMapper();
        String whereCondition = " WHERE c.to_doc = ? AND c.is_cancelled = 0 AND DATE(b.date) = CURDATE()";
        String qry = "SELECT " + docPatientListRowMapper.schema() + whereCondition;
        log.debug("END of fetchDocPatientList()");
        return this.jdbcTemplate.query(qry, docPatientListRowMapper, toDoc);
    }

    @Override
    public List<DocPatientListData> fetchDocPatientListByDate(Long toDoc, String date) {
        log.debug("START of fetchDocPatientListByDate() toDoc{} date{} ", toDoc, date);
        final DocPatientListRowMapper docPatientListRowMapper = new DocPatientListRowMapper();
        String qry = "SELECT a.display_number AS displayNumber, " +
                "a.name AS patientName, " +
                "c.ent_dateTime AS entDateTime, " +
                "td.name AS doctorName, " +
                "fd.name AS referDoctor, " +
                "d.phone AS contactNumber, " +
                "TIMESTAMPDIFF(YEAR, d.dob, CURDATE()) AS age, " +
                "CASE c.is_completed " +
                    "WHEN 0 THEN 'Pending' " +
                    "WHEN 1 THEN 'In Progress' " +
                    "WHEN 2 THEN 'Completed' " +
                    "ELSE 'Unknown' END AS status " +
                "FROM rec_doctor_transfer c " +
                "INNER JOIN rec_patient_opvisits b ON c.vst_id = b.id " +
                "INNER JOIN rec_patient a ON b.pat_id = a.id " +
                "INNER JOIN rec_config_msc_consultants td ON c.to_doc = td.id " +
                "LEFT JOIN rec_config_msc_consultants fd ON c.from_doc = fd.id " +
                "INNER JOIN rec_patient_details d ON a.id = d.pat_id " +
                "WHERE c.to_doc = ? AND c.is_cancelled = 0 AND DATE(b.date) = ?";
        log.debug("END of fetchDocPatientListByDate()");
        return this.jdbcTemplate.query(qry, docPatientListRowMapper, toDoc, date);
    }

    @Override
    public DoctorScheduleStatusData fetchDocStatus(Long doctorId) {
        log.debug("START of fetchDocStatus() doctorId{}", doctorId);

        String consultantQry = "SELECT is_cons FROM rec_config_msc_consultants WHERE id = ?";
        List<Map<String, Object>> consultant = this.jdbcTemplate.queryForList(consultantQry, doctorId);
        if (consultant.isEmpty()) {
            throw new com.ueniweb.swiftwaresolutions.infrastructure.exceptions.NoRecordFoundException("Doctor not found");
        }
        if (((Number) consultant.get(0).get("is_cons")).intValue() != 1) {
            log.debug("fetchDocStatus skipped for temporary doctorId={}", doctorId);
            return DoctorScheduleStatusData.newInstance(null, doctorId, "AVAILABLE", LocalDate.now().toString());
        }

        String qry = "SELECT id, doctor_id AS doctorId, status, attendance_date AS attendanceDate " +
                     "FROM doctor_daily_schedule " +
                     "WHERE doctor_id = ? " +
                     "AND DATE(attendance_date) = CURDATE() " +
                     "ORDER BY id DESC LIMIT 1";
        try {
            DoctorScheduleStatusData result = this.jdbcTemplate.queryForObject(qry, (rs, rowNum) ->
                    DoctorScheduleStatusData.newInstance(
                            rs.getLong("id"),
                            rs.getLong("doctorId"),
                            rs.getString("status"),
                            rs.getString("attendanceDate")
                    ), doctorId);
            log.debug("END of fetchDocStatus() doctorId{}", doctorId);
            return result;
        } catch (EmptyResultDataAccessException e) {
            throw new com.ueniweb.swiftwaresolutions.infrastructure.exceptions.NoRecordFoundException(
                    "PLEASE CHECK IN");
        }
    }
}
