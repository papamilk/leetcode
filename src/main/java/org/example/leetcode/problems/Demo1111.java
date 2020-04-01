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
        System.out.println(Arrays.toString(maxDepthAfterSplitV2(seq)));

    }

    /**
     * 一种比较直接的方式，通过标记来实现，效率比位运算方式低。
     *
     * 这道题要让字符串的深度最低，保证连续出现的左括号要分到不同组即可。
     *
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     *
     * @param seq
     * @return
     */
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

    /**
     * 使用位运算
     * @param seq
     * @return
     */
    public static int[] maxDepthAfterSplitV2(String seq) {
        int[] arr = new int[seq.length()];
        int depth = 0;
        char[] chars = seq.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '(') {
                depth++;
                // depth & 1 等价于 depth % 2，位运算会比较快
                arr[i] = depth & 1;
            } else {
                arr[i] = depth & 1;
                depth--;
            }
        }
        return arr;
    }
}
