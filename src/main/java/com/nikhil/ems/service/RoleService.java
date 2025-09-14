package com.nikhil.ems.service;

import com.nikhil.ems.model.entity.Role;
import com.nikhil.ems.repository.RoleRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RoleService {
  private final RoleRepository roleRepository;

  // create methods for designation operations
  public Role save(Role role) {
    return roleRepository.save(role);
  }

  public Role getById(Integer id) {
    return roleRepository.findById(id).orElseThrow(() ->
        new RuntimeException("Designation not found")
    );
  }

  public List<Role> getAll() {
    return roleRepository.findAll();
  }

  public void deleteById(Integer id) {
    roleRepository.deleteById(id);
  }

}
