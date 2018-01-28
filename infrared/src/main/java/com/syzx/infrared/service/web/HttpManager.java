/**
 * Project Name:Infrared
 * File Name:HttpManager.java
 * Package Name:com.syzx.infrared.domain
 * Date:2018年1月23日下午12:20:58
 * Copyright (c) 2018, syzx.com All Rights Reserved.
 *
 */
package com.syzx.infrared.service.web;

import java.time.Duration;
import java.time.Instant;

import javax.net.ssl.SSLContext;

import org.apache.http.HttpEntity;
import org.apache.http.HttpRequest;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.config.Registry;
import org.apache.http.config.RegistryBuilder;
import org.apache.http.conn.socket.ConnectionSocketFactory;
import org.apache.http.conn.socket.PlainConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.TrustSelfSignedStrategy;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.ssl.SSLContexts;
import org.apache.http.util.EntityUtils;

import com.syzx.infrared.service.interfaces.IHttpManager;

/**
 * ClassName: HttpManager <br/>
 * Function: TODO 描述类的功能. <br/>
 * date: 2018年1月23日 下午12:20:58 <br/>
 *
 * @author Zxy
 * @version 
 * @since JDK 1.8
 */
public class HttpManager implements IHttpManager {

    private static final int REQUEST_TIMEOUT = 2 * 1000;
    private static final int REQUEST_SOCKET_TIME = 2 * 1000;
    private static final int MAX_TOTAL_CONNECTIONS = 50;
    private static final int MAX_ROUTE_CONNECTIONS = 25;
    private static final Object syncLock = new Object();

    private static CloseableHttpClient httpClient = null;
    private static PoolingHttpClientConnectionManager clientConnectionManager = null;

    static {
        SSLContext sslContext;
        try {
            //注册https和http
            sslContext = SSLContexts.custom().loadTrustMaterial(null, new TrustSelfSignedStrategy()).build();
            SSLConnectionSocketFactory sslsf = new SSLConnectionSocketFactory(sslContext,
                    SSLConnectionSocketFactory.getDefaultHostnameVerifier());
            Registry<ConnectionSocketFactory> socketFactoryRegistry = RegistryBuilder.<ConnectionSocketFactory>create()
                    .register("https", sslsf).register("http", PlainConnectionSocketFactory.getSocketFactory()).build();
            clientConnectionManager = new PoolingHttpClientConnectionManager(socketFactoryRegistry);
            //设置最大连接数
            clientConnectionManager.setMaxTotal(MAX_TOTAL_CONNECTIONS);
            clientConnectionManager.setDefaultMaxPerRoute(MAX_ROUTE_CONNECTIONS);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public CloseableHttpClient getHttpClient() {
        if (httpClient == null) {
            synchronized (syncLock) {
                if (httpClient == null) {
                    RequestConfig defaultRequestConfig = RequestConfig.custom().setConnectTimeout(REQUEST_TIMEOUT)
                            .setSocketTimeout(REQUEST_SOCKET_TIME).build();
                    //                CookieStore cookieStore = new BasicCookieStore();
                    //                BasicClientCookie cookie = new BasicClientCookie("sessionID", "######");
                    //                cookie.setDomain("#####");
                    //                cookie.setPath("/");
                    //                cookieStore.addCookie(cookie);
                    //                httpClient = HttpClients.custom().setConnectionManager(clientConnectionManager)
                    //                        .setDefaultCookieStore(cookieStore).setDefaultRequestConfig(config).build();
                    httpClient = HttpClients.custom().setConnectionManager(clientConnectionManager)
                            .setDefaultRequestConfig(defaultRequestConfig).build();
                }
            }
        }

        return httpClient;
    }

    public String httpGet(String url) {
        Instant x1 = Instant.now();
        CloseableHttpClient httpClient = getHttpClient();
        Instant x2 = Instant.now();
        HttpRequest httpGet = new HttpGet(url);
        Instant x3 = Instant.now();
        CloseableHttpResponse response = null;
        try {
            response = httpClient.execute((HttpGet) httpGet);
            Instant x4 = Instant.now();
            HttpEntity entity = response.getEntity();
            Instant x5 = Instant.now();
            String responseString = EntityUtils.toString(entity);
            Instant x6 = Instant.now();
            System.out.println("获取httpClient:" + Duration.between(x1, x2).toMillis());
            // System.out.println("构造http请求:" + Duration.between(x2, x3).toMillis());
            System.out.println("获取响应:" + Duration.between(x3, x4).toMillis());
            //System.out.println("提取网页源代码:" + Duration.between(x4, x5).toMillis());
            System.out.println("转换网页源代码:" + Duration.between(x5, x6).toMillis());
            System.out.println("---------------------------------------------------");
            return responseString;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}