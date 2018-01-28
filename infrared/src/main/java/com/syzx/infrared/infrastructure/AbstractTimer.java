/**
 * Project Name:Infrared
 * File Name:AbstractTimer.java
 * Package Name:com.syzx.infrared.infrastructure
 * Date:2018年1月2日下午3:45:04
 * Copyright (c) 2018, syzx.com All Rights Reserved.
 *
 */
package com.syzx.infrared.infrastructure;

import com.syzx.infrared.infrastructure.interfaces.ITimerEventHandler;

/**
 * ClassName: AbstractTimer <br/>
 * Function: 计时器基类. <br/>
 * date: 2018年1月2日 下午3:45:04 <br/>
 *
 * @author Zxy
 * @version 
 * @since JDK 1.8
 */
public abstract class AbstractTimer extends Thread {

    private ITimerEventHandler cycleFinishedEventHandler;
    private TimerEventArgs timerEventArgs;

    private boolean isContinueRunning;
    private int interval;

    public AbstractTimer() {
        this(0);
    }

    /**
     *创建一个AbstractTimer的实例.
     *
     * @param interval
     */

    public AbstractTimer(int interval) {
        super();
        this.interval = interval;
    }

    /**
     * 获取 interval.
     *
     * @return  interval
     * @since   JDK 1.8
     */
    public int getInterval() {
        return interval;
    }

    /**
     * 设置 interval.
     *
     * @param   interval
     * @since   JDK 1.8
     */
    public void setInterval(int interval) {
        this.interval = interval;
    }

    /**
     * 设置 cycleFinishedEventHandler.
     *
     * @param   cycleFinishedEventHandler
     * @since   JDK 1.8
     */
    public void setCycleFinishedEventHandler(ITimerEventHandler cycleFinishedEventHandler) {
        this.cycleFinishedEventHandler = cycleFinishedEventHandler;
    }

    /**
     * 设置 timerEventArgs.
     *
     * @param   timerEventArgs
     * @since   JDK 1.8
     */
    protected void setTimerEventArgs(TimerEventArgs args) {
        this.timerEventArgs = args;
    }

    /**
     * TODO 简单描述该方法的实现功能（可选）.
     * @see java.lang.Thread#run()
     */
    @Override
    public void run() {
        beforeAction();
        isContinueRunning = true;
        while (isContinueRunning) {
            action();
            if (cycleFinishedEventHandler != null)
                cycleFinishedEventHandler.doEventHandler(this, timerEventArgs);

            if (interval > 0)
                try {
                    Thread.sleep(interval);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
        }
        releaseResource();
    }

    public void beforeAction() {
    }

    public abstract void action();

    public abstract void releaseResource();

    public void stopTimer() {
        isContinueRunning = false;
    }
}