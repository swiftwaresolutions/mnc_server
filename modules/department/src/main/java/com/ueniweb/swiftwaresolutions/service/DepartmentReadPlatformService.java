package com.ueniweb.swiftwaresolutions.service;

import com.ueniweb.swiftwaresolutions.data.ConsultantDetailsData;
import com.ueniweb.swiftwaresolutions.data.DepartmentData;
import com.ueniweb.swiftwaresolutions.domain.Department;

import java.util.List;

public interface DepartmentReadPlatformService {

    List<Department> fetchAllDepartments();
    List <DepartmentData> fetchDepartmentName(String deptName);

    List<ConsultantDetailsData> fetchConsultantDetails();
}
