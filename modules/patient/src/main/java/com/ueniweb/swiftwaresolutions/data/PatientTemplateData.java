package com.ueniweb.swiftwaresolutions.data;

import com.ueniweb.swiftwaresolutions.domain.Department;
import com.ueniweb.swiftwaresolutions.domain.Ward;
import lombok.Data;

import java.util.List;

@Data
public class PatientTemplateData {

    List<Department> departmentList;

    List<Ward> wardList;
}
