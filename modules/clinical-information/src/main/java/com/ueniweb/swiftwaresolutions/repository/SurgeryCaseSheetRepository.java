package com.ueniweb.swiftwaresolutions.repository;

import com.ueniweb.swiftwaresolutions.domain.SurgeryCaseSheet;
import com.ueniweb.swiftwaresolutions.domain.SurgeryNurse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SurgeryCaseSheetRepository extends  JpaRepository<SurgeryCaseSheet, Long> {
//    @Query("select d from cli_ot_nurse d where d.surId.id=:surId")
//    List<SurgeryNurse> fetchSurgeryNurseBycaseSheetId(@Param("surId") Long surId);
}
