package com.yl.demo.learning.algotithm.string.interview;

public class PalindromeStringTest {



    public static void main(String[] args) {
        String input = "abababa";

        System.out.println("reverse string of input is:" + reverse(input));

        System.out.println("is palindrome:" + isPalindrome(input));

    }

    static boolean isPalindrome(String input) {

        return input.equals(reverse(input));
    }

    static String reverse(String input) {
        if (input.length() == 1) {
            return input;
        }

        return input.charAt(input.length()-1) + reverse(input.substring(0, input.length() - 1));
    }

    static String reverse2(String input) {
        char[] chars = input.toCharArray();
        StringBuffer s = new StringBuffer();
        for (int i=chars.length; i > 0; i--) {
            s.append(chars[i-1]);
        }
        return s.toString();
    }


}
