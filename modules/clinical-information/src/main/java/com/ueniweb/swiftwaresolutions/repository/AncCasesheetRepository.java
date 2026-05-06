package com.ueniweb.swiftwaresolutions.repository;


import com.ueniweb.swiftwaresolutions.domain.AncCaseSheet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;


public interface AncCasesheetRepository extends JpaRepository<AncCaseSheet, Long> {

    @Modifying
    @Query("UPDATE AncCaseSheet a SET a.riskFactor = :riskFactors, a.personalInfo = :personalInfo WHERE a.id = :id")
    int updateRiskFactorsById(@Param("id") Long id, @Param("riskFactors") String riskFactors, @Param("personalInfo") String personalInfo);

    @Query("SELECT a.riskFactor FROM AncCaseSheet a WHERE a.id = :id")
    String findRiskFactorsById(@Param("id") Long id);

    @Modifying
    @Transactional
    @Query("UPDATE AncCaseSheet a SET a.isDelivered = 1 WHERE a.id = :ancId")
    int updateDeliveryStatus(@Param("ancId") Long ancId);


}
