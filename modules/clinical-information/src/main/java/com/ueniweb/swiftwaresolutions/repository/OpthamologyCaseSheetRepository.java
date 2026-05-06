package com.ueniweb.swiftwaresolutions.repository;

import com.ueniweb.swiftwaresolutions.domain.OpthamologyCaseSheet;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface OpthamologyCaseSheetRepository extends JpaRepository<OpthamologyCaseSheet,Long> {

    Optional<OpthamologyCaseSheet> findByPatientId(Long patientId);
}
