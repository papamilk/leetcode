package org.example.leetcode.sort;

import java.util.Arrays;

public class ChoiceSort {

    public static void main(String[] args) {
        int[] nums = {5, 1, 1, 2, 0, 0};
        nums = choiceSort(nums);
        System.out.println(Arrays.toString(nums));
    }

    public static int[] choiceSort(int[] nums) {
        if (nums == null || nums.length == 0) {
            return nums;
        }

        for (int i = 0; i < nums.length - 1; i++) {
            int min = i;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] < nums[min]) {
                    min = j;
                }
            }
            if (min != i) {
                swap(nums, i, min);
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
