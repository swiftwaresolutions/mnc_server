package com.ueniweb.swiftwaresolutions.repository;

import com.ueniweb.swiftwaresolutions.domain.OutsideInv;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface OutsideInvRepository extends JpaRepository<OutsideInv,Long> {

    @Query("SELECT max(a.id) from OutsideInv a where a.patId = :patId")
    String getInvDisplay(@Param("patId") Long patId);
}
