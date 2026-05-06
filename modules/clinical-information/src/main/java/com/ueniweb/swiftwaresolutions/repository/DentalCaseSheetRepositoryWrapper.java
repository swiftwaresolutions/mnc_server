package com.ueniweb.swiftwaresolutions.repository;

import com.ueniweb.swiftwaresolutions.domain.DentalCaseSheet;
import com.ueniweb.swiftwaresolutions.infrastructure.exceptions.NotFoundException;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.expression.ExpressionInvocationTargetException;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@RequiredArgsConstructor
public class DentalCaseSheetRepositoryWrapper {

    @Autowired
    private final DentalCaseSheetRepository dentalCaseSheetRepository;

    @Transactional(readOnly = true)
    public DentalCaseSheet findOneWithNotFoundDetection(final Long dentalCaseSheetId){
        return this.dentalCaseSheetRepository.findById(dentalCaseSheetId).orElseThrow(()-> new NotFoundException("Dental Case Sheet not found for id : "+dentalCaseSheetId));
    }

}
