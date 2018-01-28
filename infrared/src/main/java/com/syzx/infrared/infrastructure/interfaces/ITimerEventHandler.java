/**
 * Project Name:Infrared
 * File Name:ITimerEventHandler.java
 * Package Name:com.syzx.infrared.service.interfaces
 * Date:2017年12月9日下午11:04:22
 * Copyright (c) 2017, syzx.com All Rights Reserved.
 *
 */
package com.syzx.infrared.infrastructure.interfaces;

import com.syzx.infrared.infrastructure.TimerEventArgs;

/**
 * ClassName: ITimerEventHandler <br/>
 * Function: 计时器类的循环事件接口. <br/>
 * date: 2017年12月9日 下午11:04:22 <br/>
 *
 * @author Zxy
 * @version 
 * @since JDK 1.8
 */
public interface ITimerEventHandler {
    /**
     * 
     * interval:计时器类的循环事件回调函数. <br/>
     *
     * @param sender 事件触发计时器
     * @param e 事件参数
     *
     * @since JDK 1.8
     * @author Zxy
     */
    public abstract void doEventHandler(Object sender, TimerEventArgs e);
}