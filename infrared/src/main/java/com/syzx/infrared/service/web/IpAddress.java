/**
 * Project Name:Infrared
 * File Name:IpAddress.java
 * Package Name:com.syzx.infrared.service
 * Date:2017年12月30日下午1:17:07
 * Copyright (c) 2017, syzx.com All Rights Reserved.
 *
 */
package com.syzx.infrared.service.web;

import java.net.InetAddress;
import java.net.UnknownHostException;

import com.syzx.infrared.service.interfaces.IIpAddress;
import com.syzx.infrared.service.interfaces.ISocketAddress;

/**
 * ClassName: IpAddress <br/>
 * Function: TODO 描述类的功能. <br/>
 * date: 2017年12月30日 下午1:17:07 <br/>
 *
 * @author Zxy
 * @version 
 * @since JDK 1.8
 */
public class IpAddress extends AbstractNetAddress implements IIpAddress {

    private String ip;

    /**
     *创建一个NetAddress的实例.
     *
     * @param hostname
     * @param port
     */

    public IpAddress(String ip) {
        this.ip = ip;
    }

    /**
     * 获取 ip.
     *
     * @return  ip
     * @since   JDK 1.8
     */
    public String getIp() {
        return ip;
    }

    /**
     * TODO 简单描述该方法的实现功能（可选）.
     * @throws UnknownHostException 
     * @see com.syzx.infrared.service.interfaces.IIpAddress#toInetAddress()
     */
    public InetAddress toInetAddress() throws UnknownHostException {
        return InetAddress.getByName(getIp());
    }

    /**
     * TODO 简单描述该方法的实现功能（可选）.
     * @see com.syzx.infrared.service.interfaces.IIpAddress#generateUrl(int)
     */
    public String generateUrl(int port) {
        return generateUrl(getIp(), port);
    }

    /**
     * TODO 简单描述该方法的实现功能（可选）.
     * @see com.syzx.infrared.service.interfaces.IIpAddress#generateSocketAddress(int)
     */
    public ISocketAddress generateSocketAddress(int port) {
        return (ISocketAddress) new SocketAddress(ip, port);
    }
}