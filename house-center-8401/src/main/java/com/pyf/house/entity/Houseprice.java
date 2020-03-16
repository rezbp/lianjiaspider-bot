package com.pyf.house.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

@Table(name = "houseprice")
@Entity
@Data
public class Houseprice implements Serializable {
  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id", insertable = false, nullable = false)
  private Long id;

  @Column(name = "code", nullable = false)
  private String code;

  @Column(name = "price", nullable = false)
  private Double price;

  @Column(name = "date")
  private Date date;

  
}