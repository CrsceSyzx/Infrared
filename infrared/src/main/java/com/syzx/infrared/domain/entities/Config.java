package com.syzx.infrared.domain.entities;

import java.util.List;

/**
 * Auto-generated: 2017-12-08 13:4:45
 *
 * @author bejson.com (i@bejson.com)
 * @website http://www.bejson.com/java2pojo/
 */
public class Config {

    private List<PortConfig> ports;
    private int mappingMode;

    public void setPorts(List<PortConfig> ports) {
        this.ports = ports;
    }

    public List<PortConfig> getPorts() {
        return ports;
    }

    public void setMappingMode(int mappingMode) {
        this.mappingMode = mappingMode;
    }

    public int getMappingMode() {
        return mappingMode;
    }

}