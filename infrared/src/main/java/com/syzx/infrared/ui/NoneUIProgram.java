/**
 * Project Name:Infrared
 * File Name:NoneUIProgram.java
 * Package Name:com.syzx.infrared.ui
 * Date:2017年12月11日上午9:54:41
 * Copyright (c) 2017, syzx.com All Rights Reserved.
 *
 */
package com.syzx.infrared.ui;

import java.io.IOException;
import java.util.Scanner;

import com.syzx.infrared.domain.ApplicationConfig;
import com.syzx.infrared.service.UDPClient;
import com.syzx.infrared.service.web.SocketAddress;

/**
 * ClassName: NoneUIProgram <br/>
 * Function: TODO 描述类的功能. <br/>
 * date: 2017年12月11日 上午9:54:41 <br/>
 *
 * @author Zxy
 * @version 
 * @since JDK 1.8
 */
public class NoneUIProgram {

    public static void main(String[] args) throws IOException, InterruptedException {
        //        int mode;
        //        String serverIp;
        //        int serverPort;
        //        String receiveIp = "192.168.1.125";
        String kilometerMark = null;
        Scanner scanner = new Scanner(System.in);

        //        if ("server".equals(ApplicationConfig.getInstance().getWorkingMode())) {
        //            UDPServer server = new UDPServer(ApplicationConfig.getInstance().getSendPort());
        //            server.start();
        //            System.out.println("服务器启动...");
        //            String isExit = null;
        //            while (!"exit".equals(isExit)) {
        //                isExit = scanner.nextLine();
        //            }
        //            server.stop();
        //            System.out.println("服务器停止...");
        //        } else if ("client".equals(ApplicationConfig.getInstance().getWorkingMode())) {
        System.out.println("请输入采集终端公里标:");
        kilometerMark = scanner.nextLine();

        UDPClient client = new UDPClient(kilometerMark, new SocketAddress(
                ApplicationConfig.getInstance().getForwardIp(), ApplicationConfig.getInstance().getReceivePort()));
        client.start();
        System.out.println("客户端启动...");
        if ("MOCK".equals(ApplicationConfig.getInstance().getWorkingMode().toUpperCase())) {
            System.out.println("运行模式：模拟");
        } else if ("REAL".equals(ApplicationConfig.getInstance().getWorkingMode().toUpperCase())) {
            System.out.println("运行模式：实际");
        }

        System.out.println("开始采集数据...");
        String isExit = null;
        while (!"exit".equals(isExit)) {
            isExit = scanner.nextLine();
        }
        client.stop();
        System.out.println("客户端关闭..");
        //        }

        scanner.close();
    }
}