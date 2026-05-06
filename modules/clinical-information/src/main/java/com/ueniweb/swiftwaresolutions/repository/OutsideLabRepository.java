package com.ueniweb.swiftwaresolutions.repository;

import com.ueniweb.swiftwaresolutions.domain.OutsideLab;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface OutsideLabRepository extends JpaRepository<OutsideLab, Long> {
    @Query("SELECT max(a.id) from OutsideLab a where a.patId = :patId")
    String getlabResDisplay(@Param("patId") Long patId);
}
