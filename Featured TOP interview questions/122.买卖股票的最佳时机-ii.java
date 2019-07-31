/*
 * @lc app=leetcode.cn id=122 lang=java
 *
 * [122] 买卖股票的最佳时机 II
 *
 * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii/description/
 *
 * algorithms
 * Easy (54.03%)
 * Likes:    417
 * Dislikes: 0
 * Total Accepted:    62K
 * Total Submissions: 114.5K
 * Testcase Example:  '[7,1,5,3,6,4]'
 *
 * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
 * 
 * 设计一个算法来计算你所能获取的最大利润。你可以尽可能地完成更多的交易（多次买卖一支股票）。
 * 
 * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 * 
 * 示例 1:
 * 
 * 输入: [7,1,5,3,6,4]
 * 输出: 7
 * 解释: 在第 2 天（股票价格 = 1）的时候买入，在第 3 天（股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。
 * 随后，在第 4 天（股票价格 = 3）的时候买入，在第 5 天（股票价格 = 6）的时候卖出, 这笔交易所能获得利润 = 6-3 = 3 。
 * 
 * 
 * 示例 2:
 * 
 * 输入: [1,2,3,4,5]
 * 输出: 4
 * 解释: 在第 1 天（股票价格 = 1）的时候买入，在第 5 天 （股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4
 * 。
 * 注意你不能在第 1 天和第 2 天接连购买股票，之后再将它们卖出。
 * 因为这样属于同时参与了多笔交易，你必须在再次购买前出售掉之前的股票。
 * 
 * 
 * 示例 3:
 * 
 * 输入: [7,6,4,3,1]
 * 输出: 0
 * 解释: 在这种情况下, 没有交易完成, 所以最大利润为 0。
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
     *      这里k = ini，即能买入和卖出股票任意次，因此，状态转移方程可以转化为如下形式
     * 
     * 转化后的状态转移方程：
     *      dp[i][ini][0] = max(dp[i-1][ini][0], dp[i-1][ini][1] + prices[i])
     *      dp[i][ini][1] = max(dp[i-1][ini][1], dp[i-1][ini-1][0] - prices[i])
     * 
     * 这里dp[i][ini][0] = dp[i][ini-1][0] 恒成立，这里k已经不再影响整个方程了
     * 
     * 转化后的状态转移方程：
     *      dp[i][0] = max(dp[i-1][0], dp[i-1][1] + prices[i])
     *      dp[i][1] = max(dp[i-1][1], dp[i-1][0]- prices[i])
     * 
     * 
     * 
     * 
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices){
        if(prices.length == 0) return 0;
        int len = prices.length;
        int dp_i0 = 0;
        int dp_i1 = -prices[0];
        for(int i = 1; i<len; i++){
            dp_i0 = Math.max(dp_i0, dp_i1+prices[i]);
            dp_i1 = Math.max(dp_i1, dp_i0-prices[i]);
        }
        return dp_i0;
    }

    public int maxProfit0(int[] prices) {
        int res = 0;
        for(int i = 1; i<prices.length; i++){
            if(prices[i] > prices[i-1]){
                res += (prices[i] - prices[i-1]);
            }
        }
        return res;    
    }
}

