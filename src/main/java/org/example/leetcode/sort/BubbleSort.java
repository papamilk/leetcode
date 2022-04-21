package org.example.leetcode.sort;

import java.util.Arrays;

public class BubbleSort {

    public static void main(String[] args) {
        int[] nums = {5, 1, 1, 2, 0, 0};
        nums = bubbleSort(nums);
        System.out.println(Arrays.toString(nums));
    }

    public static int[] bubbleSort(int[] nums) {
        if (nums == null || nums.length == 0) {
            return nums;
        }

        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = nums.length - 1; j > i; j--) {
                if (nums[j] < nums[j - 1]) {
                    swap(nums, j, j - 1);
                }
            }
        }
        return nums;
    }

    private static void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}
