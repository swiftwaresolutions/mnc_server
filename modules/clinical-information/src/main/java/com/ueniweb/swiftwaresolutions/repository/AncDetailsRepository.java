package com.ueniweb.swiftwaresolutions.repository;

import com.ueniweb.swiftwaresolutions.domain.AncDetailsSheet;
import com.ueniweb.swiftwaresolutions.domain.AntenatalCaseSheetPrevious;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AncDetailsRepository extends JpaRepository<AncDetailsSheet, Long> {
    @Query("SELECT xy FROM AncDetailsSheet xy WHERE xy.visit_id = :visit_id")
    List<AncDetailsSheet> fetchAncDetials(@Param("visit_id") Long vstId);
}
