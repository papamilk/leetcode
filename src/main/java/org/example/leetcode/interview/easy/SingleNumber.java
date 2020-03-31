package org.example.leetcode.interview.easy;

/**
 * @Description TODO
 * @Author Marcoo
 * @Date 2019/12/25 22:24
 */
public class SingleNumber {

    public static void main(String[] args) {
        int[] nums = {2,2,1};
//        int[] nums = {4,1,2,1,2};
        System.out.println(singleNumberV1(nums));
        System.out.println(singleNumberV2(nums));
    }

    public static int singleNumberV2(int[] nums) {
        int n = 0;
        for (int num : nums) {
            n = n ^ num;
        }
        return n;
    }

    /**
     * 1. 通过计数排序，找到值为 1 的元素
     *
     * 2. 异或操作 XOR
     * @param nums
     * @return
     */
    public static int singleNumberV1(int[] nums) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int num : nums) {
            if (num > max) {
                max = num;
            }
            if (num < min) {
                min = num;
            }
        }

        int len = max - min + 1;
        int[] arr = new int[len];
        for (int num : nums) {
            int index = num - min;
            arr[index] = arr[index] + 1;
        }

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 1) {
                return i + min;
            }
        }
        return 0;
    }
}
