package com.yl.demo.learning.algotithm.sort.interview;

import java.util.Arrays;

public class BubbleSortTest {
    public static void main(String[] args) {
        int[] arr = new int[] {20, 12, 45, 19, 91, 55};
        int[] arr2 = new int[] {-1, 0, 1};
        int[] arr3 = new int[] {-3, -9, -2, -1};

        System.out.println(Arrays.toString(bubbleSort(arr)));
        System.out.println(Arrays.toString(bubbleSort(arr2)));
        System.out.println(Arrays.toString(bubbleSort(arr3)));

    }

    public static int[] bubbleSort(int[] arr) {

        for (int i=0; i<arr.length; i++) {
            for (int j=arr.length-1; j>i; j--) {
                if (arr[j] < arr[j-1]) {
                    int temp = arr[j];
                    arr[j] = arr[j-1];
                    arr[j-1] = temp;
                }

            }
        }
        return arr;
    }
}
