package org.example.leetcode;

/**
 * @Description TODO
 * @Author Marcoo
 * @Date 2020/3/20 20:24
 */
public class Test {
    public static void main(String[] args) {
        int m = 40;
        int n = 3;
        long start = System.currentTimeMillis();
        long result = -1;
        for (int i = 0; i < 1000; i++) {
            result = combine(m, n);
        }
        System.out.println("result" + result + "combine use : " + (System.currentTimeMillis() - start) + "ms");
        start = System.currentTimeMillis();
        for (int i = 0; i < 1000; i++) {
            result = combineV2(m, n);
        }
        System.out.println("result" + result + "combineV2 use : " + (System.currentTimeMillis() - start) + "ms");
        start = System.currentTimeMillis();
        for (int i = 0; i < 1000; i++) {
            result = combineV3(m, n);
        }
        System.out.println("result" + result + " combineV3 use : " + (System.currentTimeMillis() - start) + "ms");

    }

    public static long combineV3(int m, int n) {
        if (n < (m - n)) {
            n = m - n;
        }
        return multiple(m, n + 1) / multiple(m - n, 2);
    }

    public static long combineV2(int m, int n) {
        return multiple(m, 2) / (multiple(n, 2) * multiple(m - n, 2));
    }

    public static long multiple(int m, int n) {
        long result = 1;
        for (int i = n; i <= m; i++) {
            result = result * i;
        }
        return result;
    }

    public static long combine(int m, int n) {
        if (m == n || n == 0) {
            return 1;
        } else {
            return combine(m - 1, n) + combine(m - 1, n - 1);
        }
    }
}
