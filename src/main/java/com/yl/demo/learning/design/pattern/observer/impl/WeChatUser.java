package com.yl.demo.learning.design.pattern.observer.impl;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class WeChatUser implements Observer {
    private String username;

    public WeChatUser(String username) {
        this.username = username;
    }

    @Override
    public void update(Object o) {
        log.info(username + "收到了提醒通知: " + o);
    }
}
