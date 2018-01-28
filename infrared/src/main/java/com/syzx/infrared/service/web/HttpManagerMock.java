/**
 * Project Name:Infrared
 * File Name:HttpManagerMock.java
 * Package Name:com.syzx.infrared.service.web
 * Date:2018年1月2日下午5:15:43
 * Copyright (c) 2018, syzx.com All Rights Reserved.
 *
 */
package com.syzx.infrared.service.web;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.syzx.infrared.domain.JsonCodec;
import com.syzx.infrared.domain.entities.IOL;
import com.syzx.infrared.domain.entities.IOLData;
import com.syzx.infrared.domain.entities.InfraredSourceData;
import com.syzx.infrared.service.interfaces.IHttpManager;

/**
 * ClassName: HttpManagerMock <br/>
 * Function: TODO 描述类的功能. <br/>
 * date: 2018年1月2日 下午5:15:43 <br/>
 *
 * @author Zxy
 * @version 
 * @since JDK 1.8
 */
public class HttpManagerMock implements IHttpManager {

    private static Random randomSeed = new Random();

    private Random random = new Random(randomSeed.nextLong());
    private int basedistance;
    private int changedistance;

    private int distanceChangeTimes = 0;
    private int distanceChangeRate = 998;

    private int blockRate = 998;
    private int blockTimes = 0;

    /**
     *创建一个DataTransceiverMock的实例.
     *
     */

    public HttpManagerMock() {
        basedistance = random.nextInt(20) + 10;
    }

    /**
     * TODO 简单描述该方法的实现功能（可选）.
     * @see com.syzx.infrared.service.interfaces.IHttpManager#httpGet(java.lang.String)
     */
    public String httpGet(String url) {
        InfraredSourceData infraredSourceData = new InfraredSourceData();
        IOL iOL = new IOL();
        IOLData iOLData = new IOLData();
        List<Integer> input = new ArrayList<Integer>();

        if (distanceChangeTimes == 0) {
            if (random.nextInt(1000) > distanceChangeRate) {
                distanceChangeTimes = random.nextInt(50) + 25;
            }
        }

        if (blockTimes == 0) {
            if (random.nextInt(1000) > blockRate) {
                blockTimes = random.nextInt(30) + 15;
                changedistance = basedistance + random.nextInt(6) - 3;
            }
        }

        if (blockTimes > 0) {
            input.add(255);
            input.add(255);
            blockTimes--;
        } else if (distanceChangeTimes > 0) {
            input.add(0);
            input.add(changedistance);
            distanceChangeTimes--;
        } else {
            input.add(0);
            input.add(basedistance);
        }

        iOLData.setInput(input);
        iOL.setData(iOLData);
        infraredSourceData.setIol(iOL);
        return JsonCodec.toString(infraredSourceData);
    }
}