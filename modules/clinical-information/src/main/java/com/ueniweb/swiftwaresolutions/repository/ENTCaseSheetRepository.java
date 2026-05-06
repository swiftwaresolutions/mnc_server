package com.ueniweb.swiftwaresolutions.repository;

import com.ueniweb.swiftwaresolutions.domain.ENTCaseSheet;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ENTCaseSheetRepository extends JpaRepository<ENTCaseSheet,Long> {

    Optional<ENTCaseSheet> findByPatientId(Long patientId);
}
