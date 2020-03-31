package org.example.leetcode.interview.easy;

import java.util.Arrays;

/**
 * @Description TODO
 * @Author Marcoo
 * @Date 2019/12/26 22:04
 */
public class PlusOne {

    public static void main(String[] args) {
//        int[] digits = {1,2,3};
//        int[] digits = {4,3,2,1};
//        int[] digits = {9,9,9,9};
//        int[] digits = {0};
        int[] digits = {8,9,9,9};
        System.out.println(Arrays.toString(plusOne(digits)));
    }

    public static int[] plusOne(int[] digits) {

        // 默认未溢出
        int overflow = 0;
        int[] arr = new int[digits.length];
        for (int i = digits.length - 1; i >= 0; i--) {
            int result;
            if (i == digits.length - 1) {
                result = digits[i] + 1;
            } else {
                result = digits[i] + overflow;
            }
            if (result > 9) {
                result = result % 10;
                overflow = 1;
            } else {
                overflow = 0;
            }
            arr[i] = result;
        }
        if (overflow == 1) {
            int[] newArr = new int[digits.length + 1];
            newArr[0] = 1;
            System.arraycopy(arr, 0, newArr, 1, arr.length);
            return newArr;
        }
        return arr;
    }
}
