package com.ueniweb.swiftwaresolutions.repository;

import com.ueniweb.swiftwaresolutions.domain.DiagnosisDetailsSummary;
import com.ueniweb.swiftwaresolutions.domain.DischargeSummary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface DischargeSummaryRepository extends JpaRepository<DischargeSummary,Long> {


}

