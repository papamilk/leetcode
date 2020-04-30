package org.example.leetcode.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Description 四数之和    https://leetcode-cn.com/problems/4sum/
 * @Author Marcoo
 * @Date 2020/4/19 21:50
 */
public class Demo018 {

    public static void main(String[] args) {
        int[] nums = {-3,-2,-1,0,0,1,2,3};
        int target = 0;
        System.out.println(fourSum(nums, target));
    }

    public static List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        if (nums == null || nums.length < 4) {
            return ans;
        }

        Arrays.sort(nums);

        int length = nums.length;
        for (int i = 0; i < length - 3; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            // 最小值都大于 target，后面肯定没戏
            int min = nums[i] + nums[i + 1] + nums[i + 2] + nums[i + 3];
            if (min > target) {
                break;
            }

            // 最大值都小于 target，肯定没戏
            int max = nums[i] + nums[length - 1] + nums[length - 2] + nums[length - 3];
            if (max < target) {
                continue;
            }

            for (int j = i + 1; j < length - 2; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }

                if (nums[i] + nums[j] + nums[j + 1] + nums[j + 2] > target) {
                    break;
                }

                if (nums[i] + nums[j] + nums[length - 1] + nums[length - 2] < target) {
                    continue;
                }

                int left = j + 1;
                int right = length - 1;

                while (left < right) {
                    int sum = nums[i] + nums[j] + nums[left] + nums[right];
                    if (sum == target) {
                        ans.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
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
        }
        return ans;
    }
}
