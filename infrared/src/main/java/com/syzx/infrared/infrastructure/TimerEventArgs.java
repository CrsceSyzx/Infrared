/**
 * Project Name:Infrared
 * File Name:TimerEventArgs.java
 * Package Name:com.syzx.infrared.service
 * Date:2017年12月10日下午12:23:10
 * Copyright (c) 2017, syzx.com All Rights Reserved.
 *
 */
package com.syzx.infrared.infrastructure;

/**
 * 
 * ClassName: TimerEventArgs <br/>
 * Function: 计时器事件参数. <br/>
 * date: 2018年1月2日 下午3:55:38 <br/>
 *
 * @author Zxy
 * @version 
 * @since JDK 1.8
 */
public class TimerEventArgs extends EventArgs {
    private Object timerData;

    /**
     * 
     *创建一个TimerEventArgs的实例.
     *
     * @param timerData
     */
    public TimerEventArgs(Object timerData) {
        this.timerData = timerData;
    }

    /**
     * 获取 timerData.
     *
     * @return  timerData
     * @since   JDK 1.8
     */
    public Object getTimerData() {
        return timerData;
    }

    /**
     * 设置 timerData.
     *
     * @param   timerData
     * @since   JDK 1.8
     */
    public void setTimerData(Object timerData) {
        this.timerData = timerData;
    }

}