package org.example.leetcode.review;

/**
 * @author Marcoo
 * @description
 * @date 2022-06-08 22:42
 */
public class Demo029 {


    public int divide(int dividend, int divisor) {
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
            } else {
                return -dividend;
            }
        }


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
    private int helper(int dividend, int divisor) {
        // dividend = -1, divisor = -5
        if (dividend >= divisor) {
            return dividend > divisor ? 0 : 1;
        }
        int count = 1;
        int res = 0;
        int nextDivisor = divisor;
        while (dividend <= nextDivisor && nextDivisor < 0) {
            dividend -= nextDivisor;
            // 先进行统计，避免加多了
            res += count;
            nextDivisor += nextDivisor;
            count += count;
        }
        return res + helper(dividend, divisor);
    }
}
