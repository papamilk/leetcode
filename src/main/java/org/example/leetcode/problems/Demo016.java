package org.example.leetcode.problems;

import java.util.Arrays;

/**
 * @Description 最接近的三数之和    https://leetcode-cn.com/problems/3sum-closest/
 * @Author Marcoo
 * @Date 2020/4/19 16:21
 */
public class Demo016 {

    public static void main(String[] args) {
        int[] nums = {-1, 2, 1, -4};
        int target = -4;
        System.out.println(threeSumClosest(nums, target));
    }

    /**
     * 数组排序 + 双指针， 与第 16 题思路一样
     * @param nums
     * @param target
     * @return
     */
    public static int threeSumClosest(int[] nums, int target) {

        Arrays.sort(nums);

        int ans = nums[0] + nums[1] + nums[2];
        for (int i = 0; i < nums.length - 2; i++) {
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                int sum = nums[left] + nums[i] + nums[right];
                if (sum == target) {
                    ans = sum;
                    break;
                }

                if (Math.abs(sum - target) < Math.abs(ans - target)) {
                    ans = sum;
                }

                if (sum < target) {
                    while (left < right && nums[left] == nums[left + 1]) {
                        left++;
                    }
                    left++;
                } else {
                    while (left < right && nums[right] == nums[right - 1]) {
                        right--;
                    }
                    right--;
                }
            }
        }
        return ans;
    }
}
