package org.example.leetcode.sort;

import java.util.Arrays;
import java.util.PriorityQueue;

public class HeapSort {

    public static void main(String[] args) {
//        int[] nums = {5,1,1,2,0,0};
        int[] nums = {-1, 2, -8, -10};
        nums = heapSort(nums);
        System.out.println(Arrays.toString(nums));
    }

    public static int[] heapSort(int[] nums) {
        if (nums == null || nums.length == 0) {
            return nums;
        }

        PriorityQueue<Integer> heap = new PriorityQueue<>();
        for (int n : nums) {
            heap.add(n);
        }
        for (int i = 0; i < nums.length; i++) {
            nums[i] = heap.poll();
        }
        return nums;
    }
}
