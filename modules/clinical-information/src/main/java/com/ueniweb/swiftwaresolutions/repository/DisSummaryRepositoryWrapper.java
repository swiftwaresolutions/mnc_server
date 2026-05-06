package com.ueniweb.swiftwaresolutions.repository;

import com.ueniweb.swiftwaresolutions.domain.DischargeSummary;
import com.ueniweb.swiftwaresolutions.domain.GeneralCaseSheet;
import com.ueniweb.swiftwaresolutions.infrastructure.exceptions.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@RequiredArgsConstructor
public class DisSummaryRepositoryWrapper {

    private final DischargeSummaryRepository dischargeSummaryRepository;

    @Transactional(readOnly = true)
    public DischargeSummary findOneWithNotFoundDetection(final Long summaryId){
        return this.dischargeSummaryRepository.findById(summaryId).orElseThrow(()-> new NotFoundException("Discharge Summary not found for id : "+summaryId));
    }
}
