/**
 * Project Name:Infrared
 * File Name:TimerEventHandler.java
 * Package Name:com.syzx.infrared.service
 * Date:2017年12月10日下午12:44:37
 * Copyright (c) 2017, syzx.com All Rights Reserved.
 *
 */
package com.syzx.infrared.infrastructure;

import com.syzx.infrared.infrastructure.interfaces.ITimerEventHandler;

/**
 * ClassName: TimerEventHandler <br/>
 * Function: 为添加静态事件块而建立的抽象事件模版. <br/>
 * date: 2017年12月10日 下午12:44:37 <br/>
 *
 * @author Zxy
 * @version 
 * @since JDK 1.8
 */
public abstract class TimerEventHandler implements ITimerEventHandler {

    /**
     * 
     * TODO 简单描述该方法的实现功能（可选）.
     * @see com.syzx.infrared.infrastructure.interfaces.ITimerEventHandler#doEventHandler(java.lang.Object, com.syzx.infrared.infrastructure.TimerEventArgs)
     */
    public void doEventHandler(Object sender, TimerEventArgs e) {
    }

}