package org.example.leetcode.interview.easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @Description TODO
 * @Author Marcoo
 * @Date 2020/1/2 22:03
 */
public class TwoSum {

    public static void main(String[] args) {
        int target = 0;
        int[] nums = {2049, 4, -1, 0};
        System.out.println(Arrays.toString(twoSumV1(nums, target)));
        System.out.println(Arrays.toString(twoSumV2(nums, target)));
    }

    public static int[] twoSumV2(int[] nums, int target) {
        int volume = 2048;
        int bitMode = volume - 1;

        int[] result = new int[volume];

        for (int i = 0; i < nums.length; i++) {
            int c = (target - nums[i]) & bitMode;
            if (result[c] != 0) {
                return new int[]{result[c] - 1, i};
            }
            result[nums[i] & bitMode] = i + 1;
        }
        return null;
    }

    public static int[] twoSumV1(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>(nums.length);

        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }

        int[] arr = new int[2];
        for (int i = 0; i < nums.length; i++) {
            int num = target - nums[i];
            Integer value = map.get(num);
            if (value != null && value != i) {
                arr[0] = i;
                arr[1] = value;
                return arr;
            }
        }
        return arr;
    }
}
