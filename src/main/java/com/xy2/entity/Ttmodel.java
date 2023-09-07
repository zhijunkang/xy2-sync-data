package com.xy2.entity;


public class Ttmodel {

  private String starthour;
  private String endhour;
  private String startminute;
  private String endminute;
  private java.sql.Date seasonstarttime;
  private java.sql.Date seasonendtime;
  private String currentseason;
  private String isopen;


  public String getStarthour() {
    return starthour;
  }

  public void setStarthour(String starthour) {
    this.starthour = starthour;
  }


  public String getEndhour() {
    return endhour;
  }

  public void setEndhour(String endhour) {
    this.endhour = endhour;
  }


  public String getStartminute() {
    return startminute;
  }

  public void setStartminute(String startminute) {
    this.startminute = startminute;
  }


  public String getEndminute() {
    return endminute;
  }

  public void setEndminute(String endminute) {
    this.endminute = endminute;
  }


  public java.sql.Date getSeasonstarttime() {
    return seasonstarttime;
  }

  public void setSeasonstarttime(java.sql.Date seasonstarttime) {
    this.seasonstarttime = seasonstarttime;
  }


  public java.sql.Date getSeasonendtime() {
    return seasonendtime;
  }

  public void setSeasonendtime(java.sql.Date seasonendtime) {
    this.seasonendtime = seasonendtime;
  }


  public String getCurrentseason() {
    return currentseason;
  }

  public void setCurrentseason(String currentseason) {
    this.currentseason = currentseason;
  }


  public String getIsopen() {
    return isopen;
  }

  public void setIsopen(String isopen) {
    this.isopen = isopen;
  }

}
