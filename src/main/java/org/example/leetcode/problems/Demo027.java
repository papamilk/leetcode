package org.example.leetcode.problems;

/**
 * @Description 移除元素    https://leetcode-cn.com/problems/remove-element/
 * @Author Marcoo
 * @Date 2022-04-22 22:25
 */
public class Demo027 {

    public static void main(String[] args) {
        int[] nums = {3, 2, 2, 3};
        int len = removeElement(nums, 3);
        for (int i = 0; i < len; i++) {
            System.out.println(nums[i]);
        }
    }

    public static int removeElement(int[] nums, int val) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        // 数组长度
        int len = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                if (len != i) {
                    nums[len] = nums[i];
                }
                len++;
            }
        }
        return len;
    }
}
