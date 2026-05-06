package com.ueniweb.swiftwaresolutions.repository;

import com.ueniweb.swiftwaresolutions.domain.AntenatalCaseSheetPrevious;
import com.ueniweb.swiftwaresolutions.domain.ComplaintDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AntenatalCaseSheetPreRepository extends JpaRepository<AntenatalCaseSheetPrevious, Long> {
    @Query("select d from AntenatalCaseSheetPrevious d where d.ancId.id=:ancId")
    List<AntenatalCaseSheetPrevious> fetchAntenatalPreviousBycaseSheetId(@Param("ancId") Long ancId);
}
