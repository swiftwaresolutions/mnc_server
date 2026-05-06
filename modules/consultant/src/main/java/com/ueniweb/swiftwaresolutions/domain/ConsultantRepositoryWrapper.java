package com.ueniweb.swiftwaresolutions.domain;

import com.ueniweb.swiftwaresolutions.infrastructure.exceptions.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ConsultantRepositoryWrapper {

    private final ConsultantRepository consultantRepository;

    @Transactional(readOnly = true)
    public Consultant findOneWithNotFoundDetection(final Long doctorId){
        return this.consultantRepository.findById(doctorId).orElseThrow(()-> new NotFoundException("Doctor not found for this id: "+doctorId));
    }
}
