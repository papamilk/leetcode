package org.example.leetcode.problems;

import java.util.Arrays;

/**
 * @Description 最长回文子串 https://leetcode-cn.com/problems/longest-palindromic-substring/
 * @Author Marcoo
 * @Date 2020/3/29 18:59
 */
public class Demo005 {

    public static void main(String[] args) {
        String s = "aaaa";
        System.out.println(longestPalindrome(s));
    }

    /**
     * 动态规划
     * 1. 定义状态
     *  dp[i][j] 表示子串s[i,j]是否为回文子串
     * 2. 状态转移方程
     *  dp[i][j] = (s[i] == s[j] & dp[i+1][j-1])
     * @param s
     * @return
     */
    public static String longestPalindrome(String s) {
        if (s == null || s.length() < 2) {
            return s;
        }

        int length = s.length();
        boolean[][] dp = new boolean[length][length];

        int maxLen = 1;
        int start = 0;
        for (int j = 1; j < length; j++) {
            for (int i = 0; i < j; i++) {
                if (s.charAt(i) == s.charAt(j)) {
                    if (j - i < 3) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                } else {
                    dp[i][j] = false;
                }
                if (dp[i][j]) {
                    int curLen = j - i + 1;
                    if (curLen > maxLen) {
                        maxLen = curLen;
                        start = i;
                    }
                }
            }
        }
        return s.substring(start, start + maxLen);
    }

}
