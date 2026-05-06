package com.ueniweb.swiftwaresolutions.repository;

import com.ueniweb.swiftwaresolutions.domain.PrescDiscount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface PrescriptionDiscountRepository extends JpaRepository<PrescDiscount,Long> {

    @Query("SELECT l from PrescDiscount l WHERE l.presciptionId = :presId")
    Optional<PrescDiscount> findPrescriptionDiscBypresId(@Param("presId") Long presId);
}
