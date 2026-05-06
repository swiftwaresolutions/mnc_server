package com.ueniweb.swiftwaresolutions.repository;

import com.ueniweb.swiftwaresolutions.domain.DentalCaseSheet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DentalCaseSheetRepository extends JpaRepository<DentalCaseSheet, Long> {
    //Optional<DentalCaseSheet> findByPatientId(Long patientId);
}
