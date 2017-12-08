/**
 * Project Name:Infrared
 * File Name:JsonCodec.java
 * Package Name:com.syzx.infrared.domain
 * Date:2017年12月8日下午2:22:06
 * Copyright (c) 2017, syzx.com All Rights Reserved.
 *
 */
package com.syzx.infrared.domain;

import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.List;

import org.junit.Test;

import com.syzx.infrared.domain.entities.JsonTopClass;
import com.syzx.infrared.service.WebDataConverter;
import com.syzx.infrared.service.WebDataTransceiver;

/**
 * ClassName: JsonCodec <br/>
 * Function: TODO 描述类的功能. <br/>
 * date: 2017年12月8日 下午2:22:06 <br/>
 *
 * @author Zxy
 * @version 
 * @since JDK 1.8
 */
public class JsonCodecTest {

    //    public String fileRead(String filename) throws Exception {
    //        File file = new File(filename);//定义一个file对象，用来初始化FileReader
    //        FileReader reader = new FileReader(file);//定义一个fileReader对象，用来初始化BufferedReader
    //        BufferedReader bReader = new BufferedReader(reader);//new一个BufferedReader对象，将文件内容读取到缓存
    //        StringBuilder sb = new StringBuilder();//定义一个字符串缓存，将字符串存放缓存中
    //        String s = "";
    //        while ((s =bReader.readLine()) != null) {//逐行读取文件内容，不读取换行符和末尾的空格
    //            sb.append(s);//将读取的字符串添加换行符后累加存放在缓存中
    //        }
    //        bReader.close();
    //        
    //        return sb.toString();
    //    }
    //    

    private int[] toIntArray(List<Integer> list) {
        int[] ret = new int[list.size()];
        for (int i = 0; i < ret.length; i++)
            ret[i] = list.get(i);
        return ret;
    }

    @Test
    public void test() throws Exception {
        //String jsonString=fileRead("E:\\编程区\\JsonString.txt");
        int[] expectedInput=new int[] {38,65,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
        int[] expectedOutput=new int[] {43,52,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
        String jsonString="{\"status\": {\"cyclic\": {\"din\": [2,0],\"din_valid\": 0,\"din_comm\": 0,\"dout\": [2,0],\"dout_comm\": 0},\"config\": {\"ports\": [{\"iolconfig\": 4,\"inlen\": 2,\"outlen\": 0,\"comm\": 6,\"aux\": 0,\"logic_4\": false,\"logic_2\": false},{\"iolconfig\": 0,\"inlen\": 0,\"outlen\": 0,\"comm\": 0,\"aux\": 0,\"logic_4\": false,\"logic_2\": false},{\"iolconfig\": 0,\"inlen\": 0,\"outlen\": 0,\"comm\": 0,\"aux\": 0,\"logic_4\": false,\"logic_2\": false},{\"iolconfig\": 0,\"inlen\": 0,\"outlen\": 0,\"comm\": 0,\"aux\": 0,\"logic_4\": false,\"logic_2\": false},{\"iolconfig\": 0,\"inlen\": 0,\"outlen\": 0,\"comm\": 0,\"aux\": 0,\"logic_4\": false,\"logic_2\": false},{\"iolconfig\": 0,\"inlen\": 0,\"outlen\": 0,\"comm\": 0,\"aux\": 0,\"logic_4\": false,\"logic_2\": false},{\"iolconfig\": 0,\"inlen\": 0,\"outlen\": 0,\"comm\": 0,\"aux\": 0,\"logic_4\": false,\"logic_2\": false},{\"iolconfig\": 0,\"inlen\": 0,\"outlen\": 0,\"comm\": 0,\"aux\": 0,\"logic_4\": false,\"logic_2\": false}],\"mappingMode\": 0},\"dia\": {\"device\": [{\"state\": 3,\"type\": 1,\"code\": 17,\"alarm\": 17,\"iol_eventcode\": 64,\"iol_eventqual\": 0,\"iol_channel\": 0}],\"master\": [],\"ports\": [false,false,false,false,false,false,false,false]},\"leds\": {\"ports\": [{\"iol\": 1,\"dia\": 0},{\"iol\": 0,\"dia\": 0},{\"iol\": 0,\"dia\": 0},{\"iol\": 0,\"dia\": 0},{\"iol\": 0,\"dia\": 0},{\"iol\": 0,\"dia\": 0},{\"iol\": 0,\"dia\": 0},{\"iol\": 0,\"dia\": 0}],\"ua_green\": 0,\"ua_red\": 0,\"us_green\": 1,\"bfms_green\": 1,\"bfms_red\": 0,\"dians_green\": 4,\"dians_red\": 0,\"p1\": 1,\"p2\": 0},\"rotarys\": [5,2,1],\"forcing\": {\"forceon\": true,\"forcelock\": false,\"port_forced\": [true,false,false,false,false,false,false,false],\"force_do\": [0,0],\"mask_do\": [0,0],\"force_di\": [0,0],\"mask_di\": [0,0]},\"bus_on\": false,\"type\": 17},\"iol\": {\"port\": 1,\"vendor_id\": 0,\"device_id\": 0,\"serial\": [],\"data\": {\"in_valid\": false,\"input\": [38,65,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0],\"output\": [43,52,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0]},\"dia\": []}}";
        JsonTopClass jsonTopClass=JsonCodec.toObject(jsonString);
        jsonTopClass.getIol().getData().getOutput().toArray(new Integer[0]);
//        byte[] aa=new WebDataTransceiver().ReceiveData("http://www.guibuyu.org/0_899/");
//        String bb=new WebDataConverter().convertToString(aa);
        assertArrayEquals(expectedInput, toIntArray(jsonTopClass.getIol().getData().getInput()));
        assertArrayEquals(expectedOutput, toIntArray(jsonTopClass.getIol().getData().getOutput()));
    }

}
