/**
 * Project Name:Infrared
 * File Name:WebDataTransceiver.java
 * Package Name:com.syzx.infrared.web
 * Date:2017年12月7日下午4:26:05
 * Copyright (c) 2017, syzx.com All Rights Reserved.
 *
 */
package com.syzx.infrared.service;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import com.syzx.infrared.service.interfaces.IDataTransceiver;

/**
 * ClassName: WebDataTransceiver <br/>
 * Function: TODO 描述类的功能. <br/>
 * date: 2017年12月7日 下午4:26:05 <br/>
 *
 * @author Zxy
 * @version 
 * @since JDK 1.8
 */
public class WebDataTransceiver implements IDataTransceiver {

    /**
     * TODO 简单描述该方法的实现功能（可选）.
     * @throws IOException 
     * @throws MalformedURLException 
     * @see com.syzx.infrared.service.interfaces.IDataTransceiver#ReceiveData(java.lang.String)
     */
    public byte[] ReceiveData(String url) throws IOException {

        HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
        connection.setRequestMethod("GET");
        connection.setConnectTimeout(5 * 1000);

        InputStream inStream = connection.getInputStream();
        ByteArrayOutputStream outStream = new ByteArrayOutputStream();
        byte[] buffer = new byte[1204];
        int readLength = 0;
        do {
            readLength = inStream.read(buffer);
            if (readLength == -1) {
                break;
            } else {
                outStream.write(buffer, 0, readLength);
            }
        } while (true);
        inStream.close();
        return outStream.toByteArray();
    }

}
