/**
 * Project Name:Infrared
 * File Name:UDPClient.java
 * Package Name:com.syzx.infrared.service
 * Date:2018年1月2日下午10:32:36
 * Copyright (c) 2018, syzx.com All Rights Reserved.
 *
 */
package com.syzx.infrared.service;

import java.util.concurrent.ConcurrentLinkedQueue;

import com.syzx.infrared.domain.ApplicationConfig;
import com.syzx.infrared.domain.dto.DataFrame;
import com.syzx.infrared.domain.dto.DataFrameType;
import com.syzx.infrared.domain.dto.UDPMessage;
import com.syzx.infrared.infrastructure.TimerEventArgs;
import com.syzx.infrared.infrastructure.interfaces.ITimerEventHandler;
import com.syzx.infrared.service.interfaces.ISocketAddress;
import com.syzx.infrared.service.web.IpAddress;

/**
 * ClassName: UDPClient <br/>
 * Function: TODO 描述类的功能. <br/>
 * date: 2018年1月2日 下午10:32:36 <br/>
 *
 * @author Zxy
 * @version 
 * @since JDK 1.8
 */
public class UDPClient {
    private DataForwardThread dataForwardThread;
    private UDPReceiverThread receiveThread;
    private UDPSenderThread sendThread;
    private UDPHeartThread heartThread;
    private ConcurrentLinkedQueue<UDPMessage> senderMessageQueue;
    private ISocketAddress serverAddress;

    public UDPClient(String kilometerMark, ISocketAddress serverAddress) {
        this.serverAddress = serverAddress;
        this.senderMessageQueue = new ConcurrentLinkedQueue<UDPMessage>();

        receiveThread = new UDPReceiverThread(serverAddress.getPort());
        receiveThread.setCycleFinishedEventHandler(new UDPClientReceiverHandler());

        sendThread = new UDPSenderThread(senderMessageQueue);
        heartThread = new UDPHeartThread(kilometerMark, serverAddress, senderMessageQueue,
                ApplicationConfig.getInstance().getHeartInterval());

        dataForwardThread = new DataForwardThread(new IpAddress(ApplicationConfig.getInstance().getMonitorIp()),
                kilometerMark);
        dataForwardThread.setCycleFinishedEventHandler(new UDPClientForwardHandler());
    }

    public void start() {
        heartThread.start();
        dataForwardThread.start();
        receiveThread.start();
        sendThread.start();
    }

    public void stop() {
        dataForwardThread.stopTimer();
        receiveThread.stopTimer();
        sendThread.stopTimer();
        heartThread.stopTimer();
    }

    /**
     * 
     * ClassName: UDPServerReceiverHandler <br/>
     * Function: TODO 描述类的功能. <br/>
     * date: 2018年1月3日 下午11:09:47 <br/>
     *
     * @author Zxy
     * @version UDPClient
     * @since JDK 1.8
     */
    class UDPClientReceiverHandler implements ITimerEventHandler {

        /**
         * TODO 简单描述该方法的实现功能（可选）.
         * @see com.syzx.infrared.infrastructure.interfaces.ITimerEventHandler#doEventHandler(java.lang.Object, com.syzx.infrared.infrastructure.TimerEventArgs)
         */
        public void doEventHandler(Object sender, TimerEventArgs e) {
            DataFrame dataFrame = ((UDPMessage) e.getTimerData()).getDataFrame();

            if (DataFrameType.START.equals(dataFrame.getType())) {
                dataForwardThread.start();
            } else if (DataFrameType.STOP.equals(dataFrame.getType())) {
                dataForwardThread.stopTimer();
            }
        }

    }

    /**
     * 
     * ClassName: UDPClientForwardHandler <br/>
     * Function: TODO 描述类的功能. <br/>
     * date: 2018年1月3日 下午11:41:30 <br/>
     *
     * @author Zxy
     * @version UDPClient
     * @since JDK 1.8
     */
    class UDPClientForwardHandler implements ITimerEventHandler {

        /**
         * TODO 简单描述该方法的实现功能（可选）.
         * @see com.syzx.infrared.infrastructure.interfaces.ITimerEventHandler#doEventHandler(java.lang.Object, com.syzx.infrared.infrastructure.TimerEventArgs)
         */
        public void doEventHandler(Object sender, TimerEventArgs e) {
            senderMessageQueue.add(new UDPMessage(serverAddress, (DataFrame) e.getTimerData()));
        }

    }

    /**
     * 
     * ClassName: UDPClientHeartHandler <br/>
     * Function: TODO 描述类的功能. <br/>
     * date: 2018年1月17日 下午1:32:46 <br/>
     *
     * @author Zxy
     * @version UDPClient
     * @since JDK 1.8
     */
    class UDPClientHeartHandler implements ITimerEventHandler {

        /**
         * TODO 简单描述该方法的实现功能（可选）.
         * @see com.syzx.infrared.infrastructure.interfaces.ITimerEventHandler#doEventHandler(java.lang.Object, com.syzx.infrared.infrastructure.TimerEventArgs)
         */
        public void doEventHandler(Object sender, TimerEventArgs e) {
            senderMessageQueue.add(new UDPMessage(serverAddress, (DataFrame) e.getTimerData()));
        }

    }
}