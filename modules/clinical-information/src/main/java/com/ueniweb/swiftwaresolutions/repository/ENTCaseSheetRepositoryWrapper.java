package com.ueniweb.swiftwaresolutions.repository;

import com.ueniweb.swiftwaresolutions.domain.ENTCaseSheet;
import com.ueniweb.swiftwaresolutions.infrastructure.exceptions.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@RequiredArgsConstructor
public class ENTCaseSheetRepositoryWrapper {

    private final ENTCaseSheetRepository entCaseSheetRepository;

    @Transactional(readOnly = true)
    public ENTCaseSheet findOneWithNotFoundDetection(final Long entCaseSheetId){

        return this.entCaseSheetRepository.findById(entCaseSheetId).orElseThrow(() -> new NotFoundException("ENT Case Sheet not Found for Id : "+entCaseSheetId));
    }

    @Transactional(readOnly = true)
    public ENTCaseSheet findOneWithNotFoundDetectionByPatientID(final Long patientId){

        return this.entCaseSheetRepository.findByPatientId(patientId).orElseThrow(() -> new NotFoundException("ENT Case Sheet not Found for Patient Id : "+patientId));
    }
}
