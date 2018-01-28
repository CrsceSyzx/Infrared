/**
 * Project Name:Infrared
 * File Name:ISocketAddress.java
 * Package Name:com.syzx.infrared.service.interfaces
 * Date:2017年12月31日下午2:06:28
 * Copyright (c) 2017, syzx.com All Rights Reserved.
 *
 */
package com.syzx.infrared.service.interfaces;

import java.net.InetSocketAddress;

/**
 * ClassName: ISocketAddress <br/>
 * Function: TODO 描述类的功能. <br/>
 * date: 2017年12月31日 下午2:06:28 <br/>
 *
 * @author Zxy
 * @version 
 * @since JDK 1.8
 */
public interface ISocketAddress {

    public String generateUrl();

    public String getIp();

    public int getPort();

    public InetSocketAddress toInetSocketAddress();
}