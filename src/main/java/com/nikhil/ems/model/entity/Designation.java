package com.nikhil.ems.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.HashSet;
import java.util.Set;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "designations")
@Getter
@Setter
public class Designation extends Root{

  @Column(name = "name", nullable = false, unique = true)
  private String name;

  @Column(name = "description")
  private String description;

  @OneToMany(mappedBy = "designation", fetch = FetchType.LAZY)
  private Set<Employee> employees = new HashSet<>();
}
