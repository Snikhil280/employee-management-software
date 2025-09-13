package com.nikhil.ems.service;

import com.nikhil.ems.model.entity.Department;
import com.nikhil.ems.repository.DepartmentRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DepartmentService {
  private final DepartmentRepository departmentRepository;

  public Department save(Department department) {
    return departmentRepository.save(department);
  }

  public Department getById(Integer id) {
    return departmentRepository.findById(id).orElseThrow(() ->
        new RuntimeException("Department not found")
    );
  }

  public void deleteById(Integer id) {
    departmentRepository.deleteById(id);
  }

  public List<Department> getAll() {
    return departmentRepository.findAll();
  }

}
