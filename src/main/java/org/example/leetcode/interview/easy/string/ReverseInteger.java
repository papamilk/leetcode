package org.example.leetcode.interview.easy.string;

/**
 * @Description TODO
 * @Author Marcoo
 * @Date 2020/1/8 22:07
 */
public class ReverseInteger {

    public static void main(String[] args) {
        int x = -463847412;
        System.out.println(reverse(x));
        System.out.println(x);
        System.out.println(x / 10);
    }

    public static int reverse(int x) {
        int result = 0;
        while (x != 0) {
            int mod = x % 10;
            if (result > Integer.MAX_VALUE / 10) {
                return 0;
            }
            if (result < Integer.MIN_VALUE / 10) {
                return 0;
            }
            result = result * 10 + mod;
            x /= 10;
        }
        return result;
    }
}
