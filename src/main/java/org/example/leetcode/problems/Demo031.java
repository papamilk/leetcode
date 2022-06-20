package org.example.leetcode.problems;

import java.util.Arrays;

/**
 * @author Marcoo
 * @desc 下一个排列       https://leetcode.cn/problems/next-permutation/
 * @date 2022-06-14 8:11
 */
public class Demo031 {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        nextPermutation(arr);
        System.out.println(Arrays.toString(arr));
        ;
    }

    public static void nextPermutation(int[] nums) {
        // 1. 从后向前，找出第一个相邻升序的两个数 i , i+ 1
        int i = nums.length - 2;
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }

        if (i >= 0) {
            // 如果存在满足条件1的i，此时 [i+1, end) 必然是降序的
            // 2. 在 [i+1, end) 中从后向前找到第一个满足nums[i+1] < nums[j] 的 j
            int j = nums.length - 1;
            while (nums[i] >= nums[j]) {
                j--;
            }
            // 3. 将 nums[i] 与 nums[j] 交换
            swap(nums, i, j);
        }

        // 4. 此时[j,end)必然是降序的，逆置[j,end)，使其升序
        reverse(nums, i + 1, nums.length - 1);
    }

    private static void reverse(int[] nums, int i, int j) {
        while (i < j) {
            swap(nums, i, j);
            i++;
            j--;
        }
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
