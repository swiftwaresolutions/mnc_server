package com.ueniweb.swiftwaresolutions.repository;

import com.ueniweb.swiftwaresolutions.domain.OrderDiscount;
import com.ueniweb.swiftwaresolutions.infrastructure.exceptions.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderDiscountRepositoryWrapper {

    private final OrderDiscountRepository orderDiscountRepository;


    @Transactional(readOnly = true)
    public OrderDiscount findOneWithNotFoundDetection(final Long discId){
        return this.orderDiscountRepository.findById(discId).orElseThrow(()-> new NotFoundException(" Order Disc not found for id : "+discId));
    }

    @Transactional(readOnly = true)
    public OrderDiscount findOneWithNotFoundDetectionByPatId(final Long patId){
        return this.orderDiscountRepository.findOrderDiscByPatientId(patId).orElse(null);
    }



}
