package com.yl.demo.learning.design.pattern.strategy.impl;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class WeChatPay implements PayStrategy {
    @Override
    public void pay(float money) {
        log.info("调用微信支付接口, 支付了: " + money);
    }
}
