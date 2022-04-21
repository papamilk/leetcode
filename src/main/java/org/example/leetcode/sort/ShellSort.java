package org.example.leetcode.sort;

import java.util.Arrays;

public class ShellSort {

    public static void main(String[] args) {
//        int[] nums = {5,1,1,2,0,0};
        int[] nums = {5, 2, 3, 1};
        nums = shellSort(nums);
        System.out.println(Arrays.toString(nums));
    }

    public static int[] shellSort(int[] nums) {
        if (nums == null || nums.length == 0) {
            return nums;
        }

        int step = nums.length / 2;
        while (step >= 1) {
            for (int i = 0; i < nums.length - step; i++) {
                int current = nums[i + step];
                int index = i;
                while (index >= 0 && current < nums[index]) {
                    nums[index + step] = nums[index];
                    index -= step;
                }
                nums[index + step] = current;
            }
            step = step / 2;
        }
        return nums;
    }
}
