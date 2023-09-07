package com.xy2.entity;


public class Managertable {

  private String manaeid;
  private String username;
  private String pwd;
  private String relname;
  private java.sql.Date createtime;
  private String flag;


  public String getManaeid() {
    return manaeid;
  }

  public void setManaeid(String manaeid) {
    this.manaeid = manaeid;
  }


  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }


  public String getPwd() {
    return pwd;
  }

  public void setPwd(String pwd) {
    this.pwd = pwd;
  }


  public String getRelname() {
    return relname;
  }

  public void setRelname(String relname) {
    this.relname = relname;
  }


  public java.sql.Date getCreatetime() {
    return createtime;
  }

  public void setCreatetime(java.sql.Date createtime) {
    this.createtime = createtime;
  }


  public String getFlag() {
    return flag;
  }

  public void setFlag(String flag) {
    this.flag = flag;
  }

}
