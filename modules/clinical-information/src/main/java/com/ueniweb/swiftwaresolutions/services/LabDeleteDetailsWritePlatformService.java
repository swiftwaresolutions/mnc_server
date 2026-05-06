package com.ueniweb.swiftwaresolutions.services;

import com.ueniweb.swiftwaresolutions.core.response.Response;
import com.ueniweb.swiftwaresolutions.request.CreateLabDeleteDetailsRequest;

public interface LabDeleteDetailsWritePlatformService {

    Response saveLabDeleteDetails(CreateLabDeleteDetailsRequest createLabDeleteDetailsRequest);
}
