package com.ueniweb.swiftwaresolutions.repository;

import com.ueniweb.swiftwaresolutions.domain.OpthamologyComplaintDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface OpthamologyComplainDetailsRepository extends JpaRepository<OpthamologyComplaintDetails,Long> {

    @Query("select d from OpthamologyComplaintDetails d where d.caseSheetId.id=:caseSheetId AND d.caseSheetType=:caseSheetType")
    List<OpthamologyComplaintDetails> fetchOpthamologyComplaintDetailsBycaseSheetId(@Param("caseSheetId") Long caseSheetId,
                                                                                    @Param("caseSheetType") Integer caseSheetType);
}
