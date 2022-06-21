package org.example.leetcode.problems;

/**
 * @author Marcoo
 * @desc 69. x 的平方根  https://leetcode.cn/problems/sqrtx/
 * @date 2022-06-20 21:36
 */
public class Demo069 {

    public static void main(String[] args) {
        int x = 2147395599;
        System.out.println(mySqrt(x));

    }

    /**
     * 二分查找，需要注意乘法溢出
     *
     * @param x
     * @return
     */
    public static int mySqrt(int x) {
        int start = 0, end = x / 2 + 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if ((long) mid * mid <= x) {
                start = mid;
            } else {
                end = mid - 1;
            }
        }
        return (long) end * end <= x ? end : start;
    }
}
