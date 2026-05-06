package com.ueniweb.swiftwaresolutions.repository;


import com.ueniweb.swiftwaresolutions.domain.SurgerySurgon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SurgerySurgonRepository extends JpaRepository<SurgerySurgon, Long> {
    @Query("select d from SurgerySurgon d where d.surId.id=:surId")
    List<SurgerySurgon> fetchSurgerySurgonBycaseSheetId(@Param("surId") Long surId);
}
