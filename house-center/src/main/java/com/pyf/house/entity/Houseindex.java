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

@Data
@Entity
@Table(name = "houseindex")
public class Houseindex implements Serializable {
  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id", insertable = false, nullable = false)
  private Long id;

  @Column(name = "code", nullable = false)
  private String code;

  @Column(name = "url", nullable = false)
  private String url;

  /**
   * -1:已下架；0:未拉取；1:已拉取；
   */
  @Column(name = "status")
  private Integer status = 0;

  @Column(name = "createtime")
  private Date createtime;

  @Column(name = "updatetime")
  private Date updatetime;

  @Column(name = "lastcheckdate")
  private Date lastcheckdate;

  @Column(name = "hasdetail")
  private Integer hasdetail = 0;

  
}