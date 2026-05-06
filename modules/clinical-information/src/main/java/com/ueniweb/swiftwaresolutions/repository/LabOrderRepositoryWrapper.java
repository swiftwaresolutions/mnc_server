package com.ueniweb.swiftwaresolutions.repository;

import com.ueniweb.swiftwaresolutions.domain.GeneralCaseSheet;
import com.ueniweb.swiftwaresolutions.domain.LabOrder;
import com.ueniweb.swiftwaresolutions.infrastructure.exceptions.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LabOrderRepositoryWrapper {

    private final LabOrderRepository labOrderRepository;

    @Transactional(readOnly = true)
    public LabOrder findOneWithNotFoundDetection(final Long labId){
        return this.labOrderRepository.findById(labId).orElseThrow(()-> new NotFoundException("Lab not found for id : "+labId));
    }

    @Transactional(readOnly = true)
    public List<LabOrder> findOneWithNotFoundDetectionByPatientId(final Long patientId){
        List<LabOrder> labOrderList =  this.labOrderRepository.findLabByPatientId(patientId);
        if (labOrderList.isEmpty()) {
            return null;
        }
        return labOrderList;
    }

}
