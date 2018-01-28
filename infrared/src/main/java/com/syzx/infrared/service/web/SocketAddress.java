/**
 * Project Name:Infrared
 * File Name:SocketAddress.java
 * Package Name:com.syzx.infrared.service
 * Date:2017年12月31日下午1:29:32
 * Copyright (c) 2017, syzx.com All Rights Reserved.
 *
 */
package com.syzx.infrared.service.web;

import java.net.InetSocketAddress;

import com.syzx.infrared.service.interfaces.ISocketAddress;

/**
 * ClassName: SocketAddress <br/>
 * Function: TODO 描述类的功能. <br/>
 * date: 2017年12月31日 下午1:29:32 <br/>
 *
 * @author Zxy
 * @version 
 * @since JDK 1.8
 */
public class SocketAddress extends AbstractNetAddress implements ISocketAddress {

    private String ip;
    private int port;

    /**
     *创建一个NetSocketAddress的实例.
     *
     * @param ip
     */

    public SocketAddress(String ip, int port) {
        this.ip = ip;
        this.port = port;
    }

    /**
     * TODO 简单描述该方法的实现功能（可选）.
     * @see com.syzx.infrared.service.web.AbstractNetAddress#getPort()
     */
    public int getPort() {
        return port;
    }

    /**
     * TODO 简单描述该方法的实现功能（可选）.
     * @see com.syzx.infrared.service.web.AbstractNetAddress#toInetSocketAddress()
     */
    public InetSocketAddress toInetSocketAddress() {
        return new InetSocketAddress(getIp(), getPort());
    }

    /**
     * TODO 简单描述该方法的实现功能（可选）.
     * @see com.syzx.infrared.service.interfaces.ISocketAddress#generateUrl()
     */
    public String generateUrl() {
        return generateUrl(ip, port);
    }

    /**
     * TODO 简单描述该方法的实现功能（可选）.
     * @see com.syzx.infrared.service.interfaces.ISocketAddress#getIp()
     */
    public String getIp() {
        return ip;
    }

}