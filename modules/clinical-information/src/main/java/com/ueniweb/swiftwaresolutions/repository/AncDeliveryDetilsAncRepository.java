package com.ueniweb.swiftwaresolutions.repository;

import com.ueniweb.swiftwaresolutions.data.AncData;
import com.ueniweb.swiftwaresolutions.domain.AncDeliverySheet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AncDeliveryDetilsAncRepository   extends JpaRepository<AncDeliverySheet, Long> {
        @Query("SELECT xy FROM AncCaseSheet xy WHERE xy.patId = :patId")
        List<AncData> fetchAncDeliveryDischarged(@Param("patId") Long patId);
}
