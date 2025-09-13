package com.nikhil.ems.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "employees")
@Getter
@Setter
public class Employee extends Root {

  @Column(name = "name", nullable = false)
  private String name;

  @Column(name = "email", nullable = false, unique = true)
  private String email;

  @ManyToOne(optional = false, fetch = FetchType.EAGER)
  @JoinColumn(name = "department_id")
  private Department department;

  @ManyToOne(optional = false, fetch = FetchType.EAGER)
  @JoinColumn(name = "designation_id")
  private Designation designation;

  @Column(name = "password", nullable = false)
  private String password;
}
