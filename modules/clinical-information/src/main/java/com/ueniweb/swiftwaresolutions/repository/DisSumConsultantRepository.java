package com.ueniweb.swiftwaresolutions.repository;


import com.ueniweb.swiftwaresolutions.domain.DischargeSummaryConsultant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface DisSumConsultantRepository  extends JpaRepository<DischargeSummaryConsultant, Long> {

    @Query("select a from DischargeSummaryConsultant a where a.summaryId.id =:summaryId")
    List<DischargeSummaryConsultant> fetchConsultantDetailsBySumId(@Param("summaryId") Long summaryId);

}
