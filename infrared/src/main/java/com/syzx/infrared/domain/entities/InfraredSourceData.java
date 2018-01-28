package com.syzx.infrared.domain.entities;

/**
 * 
 * ClassName: InfraredSourceData <br/>
 * Function: 红外测距原始数据. <br/>
 * date: 2018年1月2日 下午3:31:41 <br/>
 *
 * @author Zxy
 * @version 
 * @since JDK 1.8
 */
public class InfraredSourceData {

    private Status status;
    private IOL iol;

    public void setStatus(Status status) {
        this.status = status;
    }

    public Status getStatus() {
        return status;
    }

    public void setIol(IOL iol) {
        this.iol = iol;
    }

    public IOL getIol() {
        return iol;
    }

}