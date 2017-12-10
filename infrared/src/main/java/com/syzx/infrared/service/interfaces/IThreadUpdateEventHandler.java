/**
 * Project Name:Infrared
 * File Name:EventHandler.java
 * Package Name:com.syzx.infrared.service.interfaces
 * Date:2017年12月9日下午11:04:22
 * Copyright (c) 2017, syzx.com All Rights Reserved.
 *
 */
package com.syzx.infrared.service.interfaces;

import com.syzx.infrared.service.ThreadEventArgs;

/**
 * ClassName: EventHandler <br/>
 * Function: TODO 描述类的功能. <br/>
 * date: 2017年12月9日 下午11:04:22 <br/>
 *
 * @author Zxy
 * @version 
 * @since JDK 1.8
 */
public interface IThreadUpdateEventHandler {
    public abstract void dataUpdate(Object sender, ThreadEventArgs e);
}
