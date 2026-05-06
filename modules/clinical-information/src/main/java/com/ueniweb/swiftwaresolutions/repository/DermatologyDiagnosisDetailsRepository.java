package com.ueniweb.swiftwaresolutions.repository;

import com.ueniweb.swiftwaresolutions.domain.DermatologyDiagnosisDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface DermatologyDiagnosisDetailsRepository extends JpaRepository<DermatologyDiagnosisDetails,Long> {

    @Query("select d from DermatologyDiagnosisDetails d where d.caseSheetId.id=:caseSheetId")
    List<DermatologyDiagnosisDetails> fetchDermatologyDiagnosisDetailsBycaseSheetId(@Param("caseSheetId") Long caseSheetId);
}
