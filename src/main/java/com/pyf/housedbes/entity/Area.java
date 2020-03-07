package com.pyf.housedbes.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

@Table(name = "area")
@Data
@Entity
public class Area implements Serializable {
  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id", insertable = false, nullable = false)
  private Integer id;

  @Column(name = "name", nullable = false)
  private String name;

  @Column(name = "code", nullable = false)
  private String code = "";

  @Column(name = "link")
  private String link;

  @Column(name = "parentsId")
  private Integer parentsId = 0;

  @Column(name = "parentsName")
  private String parentsName;

  @Column(name = "parentsCode")
  private String parentsCode;

  @Column(name = "level")
  private Integer level = 0;

  
}