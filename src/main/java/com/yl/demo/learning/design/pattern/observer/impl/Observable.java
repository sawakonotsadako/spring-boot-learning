package com.yl.demo.learning.design.pattern.observer.impl;

public interface Observable {
    void registerObserver(Observer o);
    void removeObserver(Observer o);
    void notifyObserver();
}
