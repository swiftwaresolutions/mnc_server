package com.ueniweb.swiftwaresolutions.services;

import com.ueniweb.swiftwaresolutions.data.*;
import com.ueniweb.swiftwaresolutions.rowmapper.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
@RequiredArgsConstructor
@Slf4j

public class ProductDetailsReadPlatformServiceImpl implements ProductDetailsReadPlatformService{

    private final JdbcTemplate jdbcTemplate;
        @Override
        public List<MedicineNameData> fetchMedicineNames(String medName,Integer storeId) {
            log.debug("START of fetchMedicineNames() medName{} ", medName);
            final ProductRowMapper productRowMapper = new ProductRowMapper();

            String qry = "SELECT "+ productRowMapper.tableSchema()+ " WHERE a.isactive=1 and a.ph_mod_id= 1 and  a.NAME  LIKE ?";

            System.out.println("Med name is " + qry);
//            String countQry = "SELECT count(*)"+ productRowMapper.schema();
            log.debug("END of fetchMedicineNames()");
            return this.jdbcTemplate.query(qry, new Object[]{ storeId, "%" + medName + "%" } ,productRowMapper);
        }

    @Override
    public List<CaseSheetTemplateData> fetchCaseSheetTemplates(Integer casesheetType, Integer templateFieldId, Long docId) {
        log.debug("START of fetchCaseSheetTemplates() casesheetType={} templateFieldId={}", casesheetType, templateFieldId);

        StringBuilder qry = new StringBuilder("SELECT id, templateName, templateDetails FROM cli_patient_casesheet_templates WHERE casesheetType = ? AND templateFieldId = ? AND isValid = 1");

        List<Object> params = new ArrayList<>();
        params.add(casesheetType);
        params.add(templateFieldId);

        if (docId != null && docId != 0L) {
            qry.append(" AND docId = ?");
            params.add(docId);
        }

        log.debug("Query: {}", qry);
        log.debug("END of fetchCaseSheetTemplates()");

        return this.jdbcTemplate.query(qry.toString(), new CaseSheetTemplateRowMapper(), params.toArray());
    }


    @Override
    public List<StoreWiseAvailableStockData> fetchStoreWiseAvailableStock(Integer prodsId) {
        log.debug("START of fetchStoreWiseAvailableStock() prodsId{} ", prodsId);
        final StoreWiseAvailableStockRowMapper storeWiseAvailableStockRowMapper = new StoreWiseAvailableStockRowMapper();

//        String qry = "SELECT "+ storeWiseAvailableStockRowMapper.tableSchema()+ " WHERE a1.id = a4.store_id AND a2.id = a3.prods_id AND a3.id = a4.batch_id AND a2.id = "+prodsId+" AND a4.store_id = 6 GROUP BY a1.id) a5 WHERE a5.availableStock > 0";
        String qry = "SELECT "+ storeWiseAvailableStockRowMapper.tableSchema()+ " WHERE a2.id = "+prodsId+" AND a1.id IN (6,1) GROUP BY a1.id) a5 WHERE a5.availableStock > 0 ORDER BY FIELD(a5.storeId, 6,1) LIMIT 1";
        System.out.println(" stock is : " + qry);

//        String countQry = "SELECT count(*)"+ storeWiseAvailableStockRowMapper.schema();
        log.debug("END of fetchStoreWiseAvailableStock()");
        return this.jdbcTemplate.query(qry,storeWiseAvailableStockRowMapper);
    }

    @Override
    public List<ProdsUnitData> fetchMedicineUnitsById(Integer prodsId) {
        log.debug("START of fetchMedicineUnitsById() prodsId{}",prodsId);
        final ProdsUnitRowMapper prodsUnitRowMapper = new ProdsUnitRowMapper();

        String qry = " SELECT b.name as units FROM ph_prods a,ph_prods_unit b WHERE a.units_id=b.id AND a.id="+prodsId +
                      " UNION"+
                      " SELECT b.name AS units FROM ph_prods a,ph_prods_units b WHERE a.tot_unit_id=b.id AND a.id="+prodsId;

        log.debug("END of fetchMedicineUnitsById()");
        return this.jdbcTemplate.query(qry,prodsUnitRowMapper);

    }
    @Override
    public List<EqualantDrugsData> fetchEqualentDrugsByGenericId(Integer genericId) {
        log.debug("START of fetchEqualentDrugsByGenericId() genericId{}",genericId);
        final EqualantDrugsRowMapper equalantDrugsRowMapper = new EqualantDrugsRowMapper();

        String qry = " SELECT a2.id,a2.name as drugsName FROM ph_generic a1, ph_prods a2 WHERE a1.id = a2.generic_id AND a2.isactive = 1 AND a1.id ="+genericId ;

        log.debug("END of fetchEqualentDrugsByGenericId()");
        return this.jdbcTemplate.query(qry,equalantDrugsRowMapper);

    }

}

