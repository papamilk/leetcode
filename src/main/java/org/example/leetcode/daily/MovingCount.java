package org.example.leetcode.daily;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Description 面试题13. 机器人的运动范围     https://leetcode-cn.com/problems/ji-qi-ren-de-yun-dong-fan-wei-lcof/
 * @Author Marcoo
 * @Date 2020/4/8 21:21
 */
public class MovingCount {
    public static void main(String[] args) {
        int m = 2;
        int n = 3;
        int k = 1;
        System.out.println(movingCount(m, n ,k));
    }

    /**
     * 广度优先搜索
     *
     * 这里首先想到的是，遍历 上下左右 四个方向。不过由于可以从 数组arr[0][0] 开始遍历，因此只需要向下和向右两个方向即可。
     *
     * 时间复杂度：O(mn)
     *
     * 空间复杂度：O(mn)
     * @param m
     * @param n
     * @param k
     * @return
     */
    public static int movingCount(int m, int n, int k) {
        int[][] directions = {{1, 0}, {0, 1}};
        if (k == 0) {
            return 1;
        }
        int[][] arr = new int[m][n];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        arr[0][0] = 1;
        int count = 1;
        while (!queue.isEmpty()) {
            int curSize = queue.size();
            for (int i = 0; i < curSize; i++) {
                Integer head = queue.poll();
                int curX = head / n;
                int curY = head % n;
                for (int[] direction : directions) {
                    int newX = curX + direction[0];
                    int newY = curY + direction[1];
                    if (inArea(newX, newY, m, n) && isValid(newX, newY, k) && arr[newX][newY] == 0) {
                        queue.add(getIndex(newX, newY, n));
                        arr[newX][newY] = 1;
                        count++;
                    }
                }
            }
        }
        return count;
    }

    public static int getIndex(int x, int y, int length) {
        return x * length + y;
    }

    public static boolean inArea(int x, int y, int m, int n) {
        return x >= 0 && x < m && y >= 0 && y < n;
    }

    public static boolean isValid(int x, int y, int k) {
        int sumX = sum(x);
        int sumY = sum(y);
        return sumX + sumY <= k;
    }

    public static int sum(int num) {
        int sum = 0;
        while (num != 0) {
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }

}
