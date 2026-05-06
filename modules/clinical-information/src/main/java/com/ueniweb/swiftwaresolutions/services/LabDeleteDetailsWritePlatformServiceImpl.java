package com.ueniweb.swiftwaresolutions.services;

import com.ueniweb.swiftwaresolutions.core.response.Response;
import com.ueniweb.swiftwaresolutions.domain.LabDeleteDetails;
import com.ueniweb.swiftwaresolutions.infrastructure.exceptions.NotFoundException;
import com.ueniweb.swiftwaresolutions.repository.LabDeleteDetailsRepository;
import com.ueniweb.swiftwaresolutions.request.CreateLabDeleteDetailsRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class LabDeleteDetailsWritePlatformServiceImpl implements LabDeleteDetailsWritePlatformService {

    private final LabDeleteDetailsRepository labDeleteDetailsRepository;

    @Override
    @Transactional
    public Response saveLabDeleteDetails(CreateLabDeleteDetailsRequest createLabDeleteDetailsRequest) {
        try {
            if (createLabDeleteDetailsRequest.getPatId() == null) {
                throw new NotFoundException("Patient Id Not Found");
            }
            LabDeleteDetails labDeleteDetails = LabDeleteDetails.createNewInstance(createLabDeleteDetailsRequest);
            this.labDeleteDetailsRepository.saveAndFlush(labDeleteDetails);
            return new Response(labDeleteDetails.getId());
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
