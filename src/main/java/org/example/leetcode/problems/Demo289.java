package org.example.leetcode.problems;

import java.util.Arrays;

/**
 * 生命游戏     https://leetcode-cn.com/problems/game-of-life/
 * @author zhoujian
 * @date 2020/4/2
 */
public class Demo289 {
    public static void main(String[] args) {
//        int[][] board = {{0, 1, 0}, {0, 0, 1}, {1, 1, 1}, {0, 0, 0}};
        int[][] board = {{0,0,0,0,0,0}, {0,0,0,0,0,0}, {0,0,1,1,1,0}, {0,1,1,1,0,0}, {0,0,0,0,0,0}, {0,0,0,0,0,0}};
        gameOfLife(board);
        for (int i = 0; i < board.length; i++) {
            System.out.println(Arrays.toString(board[i]));
        }
    }

    public static void gameOfLife(int[][] board) {
        if (board == null || board.length == 0) {
            return;
        }

        int[][] directions = {{-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 1}, {1, -1}, {1, 0}, {1, 1}};
        int xLen = board.length;
        int yLen = board[0].length;
        int[][] temp = new int[xLen][yLen];
        for (int i = 0; i < xLen; i++) {
            search: for (int j = 0; j < yLen; j++) {
                int live = 0;
                for (int[] direction : directions) {
                    int x = i + direction[0];
                    int y = j + direction[1];
                    if (inArea(x, y, xLen, yLen) && board[x][y] == 1) {
                        live++;
                        if (live > 3 && board[i][j] == 1) {
                            // 如果活细胞周围八个位置有超过三个活细胞，则该位置活细胞死亡
                            temp[i][j] = 0;
                            continue search;
                        }
                    }
                }
                if (board[i][j] == 1) {
                    if (live < 2) {
                        // 如果活细胞周围八个位置的活细胞数少于两个，则该位置活细胞死亡
                        temp[i][j] = 0;
                    } else {
                        temp[i][j] = 1;
                    }
                }
                if (board[i][j] == 0 && live == 3) {
                    // 如果死细胞周围正好有三个活细胞，则该位置死细胞复活
                    temp[i][j] = 1;
                }
            }
        }
        for (int i = 0; i < temp.length; i++) {
            for (int j = 0; j < temp[i].length; j++) {
                board[i][j] = temp[i][j];
            }
        }
    }

    public static boolean inArea(int x, int y, int xLen, int yLen) {
        return x >= 0 && x < xLen && y >= 0 && y < yLen;
    }
}
