package com.ueniweb.swiftwaresolutions.repository;

import com.ueniweb.swiftwaresolutions.domain.OrderTemplateDetails;
import com.ueniweb.swiftwaresolutions.domain.PrescTemplateDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface OrderTemplateDetailsRepository extends JpaRepository<OrderTemplateDetails, Long> {

    @Query("select d from OrderTemplateDetails d where d.templateId=:templateId")
    List<PrescTemplateDetails> findOrderTemplateBytemplateId(@Param("templateId") Long templateId);

}
