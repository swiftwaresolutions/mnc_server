package com.ueniweb.swiftwaresolutions.repository;

import com.ueniweb.swiftwaresolutions.domain.OrderDiscount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface OrderDiscountRepository extends JpaRepository<OrderDiscount,Long> {

    @Query("SELECT l from OrderDiscount l WHERE l.patId = :patientId")
    Optional<OrderDiscount> findOrderDiscByPatientId(@Param("patientId") Long patientId);
}
