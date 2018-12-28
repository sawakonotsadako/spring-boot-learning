package com.yl.demo.learning.algotithm.product.of.array.except.self;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class Enjoy {
    public static void main(String[] args) {
        List<Integer> input = new ArrayList<>();
        input.add(1);
        input.add(2);
        input.add(65);
        input.add(4);

        List<Integer> output = productOfArrayExceptSelf(input);

        log.info("[input]"+input);
        log.info("[output]"+output);
    }

    public static List<Integer> productOfArrayExceptSelf(List<Integer> input) {
        List<Integer> temp = new ArrayList<>();
        for (int i=0; i<input.size(); i++) {
            int b1=0, e1=i, b2=i+1, e2=input.size();
            temp.add(i, productOf(input, b1, e1) * productOf(input, b2, e2));
        }
        return temp;
    }

    public static int productOf(List<Integer> arr, int begin, int end) {
        int a = 1;
        for (int i=begin; i<end; i++) {
            a = arr.get(i) * a;
        }
        return a;
    }


}

