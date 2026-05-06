package com.ueniweb.swiftwaresolutions.repository;

import com.ueniweb.swiftwaresolutions.domain.DiagnosisDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface DiagnosisDetailsRepository extends JpaRepository<DiagnosisDetails, Long>  {
    @Query("select d from DiagnosisDetails d where d.caseSheetId.id=:caseSheetId")
    List<DiagnosisDetails> fetchDiagnosisDetailsBycaseSheetId(@Param("caseSheetId") Long caseSheetId);


}
