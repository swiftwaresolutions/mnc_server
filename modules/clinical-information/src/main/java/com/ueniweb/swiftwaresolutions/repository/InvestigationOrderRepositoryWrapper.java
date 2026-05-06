package com.ueniweb.swiftwaresolutions.repository;

import com.ueniweb.swiftwaresolutions.domain.InvestigationOrder;
import com.ueniweb.swiftwaresolutions.infrastructure.exceptions.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class InvestigationOrderRepositoryWrapper {

    private final InvestigationOrderRepository investigationOrderRepository;

    @Transactional(readOnly = true)
    public InvestigationOrder findOneWithNotFoundDetection(final Long investigationOrdId){
        return this.investigationOrderRepository.findById(investigationOrdId).orElseThrow(()-> new NotFoundException("Investigation Order not found for id : "+investigationOrdId));
    }

    @Transactional(readOnly = true)
    public List<InvestigationOrder> findOneWithNotFoundDetectionByPatientId(final Long patientId){
        List<InvestigationOrder> investigationOrders =  this.investigationOrderRepository.findInvestigationOrderByPatientId(patientId);
        if (investigationOrders.isEmpty()) {
            return null;
        }
        return investigationOrders;
    }
}
