package org.example.leetcode.interview.easy;

/**
 * @Description Remove duplicated element from ordered array
 * @Author Marcoo
 * @Date 2019/12/19 22:56
 */
public class RemoveDuplicates {

    public static void main(String[] args) {
//        int[] nums = {1, 1, 2};
//        int[] nums = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
//        int[] nums = {0, 0, 0};
        int[] nums = {0};
        int count = removeDuplicates(nums);
        for (int i = 0; i < count; i++) {
            System.out.println(nums[i]);
        }
    }

    public static int removeDuplicates(int[] nums) {
        int index = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[index] != nums[i]) {
                nums[++index] = nums[i];
            }
        }
        return ++index;
    }
}
