package org.example.leetcode.daily;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Description TODO
 * @Author Marcoo
 * @Date 2020/3/29 12:03
 */
public class MaxDistance {
    public static void main(String[] args) {
//        int[][] grid = {{1,0,1}, {0,0,0}, {1,0,1}};
        int[][] grid = {{1,0,0}, {0,0,0}, {0,0,0}};
        System.out.println(maxDistance(grid));
    }

    public static int maxDistance(int[][] grid) {
        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        int length = grid.length;

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                if (grid[i][j] == 1) {
                    queue.add(getIndex(i, j, length));
                }
            }
        }

        int size = queue.size();
        if (size == 0 || size == length * length) {
            return -1;
        }

        int step = 0;
        while (!queue.isEmpty()) {
            int curSize = queue.size();
            for (int i = 0; i < curSize; i++) {
                Integer head = queue.poll();

                int curX = head / length;
                int curY = head % length;

                for (int[] direction : directions) {
                    int newX = curX + direction[0];
                    int nexY = curY + direction[1];

                    if (inArea(newX, nexY, length) && grid[newX][nexY] == 0) {
                        grid[newX][nexY] = 1;
                        queue.add(getIndex(newX, nexY, length));
                    }
                }
            }
            step++;
        }
        return step - 1;
    }

    public static int getIndex(int x, int y, int length) {
        return x * length + y;
    }

    public static boolean inArea(int x, int y, int length) {
        return x >= 0 && x < length && y >= 0 && y < length;
    }


}
