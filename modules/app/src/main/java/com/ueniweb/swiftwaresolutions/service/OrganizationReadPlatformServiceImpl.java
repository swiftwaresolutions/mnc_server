package com.ueniweb.swiftwaresolutions.service;


import com.ueniweb.swiftwaresolutions.data.ClinicalModData;
import com.ueniweb.swiftwaresolutions.data.OrganizationData;

import com.ueniweb.swiftwaresolutions.rowmapper.ClinicalModRowmapper;
import com.ueniweb.swiftwaresolutions.rowmapper.OrganizationRowMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j

public class OrganizationReadPlatformServiceImpl implements OrganizationReadPlatformService {

    private final JdbcTemplate jdbcTemplate;
    @Override

    public OrganizationData fetchOrganizationDetails(){
        try {
            log.debug("START of fetchOrganizationDetails() ");
            final OrganizationRowMapper organizationRowMapper = new OrganizationRowMapper();

            String   qry = "SELECT name,code,port,salesStoreId FROM `acc_config_organisation`";

            log.debug("END of fetchOrganizationDetails()");
            return this.jdbcTemplate.queryForObject(qry, organizationRowMapper);

        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public List<ClinicalModData> fetchClinicalModuleDetails(){
        try {
            log.debug("START of fetchClinicalModuleDetails() ");
            final ClinicalModRowmapper clinicalModRowmapper = new ClinicalModRowmapper();

            String   qry = "SELECT a.group,a.menuName,a.dispName,a.menuCode FROM `admin_config_cli_modules` a WHERE a.isActive=1";

            log.debug("END of fetchClinicalModuleDetails()");
            return this.jdbcTemplate.query(qry, clinicalModRowmapper);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
