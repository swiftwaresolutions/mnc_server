package com.ueniweb.swiftwaresolutions.repository;

import com.ueniweb.swiftwaresolutions.domain.Prescription;
import com.ueniweb.swiftwaresolutions.infrastructure.exceptions.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@RequiredArgsConstructor
public class PrescriptionRepositoryWrapper {

    private final PrescriptionRepository prescriptionRepository;

    @Transactional(readOnly = true)
    public Prescription findOneWithNotFoundDetection(final Long prescriptionId) {
        return this.prescriptionRepository.findById(prescriptionId).orElseThrow(() -> new NotFoundException("Prescription not found for id : " + prescriptionId));
    }

}
