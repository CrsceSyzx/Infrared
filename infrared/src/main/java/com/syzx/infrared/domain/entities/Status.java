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
public class Status {

    private CyclicData cyclic;
    private Config config;
    private DiaSummary dia;
    private LEDStates leds;
    private List<Integer> rotarys;
    private Force forcing;
    private boolean bus_on;
    private byte type;
    public void setCyclic(CyclicData cyclic) {
         this.cyclic = cyclic;
     }
     public CyclicData getCyclic() {
         return cyclic;
     }

    public void setConfig(Config config) {
         this.config = config;
     }
     public Config getConfig() {
         return config;
     }

    public void setDia(DiaSummary dia) {
         this.dia = dia;
     }
     public DiaSummary getDia() {
         return dia;
     }

    public void setLeds(LEDStates leds) {
         this.leds = leds;
     }
     public LEDStates getLeds() {
         return leds;
     }

    public void setRotarys(List<Integer> rotarys) {
         this.rotarys = rotarys;
     }
     public List<Integer> getRotarys() {
         return rotarys;
     }

    public void setForcing(Force forcing) {
         this.forcing = forcing;
     }
     public Force getForcing() {
         return forcing;
     }

    public void setBus_on(boolean bus_on) {
         this.bus_on = bus_on;
     }
     public boolean getBus_on() {
         return bus_on;
     }

    public void setType(byte type) {
         this.type = type;
     }
     public byte getType() {
         return type;
     }

}