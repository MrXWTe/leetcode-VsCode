/*
 * @lc app=leetcode.cn id=714 lang=java
 *
 * [714] 买卖股票的最佳时机含手续费
 *
 * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-with-transaction-fee/description/
 *
 * algorithms
 * Medium (48.90%)
 * Likes:    46
 * Dislikes: 0
 * Total Accepted:    2K
 * Total Submissions: 4.2K
 * Testcase Example:  '[1,3,2,8,4,9]\n2'
 *
 * 给定一个整数数组 prices，其中第 i 个元素代表了第 i 天的股票价格 ；非负整数 fee 代表了交易股票的手续费用。
 * 
 * 你可以无限次地完成交易，但是你每次交易都需要付手续费。如果你已经购买了一个股票，在卖出它之前你就不能再继续购买股票了。
 * 
 * 返回获得利润的最大值。
 * 
 * 示例 1:
 * 
 * 输入: prices = [1, 3, 2, 8, 4, 9], fee = 2
 * 输出: 8
 * 解释: 能够达到的最大利润:  
 * 在此处买入 prices[0] = 1
 * 在此处卖出 prices[3] = 8
 * 在此处买入 prices[4] = 4
 * 在此处卖出 prices[5] = 9
 * 总利润: ((8 - 1) - 2) + ((9 - 4) - 2) = 8.
 * 
 * 注意:
 * 
 * 
 * 0 < prices.length <= 50000.
 * 0 < prices[i] < 50000.
 * 0 <= fee < 50000.
 * 
 * 
 */


class Solution {


    /**
     * 动态规划
     * 
     * 状态转移方程：
     *      dp[i][k][0] = max(dp[i-1][k][0], dp[i-1][k][1] + prices[i])
     *      dp[i][k][1] = max(dp[i-1][k][1], dp[i-1][k-1][0] - prices[i])
     * 
     * 边界条件：
     *      dp[-1][k][0] = 0：-1天未持有股票，因此为0
     *      dp[-1][k][1] = -ini：-1天持有股票，不可能存在的情况，用负无穷代替
     *      dp[i][0][0] = 0：没有交易过，则利润为0
     *      dp[i][0][1] = -ini：没有交易过却持有股票，不可能存在的情况，用负无穷代替
     * 
     * 说明：
     *      i代表天数，k代表最多交易的次数，0表示未持有股票，1表示持有股票
     *      这里k = ini，即只能买入和卖出多支股票
     *      但每次买入卖出都需要支付一笔小费，可以在卖出时减去小费
     *      因此，状态转移方程可以转化为如下形式
     * 
     * 转化后的状态转移方程：
     *      dp[i][k][0] = max(dp[i-1][k][0], dp[i-1][k][1] + prices[i] - fee)
     *      dp[i][k][1] = max(dp[i-1][k][1], dp[i-1][k-1][0] - prices[i])
     * 
     * 
     * 这里k已经不再影响整个方程了
     * 转化后的状态转移方程：
     *      dp[i][0] = max(dp[i-1][0], dp[i-1][1] + prices[i])
     *      dp[i][1] = max(dp[i-1][1], dp[i-1][1] - prices[i])
     * 
     * 
     * 
     * 
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices, int fee) {
        int len = prices.length;
        int dp_i0 = 0;
        int dp_i1 = -prices[0];
        for(int i = 1; i<len; i++){
            dp_i0 = Math.max(dp_i0, dp_i1 + prices[i] - fee);
            dp_i1 = Math.max(dp_i1, dp_i0 - prices[i]);
        }
        return dp_i0;
    }
}

