package org.example.leetcode.problems;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description 括号生成    https://leetcode-cn.com/problems/generate-parentheses/
 * @Author Marcoo
 * @Date 2020/4/12 21:48
 */
public class Demo022 {
    public static void main(String[] args) {
        int n = 4;
        System.out.println(generateParenthesis(n));
    }

    /**
     * 回溯法
     * @param n
     * @return
     */
    public static List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        StringBuilder builder = new StringBuilder();
        backtrack(ans, builder, 0, 0, n);
        return ans;
    }

    private static void backtrack(List<String> ans, StringBuilder builder, int open, int close, int max) {
        if (builder.length() == max * 2) {
            ans.add(builder.toString());
            return;
        }
        if (open < max) {
            builder.append("(");
            backtrack(ans, builder, open + 1, close, max);
            builder.setLength(builder.length() - 1);
        }
        if (close < open) {
            builder.append(")");
            backtrack(ans, builder, open, close + 1, max);
            builder.setLength(builder.length() - 1);
        }
    }
}
