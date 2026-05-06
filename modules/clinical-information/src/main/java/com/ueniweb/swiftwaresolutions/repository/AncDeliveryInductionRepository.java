package com.ueniweb.swiftwaresolutions.repository;


import com.ueniweb.swiftwaresolutions.domain.AncDeliveryInduction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AncDeliveryInductionRepository   extends JpaRepository<AncDeliveryInduction, Long> {
    @Query("SELECT xy FROM AncDeliveryInduction xy WHERE xy.anc_Delivery_id.id = :anc_Delivery_id")
    List<AncDeliveryInduction> fetchAncDeliveryInductionDetials(@Param("anc_Delivery_id") Long id);


}

