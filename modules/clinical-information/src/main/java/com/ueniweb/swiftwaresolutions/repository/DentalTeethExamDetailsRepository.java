package com.ueniweb.swiftwaresolutions.repository;

import com.ueniweb.swiftwaresolutions.domain.DentalTeethExamDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
public interface DentalTeethExamDetailsRepository extends JpaRepository<DentalTeethExamDetails, Long> {

    @Query("select d from DentalTeethExamDetails d where d.caseSheetId.id=:caseSheetId")
    List<DentalTeethExamDetails> fetchTeethExamDetailsBycaseSheetId(@Param("caseSheetId") Long caseSheetId);


}
