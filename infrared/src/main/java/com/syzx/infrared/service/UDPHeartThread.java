/**
 * Project Name:Infrared
 * File Name:UDPHeartThread.java
 * Package Name:com.syzx.infrared.service
 * Date:2018年1月17日下午1:34:20
 * Copyright (c) 2018, syzx.com All Rights Reserved.
 *
 */
package com.syzx.infrared.service;

import java.util.concurrent.ConcurrentLinkedQueue;

import com.syzx.infrared.domain.dto.DataFrameFactory;
import com.syzx.infrared.domain.dto.DataFrameType;
import com.syzx.infrared.domain.dto.UDPMessage;
import com.syzx.infrared.infrastructure.AbstractTimer;
import com.syzx.infrared.service.interfaces.ISocketAddress;

/**
 * ClassName: UDPHeartThread <br/>
 * Function: TODO 描述类的功能. <br/>
 * date: 2018年1月17日 下午1:34:20 <br/>
 *
 * @author Zxy
 * @version 
 * @since JDK 1.8
 */
public class UDPHeartThread extends AbstractTimer {

    private ISocketAddress serverAddress;
    private ConcurrentLinkedQueue<UDPMessage> senderMessageQueue;
    private DataFrameFactory dataFrameFactory;

    public UDPHeartThread(String kilometerMark, ISocketAddress serverAddress,
            ConcurrentLinkedQueue<UDPMessage> senderMessageQueue, int interval) {
        super(interval);
        this.serverAddress = serverAddress;
        this.senderMessageQueue = senderMessageQueue;
        this.dataFrameFactory = new DataFrameFactory(kilometerMark);
    }

    /**
     * TODO 简单描述该方法的实现功能（可选）.
     * @see com.syzx.infrared.infrastructure.AbstractTimer#action()
     */
    @Override
    public void action() {
        senderMessageQueue.add(new UDPMessage(serverAddress, dataFrameFactory.getDataFrame(DataFrameType.HEART)));
    }

    /**
     * TODO 简单描述该方法的实现功能（可选）.
     * @see com.syzx.infrared.infrastructure.AbstractTimer#releaseResource()
     */
    @Override
    public void releaseResource() {
    }

}