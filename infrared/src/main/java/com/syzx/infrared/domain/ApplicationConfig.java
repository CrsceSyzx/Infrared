/**
 * Project Name:Infrared
 * File Name:ApplicationConfig.java
 * Package Name:com.syzx.infrared.service
 * Date:2018年1月3日下午2:12:00
 * Copyright (c) 2018, syzx.com All Rights Reserved.
 *
 */
package com.syzx.infrared.domain;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.configuration2.XMLConfiguration;
import org.apache.commons.configuration2.builder.fluent.Configurations;
import org.apache.commons.configuration2.ex.ConfigurationException;

/**
 * ClassName: ApplicationConfig <br/>
 * Function: TODO 描述类的功能. <br/>
 * date: 2018年1月3日 下午2:12:00 <br/>
 *
 * @author Zxy
 * @version 
 * @since JDK 1.8
 */
public class ApplicationConfig {

    private static ApplicationConfig instance;

    private static String FILE_SEPARATOR;

    private String workingMode;
    private int sendPort;
    private int receivePort;
    private String monitorIp;
    private String forwardIp;

    private int heartInterval;
    private int forwardInterval;
    private int collectionInterval;
    private int statusChangeInterval;

    static {
        try {
            FILE_SEPARATOR = System.getProperty("file.separator");
            instance = new ApplicationConfig();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private String filterPathString(String pathString) {
        String result = pathString.replace("\\", FILE_SEPARATOR).replace("/", FILE_SEPARATOR);
        if (!result.endsWith(FILE_SEPARATOR)) {
            result = result + FILE_SEPARATOR;
        }
        if (result.startsWith(FILE_SEPARATOR)) {
            result = result.substring(1);
        }
        return result;
    }

    /**
     *创建一个ApplicationConfig的实例.
     * @throws Exception 
     *
     */

    private ApplicationConfig() throws Exception {
        Configurations configs = new Configurations();
        try {
            List<String> rootPaths = new ArrayList<String>();
            rootPaths.add(filterPathString(Class.class.getClass().getResource("/").getPath()));
            rootPaths.add(filterPathString(System.getProperty("user.dir")));

            //            StringBuilder sb = new StringBuilder();
            //            sb.append("Java 运行时环境版本:" + System.getProperty("java.version") + "\n");
            //            sb.append("Java 运行时环境供应商:" + System.getProperty("java.vendor") + "\n");
            //            sb.append("Java 供应商的URL:" + System.getProperty("java.vendor.url") + "\n");
            //            sb.append("Java 安装目录:" + System.getProperty("java.home") + "\n");
            //            sb.append("Java 虚拟机规范版本:" + System.getProperty("java.vm.specification.version") + "\n");
            //            sb.append("Java 类格式版本号:" + System.getProperty("java.class.version") + "\n");
            //            sb.append("Java类路径：" + System.getProperty("java.class.path") + "\n");
            //            sb.append("加载库时搜索的路径列表:" + System.getProperty("java.library.path") + "\n");
            //            sb.append("默认的临时文件路径:" + System.getProperty("java.io.tmpdir") + "\n");
            //            sb.append("要使用的 JIT 编译器的名称:" + System.getProperty("java.compiler") + "\n");
            //            sb.append("一个或多个扩展目录的路径:" + System.getProperty("java.ext.dirs") + "\n");
            //            sb.append("操作系统的名称:" + System.getProperty("os.name") + "\n");
            //            sb.append("操作系统的架构:" + System.getProperty("os.arch") + "\n");
            //            sb.append("操作系统的版本:" + System.getProperty("os.version") + "\n");
            //            sb.append("文件分隔符（在 UNIX 系统中是“/”）:" + System.getProperty("file.separator") + "\n");
            //            sb.append("路径分隔符（在 UNIX 系统中是“:”）:" + System.getProperty("path.separator") + "\n");
            //            sb.append("行分隔符（在 UNIX 系统中是“/n”）:" + System.getProperty("line.separator") + "\n");
            //            sb.append("用户的账户名称:" + System.getProperty("user.name") + "\n");
            //            sb.append("用户的主目录:" + System.getProperty("user.home") + "\n");
            //            sb.append("用户的当前工作目录:" + System.getProperty("user.dir") + "\n");
            //            sb.append("用户的当前工作目录2:" + new File("").getAbsolutePath() + "\n");
            //            sb.append("用户的当前工作目录3:" + Class.class.getClass().getResource("/").getPath().substring(1)
            //                    + "\n");
            //
            //            System.out.println(sb.toString());

            XMLConfiguration config = null;

            for (String path : rootPaths) {
                if (new File(path + "config.xml").exists()) {
                    config = configs.xml(path + "config.xml");
                    break;
                } else if (new File(FILE_SEPARATOR + path + "config.xml").exists()) {
                    config = configs.xml(FILE_SEPARATOR + path + "config.xml");
                    break;
                }
            }

            if (config == null) {
                throw new Exception("找不到配置文件“config.xml”！！");
            }

            workingMode = config.getString("connectionConfig.workingMode");
            sendPort = config.getInt("connectionConfig.sendPort");
            receivePort = config.getInt("connectionConfig.receivePort");
            monitorIp = config.getString("connectionConfig.monitorIp");
            forwardIp = config.getString("connectionConfig.forwardIp");

            heartInterval = config.getInt("threadConfig.heartInterval");
            forwardInterval = config.getInt("threadConfig.forwardInterval");
            collectionInterval = config.getInt("threadConfig.collectionInterval");
            statusChangeInterval = config.getInt("threadConfig.statusChangeInterval");

        } catch (ConfigurationException cex) {
            cex.printStackTrace();
        }
    }

    /**
     * 获取 instance.
     *
     * @return  instance
     * @since   JDK 1.8
     */
    public static ApplicationConfig getInstance() {
        return instance;
    }

    /**
     * 获取 workingMode.
     *
     * @return  workingMode
     * @since   JDK 1.8
     */
    public String getWorkingMode() {
        return workingMode;
    }

    /**
     * 设置 workingMode.
     *
     * @param   workingMode
     * @since   JDK 1.8
     */
    public void setWorkingMode(String workingMode) {
        this.workingMode = workingMode;
    }

    /**
     * 获取 sendPort.
     *
     * @return  sendPort
     * @since   JDK 1.8
     */
    public int getSendPort() {
        return sendPort;
    }

    /**
     * 设置 sendPort.
     *
     * @param   sendPort
     * @since   JDK 1.8
     */
    public void setSendPort(int sendPort) {
        this.sendPort = sendPort;
    }

    /**
     * 获取 receivePort.
     *
     * @return  receivePort
     * @since   JDK 1.8
     */
    public int getReceivePort() {
        return receivePort;
    }

    /**
     * 设置 receivePort.
     *
     * @param   receivePort
     * @since   JDK 1.8
     */
    public void setReceivePort(int receivePort) {
        this.receivePort = receivePort;
    }

    /**
     * 获取 monitorIp.
     *
     * @return  monitorIp
     * @since   JDK 1.8
     */
    public String getMonitorIp() {
        return monitorIp;
    }

    /**
     * 设置 monitorIp.
     *
     * @param   monitorIp
     * @since   JDK 1.8
     */
    public void setMonitorIp(String monitorIp) {
        this.monitorIp = monitorIp;
    }

    /**
     * 获取 forwardIp.
     *
     * @return  forwardIp
     * @since   JDK 1.8
     */
    public String getForwardIp() {
        return forwardIp;
    }

    /**
     * 设置 forwardIp.
     *
     * @param   forwardIp
     * @since   JDK 1.8
     */
    public void setForwardIp(String forwardIp) {
        this.forwardIp = forwardIp;
    }

    /**
     * 获取 heartInterval.
     *
     * @return  heartInterval
     * @since   JDK 1.8
     */
    public int getHeartInterval() {
        return heartInterval;
    }

    /**
     * 设置 heartInterval.
     *
     * @param   heartInterval
     * @since   JDK 1.8
     */
    public void setHeartInterval(int heartInterval) {
        this.heartInterval = heartInterval;
    }

    /**
     * 获取 forwardInterval.
     *
     * @return  forwardInterval
     * @since   JDK 1.8
     */
    public int getForwardInterval() {
        return forwardInterval;
    }

    /**
     * 设置 forwardInterval.
     *
     * @param   forwardInterval
     * @since   JDK 1.8
     */
    public void setForwardInterval(int forwardInterval) {
        this.forwardInterval = forwardInterval;
    }

    /**
     * 获取 collectionInterval.
     *
     * @return  collectionInterval
     * @since   JDK 1.8
     */
    public int getCollectionInterval() {
        return collectionInterval;
    }

    /**
     * 设置 collectionInterval.
     *
     * @param   collectionInterval
     * @since   JDK 1.8
     */
    public void setCollectionInterval(int collectionInterval) {
        this.collectionInterval = collectionInterval;
    }

    /**
     * 获取 statusChangeInterval.
     *
     * @return  statusChangeInterval
     * @since   JDK 1.8
     */
    public int getStatusChangeInterval() {
        return statusChangeInterval;
    }

    /**
     * 设置 statusChangeInterval.
     *
     * @param   statusChangeInterval
     * @since   JDK 1.8
     */
    public void setStatusChangeInterval(int statusChangeInterval) {
        this.statusChangeInterval = statusChangeInterval;
    }

}