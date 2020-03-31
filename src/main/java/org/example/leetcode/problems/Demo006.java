package org.example.leetcode.problems;

/**
 * @Description Z 字形变换 https://leetcode-cn.com/problems/zigzag-conversion/
 * @Author Marcoo
 * @Date 2020/3/29 22:02
 */
public class Demo006 {
    public static void main(String[] args) {
        System.out.println(getXLength(20, 4));

        String s = "";
        int numRows = 1;
        System.out.println(convert(s, numRows));
    }

    /**
     * 直接用二维数组
     * @param s
     * @param numRows
     * @return
     */
    public static String convert(String s, int numRows) {
        if (s == null || s.length() < 2 || numRows == 1) {
            return s;
        }

        int xLength = getXLength(s.length(), numRows);
        int[][] arr = new int[xLength][numRows];

        int index = 0;
        boolean down = true;
        int i = 0;
        int j = 0;
        while (index < s.length()) {
            if (j == numRows - 1) {
                down = false;
            }
            if (j == 0) {
                down = true;
            }
            arr[i][j] = s.charAt(index);
            if (down) {
                j++;
            } else {
                j--;
                i++;
            }
            index++;
        }

        StringBuilder builder = new StringBuilder(s.length());
        for (int k = 0; k < numRows; k++) {
            for (int l = 0; l < xLength; l++) {
                int value = arr[l][k];
                if (value != 0) {
                    builder.append((char) value);
                }
            }
        }
        return builder.toString();
    }

    public static int getXLength(int len, int numRows) {
        int n = (2 * numRows) - 2;
        int xLen = (len / n) * (numRows - 1);
        int mod = len % n;
        if (mod != 0) {
            return mod > numRows ? xLen + (mod - numRows + 1) : xLen + 1;
        }
        return xLen;
    }
}
