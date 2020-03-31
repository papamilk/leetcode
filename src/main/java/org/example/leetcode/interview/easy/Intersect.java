package org.example.leetcode.interview.easy;

import java.util.*;

/**
 * @Description TODO
 * @Author Marcoo
 * @Date 2019/12/26 20:42
 */
public class Intersect {

    public static void main(String[] args) {
//        int[] nums1 = {4, 9, 5};
//        int[] nums2 = {9, 4, 9, 8, 4};
        int[] nums1 = {1,2,2,1};
        int[] nums2 = {2,2};
        System.out.println(Arrays.toString(intersectV2(nums1, nums2)));
    }

    /**
     * 双指针法
     * @param nums1
     * @param nums2
     * @return
     */
    public static int[] intersectV2(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int index1 = 0;
        int index2 = 0;
        int count = 0;
        while (index1 != nums1.length && index2 != nums2.length) {
            if (nums1[index1] == nums2[index2]) {
                nums1[count] = nums1[index1];
                index1++;
                index2++;
                count++;
            } else if (nums1[index1] > nums2[index2]) {
                index2++;
            } else {
                index1++;
            }
        }
        return Arrays.copyOfRange(nums1, 0, count);
    }

    /**
     * 使用HashMap，存储较小数组的元素和该元素出现的次数
     * 遍历另外一个数组，每次在Map中找到该元素，就将该元素记录下来，并且Map中记录的次数减 1 ，次数为0时，则不再记录该元素
     * @param nums1
     * @param nums2
     * @return
     */
    public static int[] intersectV1(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            int[] temp = nums1;
            nums1 = nums2;
            nums2 = temp;
        }

        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums1) {
            Integer value = map.get(num);
            if (value != null) {
                map.put(num, value + 1);
            } else {
                map.put(num, 1);
            }
        }

        List<Integer> list = new ArrayList<>();
        for (int num : nums2) {
            Integer value = map.get(num);
            if (value != null && value != 0) {
                list.add(num);
                value--;
                map.put(num, value);
            }
        }

        int[] arr = new int[list.size()];
        int index = 0;
        for (int num : list) {
            arr[index] = num;
            index++;
        }
        return arr;
    }
}
