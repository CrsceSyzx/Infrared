/**
 * Project Name:Infrared
 * File Name:UDPSenderThread.java
 * Package Name:com.syzx.infrared.service
 * Date:2018年1月2日上午9:41:56
 * Copyright (c) 2018, syzx.com All Rights Reserved.
 *
 */
package com.syzx.infrared.service;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.util.concurrent.ConcurrentLinkedQueue;

import com.syzx.infrared.domain.dto.UDPMessage;
import com.syzx.infrared.infrastructure.AbstractTimer;

/**
 * ClassName: UDPSenderThread <br/>
 * Function: TODO 描述类的功能. <br/>
 * date: 2018年1月2日 上午9:41:56 <br/>
 *
 * @author Zxy
 * @version 
 * @since JDK 1.8
 */
public class UDPSenderThread extends AbstractTimer {

    private DatagramSocket socket;
    private ConcurrentLinkedQueue<UDPMessage> senderMessageQueue;

    /**
     *创建一个UDPSenderThread的实例.
     *
     * @param messageQueue
     */

    public UDPSenderThread(ConcurrentLinkedQueue<UDPMessage> senderMessageQueue) {
        super(10);
        this.senderMessageQueue = senderMessageQueue;
    }

    /**
     * TODO 简单描述该方法的实现功能（可选）.
     * @see com.syzx.infrared.infrastructure.AbstractTimer#beforeAction()
     */
    @Override
    public void beforeAction() {
        try {
            socket = new DatagramSocket();
        } catch (SocketException e) {
            e.printStackTrace();
        }
    }

    /**
     * TODO 简单描述该方法的实现功能（可选）.
     * @see com.syzx.infrared.infrastructure.AbstractTimer#action()
     */
    @Override
    public void action() {
        if (!senderMessageQueue.isEmpty()) {
            UDPMessage uDPMessage = senderMessageQueue.remove();
            DatagramPacket dataPacket = new DatagramPacket(uDPMessage.getMessage(), uDPMessage.getMessageLength(),
                    uDPMessage.getSocketAddress());
            try {
                socket.send(dataPacket);
            } catch (SocketException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

            System.out.println("sendTo:" + dataPacket.getAddress().getHostAddress() + ":" + dataPacket.getPort() + " "
                    + new String(dataPacket.getData()));
        }
    }

    /**
     * TODO 简单描述该方法的实现功能（可选）.
     * @see com.syzx.infrared.infrastructure.AbstractTimer#releaseResource()
     */
    @Override
    public void releaseResource() {
        socket.close();
    }
}