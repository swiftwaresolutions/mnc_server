package com.ueniweb.swiftwaresolutions.repository;
import com.ueniweb.swiftwaresolutions.domain.AncDeliverySheet;
import com.ueniweb.swiftwaresolutions.infrastructure.exceptions.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@RequiredArgsConstructor
public class AncDeliveryDetialsRepositoryWrapper {
    @Autowired
    public AncSheetDeliveryRepository ancSheetDeliveryRepository;
    @Transactional(readOnly = true)
    public AncDeliverySheet findOneWithNotFoundDetection(final Long id){
        return this.ancSheetDeliveryRepository.findById(id).orElseThrow(()-> new NotFoundException("AncDeliverySheet not found for id : "+id));
    }
}
