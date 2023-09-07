package com.xy2.entity;


public class Message {

  private String mesid;
  private String roleid;
  private String saleid;
  private String mescontent;
  private java.sql.Timestamp gettime;


  public String getMesid() {
    return mesid;
  }

  public void setMesid(String mesid) {
    this.mesid = mesid;
  }


  public String getRoleid() {
    return roleid;
  }

  public void setRoleid(String roleid) {
    this.roleid = roleid;
  }


  public String getSaleid() {
    return saleid;
  }

  public void setSaleid(String saleid) {
    this.saleid = saleid;
  }


  public String getMescontent() {
    return mescontent;
  }

  public void setMescontent(String mescontent) {
    this.mescontent = mescontent;
  }


  public java.sql.Timestamp getGettime() {
    return gettime;
  }

  public void setGettime(java.sql.Timestamp gettime) {
    this.gettime = gettime;
  }

}
