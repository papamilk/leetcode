package org.example.leetcode.problems;

import java.util.Arrays;

/**
 * 有效括号的嵌套深度    https://leetcode-cn.com/problems/maximum-nesting-depth-of-two-valid-parentheses-strings/
 *
 * @author zhoujian
 * @date 2020/4/1
 */
public class Demo1111 {

    public static void main(String[] args) {
//        String seq = "(()())";
        String seq = "()(())()";
        System.out.println(Arrays.toString(maxDepthAfterSplit(seq)));

    }

    public static int[] maxDepthAfterSplit(String seq) {
        int[] arr = new int[seq.length()];
        boolean sign = true;
        arr[0] = 0;
        for (int i = 1; i < seq.length(); i++) {
            char c = seq.charAt(i);
            if (c != seq.charAt(i - 1)) {
                arr[i] = sign ? 0 : 1;
            } else {
                sign = !sign;
                arr[i] = sign ? 0 : 1;
            }
        }
        return arr;
    }
}
