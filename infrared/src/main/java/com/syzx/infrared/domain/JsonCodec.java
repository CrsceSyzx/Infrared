/**
 * Project Name:Infrared
 * File Name:JsonCodec.java
 * Package Name:com.syzx.infrared.domain
 * Date:2017年12月7日下午4:26:54
 * Copyright (c) 2017, syzx.com All Rights Reserved.
 *
 */
package com.syzx.infrared.domain;

import com.alibaba.fastjson.JSONObject;
import com.syzx.infrared.domain.dto.DataFrame;
import com.syzx.infrared.domain.entities.InfraredSourceData;

/**
 * ClassName: JsonCodec <br/>
 * Function: TODO 描述类的功能. <br/>
 * date: 2017年12月7日 下午4:26:54 <br/>
 *
 * @author Zxy
 * @version 
 * @since JDK 1.8
 */
public class JsonCodec {

    public static String toString(Object object) {
        return JSONObject.toJSONString(object);
    }

    public static InfraredSourceData toInfraredSourceData(String jsonString) {
        return JSONObject.parseObject(jsonString, InfraredSourceData.class);
    }

    public static DataFrame toDataFrame(String jsonString) {
        return JSONObject.parseObject(jsonString, DataFrame.class);
    }
}