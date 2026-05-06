package com.ueniweb.swiftwaresolutions.repository;



import com.ueniweb.swiftwaresolutions.domain.SurgeryCheck;
import com.ueniweb.swiftwaresolutions.infrastructure.exceptions.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@RequiredArgsConstructor
public class SurgeryChecklistRepositoryWrapper {

    @Autowired
    public SurgeryChecklistRepository surgeryChecklistRepository;
    @Transactional(readOnly = true)
    public SurgeryCheck findOneWithNotFoundDetection(final Long ckId) {
        return this.surgeryChecklistRepository.findById(ckId).orElseThrow(() -> new NotFoundException("Surgery Checklist not found for id : " + ckId));
    }
}
