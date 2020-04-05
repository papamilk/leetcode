package org.example.leetcode.problems;

/**
 * @Description 接雨水     https://leetcode-cn.com/problems/trapping-rain-water/
 * @Author Marcoo
 * @Date 2020/4/4 10:28
 */
public class Demo042 {
    public static void main(String[] args) {
//        int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};
        int[] height = {4,2,0,3,2,5};
//        int[] height = {2, 1, 0 ,1};
//        int[] height = {3, 2, 1, 0, 0, 2};
        System.out.println(trapV2(height));
    }

    public static int trapV2(int[] height) {
        int left = 0;
        int temp = 0;
        int ans = 0;
        for (int i = 0; i < height.length; i++) {
            if (left == i - 1) {
                if (height[i] >= height[left]) {
                    left = i;
                } else {
                    temp = i;
                }
                continue;
            }

            if (height[i] < height[temp]) {
                temp = i;
                continue;
            }

            if (height[i] > height[temp]) {
                for (int j = temp - 1; j >= left; j--) {
                    if (height[j] > height[temp]) {
                        int h = Math.min(height[i], height[j]) - height[temp];
                        int water = h * (i - j - 1);
                        ans += water;
                        temp = j;
                        if (j == left) {
                            temp = i;
                            if (height[left] <= height[i]) {
                                left = i;
                            }
                            break;
                        }
                        if (height[i] <= height[j]) {
                            temp = i;
                            break;
                        }
                    }
                }
            }
        }
        return ans;
    }

    /**
     * 线性时间方法
     *
     * 思想：通过观察可以知道，要能够接雨水，就必须存在两边高中间低的情况。因此，要先找到一根比它后面要高的柱子，接着往后找到一
     * 根
     * @param height
     * @return
     */
    public static int trap(int[] height) {
        int left = 0;
        int temp = 0;
        int ans = 0;
        for (int i = 1; i < height.length; i++) {
            if (left == i - 1) {
                if (height[i] >= height[left]) {
                    left = i;
                } else {
                    temp = i;
                }
            } else {
                if (height[i] < height[temp]) {
                    temp = i;
                    continue;
                }
                if (height[i] > height[temp]) {
                    for (int j = temp - 1; j >= left; j--) {
                        if (height[j] > height[temp]) {
                            int h = Math.min(height[i], height[j]) - height[temp];
                            int water = h * (i - j - 1);
                            ans += water;
                            temp = j;
                            if (j == left) {
                                temp = i;
                                if (height[left] <= height[i]) {
                                    left = i;
                                }
                                break;
                            }
                            if (height[i] <= height[j]) {
                                temp = i;
                                break;
                            }
                        }
                    }
                }
            }
        }
        return ans;
    }
}
