package com.ueniweb.swiftwaresolutions.repository;

import com.ueniweb.swiftwaresolutions.domain.PrescTemplate;
import com.ueniweb.swiftwaresolutions.infrastructure.exceptions.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@RequiredArgsConstructor
public class PrescTemplateRepositoryWrapper {

    private final PrescTemplateRepository prescTemplateRepository;

    @Transactional(readOnly = true)
    public PrescTemplate findOneWithNotFoundDetection(final Long id){
        return this.prescTemplateRepository.findById(id).orElseThrow(()-> new NotFoundException("Prescription Template not found for id : "+id));
    }
}
