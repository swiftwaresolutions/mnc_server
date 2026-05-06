package com.ueniweb.swiftwaresolutions.repository;

import com.ueniweb.swiftwaresolutions.domain.AncCaseSheet;
import com.ueniweb.swiftwaresolutions.domain.AntenatalCaseSheet;
import com.ueniweb.swiftwaresolutions.infrastructure.exceptions.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
@Component
@RequiredArgsConstructor
public class AncRepositoryWrapper {
    @Autowired
    public AncCasesheetRepository ancCasesheetRepository;
    @Transactional(readOnly = true)
    public AncCaseSheet findOneWithNotFoundDetection(final Long caseSheetId){
        return this.ancCasesheetRepository.findById(caseSheetId).orElseThrow(()-> new NotFoundException("AncCaseSheet not found for id : "+caseSheetId));
    }
}
