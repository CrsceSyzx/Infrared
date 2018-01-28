/**
 * Project Name:Infrared
 * File Name:DataFrameType.java
 * Package Name:com.syzx.infrared.domain.dto
 * Date:2018年1月2日下午9:59:57
 * Copyright (c) 2018, syzx.com All Rights Reserved.
 *
 */
package com.syzx.infrared.domain.dto;

/**
 * ClassName: DataFrameType <br/>
 * Function: TODO 描述类的功能. <br/>
 * date: 2018年1月2日 下午9:59:57 <br/>
 *
 * @author Zxy
 * @version 
 * @since JDK 1.8
 */
public enum DataFrameType {
    HEART(0), START(10), STOP(11), DATA(101);

    private final int value;

    private DataFrameType(int value) {
        this.value = value;
    }

    /**
     * 获取 value.
     *
     * @return  value
     * @since   JDK 1.8
     */
    public int getValue() {
        return value;
    }
}