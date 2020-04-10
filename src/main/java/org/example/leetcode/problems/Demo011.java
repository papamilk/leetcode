package org.example.leetcode.problems;

/**
 * 盛最多水的容器      https://leetcode-cn.com/problems/container-with-most-water/
 * @author zhoujian
 * @date 2020/4/10
 */
public class Demo011 {
    public static void main(String[] args) {
        int[] height = {1, 8, 6, 2, 5, 4, 8, 3, 7};
//        int[] height = {1, 2, 7};
        System.out.println(maxArea(height));
        System.out.println(maxAreaV1(height));
    }

    /**
     * 双指针
     *
     * 思路：两条线之间的面积总是受限于较短的那条线段，同时也与线段之间的距离相关。距离越长，面积越大。因此，刚开始的时候，用一个指针指
     * 向最前端，一个指针指向末尾，记录此时的面积，接着指向较短线段的指针向另一个指针移动，并判断此时面积与原来记录的面积的大小。
     * 这种方法会得到正确结果的原因是，我们一开始就考虑距离越长，面积越大。接着，由较短的线段向较长的线程移动，虽然使得距离变短，但是它
     * 有可能使面积变大。如果将较长的线段往较短线段移动，面积仍然受限于较短的线段，因此不会有作用。
     *
     * 时间复杂度：O(n)
     *
     * 空间复杂度：O(1)
     *
     * @param height
     * @return
     */
    public static int maxAreaV1(int[] height) {
        int left = 0;
        int right = height.length - 1;

        int maxArea = 0;
        while (left < right) {
            int area = Math.min(height[left], height[right]) * (right - left);
            if (maxArea < area) {
                maxArea = area;
            }
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return maxArea;
    }

    /**
     * 暴力求解，直接遍历计算任意两条线构成的容器大小，
     *
     * 时间复杂度：O(n2)
     *
     * 空间复杂度：O(1)
     * @param height
     * @return
     */
    public static int maxArea(int[] height) {
        int max = 0;
        for (int i = 0; i < height.length - 1; i++) {
            for (int j = i + 1; j < height.length; j++) {
                int h = Math.min(height[i], height[j]);
                int v = (j - i) * h;
                if (max < v) {
                    max = v;
                }
            }
        }
        return max;
    }
}
