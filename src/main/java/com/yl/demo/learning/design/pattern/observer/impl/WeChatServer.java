package com.yl.demo.learning.design.pattern.observer.impl;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class WeChatServer implements Observable {
    private List<Observer> obs;
    private Object notification;

    public WeChatServer() {
        this.obs = new ArrayList<Observer>();
    }

    @Override
    public void registerObserver(Observer o) {
        obs.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        if (!obs.isEmpty())
            obs.remove(o);
    }

    @Override
    public void notifyObserver() {
        if (obs.isEmpty())
            log.info("订阅人数为0,没有可以提醒的人呢");
        for (int i=0; i<obs.size(); i++) {
            obs.get(i).update(notification);
        }
    }

    public void setNotification(Object notification) {
        this.notification = notification;
        log.info("微信公众号更新了消息: " + notification);
        notifyObserver();
    }
}
