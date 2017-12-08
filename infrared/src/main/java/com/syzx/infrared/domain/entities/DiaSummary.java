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
public class DiaSummary {

    private List<ModuleRelatedDiagnosis> device;
    private List<ModuleRelatedDiagnosis> master;
    private List<Boolean> ports;
    public void setDevice(List<ModuleRelatedDiagnosis> device) {
         this.device = device;
     }
     public List<ModuleRelatedDiagnosis> getDevice() {
         return device;
     }

    public void setMaster(List<ModuleRelatedDiagnosis> master) {
         this.master = master;
     }
     public List<ModuleRelatedDiagnosis> getMaster() {
         return master;
     }

    public void setPorts(List<Boolean> ports) {
         this.ports = ports;
     }
     public List<Boolean> getPorts() {
         return ports;
     }

}