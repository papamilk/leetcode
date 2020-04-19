package org.example.leetcode.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Description 三数之和    https://leetcode-cn.com/problems/3sum/
 * @Author Marcoo
 * @Date 2020/4/19 11:48
 */
public class Demo015 {

    public static void main(String[] args) {

//        int[] nums = {-1, 0, 1, 2, -1, -4};
//        int[] nums = {-1, 0, 1, -1, 0, 1};
        int[] nums = {-1, -1, -1, 0, 1, 1, 2, 2};
//        int[] nums = {0, 0, 0,0};
        List<List<Integer>> list = threeSum(nums);

        for (List<Integer> l : list) {
            System.out.println(l);
        }
    }

    /**
     * 排序 + 双指针
     *
     * 时间复杂度: O(n2)
     *
     * 空间复杂度：O(1)
     * @param nums
     * @return
     */
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();

        if (nums == null || nums.length < 3) {
            return ans;
        }

        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++) {
            if (nums[i] > 0) {
                break;
            }

            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int left = i + 1;
            int right = nums.length - 1;

            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == 0) {
                    ans.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    while (left < right && nums[left] == nums[left + 1]) {
                        left++;
                    }
                    while (left < right && nums[right] == nums[right - 1]) {
                        right--;
                    }
                    left++;
                    right--;
                    continue;
                }

                if (sum < 0) {
                    left++;
                } else {
                    right--;
                }

            }
        }
        return ans;
    }
}
