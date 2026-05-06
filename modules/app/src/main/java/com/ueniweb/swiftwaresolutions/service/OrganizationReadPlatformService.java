package com.ueniweb.swiftwaresolutions.service;

import com.ueniweb.swiftwaresolutions.data.ClinicalModData;
import com.ueniweb.swiftwaresolutions.data.OrganizationData;

import java.util.List;

public interface OrganizationReadPlatformService {

    OrganizationData fetchOrganizationDetails();

    List<ClinicalModData> fetchClinicalModuleDetails();

}
