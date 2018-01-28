/**
 * Project Name:Infrared
 * File Name:TestGetThread.java
 * Package Name:com.syzx.infrared.domain
 * Date:2018年1月23日上午10:42:59
 * Copyright (c) 2018, syzx.com All Rights Reserved.
 *
 */
package com.syzx.infrared.service;

import com.syzx.infrared.service.interfaces.IHttpManager;
import com.syzx.infrared.service.web.HttpManager;

/**
 * ClassName: TestGetThread <br/>
 * Function: TODO 描述类的功能. <br/>
 * date: 2018年1月23日 上午10:42:59 <br/>
 *
 * @author Zxy
 * @version 
 * @since JDK 1.8
 */
public class TestGetThread implements Runnable {

    private int index;
    private IHttpManager httpManager;

    /**
     *创建一个TestGetThread的实例.
     *
     * @param index
     */

    public TestGetThread(int index) {
        this.index = index;
        this.httpManager = new HttpManager();
    }

    /**
     * TODO 简单描述该方法的实现功能（可选）.
     * @see java.lang.Thread#run()
     */
    public void run() {
        String url = "http://www.google.com/";
        @SuppressWarnings("unused")
        String a = httpManager.httpGet(url);
        System.out.println(index);
    }
}
