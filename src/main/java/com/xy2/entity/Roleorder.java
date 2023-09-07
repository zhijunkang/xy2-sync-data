package com.xy2.entity;


public class Roleorder {

  private String orderid;
  private String saleid;
  private java.sql.Timestamp buytime;
  private String status;
  private String roleid;
  private String ordernumber;


  public String getOrderid() {
    return orderid;
  }

  public void setOrderid(String orderid) {
    this.orderid = orderid;
  }


  public String getSaleid() {
    return saleid;
  }

  public void setSaleid(String saleid) {
    this.saleid = saleid;
  }


  public java.sql.Timestamp getBuytime() {
    return buytime;
  }

  public void setBuytime(java.sql.Timestamp buytime) {
    this.buytime = buytime;
  }


  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }


  public String getRoleid() {
    return roleid;
  }

  public void setRoleid(String roleid) {
    this.roleid = roleid;
  }


  public String getOrdernumber() {
    return ordernumber;
  }

  public void setOrdernumber(String ordernumber) {
    this.ordernumber = ordernumber;
  }

}
