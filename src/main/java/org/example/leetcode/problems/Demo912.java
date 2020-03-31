package org.example.leetcode.problems;

import java.util.Arrays;

/**
 * @Description 排序数组    https://leetcode-cn.com/problems/sort-an-array/
 * @Author Marcoo
 * @Date 2020/3/31 20:43
 */
public class Demo912 {
    public static void main(String[] args) {
        int[] nums = {5,2,3,1};
//        int[] nums = {5,1,1,2,0,0};
//        System.out.println(Arrays.toString(bubbleSort(nums)));
//        System.out.println(Arrays.toString(selectSort(nums)));
        System.out.println(Arrays.toString(insertSort(nums)));
    }

    /**
     * 插入排序
     *
     * 思想：先将待排序序列的第一个元素看做是一个有序序列，把第二个元素到最后一个元素当成是未排序序列；然后从头到尾依次扫描未排
     * 序序列，将扫描到的每个元素插入到有序序列的适当位置，直到所有数据都完成排序；如果待插入的元素与有序序列中的某个元素相等，
     * 则将待插入元素插入到相等元素的后面。
     * 
     * 时间复杂度：O(n2)
     * 
     * 空间复杂度：O(1)
     * 
     * 排序性质：稳定的内排序
     * @param nums
     * @return
     */
    public static int[] insertSort(int[] nums) {
        if (nums == null || nums.length < 2) {
            return nums;
        }
        for (int i = 1; i < nums.length; i++) {
            int ins = nums[i];
            int k = i - 1;
            while (k >= 0 && ins < nums[k]) {
                k--;
            }
            for (int j = i; j > k + 1; j--) {
                nums[j] = nums[j - 1];
            }
            nums[k + 1] = ins;
        }
        return nums;
    }

    /**
     * 选择排序，简单直观的排序方式
     *
     * 思想：先在数据中找出最大或者最小的元素，放到序列起始位置；然后再从余下的数据中继续寻找最大或者最小的元素，依次放到排序序
     * 列中，直到排序完成。
     *
     * 时间复杂度：O(n2)
     *
     * 空间复杂度：O(1)
     *
     * 排序性质：不稳定的内排序
     * @param nums
     * @return
     */
    public static int[] selectSort(int[] nums) {
        if (nums == null || nums.length < 2) {
            return nums;
        }
        for (int i = 0; i < nums.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[minIndex] > nums[j]) {
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                int temp = nums[minIndex];
                nums[minIndex] = nums[i];
                nums[i] = temp;
            }
        }
        return nums;
    }

    /**
     * 冒泡排序，一种简单排序方式，O(n2)的时间复杂度。当数据量较大时，性能会比较差。本题用冒泡排序会超时。
     *
     * 思想：首先将第一个元素与第二个元素进行比较，如果第一个元素比第二个元素大，那么就交换位置。接着比较第二个元素和第三个元素，
     * 如果第二个元素比第三个元素大，则交换位置，如此往复，直到最后一个元素，这样一轮下来，最大的元素就被交换到最后的位置。接着
     * 进行第二轮，将第二大的元素交换到倒数第二个位置。如此，大的元素下沉到末尾，小的上浮到前面的算法，被形象地称为冒泡排序。
     *
     * 时间复杂度：O(n2)
     *
     * 空间复杂度：O(1)
     *
     * 排序性质：稳定的内排序
     *
     * @param nums
     * @return
     */
    public static int[] bubbleSort(int[] nums) {
        if (nums == null || nums.length < 2) {
            return nums;
        }
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = 0; j < nums.length - i - 1; j++) {
                if (nums[j] > nums[j + 1]) {
                    int temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                }
            }
        }
        return nums;
    }
}
