package com.syzx.infrared.domain.entities;

import java.util.List;

/**
 * Auto-generated: 2017-12-08 13:4:45
 *
 * @author bejson.com (i@bejson.com)
 * @website http://www.bejson.com/java2pojo/
 */
public class Force {

    private boolean forceon;
    private boolean forcelock;
    private List<Boolean> port_forced;
    private List<Integer> force_do;
    private List<Integer> mask_do;
    private List<Integer> force_di;
    private List<Integer> mask_di;

    public void setForceon(boolean forceon) {
        this.forceon = forceon;
    }

    public boolean getForceon() {
        return forceon;
    }

    public void setForcelock(boolean forcelock) {
        this.forcelock = forcelock;
    }

    public boolean getForcelock() {
        return forcelock;
    }

    public void setPort_forced(List<Boolean> port_forced) {
        this.port_forced = port_forced;
    }

    public List<Boolean> getPort_forced() {
        return port_forced;
    }

    public void setForce_do(List<Integer> force_do) {
        this.force_do = force_do;
    }

    public List<Integer> getForce_do() {
        return force_do;
    }

    public void setMask_do(List<Integer> mask_do) {
        this.mask_do = mask_do;
    }

    public List<Integer> getMask_do() {
        return mask_do;
    }

    public void setForce_di(List<Integer> force_di) {
        this.force_di = force_di;
    }

    public List<Integer> getForce_di() {
        return force_di;
    }

    public void setMask_di(List<Integer> mask_di) {
        this.mask_di = mask_di;
    }

    public List<Integer> getMask_di() {
        return mask_di;
    }

}