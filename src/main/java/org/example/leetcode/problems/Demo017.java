package org.example.leetcode.problems;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description 电话号码的字母组合   https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number/
 * @Author Marcoo
 * @Date 2020/4/19 18:22
 */
public class Demo017 {
    public static void main(String[] args) {
//        String digits = "234";
        String digits = "";
        System.out.println(letterCombinations(digits));
    }

    /**
     * 回溯法
     * @param digits
     * @return
     */
    public static List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<>();
        if (digits == null || digits.length() == 0) {
            return ans;
        }

        String[][] table = {
                {"a", "b", "c"},
                {"d", "e", "f"},
                {"g", "h", "i"},
                {"j", "k", "l"},
                {"m", "n", "o"},
                {"p", "q", "r", "s"},
                {"t", "u", "v"},
                {"w", "x", "y", "z"}
        };

        char[] digitsChars = digits.toCharArray();
        StringBuilder builder = new StringBuilder();
        backtrack(ans, builder, 0, table, digitsChars);
        return ans;
    }

    private static void backtrack(List<String> ans, StringBuilder builder, int index, String[][] table, char[] digitsChars) {
        if (index == digitsChars.length) {
            ans.add(builder.toString());
            return;
        }

        int digit = digitsChars[index] - '0';
        String[] words = table[digit - 2];
        for (String word : words) {
            builder.append(word);
            backtrack(ans, builder, index + 1, table, digitsChars);
            builder.setLength(builder.length() - 1);
        }
    }
}
