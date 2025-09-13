package com.nikhil.ems.service;

import com.nikhil.ems.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmployeeService {

  private final EmployeeRepository employeeRepository;
  private final DepartmentService departmentService;
  private final DesignationService designationService;


}
