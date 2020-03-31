package org.example.leetcode.algorithms;

/**
 * @Description TODO
 * @Author Marcoo
 * @Date 2019/12/23 20:49
 */
public class FindMedianSortedArrays {

    public static void main(String[] args) {
        int[] nums1 = {1, 5};
        int[] nums2 = {2,3,4,6};
        System.out.println(findMedianSortedArrays(nums1, nums2));
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length == 0) {
            return findMedianFromArray(nums2);
        }
        if (nums2.length == 0) {
            return findMedianFromArray(nums1);
        }
        // 交换数组，始终让 num1 表示长度较小的数组
        if (nums1.length > nums2.length) {
            int[] temp = nums1;
            nums1 = nums2;
            nums2 = temp;
        }
        int m = nums1.length;
        int n = nums2.length;
        int mid = (m + n + 1) / 2;
        int i = m / 2;
        while (true) {
            int j = mid - i;
            if (i < m && nums1[i] < nums2[j - 1]) {
                i++;
            } else if (i > 0 && nums2[j] < nums1[i - 1]) {
                i--;
            } else {
                int maxLeft;
                if (i == 0) {
                    maxLeft = nums2[j - 1];
                } else if (j == 0) {
                    maxLeft = nums1[i - 1];
                } else {
                    maxLeft = Math.max(nums1[i - 1], nums2[j - 1]);
                }
                if (isOdd(m + n)) {
                    return maxLeft;
                }
                int minRight;
                if (i == m) {
                    minRight = nums2[j];
                } else if (j == n) {
                    minRight = nums1[i];
                } else {
                    minRight = Math.min(nums1[i], nums2[j]);
                }
                return (maxLeft + minRight) / 2.0;
            }
        }
    }

    private static double findMedianFromArray(int[] nums) {
        int length = nums.length;
        int index = (length - 1)/ 2;
        if (isOdd(length)) {
            return nums[index];
        }else{
            return (nums[index] + nums[index + 1]) / 2.0;
        }
    }

    private static boolean isOdd(int length) {
        return length % 2 == 1;
    }
}
