/**
 * Project Name:Infrared
 * File Name:IWebDataTransceiver.java
 * Package Name:com.syzx.infrared.web
 * Date:2017年12月7日下午4:30:28
 * Copyright (c) 2017, syzx.com All Rights Reserved.
 *
 */
package com.syzx.infrared.service.interfaces;

import java.io.IOException;
import java.net.MalformedURLException;

/**
 * ClassName: IDataTransceiver <br/>
 * Function: 数据收发器. <br/>
 * date: 2017年12月7日 下午4:30:28 <br/>
 *
 * @author Zxy
 * @version 
 * @since JDK 1.8
 */
public interface IDataTransceiver {
    public byte[] ReceiveData(String url) throws MalformedURLException, IOException;
}
