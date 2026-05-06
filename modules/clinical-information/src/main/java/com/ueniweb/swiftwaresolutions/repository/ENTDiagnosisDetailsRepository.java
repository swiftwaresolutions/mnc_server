package com.ueniweb.swiftwaresolutions.repository;

import com.ueniweb.swiftwaresolutions.domain.ENTDiagnosisDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ENTDiagnosisDetailsRepository extends JpaRepository<ENTDiagnosisDetails,Long> {

    @Query("select d from ENTDiagnosisDetails d where d.caseSheetId.id=:caseSheetId")
    List<ENTDiagnosisDetails> fetchENTDiagnosisDetailsBycaseSheetId(@Param("caseSheetId") Long caseSheetId);
}
