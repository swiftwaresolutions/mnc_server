package com.ueniweb.swiftwaresolutions.repository;


import com.ueniweb.swiftwaresolutions.domain.NursingIoSheet;
import com.ueniweb.swiftwaresolutions.infrastructure.exceptions.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@RequiredArgsConstructor
public class NursingIoRepositoryWrapper {

    @Autowired
    public NursingIoRepository nursingIoRepository;
    @Transactional(readOnly = true)
    public NursingIoSheet findOneWithNotFoundDetection(final Long IoId) {
        return this.nursingIoRepository.findById(IoId).orElseThrow(() -> new NotFoundException("NursingIo sheet not found for id : " + IoId));
    }
}
