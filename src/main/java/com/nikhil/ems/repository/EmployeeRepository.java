package com.nikhil.ems.repository;

import com.nikhil.ems.model.entity.Employee;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

  Optional<Employee> findByEmail(String email);

}
