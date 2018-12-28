package com.yl.demo.learning.design.pattern.strategy.impl;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class AliPay implements PayStrategy {
    @Override
    public void pay(float money) {
        if (money < 200) {
            log.info("调用支付宝接口 - 免密支付, 支付了: " + money);
        } else {
            log.info("调用支付宝 - 输入密码支付, 支付了: " + money);
        }
    }
}
