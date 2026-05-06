package com.ueniweb.swiftwaresolutions.repository;

import com.ueniweb.swiftwaresolutions.domain.PediatricCaseSheet;
import com.ueniweb.swiftwaresolutions.infrastructure.exceptions.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@RequiredArgsConstructor
public class PediatricCaseSheetWrapper {

    private final PediatricCaseSheetRepository pediatricCaseSheetRepository;

    @Transactional(readOnly = true)
    public PediatricCaseSheet findOneWithNotFoundDetection(final Long caseSheetId){
        return this.pediatricCaseSheetRepository.findById(caseSheetId).orElseThrow(()-> new NotFoundException("Pediatric Case Sheet not found for id : "+caseSheetId));
    }

}
