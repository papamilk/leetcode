package org.example.leetcode.problems;

/**
 * @author Marcoo
 * @description 29. 两数相除 https://leetcode.cn/problems/divide-two-integers/
 * @date 2022-06-07 21:10
 */
public class Demo029 {

    /**
     * 二分法 + 快速乘法
     *
     * @param dividend
     * @param divisor
     * @return
     */
    public static int divide(int dividend, int divisor) {
        return 0;
    }


    /**
     * 递归，除数倍增
     *
     * @param dividend
     * @param divisor
     * @return
     */
    public static int divideV0(int dividend, int divisor) {
        if (dividend == 0) {
            return 0;
        }
        if (divisor == 1) {
            return dividend;
        }
        if (divisor == -1) {
            // 负数会溢出
            if (dividend == Integer.MIN_VALUE) {
                return Integer.MAX_VALUE;
            }
            return -dividend;
        }
        // 记录正负号
        int sign = 1;
        if ((dividend > 0 && divisor < 0) || (dividend < 0 && divisor > 0)) {
            sign = -1;
        }
        // 为了避免溢出，统一使用负数进行计算
        dividend = dividend > 0 ? -dividend : dividend;
        divisor = divisor > 0 ? -divisor : divisor;

        return sign * helper(dividend, divisor);
    }

    /**
     * 除数倍增
     *
     * @param dividend
     * @param divisor
     * @return
     */
    private static int helper(int dividend, int divisor) {
        // dividend = -1, divisor = -5
        if (dividend >= divisor) {
            return dividend > divisor ? 0 : 1;
        }
        int count = 1;
        int res = 0;
        int nextDivisor = divisor;
        // nextDivisor可能会溢出，所以判断 nextDivisor < 0
        while (dividend <= nextDivisor && nextDivisor < 0) {
            // 减去已经计算的部分
            dividend -= nextDivisor;
            // 先进行统计，避免加多了
            res += count;
            // 除数倍增
            nextDivisor += nextDivisor;
            count += count;
        }
        return res + helper(dividend, divisor);
    }
}
