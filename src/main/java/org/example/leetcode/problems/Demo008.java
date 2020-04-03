package org.example.leetcode.problems;

/**
 * 字符串转换整数 (atoi)   https://leetcode-cn.com/problems/string-to-integer-atoi/
 *
 * @author zhoujian
 * @date 2020/4/3
 */
public class Demo008 {

    public static void main(String[] args) {
//        String str = "4193 with words";
//        String str = "words and 987";
//        String str = "-91283472332";
        String str = "";
        System.out.println(myAtoi(str));
    }

    public static int myAtoi(String str) {
        if (str == null) {
            return 0;
        }
        char[] chars = str.toCharArray();

        // 丢弃无用的开头空格字符
        int index = 0;
        for (char c : chars) {
            if (c != ' ') {
                break;
            }
            index++;
        }

        if (index >= chars.length) {
            return 0;
        }

        // 根据第一个非空字符判断数字的正负性
        int sign = 1;
        if (chars[index] == '-') {
            sign = -1;
            index++;
        } else if (chars[index] == '+') {
            index++;
        }

        int ans = 0;
        for (int i = index; i < chars.length; i++) {
            int value = chars[i] - '0';
            if (value >= 0 && value <= 9) {
                if (ans > Integer.MAX_VALUE / 10 || (ans == Integer.MAX_VALUE / 10 && value >= 7)) {
                    return Integer.MAX_VALUE;
                }
                if (ans < Integer.MIN_VALUE / 10 || (ans == Integer.MIN_VALUE / 10 && value >= 8)) {
                    return Integer.MIN_VALUE;
                }
                ans = ans * 10 + sign * value;
            } else {
                break;
            }
        }
        return ans;
    }
}
