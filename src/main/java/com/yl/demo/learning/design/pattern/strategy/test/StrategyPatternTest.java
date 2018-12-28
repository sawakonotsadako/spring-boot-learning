package com.yl.demo.learning.design.pattern.strategy.test;

import com.yl.demo.learning.design.pattern.strategy.impl.*;

public class StrategyPatternTest {
    public static void main(String[] args) {
        // 普通用法一 （策略模式三要素: 环境, 抽象策略, 具体策略）
        StrategyContext ctx = new StrategyContext();
        ctx.setStrategy(new AliPay());
        ctx.pay(201f);
        ctx.setStrategy(new WeChatPay());
        ctx.pay(201f);

        // 策略模式和工厂模式结合
        PayStrategy payStrategy = null;
        payStrategy = StrategyFactory.create(StrategyFactory.TYPE_ALI);
        payStrategy.pay(202f);
        payStrategy = StrategyFactory.create(StrategyFactory.TYPE_WECHAT);
        payStrategy.pay(202f);
    }
}
