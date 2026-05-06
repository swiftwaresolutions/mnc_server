package com.ueniweb.swiftwaresolutions.service;

import com.ueniweb.swiftwaresolutions.data.PatientVisitData;
import com.ueniweb.swiftwaresolutions.data.PrePatientData;
import com.ueniweb.swiftwaresolutions.domain.*;
import com.ueniweb.swiftwaresolutions.repository.PatientRepository;
import com.ueniweb.swiftwaresolutions.rowmapper.PrePatientRowMapper;
import com.ueniweb.swiftwaresolutions.rowmapper.VisitDetailsRowMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j

public class PatientVisitReadPlatformServiceImpl implements PatientVisitReadPlatformService {

    private final JdbcTemplate jdbcTemplate;

    private final PatientRepository patientRepository;

    @Override
    public List<PatientVisitData> fetchPatientVisitDetailsByPatientId(Long patientId) {
        try {
            VisitDetailsRowMapper visitDetailsRowMapper = new VisitDetailsRowMapper();
            String qry = "SELECT "+ visitDetailsRowMapper.schema()+" WHERE a.pat_id = "+patientId +" AND a.date > \"2026-01-31\" ORDER BY a.id DESC";
            System.out.println("pat "+ qry);
            return this.jdbcTemplate.query(qry,visitDetailsRowMapper);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }
    @Override
    public List<PatientVisitData> fetchPatientVisitDetailsByPatientDisplayNumber(String patientDisplayNumber) {
        try {
            final Patient patient = this.patientRepository.findPatientOpVisitByPatientDisplayNumber(patientDisplayNumber);
            return this.fetchPatientVisitDetailsByPatientId(patient.getId());
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }
    @Override
    public List<PrePatientData> fetchPrePatientDetialsByVstId(Long vstId) {
        log.debug("START of fetchPrePatientDetialsByVstId()  vstId{} ", vstId);
        final PrePatientRowMapper prePatientRowMapper = new PrePatientRowMapper();
        String qry = "SELECT " + prePatientRowMapper.tableSchema() + "WHERE a.pat_id = b.`pat_id` AND d.id=b.pat_id AND a.id ="+vstId;
        System.out.print("patientDetail"+qry);
        log.debug("END of fetchPrePatientDetialsByVstId()");
        return this.jdbcTemplate.query(qry, prePatientRowMapper);
    }

    @Override
    public int fetchPatientIdByOpNo(Long opNo) {
        try {
            log.debug("START of fetchPatientIdByOpNo() opNo{} ", opNo);
            String qry = " SELECT id FROM rec_patient WHERE display_number = ?";

            List<Integer> results = jdbcTemplate.query(qry, new Object[]{opNo},
                    (rs, rowNum) -> rs.getInt("id"));

            log.debug("END of fetchPatientIdByOpNo() ");
            return results.isEmpty() ? -1 : results.get(0);
        }
        catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

}
