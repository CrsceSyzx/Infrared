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
public class IOL {

    private int port;
    private int vendor_id;
    private int device_id;
    private List<String> serial;
    private IOLData data;
    private ModuleRelatedDiagnosis dia;
    public void setPort(int port) {
         this.port = port;
     }
     public int getPort() {
         return port;
     }

    public void setVendor_id(int vendor_id) {
         this.vendor_id = vendor_id;
     }
     public int getVendor_id() {
         return vendor_id;
     }

    public void setDevice_id(int device_id) {
         this.device_id = device_id;
     }
     public int getDevice_id() {
         return device_id;
     }

    public void setSerial(List<String> serial) {
         this.serial = serial;
     }
     public List<String> getSerial() {
         return serial;
     }

    public void setData(IOLData data) {
         this.data = data;
     }
     public IOLData getData() {
         return data;
     }

    public void setDia(ModuleRelatedDiagnosis dia) {
         this.dia = dia;
     }
     public ModuleRelatedDiagnosis getDia() {
         return dia;
     }

}