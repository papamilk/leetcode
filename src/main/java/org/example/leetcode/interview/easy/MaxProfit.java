package org.example.leetcode.interview.easy;

/**
 * @Description TODO
 * @Author Marcoo
 * @Date 2019/12/20 22:15
 */
public class MaxProfit {

    public static void main(String[] args) {
//        int[] prices = {7,6,4,3,1};
        int[] prices = {2,4,1};
        System.out.println(maxProfit(prices));
    }

    /**
     * 要想获得最大利润，就应该在阶段最低点买入，阶段最高点卖出
     * 1. 判断下一天的价格是否低于买入价格，是的话，说明当前买入位置还不是阶段最低点，应该将买入位置更新
     * 2. 判断条件一: 找到买入位置后，说明买入位置的后一个价格肯定比买入价格高，这个位置可以当作卖出位置
     *    判断条件二：在将买入位置后一个位置的价格当作卖出位置后，如果有接着有比它更高的价格，就更新卖出位置
     * 3. 如果确定了卖出位置，那么算出该阶段的最大利润，并且更改买入位置，重复上面的逻辑
     * 4. 如果卖出位置是最后一个元素，就不会走到第三个判断条件，因此要单独处理一下
     * @param prices
     * @return
     */
    public static int maxProfit(int[] prices) {
        // 要想获得最大利润，就应该在阶段最低点买入，阶段最高点卖出
        // 默认买入位置，每次找到更低的位置会得到更新
        int buyIndex = 0;
        // saleIndex = 0 作为一个买入阶段的标记
        int saleIndex = 0;
        int maxProfit = 0;
        for (int i = 1; i < prices.length; i++) {
            // 1. 判断下一天的价格是否低于买入价格，是的话，说明当前买入位置还不是阶段最低点，应该将买入位置更新
            // saleIndex == 0 作为买入阶段的标记，此时才能更新买入位置
            if (prices[i] < prices[buyIndex] && saleIndex == 0) {
                buyIndex = i;
            } else if (saleIndex <= buyIndex || prices[saleIndex] < prices[i]) {
                // 2. 判断条件一: 找到买入位置后，说明买入位置的后一个价格肯定比买入价格高，这个位置可以当作卖出位置
                // 判断条件二：在将买入位置后一个位置的价格当作卖出位置后，如果有接着有比它更高的价格，就更新卖出位置
                saleIndex = i;
            } else {
                // 如果确定了卖出位置，那么算出该阶段的最大利润
                maxProfit = maxProfit + prices[saleIndex] - prices[buyIndex];
                // 更改买入位置，重复上面的逻辑
                buyIndex = i;
                saleIndex = 0;
            }
        }
        if (saleIndex == prices.length - 1) {
            // 如果卖出位置是最后一个元素，就不会走到第三个判断条件，因此要单独处理一下
            maxProfit = maxProfit + prices[saleIndex] - prices[buyIndex];
        }
        return maxProfit;
    }
}
