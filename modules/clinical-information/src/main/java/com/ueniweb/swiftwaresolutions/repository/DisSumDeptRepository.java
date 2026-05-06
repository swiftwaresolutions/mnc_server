package com.ueniweb.swiftwaresolutions.repository;

import com.ueniweb.swiftwaresolutions.domain.DischargeSummaryConsultant;
import com.ueniweb.swiftwaresolutions.domain.DischargeSummaryDept;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface DisSumDeptRepository extends JpaRepository<DischargeSummaryDept,Long> {

    @Query("select a from DischargeSummaryDept a where a.summaryId.id =:summaryId")
    List<DischargeSummaryDept> fetchDeptDetailsBySumId(@Param("summaryId") Long summaryId);

}
