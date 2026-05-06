package com.ueniweb.swiftwaresolutions.repository;

import com.ueniweb.swiftwaresolutions.domain.CaseSheetTemplate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface CaseSheetTemplateRepository extends JpaRepository<CaseSheetTemplate, Long> {

    @Modifying
    @Transactional
    @Query("UPDATE CaseSheetTemplate t SET t.isValid = 0 WHERE t.id = :id")
    int deleteTemplateById(@Param("id") Long id);

}
