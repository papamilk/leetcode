package org.example.leetcode.daily;

/**
 * @Description TODO
 * @Author Marcoo
 * @Date 2020/3/24 21:58
 */
public class Massage {

    public static void main(String[] args) {
        int[] nums = {2,1,4,5,3,1,1,3};
        System.out.println(massage(nums));
    }

    public static int massage(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        if (nums.length == 1) {
            return nums[0];
        }

        int dp0 = 0;
        int dp1 = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int tdp0 = Math.max(dp0, dp1);
            int tdp1 = dp0 + nums[i];

            dp0 = tdp0;
            dp1 = tdp1;
        }
        return Math.max(dp0, dp1);
    }
}
