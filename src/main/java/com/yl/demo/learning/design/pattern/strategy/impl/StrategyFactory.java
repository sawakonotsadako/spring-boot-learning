package com.yl.demo.learning.design.pattern.strategy.impl;

public class StrategyFactory {
    public static final String TYPE_ALI = "ali";
    public static final String TYPE_WECHAT = "wechat";

    private StrategyFactory() {

    }

    public static PayStrategy create(String type) {
        PayStrategy pay = null;
        if (type.equals(TYPE_WECHAT)) {
            pay = new WeChatPay();
        } else if (type.equals(TYPE_ALI)) {
            pay = new AliPay();
        }
        return pay;
    }
}
