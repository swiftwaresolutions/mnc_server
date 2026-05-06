package com.ueniweb.swiftwaresolutions.controllers.department;


import com.ueniweb.swiftwaresolutions.data.ConsultantDetailsData;
import com.ueniweb.swiftwaresolutions.data.DepartmentData;
import com.ueniweb.swiftwaresolutions.data.TimingData;
import com.ueniweb.swiftwaresolutions.domain.Ward;
import com.ueniweb.swiftwaresolutions.service.DepartmentReadPlatformService;
import com.ueniweb.swiftwaresolutions.service.WardReadPlatformService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/department")
@Slf4j
public class DepartmentController {
    private final DepartmentReadPlatformService departmentReadPlatformService;

    private final WardReadPlatformService wardReadPlatformService;
    @GetMapping("/fetchDepartmentName/{deptName}")
    public List<DepartmentData> fetchDepartmentName(@PathVariable(name = "deptName") String deptName) {
        List<DepartmentData> departmentList = this.departmentReadPlatformService.fetchDepartmentName(deptName);

        return departmentList;
    }
    @GetMapping("/fetchAllWards")
    public List<Ward> fetchAllWards() {
        return wardReadPlatformService.fetchAllWards();
    }

    @GetMapping("/fetchAllConsultant")
    public List<Ward> fetchAllConsultant() {
        return wardReadPlatformService.fetchAllWards();
    }

    @GetMapping("/fetchAllConsultantDetails")
    public List<ConsultantDetailsData> fetchAllConsultantDetails() {
        return this.departmentReadPlatformService.fetchConsultantDetails();
    }

}


