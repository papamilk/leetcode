package org.example.leetcode.problems;

/**
 * @author Marcoo
 * @description 29. 两数相除 https://leetcode.cn/problems/divide-two-integers/
 * @date 2022-06-07 21:10
 */
public class Demo029 {

    public static void main(String[] args) {
        System.out.println(divide(3, 4));
    }

    /**
     * 二分法 + 快速乘法
     *
     * @param dividend
     * @param divisor
     * @return
     */
    public static int divide(int dividend, int divisor) {
        long x = dividend;
        long y = divisor;
        boolean isNeg = (x < 0 && y > 0) || (x > 0 && y < 0);
        // 转换成正数，方便计算
        x = x < 0 ? -x : x;
        y = y < 0 ? -y : y;
        // 由于 x/y 的结果一定会落在[0, x]的范围内，所以对x进行二分
        long left = 0;
        long right = x;
        while (left < right) {
            long mid = left + (right - left + 1 >> 1);
            if (quickMultiply(mid, y) <= x) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }
        long res = isNeg ? -left : left;
        if (res > Integer.MAX_VALUE || res < Integer.MIN_VALUE) {
            return Integer.MAX_VALUE;
        }
        return (int) res;
    }

    /**
     * 快速乘法
     *
     * @param a 乘数
     * @param b 被乘数
     * @return
     */
    public static long quickMultiply(long a, long b) {
        long res = 0;
        while (b > 0) {
            if ((b & 1) == 1) {
                // 通过位运算，判断当前位是否需要累加
                res += a;
            }
            // 被乘数右移1位，缩小二分之一，为了保证最终结果不变，乘数要响应变大2倍。 (b * 1/2) * (a * 2) == a * b
            b >>= 1;
            // 因为不能使用乘法，通过加法变大2倍
            a += a;
        }
        return res;
    }

    /**
     * 递归 + 除数倍增
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
