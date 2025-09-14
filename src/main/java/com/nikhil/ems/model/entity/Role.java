package com.nikhil.ems.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import java.util.HashSet;
import java.util.Set;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "designations")
@Getter
@Setter
public class Role extends Root{

  @Column(name = "name", nullable = false, unique = true)
  private String name;

  @Column(name = "description")
  private String description;

  @ManyToMany(mappedBy = "roles", fetch = FetchType.LAZY)
  private Set<Employee> employees = new HashSet<>();
}
