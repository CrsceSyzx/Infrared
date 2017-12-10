/**
 * Project Name:Infrared
 * File Name:EventThread.java
 * Package Name:com.syzx.infrared.service
 * Date:2017年12月10日下午12:48:53
 * Copyright (c) 2017, syzx.com All Rights Reserved.
 *
 */
package com.syzx.infrared.service;

import java.io.IOException;
import java.net.MalformedURLException;

import com.syzx.infrared.domain.JsonCodec;
import com.syzx.infrared.domain.entities.JsonTopClass;
import com.syzx.infrared.service.interfaces.IDataConverter;
import com.syzx.infrared.service.interfaces.IDataTransceiver;
import com.syzx.infrared.service.interfaces.IThreadUpdateEventHandler;

/**
 * ClassName: EventThread <br/>
 * Function: TODO 描述类的功能. <br/>
 * date: 2017年12月10日 下午12:48:53 <br/>
 *
 * @author Zxy
 * @version 
 * @since JDK 1.8
 */
public class GetInfraredDataThread extends Thread {

    private IDataTransceiver dataTransceiver;
    private IDataConverter dataConverter;
    private IThreadUpdateEventHandler threadUpdateEventHandler;
    private boolean isContinueRunning;
    private String url;
    private int updateInterval;

    /**
     *创建一个EventThread的实例.
     *
     * @param url
     */

    public GetInfraredDataThread(String url) {
        super();
        this.dataTransceiver = new WebDataTransceiver();
        this.dataConverter = new WebDataConverter();
        this.url = url;
        this.isContinueRunning = true;
        this.updateInterval = 2000;
    }

    /**
     * 设置 threadUpdateEventHandler.
     *
     * @param   threadUpdateEventHandler
     * @since   JDK 1.8
     */
    public void setThreadUpdateEventHandler(IThreadUpdateEventHandler threadUpdateEventHandler) {
        this.threadUpdateEventHandler = threadUpdateEventHandler;
    }

    /**
     * TODO 简单描述该方法的实现功能（可选）.
     * @see java.lang.Thread#run()
     */
    @Override
    public void run() {
        String receiveString = null;
        while (isContinueRunning) {
            try {
                receiveString = dataConverter.convertToString(dataTransceiver.ReceiveData(url));
                //                JsonTopClass jsonTopClass = JsonCodec.toObject(receiveString);
                if (threadUpdateEventHandler != null) {
                    //                    threadUpdateEventHandler.dataUpdate(this,
                    //                            new ThreadEventArgs(jsonTopClass.getIol().getData().getInput()));
                    threadUpdateEventHandler.dataUpdate(this, new ThreadEventArgs(receiveString.substring(0, 100)));
                }

                Thread.sleep(updateInterval);
            } catch (MalformedURLException e) {

                // TODO Auto-generated catch block
                e.printStackTrace();

            } catch (IOException e) {

                // TODO Auto-generated catch block
                e.printStackTrace();

            } catch (InterruptedException e) {

                // TODO Auto-generated catch block
                e.printStackTrace();

            }

        }
    }

    /**
     * 
     * stopThread:(这里描述该方法的功能). <br/>
     * TODO(这里描述这个方法适用条件 – 可选).<br/>
     * TODO(这里描述这个方法的执行流程 – 可选).<br/>
     * TODO(这里描述这个方法的使用方法 – 可选).<br/>
     * TODO(这里描述这个方法的注意事项 – 可选).<br/>
     *
     *
     * @since JDK 1.8
     * @author Zxy
     */
    public void stopThread() {
        this.isContinueRunning = true;
    }
}
