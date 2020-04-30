package org.example.leetcode.problems;

import java.util.*;

/**
 * @Description 全排列     https://leetcode-cn.com/problems/permutations/
 * @Author Marcoo
 * @Date 2020/4/25 9:14
 */
public class Demo046 {
    public static void main(String[] args) {
        int[] nums = {1,2,3, 4};
//        int[] nums = {1,2};
//        int[] nums = {1};

//        List<List<Integer>> permute = permute(nums);
        List<List<Integer>> permute = permuteV1(nums);
        for (List<Integer> list : permute) {
            System.out.println(list);
        }
    }

    public static List<List<Integer>> permuteV1(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return ans;
        }

        int length = nums.length;
        Set<Integer> used = new HashSet<>(length);
        Deque<Integer> deque = new ArrayDeque<>(length);

        backtrackV1(ans, deque, used, nums, 0);
        return ans;
    }

    public static void backtrackV1(List<List<Integer>> ans, Deque<Integer> deque, Set<Integer> used, int[] nums, int depth) {
        if (depth == nums.length) {
            ans.add(new ArrayList<>(deque));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (!used.contains(nums[i])) {
                used.add(nums[i]);
                deque.addLast(nums[i]);

                backtrackV1(ans, deque, used, nums, depth + 1);
                deque.removeLast();
                used.remove(nums[i]);
            }

        }
    }

    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return ans;
        }
        List<Integer> list = new ArrayList<>();

        List<Integer> temp = new ArrayList<>(nums.length);
        for (int num : nums) {
            temp.add(num);
        }

        backtrack(ans, list, temp);
        return ans;

    }

    public static void backtrack(List<List<Integer>> ans, List<Integer> list, List<Integer> nums) {
        if (nums.size() == 1) {
            list.add(nums.get(0));
            List<Integer> item = new ArrayList<>(list);
            ans.add(item);
            list.remove(list.size() - 1);
            return;
        }

        for (int num : nums) {
            list.add(num);

            List<Integer> temp = new LinkedList<>(nums);
            temp.remove(Integer.valueOf(num));
            backtrack(ans, list, temp);
            list.remove(list.size() - 1);
        }
    }
}
