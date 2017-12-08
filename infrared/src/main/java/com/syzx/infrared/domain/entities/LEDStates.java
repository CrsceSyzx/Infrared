/**
  * Copyright 2017 bejson.com 
  */
package com.syzx.infrared.domain.entities;
import java.util.List;

/**
 * Auto-generated: 2017-12-08 13:4:45
 *
 * @author bejson.com (i@bejson.com)
 * @website http://www.bejson.com/java2pojo/
 */
public class LEDStates {

    private List<LEDPortStates> ports;
    private int ua_green;
    private int ua_red;
    private int us_green;
    private int bfms_green;
    private int bfms_red;
    private int dians_green;
    private int dians_red;
    private int p1;
    private int p2;
    public void setPorts(List<LEDPortStates> ports) {
         this.ports = ports;
     }
     public List<LEDPortStates> getPorts() {
         return ports;
     }

    public void setUa_green(int ua_green) {
         this.ua_green = ua_green;
     }
     public int getUa_green() {
         return ua_green;
     }

    public void setUa_red(int ua_red) {
         this.ua_red = ua_red;
     }
     public int getUa_red() {
         return ua_red;
     }

    public void setUs_green(int us_green) {
         this.us_green = us_green;
     }
     public int getUs_green() {
         return us_green;
     }

    public void setBfms_green(int bfms_green) {
         this.bfms_green = bfms_green;
     }
     public int getBfms_green() {
         return bfms_green;
     }

    public void setBfms_red(int bfms_red) {
         this.bfms_red = bfms_red;
     }
     public int getBfms_red() {
         return bfms_red;
     }

    public void setDians_green(int dians_green) {
         this.dians_green = dians_green;
     }
     public int getDians_green() {
         return dians_green;
     }

    public void setDians_red(int dians_red) {
         this.dians_red = dians_red;
     }
     public int getDians_red() {
         return dians_red;
     }

    public void setP1(int p1) {
         this.p1 = p1;
     }
     public int getP1() {
         return p1;
     }

    public void setP2(int p2) {
         this.p2 = p2;
     }
     public int getP2() {
         return p2;
     }

}