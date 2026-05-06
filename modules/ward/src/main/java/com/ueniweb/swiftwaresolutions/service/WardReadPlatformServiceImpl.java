package com.ueniweb.swiftwaresolutions.service;

import com.ueniweb.swiftwaresolutions.domain.Ward;
import com.ueniweb.swiftwaresolutions.repository.WardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class WardReadPlatformServiceImpl implements WardReadPlatformService {

    private final WardRepository wardRepository;

    @Override
    public List<Ward> fetchAllWards() {
        return this.wardRepository.fetchActiveWards();
    }
}
