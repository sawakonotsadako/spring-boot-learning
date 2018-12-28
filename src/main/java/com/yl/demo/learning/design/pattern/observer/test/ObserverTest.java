package com.yl.demo.learning.design.pattern.observer.test;

import com.yl.demo.learning.design.pattern.observer.impl.WeChatServer;
import com.yl.demo.learning.design.pattern.observer.impl.WeChatUser;

public class ObserverTest {
    public static void main(String[] args) {
        WeChatServer wechatServer = new WeChatServer();
        wechatServer.registerObserver(new WeChatUser("sawakonotsadako"));
        wechatServer.setNotification("今天我们学习如何使用Eureka Server搭建服务注册中心");

    }


}
