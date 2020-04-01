package org.example.leetcode.problems;

import java.util.Arrays;

/**
 * @Description 排序数组    https://leetcode-cn.com/problems/sort-an-array/
 * @Author Marcoo
 * @Date 2020/3/31 20:43
 */
public class Demo912 {
    public static void main(String[] args) {
//        int[] nums = {5,2,3,1};
        int[] nums = {5,1,1,2,0,0};
//        System.out.println(Arrays.toString(bubbleSort(nums)));
//        System.out.println(Arrays.toString(selectSort(nums)));
//        System.out.println(Arrays.toString(insertSort(nums)));
//        System.out.println(Arrays.toString(shellSort(nums)));
//        System.out.println(Arrays.toString(mergeSortV1(nums)));
//        System.out.println(Arrays.toString(mergeSortV2(nums)));
        System.out.println(Arrays.toString(quickSort(nums)));
    }

    public static int[] heapSort(int[] nums) {
        if (nums == null || nums.length < 2) {
            return nums;
        }
        return nums;

    }

    /**
     * 快速排序，采用分治思想的高效排序算法。（递归版本）
     *
     * 思想：使用分治策略把一个序列分成两个子序列。不同于归并排序的是，它首先从序列中挑出一个元素，并将这个元素称为基准，pivot。所有比
     * 基准元素小的元素放到基准前面，比基准大的元素放到基准后面。如此，将序列分成比基准小的一个子序列，和一个比基准大的子序列。接着分别
     * 对子序列进行操作，直到所有数据都排序完成。
     *
     * 时间复杂度：O(nlogn)
     *
     * 空间复杂度：O(logn)
     *
     * 排序性质：不稳定的内排序
     * @param nums
     * @return
     */
    public static int[] quickSort(int[] nums) {
        if (nums == null || nums.length < 2) {
            return nums;
        }
        return quickSort(nums, 0, nums.length - 1);
    }

    private static int[] quickSort(int[] nums, int left, int right) {
        if (left < right) {
            //获取中轴元素所处的位置
            int mid = partition(nums, left, right);
            //进行分割
            nums = quickSort(nums, left, mid - 1);
            nums = quickSort(nums, mid + 1, right);
        }
        return nums;
    }

    private static int partition(int[] nums, int left, int right) {
        int pivot = nums[left];
        int i = left + 1;
        int j = right;
        while (true) {
            while (i <= j && nums[i] <= pivot) {
                i++;
            }
            while (i <= j && nums[j] >= pivot) {
                j--;
            }
            if (i >= j) {
                break;
            }
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
        nums[left] = nums[j];
        nums[j] = pivot;
        return j;
    }

    /**
     * 归并排序，建立在归并操作上的一种有效的排序算法。（递归版本）
     *
     * 思想：通过分治法将序列拆分成两个子序列，再分别对两个子序列进行拆分，直到序列大小为 1，此时序列只有一个元素，所以是有序的。接着
     * 再把两个大小为 1 的序列合并为大小为2的序列，再把大小为 2 的序列合并为大小为 4 的序列，直到所有序列都合并。由于小的序列是有序的，
     * 因此，合并操作会相当快。
     *
     * 时间复杂度：O(nlogn)
     *
     * 空间复杂度：O(n)
     *
     * 排序性质：稳定的外排序
     *
     * @param nums
     * @return
     */
    public static int[] mergeSortV1(int[] nums) {
        if (nums == null || nums.length < 2) {
            return nums;
        }
        return mergeSortV1(nums, 0, nums.length - 1);
    }

    private static int[] mergeSortV1(int[] nums, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            nums = mergeSortV1(nums, left, mid);
            nums = mergeSortV1(nums, mid + 1, right);
            merge(nums, left, mid, right);
        }
        return nums;
    }

    private static void merge(int[] nums, int left, int mid, int right) {
        int[] temp = new int[right - left + 1];
        int i = left;
        int j = mid + 1;
        int k = 0;
        while (i <= mid && j <= right) {
            if (nums[i] < nums[j]) {
                temp[k++] = nums[i++];
            } else {
                temp[k++] = nums[j++];
            }
        }
        while (i <= mid) {
            temp[k++] = nums[i++];
        }
        while (j <= right) {
            temp[k++] = nums[j++];
        }
        for (i = 0; i < k; i++) {
            nums[left++] = temp[i];
        }
    }

    /**
     * 归并排序（迭代版本）
     * @param nums
     * @return
     */
    public static int[] mergeSortV2(int[] nums) {
        if (nums == null || nums.length < 2) {
            return nums;
        }
        int length = nums.length;
        for (int i = 1; i < length; i+=i) {
            int left = 0;
            int mid = left + i - 1;
            int right = mid + i;
            while (right < length) {
                merge(nums, left, mid, right);
                left = right + 1;
                mid = left + i - 1;
                right = mid + i;
            }

            if (left < length && mid < length) {
                merge(nums, left, mid, length - 1);
            }
        }
        return nums;
    }


    /**
     * 希尔排序，插入排序的改进版本。
     *
     * 思想：插入排序对几乎排好序的数据进行操作时，效果非常好。但是，考虑一种情况，如果序列的最大值正好在第一位，要将它挪到正确的位置需
     * 要 n - 1 次移动。也就是说，如果序列中一个元素距离它正确的位置很远，则需要移动很多次才能到达正确的位置。希尔排序为了改进这一点，
     * 先将整个序列分割成若干个子序列分别进行插入排序，这样消除了大多数不必要的数据移动。待整个序列基本有序后，再对全部数据进行插入排序。
     *
     * 时间复杂度: O(nlogn)
     *
     * 空间复杂度：O(1)
     *
     * 排序性质：不稳定的内排序
     * @param nums
     * @return
     */
    public static int[] shellSort(int[] nums) {
        if (nums == null || nums.length < 2) {
            return nums;
        }

        for (int h = nums.length /2; h > 0; h /= 2) {
            for (int i = h; i < nums.length; i++) {
                insertSort(nums, i, h);
            }
        }
        return nums;
    }

    public static void insertSort(int[] nums, int i, int h) {
        int ins = nums[i];
        int k;
        for (k = i - h; k >= 0 && ins < nums[k]; k -= h) {
            nums[k + h] = nums[k];
        }
        nums[k + h] = ins;
    }

    /**
     * 直接插入排序
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
