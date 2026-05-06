package com.ueniweb.swiftwaresolutions.repository;

import com.ueniweb.swiftwaresolutions.domain.Patient;
import com.ueniweb.swiftwaresolutions.domain.PatientOpVisit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {
    @Query("SELECT pv from RecPatient pv WHERE pv.displayNumber = :patientDisplayNumber ORDER BY pv.id DESC")
    Patient findPatientOpVisitByPatientDisplayNumber(@Param("patientDisplayNumber") String patientDisplayNumber);

}
