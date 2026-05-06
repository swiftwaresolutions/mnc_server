package com.ueniweb.swiftwaresolutions.repository;

import com.ueniweb.swiftwaresolutions.domain.PediatricCaseSheet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PediatricCaseSheetRepository  extends JpaRepository<PediatricCaseSheet, Long> {

   // Optional<PediatricCaseSheet> findByPatientId(Long patId);
}
