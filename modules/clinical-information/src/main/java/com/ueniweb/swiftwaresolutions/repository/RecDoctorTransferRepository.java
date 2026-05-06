package com.ueniweb.swiftwaresolutions.repository;

import com.ueniweb.swiftwaresolutions.domain.RecDoctorTransfer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

public interface RecDoctorTransferRepository
        extends JpaRepository<RecDoctorTransfer, Long> {

//    @Modifying
//    @Transactional
//    @Query("UPDATE RecDoctorTransfer t SET t.isCancelled = 1 WHERE t.id = :id")
//    int deleteTransferTransfer(@Param("id") Long id);

    @Modifying(clearAutomatically = true)
    @Transactional
    @Query("""
    UPDATE RecDoctorTransfer i
    SET i.isCancelled = true,
        i.blockUid = :userId,
        i.blockDateTime = CURRENT_TIMESTAMP
    WHERE i.id = :transferId
      AND i.isCancelled = false
""")
    int cancelTransferOrder(@Param("transferId") Long transferId,
                            @Param("userId") Long userId);

    Optional<RecDoctorTransfer> findByIdAndToDocAndIsCancelledFalse(Long id, Long toDoc);

    @Modifying(clearAutomatically = true)
    @Transactional
    @Query("""
    UPDATE RecDoctorTransfer i
    SET i.isCompleted = 1,
        i.editUid = :userId,
        i.editDateTime = CURRENT_TIMESTAMP
    WHERE i.id = :transferId
      AND i.isCompleted = 0
""")
    int markTransferAsReceived(@Param("transferId") Long transferId,
                                @Param("userId") Long userId);

    @Modifying(clearAutomatically = true)
    @Transactional
    @Query("""
    UPDATE RecDoctorTransfer i
    SET i.isCompleted = 1,
        i.editUid = :userId,
        i.editDateTime = CURRENT_TIMESTAMP
    WHERE i.id = :transferId
      AND i.isCompleted = 2
""")
    int markTransferAsReopened(@Param("transferId") Long transferId,
                               @Param("userId") Long userId);


}
