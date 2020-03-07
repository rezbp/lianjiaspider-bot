package com.pyf.housedbes.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

@Table(name = "httpproxy")
@Data
@Entity
public class Httpproxy implements Serializable {
  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id", insertable = false, nullable = false)
  private Integer id;

  @Column(name = "host", nullable = false)
  private String host;

  @Column(name = "port", nullable = false)
  private Integer port;

  @Column(name = "location")
  private String location;

  /**
   * -1已失效;0未使用;1已使用
   */
  @Column(name = "status", nullable = false)
  private Integer status = 0;

  @Column(name = "createtime")
  private Date createtime;

  
}