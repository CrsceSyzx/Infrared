/**
  * Copyright 2017 bejson.com 
  */
package com.syzx.infrared.domain.entities;

/**
 * Auto-generated: 2017-12-08 13:4:45
 *
 * @author bejson.com (i@bejson.com)
 * @website http://www.bejson.com/java2pojo/
 */
public class ModuleRelatedDiagnosis {

    private int state;
    private int type;
    private int code;
    private int alarm;
    private int iol_eventcode;
    private int iol_eventqual;
    private int iol_channel;
    public void setState(int state) {
         this.state = state;
     }
     public int getState() {
         return state;
     }

    public void setType(int type) {
         this.type = type;
     }
     public int getType() {
         return type;
     }

    public void setCode(int code) {
         this.code = code;
     }
     public int getCode() {
         return code;
     }

    public void setAlarm(int alarm) {
         this.alarm = alarm;
     }
     public int getAlarm() {
         return alarm;
     }

    public void setIol_eventcode(int iol_eventcode) {
         this.iol_eventcode = iol_eventcode;
     }
     public int getIol_eventcode() {
         return iol_eventcode;
     }

    public void setIol_eventqual(int iol_eventqual) {
         this.iol_eventqual = iol_eventqual;
     }
     public int getIol_eventqual() {
         return iol_eventqual;
     }

    public void setIol_channel(int iol_channel) {
         this.iol_channel = iol_channel;
     }
     public int getIol_channel() {
         return iol_channel;
     }

}