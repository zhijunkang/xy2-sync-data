package com.xy2.entity;


public class RewardHall {

  private String id;
  private String goodstable;
  private String goodnum;
  private String goodprice;
  private String roleId;
  private java.sql.Timestamp throwtime;


  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }


  public String getGoodstable() {
    return goodstable;
  }

  public void setGoodstable(String goodstable) {
    this.goodstable = goodstable;
  }


  public String getGoodnum() {
    return goodnum;
  }

  public void setGoodnum(String goodnum) {
    this.goodnum = goodnum;
  }


  public String getGoodprice() {
    return goodprice;
  }

  public void setGoodprice(String goodprice) {
    this.goodprice = goodprice;
  }


  public String getRoleId() {
    return roleId;
  }

  public void setRoleId(String roleId) {
    this.roleId = roleId;
  }


  public java.sql.Timestamp getThrowtime() {
    return throwtime;
  }

  public void setThrowtime(java.sql.Timestamp throwtime) {
    this.throwtime = throwtime;
  }

}
