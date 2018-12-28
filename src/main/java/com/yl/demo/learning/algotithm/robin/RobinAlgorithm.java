package com.yl.demo.learning.algotithm.robin;

import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
public class RobinAlgorithm {
    private static final String expression = "(CUR+1)%SIZE";

    public static void polling(List<Integer> integerList) {
        for (int i=0; i<integerList.size(); i++) {
            log.info("current: " + i + ", next: " + ((i+1)%integerList.size()));
        }
    }

}
