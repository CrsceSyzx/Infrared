/**
 * Project Name:Infrared
 * File Name:DataCollectionThread.java
 * Package Name:com.syzx.infrared.service
 * Date:2017年12月10日下午12:48:53
 * Copyright (c) 2017, syzx.com All Rights Reserved.
 *
 */
package com.syzx.infrared.service;

import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;

import com.syzx.infrared.domain.ApplicationConfig;
import com.syzx.infrared.domain.JsonCodec;
import com.syzx.infrared.domain.dto.DistanceDataUnit;
import com.syzx.infrared.domain.entities.InfraredSourceData;
import com.syzx.infrared.service.interfaces.IHttpManager;
import com.syzx.infrared.service.interfaces.ISocketAddress;
import com.syzx.infrared.service.web.HttpManager;
import com.syzx.infrared.service.web.HttpManagerMock;

/**
 * ClassName: DataCollectionThread <br/>
 * Function: TODO 描述类的功能. <br/>
 * date: 2017年12月10日 下午12:48:53 <br/>
 *
 * @author Zxy
 * @version 
 * @since JDK 1.8
 */
public class DataCollectionThread implements Runnable {

    private IHttpManager httpManager;
    //    private IDataConverter dataConverter;

    private String url;
    private int portIndex;
    private ConcurrentLinkedQueue<DistanceDataUnit> cache;

    /**
     * 
     *创建一个DataCollectionThread的实例.
     *
     * @param ip
     * @param port
     * @param isContinueRunning
     * @param interval
     */
    public DataCollectionThread(ISocketAddress socketAddress, ConcurrentLinkedQueue<DistanceDataUnit> cache) {
        if ("MOCK".equals(ApplicationConfig.getInstance().getWorkingMode().toUpperCase())) {
            this.httpManager = new HttpManagerMock();
        } else if ("REAL".equals(ApplicationConfig.getInstance().getWorkingMode().toUpperCase())) {
            this.httpManager = new HttpManager();
        }

        //        this.dataConverter = new WebDataConverter();

        this.portIndex = socketAddress.getPort();
        this.url = socketAddress.generateUrl();
        this.cache = cache;
    }

    /**
     * TODO 简单描述该方法的实现功能（可选）.
     * @see java.lang.Runnable#run()
     */
    public void run() {
        String receiveString = httpManager.httpGet(url);

        if (receiveString != null) {
            InfraredSourceData infraredSourceData = JsonCodec.toInfraredSourceData(receiveString);
            List<Integer> input = infraredSourceData.getIol().getData().getInput();
            cache.add(new DistanceDataUnit(portIndex, input.get(0) * 256 + input.get(1)));
        }
    }
}