package com.ueniweb.swiftwaresolutions.repository;

import com.ueniweb.swiftwaresolutions.domain.OpthamologyCaseSheet;
import com.ueniweb.swiftwaresolutions.infrastructure.exceptions.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@RequiredArgsConstructor
public class OpthamologyCaseSheetRepositoryWrapper {

    private final OpthamologyCaseSheetRepository opthamologyCaseSheetRepository;

    @Transactional(readOnly = true)
    public OpthamologyCaseSheet findOneWithNotFoundDetection(final Long opthamologyCaseSheetId){

        return this.opthamologyCaseSheetRepository.findById(opthamologyCaseSheetId).orElseThrow(() -> new NotFoundException("Opthamology Case Sheet not Found for Id : "+opthamologyCaseSheetId));
    }

    @Transactional(readOnly = true)
    public OpthamologyCaseSheet findOneWithNotFoundDetectionByPatientID(final Long patientId){

        return this.opthamologyCaseSheetRepository.findByPatientId(patientId).orElseThrow(() -> new NotFoundException("Opthamology Case Sheet not Found for Patient Id : "+patientId));
    }
}
