package com.ueniweb.swiftwaresolutions.repository;

import com.ueniweb.swiftwaresolutions.domain.OpthamologyDiagnosisDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface OpthamologyDiagnosisDetailsRepository extends JpaRepository<OpthamologyDiagnosisDetails,Long> {

    @Query("select d from OpthamologyDiagnosisDetails d where d.caseSheetId.id=:caseSheetId")
    List<OpthamologyDiagnosisDetails> fetchOpthamologyDiagnosisDetailsBycaseSheetId(@Param("caseSheetId") Long caseSheetId);
}
