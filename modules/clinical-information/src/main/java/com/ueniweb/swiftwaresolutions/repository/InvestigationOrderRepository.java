package com.ueniweb.swiftwaresolutions.repository;

import com.ueniweb.swiftwaresolutions.domain.InvestigationOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InvestigationOrderRepository extends JpaRepository<InvestigationOrder, Long>  {

    @Query("SELECT l from InvestigationOrder l WHERE l.patId = :patientId")
    List<InvestigationOrder> findInvestigationOrderByPatientId(@Param("patientId") Long patientId);

    @Query("""
    UPDATE InvestigationOrder i
    SET i.isCancelled = true,
        i.cancelUid = :userId,
        i.cancelDate = CURRENT_DATE,
        i.cancelTime = CURRENT_TIME
    WHERE i.id = :orderId
      AND i.isCancelled = false
""")
    @Modifying(clearAutomatically = true)
    int cancelInvestigationOrder(@Param("orderId") Long orderId,
                                 @Param("userId") Long userId);

    @Modifying(clearAutomatically = true)
    @Query("""
        UPDATE InvestigationOrder i
        SET i.isCancelled = true,
            i.cancelUid = :userId,
            i.cancelDate = CURRENT_DATE,
            i.cancelTime = CURRENT_TIME
        WHERE i.patId = :patientId
          AND i.finalBillId = 0
          AND i.isCancelled = false
    """)
    int cancelInvestigationOrdersByPatientId(@Param("patientId") Long patientId,
                                             @Param("userId") Long userId);

    @Modifying(clearAutomatically = true)
    @Query("""
        UPDATE InvestigationOrder i
        SET i.isCancelled = true,
            i.cancelUid = :userId,
            i.cancelDate = CURRENT_DATE,
            i.cancelTime = CURRENT_TIME
        WHERE i.docId = :docId and i.visitId = :visitId
          AND i.isCancelled = false
    """)
    int cancelByDocId(@Param("docId") Long docId,
                      @Param("userId") Long userId,@Param("visitId") Long visitId);

}
