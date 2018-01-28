/**
 * Project Name:Infrared
 * File Name:Program.java
 * Package Name:com.syzx.infrared.ui
 * Date:2017年12月10日下午2:29:23
 * Copyright (c) 2017, syzx.com All Rights Reserved.
 *
 */
package com.syzx.infrared.ui;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.syzx.infrared.service.TestGetThread;

/**
 * ClassName: Program <br/>
 * Function: TODO 描述类的功能. <br/>
 * date: 2017年12月10日 下午2:29:23 <br/>
 *
 * @author Zxy
 * @version 
 * @since JDK 1.8
 */
public class Program {
    public static void main(String[] args) throws Exception {
        //        new MainForm().show();
        ExecutorService executor=Executors.newFixedThreadPool(8);
        for (int i = 0; i < 8; i++) {
//          String a=HttpManager.httpGet("http://192.168.1.125/r/ioldetails.lr?port=1");
//          String a=HttpManager.httpGet("http://www.sina.com.cn/");
//          InfraredSourceData infraredSourceData = JsonCodec.toInfraredSourceData(a);
//          List<Integer> input = infraredSourceData.getIol().getData().getInput();
            executor.execute(new TestGetThread(i));
          //Thread.sleep(500);
//            String url = "http://www.sina.com.cn/";
//            String a=HttpManager.httpGet(url);
//            System.out.println(i);
      }
    }
}
