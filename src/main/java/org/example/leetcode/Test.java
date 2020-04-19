package org.example.leetcode;

/**
 * @Description TODO
 * @Author Marcoo
 * @Date 2020/3/20 20:24
 */
public class Test {
    public static void main(String[] args) {
//        int[] height = {1,8,6,2,5,4,8,3,7};
        int[] height = {1,8};
        System.out.println(maxArea(height));

    }

    /**
     * 双指针
     * 两条线组成的区域面积由两条线之间的距离（长）和较短的线条（宽）决定，一个指针指向开头，一个指针指向末尾，这个时候线条之间的距离是最长的。
     * 接着，由较短的线条向另一个线条移动，这样有可能找到面积更大的区域（长度变小，但是宽度可能会变大很多）。如果是较长的线条向
     * 较短的线条移动，面积不可能变大（长度变小，宽度不变或者变小）。
     * @param height
     * @return
     */
    public static int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int maxArea = 0;
        while (left < right) {
            int area = Math.min(height[left], height[right]) * (right - left);
            if (area > maxArea) {
                maxArea = area;
            }
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return maxArea;
    }

}
