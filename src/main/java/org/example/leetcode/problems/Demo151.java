package org.example.leetcode.problems;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 翻转字符串里的单词    https://leetcode-cn.com/problems/reverse-words-in-a-string/
 * @author zhoujian
 * @date 2020/4/10
 */
public class Demo151 {
    public static void main(String[] args) {
//        String s = "the sky is blue";
        String s = "  hello  world!  ";
//        String s = "    ";
//        String s = "";
//        String s = "a good   example";
        System.out.println(reverseWordsV2(s));
    }

    /**
     * LeetCode 100% 的时间
     * @param s
     * @return
     */
    public static String reverseWords(String s) {
        String[] strings = s.split(" ");
        StringBuilder builder = new StringBuilder();
        for (int i = strings.length - 1; i >= 0; i--) {
            if (!"".equals(strings[i])) {
                builder.append(strings[i]);
                builder.append(" ");
            }
        }
        if (builder.length() > 0) {
            builder.setLength(builder.length() - 1);
        }
        return builder.toString();
    }

    /**
     * 队列的方式去处理，速度不算快
     * @param s
     * @return
     */
    public static String reverseWordsV2(String s) {
        int left = 0;
        int right = s.length() - 1;
        while (left <= right && s.charAt(left) == ' ') {
            left++;
        }
        while (left <= right && s.charAt(right) == ' ') {
            right--;
        }
        Deque<String> deque = new ArrayDeque<>();
        StringBuilder builder = new StringBuilder();
        while (left <= right) {
            char c = s.charAt(left);
            if (c != ' ') {
                builder.append(c);
            } else if (builder.length() > 0){
                deque.addFirst(builder.toString());
                builder.setLength(0);
            }
            left++;
        }
        deque.addFirst(builder.toString());
        return String.join(" ", deque);
    }

    /**
     * 完全使用 Java 内置类语法，速度不快
     * @param s
     * @return
     */
    public static String reverseWordsV1(String s) {
        s = s.trim();
        List<String> list = Arrays.asList(s.split("\\s"));
        Collections.reverse(list);
        return String.join(" ", list);
    }
}
