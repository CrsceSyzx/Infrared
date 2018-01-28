/**
 * Project Name:Infrared
 * File Name:DistanceDataUnit.java
 * Package Name:com.syzx.infrared.service
 * Date:2017年12月30日上午8:35:31
 * Copyright (c) 2017, syzx.com All Rights Reserved.
 *
 */
package com.syzx.infrared.domain.dto;

/**
 * ClassName: DistanceDataUnit <br/>
 * Function: 距离数据单元. <br/>
 * date: 2017年12月30日 上午8:35:31 <br/>
 *
 * @author Zxy
 * @version 
 * @since JDK 1.8
 */
public class DistanceDataUnit {
    private int port;
    private int distance;

    /**
     * 
     *创建一个DistanceDataUnit的实例.
     *
     * @param time
     * @param port
     * @param distance
     */
    public DistanceDataUnit(int port, int distance) {
        this.port = port;
        this.distance = distance;
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
     * 获取 distance.
     *
     * @return  distance
     * @since   JDK 1.8
     */
    public int getDistance() {
        return distance;
    }

}