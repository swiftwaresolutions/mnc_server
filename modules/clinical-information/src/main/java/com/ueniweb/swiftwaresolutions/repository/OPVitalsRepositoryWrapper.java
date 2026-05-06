package com.ueniweb.swiftwaresolutions.repository;

import com.ueniweb.swiftwaresolutions.domain.Opvitals;
import com.ueniweb.swiftwaresolutions.infrastructure.exceptions.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@RequiredArgsConstructor
public class OPVitalsRepositoryWrapper {
    @Autowired
    public OPVitalsRepository opVitalsRepository;
    @Transactional(readOnly = true)
    public Opvitals findOneWithNotFoundDetection(final Long opVitalsId) {
        return this.opVitalsRepository.findById(opVitalsId).orElseThrow(() -> new NotFoundException("Opvitals not found for id : " + opVitalsId));
    }
}
