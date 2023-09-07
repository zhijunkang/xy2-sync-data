package com.xy2.entity;

import lombok.Data;

@Data
public class Appversion {

  private String verId;
  private String verUrl;
  private String verSign;


  public String getVerId() {
    return verId;
  }

  public void setVerId(String verId) {
    this.verId = verId;
  }


  public String getVerUrl() {
    return verUrl;
  }

  public void setVerUrl(String verUrl) {
    this.verUrl = verUrl;
  }


  public String getVerSign() {
    return verSign;
  }

  public void setVerSign(String verSign) {
    this.verSign = verSign;
  }

}
