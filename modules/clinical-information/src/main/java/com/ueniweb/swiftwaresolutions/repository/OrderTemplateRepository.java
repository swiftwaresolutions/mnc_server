package com.ueniweb.swiftwaresolutions.repository;

import com.ueniweb.swiftwaresolutions.domain.OrderTemplate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface OrderTemplateRepository  extends JpaRepository<OrderTemplate, Long>  {

    @Modifying
    @Transactional
    @Query("UPDATE OrderTemplate t SET t.isActive = 0 WHERE t.id = :id")
    int deleteTemplateById(@Param("id") Long id);

    @Override
    boolean existsById(Long id);
}
