package com.nikhil.ems.service;

import com.nikhil.ems.model.entity.Designation;
import com.nikhil.ems.repository.DesignationRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DesignationService {
  private final DesignationRepository designationRepository;

  // create methods for designation operations
  public Designation save(Designation designation) {
    return designationRepository.save(designation);
  }

  public Designation getById(Integer id) {
    return designationRepository.findById(id).orElseThrow(() ->
        new RuntimeException("Designation not found")
    );
  }

  public List<Designation> getAll() {
    return designationRepository.findAll();
  }

  public void deleteById(Integer id) {
    designationRepository.deleteById(id);
  }

}
