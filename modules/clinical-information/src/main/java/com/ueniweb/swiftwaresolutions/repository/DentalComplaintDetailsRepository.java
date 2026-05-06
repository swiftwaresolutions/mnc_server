package com.ueniweb.swiftwaresolutions.repository;

import com.ueniweb.swiftwaresolutions.domain.DentalComplaintDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface DentalComplaintDetailsRepository extends JpaRepository<DentalComplaintDetails, Long> {

    @Query("select d from DentalComplaintDetails d where d.caseSheetId.id=:caseSheetId")
    List<DentalComplaintDetails> fetchComplaintDetailsBycaseSheetId(@Param("caseSheetId") Long caseSheetId);

}
