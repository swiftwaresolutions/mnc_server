package com.ueniweb.swiftwaresolutions.repository;

import com.ueniweb.swiftwaresolutions.domain.GeneralCaseSheet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface GeneralCaseSheetRepository extends JpaRepository<GeneralCaseSheet, Long> {
    Optional<GeneralCaseSheet> findByPatientId(Long patientId);
    @Query("select g from #{#entityName} g where g.visitId = :visitId")
    GeneralCaseSheet findByVisitId(@Param("visitId")Long visitId);
}
