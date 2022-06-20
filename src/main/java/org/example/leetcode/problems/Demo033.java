package org.example.leetcode.problems;

/**
 * @author Marcoo
 * @desc 33. 搜索旋转排序数组   https://leetcode.cn/problems/search-in-rotated-sorted-array/
 * @date 2022-06-15 7:50
 */
public class Demo033 {

    public static void main(String[] args) {
        int[] arr = {4, 5, 6, 7, 0, 1, 2};
        int target = 2;
        System.out.println(search(arr, target));
    }

    public static int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }

        int start = 0, end = nums.length - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;

            if (nums[mid] == target) {
                return mid;
            }
            if (nums[start] <= nums[mid]) {
                if (nums[start] <= target && nums[mid] > target) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            } else {
                if (nums[mid] < target && nums[end] >= target) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
        }
        if (nums[start] == target) {
            return start;
        }
        if (nums[end] == target) {
            return end;
        }
        return -1;


    }

    public int binarySearch(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int start = 0, end = nums.length - 1;
        // 用 start + 1 < end 而不是 start < end 的目的是为了避免死循环
        // 在 first position of target 的情况下不会出现死循环
        // 但是在 last position of target 的情况下会出现死循环
        // 样例：nums=[1, 1] target = 1
        // 为了统一模板，我们就采用 start + 1 < end，保证不会出现死循环
        while (start + 1 < end) {
            // 为了防止在 start 和 end 都很大的情况，出现加法 overflow
            // 最好写成 mid = start + (end - start) / 2
            int mid = start + (end - start) / 2;

            // >, =, < 的逻辑分开写，然后再看看 = 的情况是否能够合并到其他分支去
            if (nums[mid] < target) {
                // 写作 start = mid + 1 也是正确的
                // 只是可以偷懒不写，因为不写也没有问题，不会影响时间复杂度
                // 不写的好处是，万一不小心写成了 mid - 1 就错了
                start = mid;
            } else if (nums[mid] == target) {
                end = mid;
            } else {
                // 写作 end = mid - 1 也是正确的
                // 只是可以偷懒不写，因为不写也没有问题，不会影响时间复杂度
                // 不写的好处是，万一不小心写成了 mid + 1 就错了
                end = mid;
            }
        }

        // 因为上面的循环退出条件是 start + 1 < end
        // 因此这里循环结束的时候，start 和 end 的关系是相邻关系(如：1 和 2，3 和 4 这种)
        // 因此需要再单独判断 start 和 end 这两个数谁是我们要的答案
        // 如果是找 first position of target 就先看 start，否则就先看 end
        if (nums[start] == target) {
            return start;
        }
        if (nums[end] == target) {
            return end;
        }
        return -1;
    }
}
