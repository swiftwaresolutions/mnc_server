package com.ueniweb.swiftwaresolutions.repository;

import com.ueniweb.swiftwaresolutions.domain.GeneralCaseSheet;
import com.ueniweb.swiftwaresolutions.infrastructure.exceptions.NotFoundException;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.expression.ExpressionInvocationTargetException;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@RequiredArgsConstructor
public class GeneralCaseSheetRepositoryWrapper {

    private final GeneralCaseSheetRepository generalCaseSheetRepository;

    @Transactional(readOnly = true)
    public GeneralCaseSheet findOneWithNotFoundDetection(final Long generalCaseSheetId){
        return this.generalCaseSheetRepository.findById(generalCaseSheetId).orElseThrow(()-> new NotFoundException("General Case Sheet not found for id : "+generalCaseSheetId));
    }

    @Transactional(readOnly = true)
    public GeneralCaseSheet findOneWithNotFoundDetectionByPatientID(final Long patientId){
        return this.generalCaseSheetRepository.findByPatientId(patientId).orElseThrow(()-> new NotFoundException("General Case Sheet not found for patient id : "+patientId));
    }

}
