/**
 * Project Name:Infrared
 * File Name:DistanceData.java
 * Package Name:com.syzx.infrared.domain.transmission
 * Date:2017年12月31日下午2:39:18
 * Copyright (c) 2017, syzx.com All Rights Reserved.
 *
 */
package com.syzx.infrared.domain.dto;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * ClassName: DataFrame <br/>
 * Function: TODO 描述类的功能. <br/>
 * date: 2017年12月31日 下午2:39:18 <br/>
 *
 * @author Zxy
 * @version 
 * @since JDK 1.8
 */
public class DataFrame {
    private String kilometerMark;
    private String time;
    private DataFrameType type;
    private int[] distances;

    /**
     *创建一个DataFrame的实例.
     *
     * @param kilometerMark
     * @param time
     */
    public DataFrame(String kilometerMark, DataFrameType type) {
        this.time = LocalDateTime.now().format(DateTimeFormatter.ofPattern("uuuu-MM-dd HH:mm:ss.SSS"));
        this.kilometerMark = kilometerMark;
        this.type = type;
    }

    /**
     * 获取 kilometerMark.
     *
     * @return  kilometerMark
     * @since   JDK 1.8
     */
    public String getKilometerMark() {
        return kilometerMark;
    }

    /**
     * 设置 kilometerMark.
     *
     * @param   kilometerMark
     * @since   JDK 1.8
     */
    public void setKilometerMark(String kilometerMark) {
        this.kilometerMark = kilometerMark;
    }

    /**
     * 获取 time.
     *
     * @return  time
     * @since   JDK 1.8
     */
    public String getTime() {
        return time;
    }

    /**
     * 设置 time.
     *
     * @param   time
     * @since   JDK 1.8
     */
    public void setTime(String time) {
        this.time = time;
    }

    /**
     * 获取 distances.
     *
     * @return  distances
     * @since   JDK 1.8
     */
    public int[] getDistances() {
        return distances;
    }

    /**
     * 设置 distances.
     *
     * @param   distances
     * @since   JDK 1.8
     */
    public void setDistances(int[] distances) {
        this.distances = distances;
    }

    /**
     * 获取 type.
     *
     * @return  type
     * @since   JDK 1.8
     */
    public DataFrameType getType() {
        return type;
    }

    /**
     * 设置 type.
     *
     * @param   type
     * @since   JDK 1.8
     */
    public void setType(DataFrameType mode) {
        this.type = mode;
    }

}