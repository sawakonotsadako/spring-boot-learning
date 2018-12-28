package com.yl.demo.learning.algotithm.robin.test;


import com.yl.demo.learning.algotithm.robin.RobinAlgorithm;

import java.util.ArrayList;
import java.util.List;

public class RobinAnArrayTest {
    public static void main(String[] args) {
        List<Integer> integers = new ArrayList<>();
        integers.add(1);
        integers.add(2);
        integers.add(3);
        integers.add(4);

        RobinAlgorithm.polling(integers);
    }
}
