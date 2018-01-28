package com.syzx.infrared.domain.entities;

import java.util.List;

/**
 * Auto-generated: 2017-12-08 13:4:45
 *
 * @author bejson.com (i@bejson.com)
 * @website http://www.bejson.com/java2pojo/
 */
public class CyclicData {

    private List<Integer> din;
    private int din_valid;
    private int din_comm;
    private List<Integer> dout;
    private int dout_comm;

    public void setDin(List<Integer> din) {
        this.din = din;
    }

    public List<Integer> getDin() {
        return din;
    }

    public void setDin_valid(int din_valid) {
        this.din_valid = din_valid;
    }

    public int getDin_valid() {
        return din_valid;
    }

    public void setDin_comm(int din_comm) {
        this.din_comm = din_comm;
    }

    public int getDin_comm() {
        return din_comm;
    }

    public void setDout(List<Integer> dout) {
        this.dout = dout;
    }

    public List<Integer> getDout() {
        return dout;
    }

    public void setDout_comm(int dout_comm) {
        this.dout_comm = dout_comm;
    }

    public int getDout_comm() {
        return dout_comm;
    }

}