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
                SET  i.editUid = :userId,
                    i.editDateTime = CURRENT_TIMESTAMP
                WHERE i.id = :transferId
            """)
    int markTransferAsReceived(@Param("transferId") Long transferId,
                                @Param("userId") Long userId);

    @Modifying(clearAutomatically = true)
    @Transactional
    @Query("""
                UPDATE RecDoctorTransfer i
                SET  i.editUid = :userId,
                    i.editDateTime = CURRENT_TIMESTAMP
                WHERE i.id = :transferId
            """)
    int markTransferAsReopened(@Param("transferId") Long transferId,
                               @Param("userId") Long userId);

    @Query(value = """
                    SELECT COALESCE(MAX(doctor_token), 0)
                    FROM rec_doctor_transfer
                    WHERE to_doc = :toDoc
                      AND DATE(ent_dateTime) = CURDATE()
                """, nativeQuery = true)
    int findMaxDoctorTokenByToDoc(@Param("toDoc") Long toDoc);

    @Modifying(clearAutomatically = true)
    @Transactional
    @Query(value = """
                    UPDATE rec_doctor_transfer
                    SET is_doctor_viewing = 0
                    WHERE to_doc = :toDoc
                      AND is_doctor_viewing = 1
                      AND DATE(ent_dateTime) = CURDATE()
                """, nativeQuery = true)
    int resetDoctorViewing(@Param("toDoc") Long toDoc);

    @Query(value = """
                    SELECT COUNT(*)
                    FROM rec_doctor_transfer
                    WHERE pat_id = :patId
                      AND vst_id = :vstId
                      AND to_doc = :toDoc
                      AND DATE(ent_dateTime) = CURDATE()
                      AND is_cancelled = 0
                      AND is_completed = 0
                """, nativeQuery = true)
    int countPendingFirstView(@Param("patId") Long patId,
                              @Param("vstId") Long vstId,
                              @Param("toDoc") Long toDoc);

    @Modifying(clearAutomatically = true)
    @Transactional
    @Query(value = """
                    UPDATE rec_doctor_transfer
                    SET is_doctor_viewing = 1,
                        is_completed = 1
                    WHERE pat_id = :patId
                      AND vst_id = :vstId
                      AND to_doc = :toDoc
                      AND DATE(ent_dateTime) = CURDATE()
                      AND is_cancelled = 0
                """, nativeQuery = true)
    int setDoctorViewing(@Param("patId") Long patId,
                         @Param("vstId") Long vstId,
                         @Param("toDoc") Long toDoc);

}
