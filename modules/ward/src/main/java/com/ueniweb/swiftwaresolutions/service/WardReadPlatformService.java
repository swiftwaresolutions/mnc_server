package com.ueniweb.swiftwaresolutions.service;

import com.ueniweb.swiftwaresolutions.domain.Ward;

import java.util.List;

public interface WardReadPlatformService {

    List<Ward> fetchAllWards();
}
