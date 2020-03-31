package org.example.leetcode.interview.easy;

import java.util.HashSet;
import java.util.Set;

/**
 * @Description TODO
 * @Author Marcoo
 * @Date 2019/12/25 20:26
 */
public class ContainsDuplicate {

    public static void main(String[] args) {
//        int[] nums = {1, 2, 3, 1};
        int[] nums = {1, 2, 3, 4};
        System.out.println(containsDuplicate(nums));
    }

    /**
     * 1. 暴力解法 时间复杂度 O (n2)
     * 依次从数组中拿一个数，对跟其后的数进行比较
     *
     * 2. 排序法
     * 通过排序后，相等的元素肯定会相邻，因此遍历一遍就能找到是否有相等的元素
     *
     * 3. HashMap
     * HashMap 查找的平均时间复杂度是 O (1)
     *
     *
     * @param nums
     * @return
     */
    public static boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (set.contains(num)) {
                return true;
            }
            set.add(num);
        }
        return false;
    }
}
