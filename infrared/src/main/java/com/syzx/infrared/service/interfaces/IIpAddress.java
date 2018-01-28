/**
 * Project Name:Infrared
 * File Name:IIpAddress.java
 * Package Name:com.syzx.infrared.service.interfaces
 * Date:2017年12月31日上午11:51:05
 * Copyright (c) 2017, syzx.com All Rights Reserved.
 *
 */
package com.syzx.infrared.service.interfaces;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * ClassName: IIpAddress <br/>
 * Function: TODO 描述类的功能. <br/>
 * date: 2017年12月31日 上午11:51:05 <br/>
 *
 * @author Zxy
 * @version 
 * @since JDK 1.8
 */
public interface IIpAddress {

    public String getIp();

    public ISocketAddress generateSocketAddress(int port);

    public InetAddress toInetAddress() throws UnknownHostException;
}