package com.ueniweb.swiftwaresolutions.repository;

import com.ueniweb.swiftwaresolutions.domain.IpProcedureCaseSheet;
import com.ueniweb.swiftwaresolutions.infrastructure.exceptions.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@RequiredArgsConstructor
public class IpProcedureCaseSheetRepositoryWrapper {

    private final IpProcedureCaseSheetRepository ipProcedureCaseSheetRepository;

    @Transactional(readOnly = true)
    public IpProcedureCaseSheet findOneWithNotFoundDetection(final Long procedureId){
        return this.ipProcedureCaseSheetRepository.findById(procedureId).orElseThrow(()-> new NotFoundException("IpProcedure Case Sheet not found for id : "+ procedureId));
    }
}
