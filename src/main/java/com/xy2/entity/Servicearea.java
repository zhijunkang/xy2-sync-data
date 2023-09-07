package com.xy2.entity;


public class Servicearea {

  private String sid;
  private String sname;
  private java.sql.Date sdate;
  private String agents;
  private String dividedinto;
  private String manaeid;


  public String getSid() {
    return sid;
  }

  public void setSid(String sid) {
    this.sid = sid;
  }


  public String getSname() {
    return sname;
  }

  public void setSname(String sname) {
    this.sname = sname;
  }


  public java.sql.Date getSdate() {
    return sdate;
  }

  public void setSdate(java.sql.Date sdate) {
    this.sdate = sdate;
  }


  public String getAgents() {
    return agents;
  }

  public void setAgents(String agents) {
    this.agents = agents;
  }


  public String getDividedinto() {
    return dividedinto;
  }

  public void setDividedinto(String dividedinto) {
    this.dividedinto = dividedinto;
  }


  public String getManaeid() {
    return manaeid;
  }

  public void setManaeid(String manaeid) {
    this.manaeid = manaeid;
  }

}
