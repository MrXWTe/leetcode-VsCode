/*
 * @lc app=leetcode.cn id=309 lang=java
 *
 * [309] 最佳买卖股票时机含冷冻期
 *
 * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/description/
 *
 * algorithms
 * Medium (47.81%)
 * Likes:    108
 * Dislikes: 0
 * Total Accepted:    5K
 * Total Submissions: 10.3K
 * Testcase Example:  '[1,2,3,0,2]'
 *
 * 给定一个整数数组，其中第 i 个元素代表了第 i 天的股票价格 。​
 * 
 * 设计一个算法计算出最大利润。在满足以下约束条件下，你可以尽可能地完成更多的交易（多次买卖一支股票）:
 * 
 * 
 * 你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 * 卖出股票后，你无法在第二天买入股票 (即冷冻期为 1 天)。
 * 
 * 
 * 示例:
 * 
 * 输入: [1,2,3,0,2]
 * 输出: 3 
 * 解释: 对应的交易状态为: [买入, 卖出, 冷冻期, 买入, 卖出]
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
     *      并且在卖出和买入股票间需要冻结一天
     *      因此，状态转移方程可以转化为如下形式
     * 
     * 转化后的状态转移方程：
     *      dp[i][k][0] = max(dp[i-1][k][0], dp[i-1][k][1] + prices[i])
     *      dp[i][k][1] = max(dp[i-1][k][1], dp[i-2][k-1][0] - prices[i])
     * 
     * 
     * 这里k已经不再影响整个方程了
     * 转化后的状态转移方程：
     *      dp[i][0] = max(dp[i-1][0], dp[i-1][1] + prices[i])
     *      dp[i][1] = max(dp[i-1][1], dp[i-2][1] - prices[i])
     * 
     * 
     * 
     * 
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        if(prices.length == 0) return 0;
        int len = prices.length;
        int dp_i0 = 0;
        int dp_i1 = -prices[0];
        int dp_pre = 0;
        for(int i = 1; i<len; i++){
            int temp = dp_i0;
            dp_i0 = Math.max(dp_i0, dp_i1+prices[i]);
            dp_i1 = Math.max(dp_i1, dp_pre-prices[i]);
            dp_pre = temp;
        }
        return dp_i0;
    }
}

