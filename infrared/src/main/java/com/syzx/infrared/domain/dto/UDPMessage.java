/**
 * Project Name:Infrared
 * File Name:UDPMessage.java
 * Package Name:com.syzx.infrared.service
 * Date:2018年1月2日上午9:47:24
 * Copyright (c) 2018, syzx.com All Rights Reserved.
 *
 */
package com.syzx.infrared.domain.dto;

import java.net.InetSocketAddress;

import com.syzx.infrared.domain.JsonCodec;
import com.syzx.infrared.service.interfaces.ISocketAddress;

/**
 * ClassName: UDPMessage <br/>
 * Function: TODO 描述类的功能. <br/>
 * date: 2018年1月2日 上午9:47:24 <br/>
 *
 * @author Zxy
 * @version 
 * @since JDK 1.8
 */
public class UDPMessage {
    private ISocketAddress socketAddress;
    private DataFrame dataFrame;
    private byte[] message;

    /**
     *创建一个UDPMessage的实例.
     *
     */

    public UDPMessage(ISocketAddress socketAddress, DataFrame dataFrame) {
        this.socketAddress = socketAddress;
        this.dataFrame = dataFrame;
        this.message = JsonCodec.toString(dataFrame).getBytes();
    }

    public UDPMessage(ISocketAddress socketAddress, byte[] message) {
        this.socketAddress = socketAddress;
        this.message = message;
        this.dataFrame = JsonCodec.toDataFrame(new String(message));
    }

    /**
     * 获取 socketAddress.
     *
     * @return  socketAddress
     * @since   JDK 1.8
     */
    public InetSocketAddress getSocketAddress() {
        return socketAddress.toInetSocketAddress();
    }

    /**
     * 获取 message.
     *
     * @return  message
     * @since   JDK 1.8
     */
    public byte[] getMessage() {
        return message;
    }

    public int getMessageLength() {
        return message.length;
    }

    /**
     * 获取 dataFrame.
     *
     * @return  dataFrame
     * @since   JDK 1.8
     */
    public DataFrame getDataFrame() {
        return dataFrame;
    }

}