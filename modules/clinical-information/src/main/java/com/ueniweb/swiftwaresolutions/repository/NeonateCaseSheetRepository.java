package com.ueniweb.swiftwaresolutions.repository;

import com.ueniweb.swiftwaresolutions.domain.NeonateCaseSheet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface NeonateCaseSheetRepository  extends JpaRepository<NeonateCaseSheet, Long> {

  //  Optional<NeonateCaseSheet> findByPatientId(Long patId);

}
