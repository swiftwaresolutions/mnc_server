package com.ueniweb.swiftwaresolutions.service;


import com.ueniweb.swiftwaresolutions.data.ConsultantDetailsData;
import com.ueniweb.swiftwaresolutions.data.DepartmentData;
import com.ueniweb.swiftwaresolutions.domain.Department;
import com.ueniweb.swiftwaresolutions.repository.DepartmentRepository;
import com.ueniweb.swiftwaresolutions.rowmapper.FetchConsultantRowMapper;
import com.ueniweb.swiftwaresolutions.rowmapper.FetchDepartmentRowMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class DepartmentReadPlatformServiceImpl implements DepartmentReadPlatformService {

    private final DepartmentRepository departmentRepository;

    private final JdbcTemplate jdbcTemplate;
    @Override
    public List<Department> fetchAllDepartments() {
        return this.departmentRepository.findAll();
    }
    public List<DepartmentData> fetchDepartmentName(String deptName){
        try {
            //log.debug("START of fetchCaseSheetTemplates() ");
            final FetchDepartmentRowMapper deptRowMapper = new FetchDepartmentRowMapper();

            String qry = "";

            if(deptName.equals("0")) {
                 qry = "SELECT dept.name AS depName,dept.id AS id from rec_config_msc_departments dept where is_active=1";
            }
            else {
                 qry = "SELECT dept.name AS depName,dept.id AS id from rec_config_msc_departments dept where is_active=1 AND dept.name like " + "'%" + deptName + "%'";
            }

            //log.debug("END of fetchCaseSheetTemplates()");
            return this.jdbcTemplate.query(qry, deptRowMapper);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public List<ConsultantDetailsData> fetchConsultantDetails() {

        log.debug("START of fetchConsultantDetails()");

        final FetchConsultantRowMapper consultantRowMapper = new FetchConsultantRowMapper();

        String qry =
                "SELECT " + consultantRowMapper.schema() +
                        " WHERE a.is_active = 1 " +
                        " ORDER BY a.name";
        System.out.println(" cons " + qry);
        String countQry =
                "SELECT count(*)" + consultantRowMapper.tableSchema();

        log.debug("END of fetchConsultantDetails()");

        return this.jdbcTemplate.query(qry, consultantRowMapper);
    }

}
