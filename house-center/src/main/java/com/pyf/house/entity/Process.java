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

@Table(name = "process")
@Entity
@Data
public class Process implements Serializable {
  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id", insertable = false, nullable = false)
  private Integer id;

  @Column(name = "area", nullable = false)
  private String area;

  @Column(name = "pageNo")
  private Integer pageNo = 0;

  @Column(name = "finished")
  private Integer finished = 0;

  /**
   * 1:在售房源任务类别; 2:已成交房源任务类别
   */
  @Column(name = "type", nullable = false)
  private Integer type = 1;

  @Column(name = "createtime")
  private Date createtime;

  @Column(name = "finishtime")
  private Date finishtime;

  
}