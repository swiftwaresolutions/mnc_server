package com.ueniweb.swiftwaresolutions.repository;

import com.ueniweb.swiftwaresolutions.domain.DiagnosisDetailsSummary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface DiagnosisDetailsSummaryRepository extends JpaRepository<DiagnosisDetailsSummary,Long> {

    @Query("select a from DiagnosisDetailsSummary a where a.summaryId.id =:summaryId")
    List<DiagnosisDetailsSummary> fetchDiagnosisDetailsBySumId(@Param("summaryId") Long summaryId);


}
