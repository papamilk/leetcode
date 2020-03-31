package org.example.leetcode.interview.easy;

import java.util.Arrays;

/**
 * @Description TODO
 * @Author Marcoo
 * @Date 2019/12/21 14:38
 */
public class RotateArray {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7};
//        int[] nums = {-1,-100,3,99};
//        rotateV1(nums, 2);
        rotateV2(nums, 3);
        System.out.println(Arrays.toString(nums));
    }

    /**
     * 使用反转
     * 当我们旋转数组k次，k % n个尾部元素会被移动到头部，剩下的元素往后移动。
     * 首先我们反转整个数组，再反转前 k % n 个元素，再反转 n - (k % n) 个元素，就得到了结果
     * @param nums
     * @param k
     */
    public static void rotateV2(int[] nums, int k) {
        k = k % nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }

    private static void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

    /**
     * 暴力解法 O(k * n) 复杂度的算法
     * 每次向右旋转一个位置，总共旋转 k 次
     * @param nums
     * @param k
     */
    public static void rotateV1(int[] nums, int k) {
        for (int i = 0; i < k; i++) {
            int temp = nums[nums.length - 1];
            for (int j = nums.length - 1; j > 0; j--) {
                nums[j] = nums[j - 1];
            }
            nums[0] = temp;
        }
    }
}
