package com.ueniweb.swiftwaresolutions.repository;

import com.ueniweb.swiftwaresolutions.domain.ENTComplaintDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ENTComplainDetailsRepository extends JpaRepository<ENTComplaintDetails,Long> {

    @Query("select d from ENTComplaintDetails d where d.caseSheetId.id=:caseSheetId AND d.caseSheetType=:caseSheetType")
    List<ENTComplaintDetails> fetchENTComplaintDetailsBycaseSheetId(@Param("caseSheetId") Long caseSheetId,
                                                                                    @Param("caseSheetType") Integer caseSheetType);
}
