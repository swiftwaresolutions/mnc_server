package com.ueniweb.swiftwaresolutions.repository;


import com.ueniweb.swiftwaresolutions.domain.SurgeryCaseSheet;
import com.ueniweb.swiftwaresolutions.infrastructure.exceptions.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@RequiredArgsConstructor
public class SurgeryCaseSheetRepositoryWrapper {
    @Autowired
     public  SurgeryCaseSheetRepository surgeryCaseSheetRepository;
   @Transactional(readOnly = true)
    public SurgeryCaseSheet findOneWithNotFoundDetection(final Long caseSheetId){
       return this.surgeryCaseSheetRepository.findById(caseSheetId).orElseThrow(()-> new NotFoundException("surgeryCaseSheet not found for id : "+caseSheetId));
  }

}
