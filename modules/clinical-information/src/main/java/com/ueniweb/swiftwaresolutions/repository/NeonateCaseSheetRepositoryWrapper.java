package com.ueniweb.swiftwaresolutions.repository;

import com.ueniweb.swiftwaresolutions.domain.GeneralCaseSheet;
import com.ueniweb.swiftwaresolutions.domain.NeonateCaseSheet;
import com.ueniweb.swiftwaresolutions.domain.PediatricCaseSheet;
import com.ueniweb.swiftwaresolutions.infrastructure.exceptions.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
@Component
@RequiredArgsConstructor
public class NeonateCaseSheetRepositoryWrapper {
    @Autowired
    public NeonateCaseSheetRepository neonateCaseSheetRepository;
    @Transactional(readOnly = true)
    public NeonateCaseSheet findOneWithNotFoundDetection(final Long caseSheetId){
        return this.neonateCaseSheetRepository.findById(caseSheetId).orElseThrow(()-> new NotFoundException("Pediatric Case Sheet not found for id : "+caseSheetId));
    }

}
