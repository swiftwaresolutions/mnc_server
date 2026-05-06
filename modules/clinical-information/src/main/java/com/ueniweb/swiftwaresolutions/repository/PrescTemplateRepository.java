package com.ueniweb.swiftwaresolutions.repository;

import com.ueniweb.swiftwaresolutions.domain.PrescTemplate;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PrescTemplateRepository extends JpaRepository<PrescTemplate, Long> {

    boolean existsByNameAndIdNot(String name, Long id);
}
