package com.ueniweb.swiftwaresolutions.controllers.application;

import com.ueniweb.swiftwaresolutions.data.ClinicalModData;
import com.ueniweb.swiftwaresolutions.data.OrganizationData;
import com.ueniweb.swiftwaresolutions.service.OrganizationReadPlatformService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
@Slf4j
public class AppController {
    private final OrganizationReadPlatformService organizationReadPlatformService;

    @GetMapping("/fetchOrganizationDetails")
    public OrganizationData fetchOrganizationDetails() {
        OrganizationData organizationList;
        organizationList = this.organizationReadPlatformService.fetchOrganizationDetails();

        return organizationList;
    }

    @GetMapping("/fetchClinicalModuleDetails")
    public List<ClinicalModData> fetchClinicalModuleDetails() {
        List<ClinicalModData> clinicalModDataList;
        clinicalModDataList = this.organizationReadPlatformService.fetchClinicalModuleDetails();

        return clinicalModDataList;
    }

}
