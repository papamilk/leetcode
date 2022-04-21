package org.example.leetcode.sort;

import java.util.Arrays;

public class InsertSort {

    public static void main(String[] args) {
        int[] nums = {5, 1, 1, 2, 0, 0};
        nums = insertSort(nums);
        System.out.println(Arrays.toString(nums));
    }

    public static int[] insertSort(int[] nums) {
        if (nums == null || nums.length == 0) {
            return nums;
        }

        for (int i = 0; i < nums.length - 1; i++) {
            int current = nums[i + 1];
            int index = i;
            while (index >= 0 && current < nums[index]) {
                nums[index + 1] = nums[index];
                index--;
            }
            nums[index + 1] = current;
        }
        return nums;
    }
}
