package org.example.leetcode.problems;

/**
 * @Description 28. 实现 strStr()     https://leetcode-cn.com/problems/implement-strstr/
 * @Author Marcoo
 * @Date 2022-04-28 8:00
 */
public class Demo028 {

    public static void main(String[] args) {
        String haystack = "";
        String needle = "";

    }

    public static int strStr(String haystack, String needle) {
        if (needle == null) {
            return -1;
        }
        if ("".equals(needle)) {
            return 0;
        }
        if (haystack.length() < needle.length()) {
            return -1;
        }

        int index = -1;
        for (int i = 0; i < haystack.length() - needle.length() + 1; i++) {
            if (haystack.charAt(i) == needle.charAt(0)) {
                if (match(haystack, needle, i)) {
                    index = i;
                    break;
                }
            }
        }
        return index;
    }


    private static boolean match(String haystack, String needle, int index) {
        for (int i = 1; i < needle.length(); i++) {
            if (needle.charAt(i) != haystack.charAt(index + i)) {
                return false;
            }
        }
        return true;
    }
}
