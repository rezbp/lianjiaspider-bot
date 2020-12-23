package com.pyf.house.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

@Data
@Table(name = "house")
@Entity
public class House implements Serializable {
  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id", insertable = false, nullable = false)
  private Long id;

  @Column(name = "code", nullable = false)
  private String code;

  @Column(name = "url", nullable = false)
  private String url;

  @Column(name = "title")
  private String title;

  @Column(name = "subtitle")
  private String subtitle;

  @Column(name = "favcount")
  private Integer favcount;

  @Column(name = "cartcount")
  private Integer cartcount;

  @Column(name = "price")
  private BigDecimal price;

  @Column(name = "unitprice")
  private BigDecimal unitprice;

  @Column(name = "firstPayPrice")
  private BigDecimal firstPayPrice;

  @Column(name = "taxPrice")
  private BigDecimal taxPrice;

  @Column(name = "roomMainInfo")
  private String roomMainInfo;

  @Column(name = "roomSubInfo")
  private String roomSubInfo;

  @Column(name = "roomMainType")
  private String roomMainType;

  @Column(name = "roomSubType")
  private String roomSubType;

  @Column(name = "areaMainInfo")
  private String areaMainInfo;

  @Column(name = "areaSubInfo")
  private String areaSubInfo;

  @Column(name = "communityName")
  private String communityName;

  @Column(name = "areaName")
  private String areaName;

  @Column(name = "schoolName")
  private String schoolName;

  @Column(name = "tags")
  private String tags;

  @Column(name = "decoratingDesc")
  private String decoratingDesc;

  @Column(name = "houseTypeDesc")
  private String houseTypeDesc;

  @Column(name = "investmentDesc")
  private String investmentDesc;

  @Column(name = "villageDesc")
  private String villageDesc;

  @Column(name = "schoolDesc")
  private String schoolDesc;

  @Column(name = "sellingPointDesc")
  private String sellingPointDesc;

  @Column(name = "reason4saleDesc")
  private String reason4saleDesc;

  @Column(name = "supportingDesc")
  private String supportingDesc;

  @Column(name = "trafficDesc")
  private String trafficDesc;

  @Column(name = "createtime")
  private Date createtime;

  @Column(name = "baseContent1")
  private String baseContent1;

  @Column(name = "baseContent2")
  private String baseContent2;

  @Column(name = "baseContent3")
  private String baseContent3;

  @Column(name = "baseContent4")
  private String baseContent4;

  @Column(name = "baseContent5")
  private String baseContent5;

  @Column(name = "baseContent6")
  private String baseContent6;

  @Column(name = "baseContent7")
  private String baseContent7;

  @Column(name = "baseContent8")
  private String baseContent8;

  @Column(name = "baseContent9")
  private String baseContent9;

  @Column(name = "baseContent10")
  private String baseContent10;

  @Column(name = "baseContent11")
  private String baseContent11;

  @Column(name = "baseContent12")
  private String baseContent12;

  @Column(name = "transactionContent1")
  private String transactionContent1;

  @Column(name = "transactionContent2")
  private String transactionContent2;

  @Column(name = "transactionContent3")
  private String transactionContent3;

  @Column(name = "transactionContent4")
  private String transactionContent4;

  @Column(name = "transactionContent5")
  private String transactionContent5;

  @Column(name = "transactionContent6")
  private String transactionContent6;

  @Column(name = "transactionContent7")
  private String transactionContent7;

  @Column(name = "transactionContent8")
  private String transactionContent8;

  @Column(name = "transactionContent9")
  private String transactionContent9;

  @Column(name = "transactionContent10")
  private String transactionContent10;

  @Column(name = "html")
  private String html;

  @Column(name = "roomSize")
  private Double roomSize;

  /**
   * 1:在售；2:已成交;-1:已下架
   */
  @Column(name = "status")
  private Integer status = 1;

  /**
   * 成交价
   */
  @Column(name = "chengjiaoPrice")
  private Double chengjiaoPrice;

  @Column(name = "chengjiaoDate")
  private Date chengjiaoDate;

  
}