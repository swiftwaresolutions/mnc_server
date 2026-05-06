package com.ueniweb.swiftwaresolutions.repository;
import com.ueniweb.swiftwaresolutions.domain.OrderDiscount;
import com.ueniweb.swiftwaresolutions.domain.PrescTemplateDetails;
import com.ueniweb.swiftwaresolutions.domain.Prescription;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface PrescriptionRepository extends JpaRepository<Prescription, Long> {

    // Return the latest valid prescription display for a given patient and user (uid).
    // Use a native query with LIMIT 1 to get the most recent by date and time.
    @Query(value = "SELECT ph.display FROM ph_prescription ph WHERE ph.pat_id = :patId AND ph.uid = :uid AND ph.is_valid = 1 ORDER BY ph.date DESC, ph.time DESC LIMIT 1", nativeQuery = true)
    String getPrescDisplay(@Param("patId") Long patId, @Param("uid") Long uid);

}
