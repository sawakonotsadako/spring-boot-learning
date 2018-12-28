package com.yl.demo.learning.design.pattern.strategy.impl;

public class StrategyContext {
    private PayStrategy strategy;

    public void pay(float money) {
        strategy.pay(money);
    }

    public void setStrategy(PayStrategy strategy) {
        this.strategy = strategy;
    }
}
