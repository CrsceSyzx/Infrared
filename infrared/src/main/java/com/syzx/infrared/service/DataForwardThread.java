/**
 * Project Name:Infrared
 * File Name:DataForwardThread.java
 * Package Name:com.syzx.infrared.service
 * Date:2017年12月30日上午8:18:51
 * Copyright (c) 2017, syzx.com All Rights Reserved.
 *
 */
package com.syzx.infrared.service;

import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.syzx.infrared.domain.dto.DataFrameFactory;
import com.syzx.infrared.domain.dto.DistanceDataUnit;
import com.syzx.infrared.infrastructure.AbstractTimer;
import com.syzx.infrared.infrastructure.TimerEventArgs;
import com.syzx.infrared.service.interfaces.IIpAddress;

/**
 * ClassName: DataForwardThread <br/>
 * Function: TODO 描述类的功能. <br/>
 * date: 2017年12月30日 上午8:18:51 <br/>
 *
 * @author Zxy
 * @version 
 * @since JDK 1.8
 */
public class DataForwardThread extends AbstractTimer {

    private final int SUBTHREAD_COUNT = 8;

    private ConcurrentLinkedQueue<DistanceDataUnit> distanceDataQueue;
    private DataFrameFactory distanceDataFactory;
    private IIpAddress monitorAddress;
    private ExecutorService executor;

    //    /**
    //     * 
    //     *创建一个DistanceMonitoringThread的实例.
    //     *
    //     * @param monitorAddress
    //     * @param forwardAddress
    //     * @param kilometerMark
    //     */
    //    public DataForwardThread(IIpAddress monitorAddress, String kilometerMark) {
    //        this(monitorAddress, kilometerMark, 1000);
    //    }

    /**
     *创建一个DistanceMonitoringThread的实例.
     *
     * @param monitorAddress
     * @param forwardAddress
     * @param kilometerMark
     * @param updateInterval
     */

    public DataForwardThread(IIpAddress monitorAddress, String kilometerMark) {
        super();
        this.monitorAddress = monitorAddress;
        distanceDataFactory = new DataFrameFactory(kilometerMark);
        executor = Executors.newFixedThreadPool(8);
    }

    private void createDataCollectionThread(int threadCount) {
        distanceDataQueue = new ConcurrentLinkedQueue<DistanceDataUnit>();

        for (int i = 0; i < threadCount; i++) {
            executor.execute(new DataCollectionThread(monitorAddress.generateSocketAddress(i), distanceDataQueue));
        }
    }

    /**
     * TODO 简单描述该方法的实现功能（可选）.
     * @see com.syzx.infrared.infrastructure.AbstractTimer#action()
     */
    public void action() {
        createDataCollectionThread(SUBTHREAD_COUNT);

        while (distanceDataQueue.size() < SUBTHREAD_COUNT) {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        setTimerEventArgs(new TimerEventArgs(distanceDataFactory.getDataFrame(distanceDataQueue)));
    }

    /**
     * TODO 简单描述该方法的实现功能（可选）.
     * @see com.syzx.infrared.infrastructure.AbstractTimer#releaseResource()
     */
    @Override
    public void releaseResource() {
    }
}