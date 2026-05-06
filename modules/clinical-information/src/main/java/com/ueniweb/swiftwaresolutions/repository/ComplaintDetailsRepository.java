package com.ueniweb.swiftwaresolutions.repository;

import com.ueniweb.swiftwaresolutions.domain.ComplaintDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ComplaintDetailsRepository extends JpaRepository<ComplaintDetails, Long> {

    @Query("select d from ComplaintDetails d where d.caseSheetId.id=:caseSheetId AND d.caseSheetType=:caseSheetType")
    List<ComplaintDetails> fetchComplaintDetailsBycaseSheetId(@Param("caseSheetId") Long caseSheetId,
                                                              @Param("caseSheetType") Integer caseSheetType);

}
