package com.ueniweb.swiftwaresolutions.repository;

import com.ueniweb.swiftwaresolutions.domain.DermatologyComplaintDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface DermatologyComplainDetailsRepository extends JpaRepository<DermatologyComplaintDetails, Long> {

    @Query("select d from DermatologyComplaintDetails d where d.caseSheetId.id=:caseSheetId AND d.caseSheetType=:caseSheetType")
    List<DermatologyComplaintDetails> fetchDermatologyComplaintDetailsBycaseSheetId(@Param("caseSheetId") Long caseSheetId,
                                                              @Param("caseSheetType") Integer caseSheetType);
}
