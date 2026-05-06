package com.ueniweb.swiftwaresolutions.repository;

import com.ueniweb.swiftwaresolutions.domain.LabOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface LabOrderRepository extends JpaRepository<LabOrder, Long> {

    @Query("SELECT l from LabOrder l WHERE l.patId = :patientId")
    List<LabOrder> findLabByPatientId(@Param("patientId") Long patientId);

    @Modifying(clearAutomatically = true)
    @Query("""
        UPDATE LabOrder l
        SET l.isCancelled = true,
            l.cancelUid = :userId,
            l.cancelDate = CURRENT_DATE,
            l.cancelTime = CURRENT_TIME
        WHERE l.id = :labId
          AND l.isCancelled = false
          AND l.finalBillId = 0
    """)
    int cancelLabOrder(@Param("labId") Long labId,
                       @Param("userId") Long userId);

    @Modifying(clearAutomatically = true)
    @Query("""
        UPDATE LabOrder l
        SET l.isCancelled = true,
            l.cancelUid = :userId,
            l.cancelDate = CURRENT_DATE,
            l.cancelTime = CURRENT_TIME
        WHERE l.patId = :patientId
          AND l.finalBillId = 0
          AND l.isCancelled = false
    """)
    int cancelLabOrdersByPatientId(@Param("patientId") Long patientId,
                                   @Param("userId") Long userId);

    @Query("""
    SELECT l
    FROM LabOrder l
    WHERE l.patId = :patientId
      AND l.finalBillId = 0
      AND l.isCancelled = false
""")
    List<LabOrder> findActiveUnbilledByPatientId(@Param("patientId") Long patientId);
}
