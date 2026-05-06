package com.ueniweb.swiftwaresolutions.repository;

import com.ueniweb.swiftwaresolutions.domain.PrescTemplateDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PrescTemplateDetailsRepository extends JpaRepository<PrescTemplateDetails, Long>  {

    @Query("select d from PrescTemplateDetails d where d.templateId=:templateId")
    List<PrescTemplateDetails> findPrescTemplateBytemplateId(@Param("templateId") Long templateId);

}
