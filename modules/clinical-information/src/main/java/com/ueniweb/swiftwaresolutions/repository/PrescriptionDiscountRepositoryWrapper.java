package com.ueniweb.swiftwaresolutions.repository;

import com.ueniweb.swiftwaresolutions.domain.PrescDiscount;
import com.ueniweb.swiftwaresolutions.infrastructure.exceptions.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class PrescriptionDiscountRepositoryWrapper {

    private final PrescriptionDiscountRepository prescriptionDiscountRepository;

    @Transactional(readOnly = true)
    public PrescDiscount findOneWithNotFoundDetection(final Long prescriptionId){
        return this.prescriptionDiscountRepository.findById(prescriptionId).orElseThrow(()-> new NotFoundException(" Prescription Disc not found for id : "+prescriptionId));
    }

    @Transactional(readOnly = true)
    public PrescDiscount findOneWithNotFoundDetectionByPresId(final Long presId,final double disAmt){
        return this.prescriptionDiscountRepository.findPrescriptionDiscBypresId(presId).orElse(null);
    }
}
