package org.example.leetcode.problems;

import java.util.LinkedList;
import java.util.List;

/**
 * @Description 最长公共前缀  https://leetcode-cn.com/problems/longest-common-prefix/
 * @Author Marcoo
 * @Date 2020/3/30 21:47
 */
public class Demo014 {
    public static void main(String[] args) {
//        String[] strs = {"flower", "flow", "flight"};
//        String[] strs = {"dog","racecar","car"};
        String[] strs = {"fl", "flow", "flight"};
        System.out.println(longestCommonPrefix(strs));
    }

    /**
     * 水平扫描
     * @param strs
     * @return
     */
    public static String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        char[] prefix = new char[strs[0].length()];
        for (int i = 0; i < strs[0].length(); i++) {
            prefix[i] = strs[0].charAt(i);
        }
        int validIndex = prefix.length - 1;
        for (int i = 1; i < strs.length; i++) {
            int length = strs[i].length();
            for (int j = 0; j < length; j++) {
                if (j > validIndex) {
                    break;
                }
                if (strs[i].charAt(j) != prefix[j]) {
                    validIndex = j - 1;
                }
            }
            if (validIndex > length - 1) {
                validIndex = length - 1;
            }
        }
        if (validIndex == -1) {
            return "";
        }
        return String.copyValueOf(prefix, 0, validIndex + 1);
    }
}
