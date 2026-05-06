package com.ueniweb.swiftwaresolutions.repository;

import com.ueniweb.swiftwaresolutions.domain.AncDetailsSheet;
import com.ueniweb.swiftwaresolutions.infrastructure.exceptions.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@RequiredArgsConstructor
public class AncDetailsRepositoryWrapper {

    @Autowired
    public AncDetailsRepository ancDetailsRepository;
    @Transactional(readOnly = true)
    public AncDetailsSheet findOneWithNotFoundDetection(final Long ancDetId){
        return this.ancDetailsRepository.findById(ancDetId).orElseThrow(()-> new NotFoundException("AncCaseSheet Details not found for id : "+ancDetId));
    }
}
