package com.ueniweb.swiftwaresolutions.repository;

import com.ueniweb.swiftwaresolutions.domain.SurgeryName;
import com.ueniweb.swiftwaresolutions.domain.SurgerySurgon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SurgeryNAmeRepository extends JpaRepository<SurgeryName, Long> {
    @Query("select d from SurgeryName d where d.surId.id=:surId")
    List<SurgeryName> fetchSurgeryNameBycaseSheetId(@Param("surId") Long surId);
}
