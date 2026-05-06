package com.ueniweb.swiftwaresolutions.repository;

import com.ueniweb.swiftwaresolutions.domain.DentalTeethTreatDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface DentalTeethTreatDetailsRepository extends JpaRepository<DentalTeethTreatDetails, Long> {

    @Query("select d from DentalTeethTreatDetails d where d.caseSheetId.id=:caseSheetId")
    List<DentalTeethTreatDetails> fetchTeethTreatDetailsBycaseSheetId(@Param("caseSheetId") Long caseSheetId);


}
