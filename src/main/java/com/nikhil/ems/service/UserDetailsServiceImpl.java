package com.nikhil.ems.service;

import com.nikhil.ems.model.entity.Employee;
import com.nikhil.ems.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {
  private final EmployeeRepository employeeRepository;

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    if (username == null || username.isEmpty()) {
      throw new UsernameNotFoundException("Username is empty");
    }
    Employee employee = employeeRepository.findByEmail(username).orElseThrow(() ->
        new UsernameNotFoundException("User not found with email: " + username)
    );

    return User.builder()
        .username(employee.getEmail())
        .password(employee.getPassword())
        .build();
  }
}
