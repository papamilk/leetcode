package org.example.leetcode.interview.easy;

import java.util.Arrays;

/**
 * @Description TODO
 * @Author Marcoo
 * @Date 2020/1/2 20:41
 */
public class MoveZeros {

    public static void main(String[] args) {
        int[] nums = {0,1,0};
        moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
    }

    public static void moveZeroes(int[] nums) {
        int startIndex = 0;
        int index = 0;
        while (index < nums.length) {
            if (nums[index] != 0) {
                if (nums[startIndex] == 0) {
                    nums[startIndex] = nums[index];
                    nums[index] = 0;
                    startIndex++;
                }
            } else {
                if (nums[startIndex] != 0) {
                    startIndex = index;
                }
            }
            index++;
        }

    }
}
