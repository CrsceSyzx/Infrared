/**
 * Project Name:Infrared
 * File Name:ThreadEventArgs.java
 * Package Name:com.syzx.infrared.service
 * Date:2017年12月10日下午12:23:10
 * Copyright (c) 2017, syzx.com All Rights Reserved.
 *
 */
package com.syzx.infrared.service;

/**
 * ClassName: ThreadEventArgs <br/>
 * Function: TODO 描述类的功能. <br/>
 * date: 2017年12月10日 下午12:23:10 <br/>
 *
 * @author Zxy
 * @version 
 * @since JDK 1.8
 */
public class ThreadEventArgs extends EventArgs {
    private Object threadData;

    /**
     *创建一个ThreadEventArgs的实例.
     *
     * @param threadData
     */

    public ThreadEventArgs(Object threadData) {
        this.threadData = threadData;
    }

    /**
     * 获取 threadData.
     *
     * @return  threadData
     * @since   JDK 1.8
     */
    public Object getThreadData() {
        return threadData;
    }

    /**
     * 设置 threadData.
     *
     * @param   threadData
     * @since   JDK 1.8
     */
    public void setThreadData(Object threadData) {
        this.threadData = threadData;
    }

    

}
