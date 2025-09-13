package com.nikhil.ems.model.entity;

// this is a root class for all entities

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.Version;
import java.util.Date;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

@MappedSuperclass
public class Root {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @Column(name = "created_at")
  @CreatedDate
  private Date createdAt;

  @LastModifiedDate
  @Column(name = "updated_at")
  private Date updatedAt;

  @Version
  @Column(name = "version")
  private Integer version;

  @Column(name = "deleted")
  private  Boolean deleted;
}

