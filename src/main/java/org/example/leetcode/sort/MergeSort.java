package org.example.leetcode.sort;

import java.util.Arrays;

public class MergeSort {

    public static void main(String[] args) {
        int[] nums = {5, 1, 1, 2, 0, 0};
//        int[] nums = {-1,2,-8,-10};
        nums = mergeSort(nums);
        System.out.println(Arrays.toString(nums));
    }

    public static int[] mergeSort(int[] nums) {
        if (nums == null || nums.length == 0) {
            return nums;
        }
        int[] temp = new int[nums.length];
        mergeSort(nums, 0, nums.length - 1, temp);
        return nums;
    }

    private static void mergeSort(int[] nums, int start, int end, int[] temp) {
        if (start >= end) {
            return;
        }

        int mid = (start + end) / 2;
        mergeSort(nums, start, mid, temp);
        mergeSort(nums, mid + 1, end, temp);
        merge(nums, start, mid, end, temp);
    }

    private static void merge(int[] nums, int start, int mid, int end, int[] temp) {
        int left = start;
        int right = mid + 1;
        int index = start;

        while (left <= mid && right <= end) {
            if (nums[left] < nums[right]) {
                temp[index++] = nums[left++];
            } else {
                temp[index++] = nums[right++];
            }
        }

        while (left <= mid) {
            temp[index++] = nums[left++];
        }

        while (right <= end) {
            temp[index++] = nums[right++];
        }

        for (int i = start; i <= end; i++) {
            nums[i] = temp[i];
        }
    }
}
