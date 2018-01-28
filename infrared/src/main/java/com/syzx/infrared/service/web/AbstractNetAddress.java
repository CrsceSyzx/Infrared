/**
 * Project Name:Infrared
 * File Name:AbstractNetAddress.java
 * Package Name:com.syzx.infrared.service
 * Date:2017年12月31日下午12:00:56
 * Copyright (c) 2017, syzx.com All Rights Reserved.
 *
 */
package com.syzx.infrared.service.web;

/**
 * ClassName: AbstractNetAddress <br/>
 * Function: TODO 描述类的功能. <br/>
 * date: 2017年12月31日 下午12:00:56 <br/>
 *
 * @author Zxy
 * @version 
 * @since JDK 1.8
 */
public abstract class AbstractNetAddress {

    private static final String ipPlaceholder = "____IP____";
    private static final String portPlaceholder = "____PORT____";
    private static final String urlTemplate = "http://" + ipPlaceholder + "/r/ioldetails.lr?port=" + portPlaceholder;

    protected String generateUrl(String ip, int port) {
        return urlTemplate.replace(ipPlaceholder, ip).replace(portPlaceholder, port + "");
    }
}