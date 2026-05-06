package com.ueniweb.swiftwaresolutions.repository;

import com.ueniweb.swiftwaresolutions.domain.DiagnosisDetailsSummary;
import com.ueniweb.swiftwaresolutions.domain.LabAndInvestigationSummary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface LabAndInvSummaryRepository extends JpaRepository<LabAndInvestigationSummary,Long> {

    @Query("select a from LabAndInvestigationSummary a where a.summaryId.id =:summaryId")
    List<LabAndInvestigationSummary> fetchLabAndInvBySumId(@Param("summaryId") Long summaryId);


}
