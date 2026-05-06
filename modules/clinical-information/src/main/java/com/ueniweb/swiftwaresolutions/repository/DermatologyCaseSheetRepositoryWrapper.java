package com.ueniweb.swiftwaresolutions.repository;


import com.ueniweb.swiftwaresolutions.domain.DermatologyCaseSheet;
import com.ueniweb.swiftwaresolutions.infrastructure.exceptions.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@RequiredArgsConstructor
public class DermatologyCaseSheetRepositoryWrapper {

    private final DermatologyCaseSheetRepository dermatologyCaseSheetRepository;

    @Transactional(readOnly = true)
    public DermatologyCaseSheet findOneWithNotFoundDetection(final Long dermatologyCaseSheetId){

        return this.dermatologyCaseSheetRepository.findById(dermatologyCaseSheetId).orElseThrow(() -> new NotFoundException("Dermatology Case Sheet not Found for Id : "+dermatologyCaseSheetId));
    }

    @Transactional(readOnly = true)
    public DermatologyCaseSheet findOneWithNotFoundDetectionByPatientID(final Long patientId){

        return this.dermatologyCaseSheetRepository.findByPatientId(patientId).orElseThrow(() -> new NotFoundException("Dermatology Case Sheet not Found for Patient Id : "+patientId));
    }
}
