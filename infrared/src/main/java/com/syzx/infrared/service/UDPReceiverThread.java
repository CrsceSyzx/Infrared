/**
 * Project Name:Infrared
 * File Name:UDPReceiverThread.java
 * Package Name:com.syzx.infrared.service
 * Date:2018年1月2日上午10:37:04
 * Copyright (c) 2018, syzx.com All Rights Reserved.
 *
 */
package com.syzx.infrared.service;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

import com.syzx.infrared.domain.dto.UDPMessage;
import com.syzx.infrared.infrastructure.AbstractTimer;
import com.syzx.infrared.infrastructure.TimerEventArgs;
import com.syzx.infrared.service.web.SocketAddress;

/**
 * ClassName: UDPReceiverThread <br/>
 * Function: TODO 描述类的功能. <br/>
 * date: 2018年1月2日 上午10:37:04 <br/>
 *
 * @author Zxy
 * @version 
 * @since JDK 1.8
 */
public class UDPReceiverThread extends AbstractTimer {

    private static final int BUFFER_SIZE = 1024 * 4;

    private DatagramSocket socket;
    //private ConcurrentLinkedQueue<UDPMessage> receiveMessageQueue;
    private int port;

    /**
     *创建一个UDPReceiverThread的实例.
     *
     * @param port
     * @param receiveMessageQueue 
     */

    public UDPReceiverThread(int port) {
        super();
        this.port = port;
        //this.receiveMessageQueue = receiveMessageQueue;
    }

    /**
     * 获取 port.
     *
     * @return  port
     * @since   JDK 1.8
     */
    public int getPort() {
        return port;
    }

    /**
     * 设置 port.
     *
     * @param   port
     * @since   JDK 1.8
     */
    public void setPort(int port) {
        this.port = port;
    }

    /**
     * TODO 简单描述该方法的实现功能（可选）.
     * @see com.syzx.infrared.infrastructure.AbstractTimer#beforeAction()
     */
    @Override
    public void beforeAction() {
        try {
            socket = new DatagramSocket(port);
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
        byte[] receiveMessage = new byte[BUFFER_SIZE];
        DatagramPacket packet = new DatagramPacket(receiveMessage, receiveMessage.length);
        try {
            socket.receive(packet);
        } catch (IOException e) {
            e.printStackTrace();
        }

        UDPMessage uDPMessage = new UDPMessage(
                new SocketAddress(packet.getAddress().getHostAddress(), packet.getPort()), receiveMessage);

        setTimerEventArgs(new TimerEventArgs(uDPMessage));
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