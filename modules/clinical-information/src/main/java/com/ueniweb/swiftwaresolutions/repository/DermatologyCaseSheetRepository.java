package com.ueniweb.swiftwaresolutions.repository;

import com.ueniweb.swiftwaresolutions.domain.DermatologyCaseSheet;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DermatologyCaseSheetRepository extends JpaRepository<DermatologyCaseSheet,Long> {

    Optional<DermatologyCaseSheet> findByPatientId(Long patientId);
}
