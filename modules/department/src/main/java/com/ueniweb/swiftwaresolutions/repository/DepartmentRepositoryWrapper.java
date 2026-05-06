package com.ueniweb.swiftwaresolutions.repository;

import com.ueniweb.swiftwaresolutions.domain.Department;
import com.ueniweb.swiftwaresolutions.infrastructure.exceptions.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@RequiredArgsConstructor
public class DepartmentRepositoryWrapper {

    private final DepartmentRepository departmentRepository;

    @Transactional(readOnly = true)
    public Department findOneWithNotFoundDetection(final Long departmentId){
        return this.departmentRepository.findById(departmentId).orElseThrow(()-> new NotFoundException("Department id not found : "+departmentId));
    }
}
