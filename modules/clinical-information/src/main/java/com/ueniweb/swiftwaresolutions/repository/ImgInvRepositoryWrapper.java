package com.ueniweb.swiftwaresolutions.repository;

import com.ueniweb.swiftwaresolutions.domain.InvImgUpload;
import com.ueniweb.swiftwaresolutions.infrastructure.exceptions.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@RequiredArgsConstructor
public class ImgInvRepositoryWrapper {

    private final ImgInvRepository imgInvRepository;

    @Transactional(readOnly = true)
    public InvImgUpload findOneWithNotFoundDetection(final Long imgId){
        return this.imgInvRepository.findById(imgId).orElseThrow(()-> new NotFoundException("Image not found for id : "+imgId));
    }
}
