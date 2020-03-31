package org.example.leetcode.interview.easy.string;

import java.util.Arrays;

/**
 * @Description TODO
 * @Author Marcoo
 * @Date 2020/1/7 21:10
 */
public class ReverseString {

    public static void main(String[] args) {
//        char[] s = {'h','e','l','l','o'};
        char[] s = {'H','a','n','n','a','h'};
//        char[] s = {};
        reverseString(s);
        System.out.println(Arrays.toString(s));
    }

    public static void reverseString(char[] s) {
        int num = s.length - 1;
        for (int i = 0; i < s.length / 2; i++) {
            char temp = s[i];
            s[i] = s[num - i];
            s[num - i] = temp;
        }
    }

}
