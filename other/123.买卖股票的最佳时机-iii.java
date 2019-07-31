package other;

/*
 * @lc app=leetcode.cn id=123 lang=java
 *
 * [123] 买卖股票的最佳时机 III
 *
 * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-iii/description/
 *
 * algorithms
 * Hard (36.32%)
 * Likes:    133
 * Dislikes: 0
 * Total Accepted:    5.9K
 * Total Submissions: 16K
 * Testcase Example:  '[3,3,5,0,0,3,1,4]'
 *
 * 给定一个数组，它的第 i 个元素是一支给定的股票在第 i 天的价格。
 * 
 * 设计一个算法来计算你所能获取的最大利润。你最多可以完成 两笔 交易。
 * 
 * 注意: 你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 * 
 * 示例 1:
 * 
 * 输入: [3,3,5,0,0,3,1,4]
 * 输出: 6
 * 解释: 在第 4 天（股票价格 = 0）的时候买入，在第 6 天（股票价格 = 3）的时候卖出，这笔交易所能获得利润 = 3-0 = 3 。
 * 随后，在第 7 天（股票价格 = 1）的时候买入，在第 8 天 （股票价格 = 4）的时候卖出，这笔交易所能获得利润 = 4-1 = 3 。
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
 * 示例 3:
 * 
 * 输入: [7,6,4,3,1] 
 * 输出: 0 
 * 解释: 在这个情况下, 没有交易完成, 所以最大利润为 0。
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
     *      这里k = 2，即只能买入和卖出两支股票，因此，状态转移方程可以转化为如下形式
     * 
     * 转化后的状态转移方程：
     *      dp[i][1][0] = max(dp[i-1][1][0], dp[i-1][1][1] + prices[i])
     *      dp[i][1][1] = max(dp[i-1][1][1], dp[i-1][0][0] - prices[i])
     *      dp[i][2][0] = max(dp[i-1][2][0], dp[i-1][2][1] + prices[i])
     *      dp[i][2][1] = max(dp[i-1][2][1], dp[i-1][1][0] - prices[i])
     * 
     * 这里dp[i-1][0][0] = 0 恒成立
     * 
     * 转化后的状态转移方程：
     *      dp[i][2][0] = max(dp[i-1][2][0], dp[i-1][2][1] + prices[i])
     *      dp[i][2][1] = max(dp[i-1][2][1], dp[i-1][1][0] - prices[i])
     *      dp[i][1][0] = max(dp[i-1][1][0], dp[i-1][1][1] + prices[i])
     *      dp[i][1][1] = max(dp[i-1][1][1], - prices[i])
     * 
     * 
     * 这里有一点需要注意：你可以在一天内卖出股票，然后再购买当天的股票
     * @param prices
     * @return
     */



    public int maxProfit(int[] prices) {
        if(prices.length == 0) return 0;
        int len = prices.length;
        int dp_i10 = 0, dp_i11 = -prices[0], dp_i20=0, dp_i21 = -prices[0];
        for(int i = 1; i<len; i++){
            dp_i10 = Math.max(dp_i10, dp_i11 + prices[i]);
            dp_i11 = Math.max(dp_i11, - prices[i]);
            dp_i20 = Math.max(dp_i20, dp_i21 + prices[i]);
            dp_i21 = Math.max(dp_i21, dp_i10 - prices[i]);
        }
        return dp_i20;
    }


    public int maxProfit2(int[] prices) {
        if(prices.length == 0) return 0;
        int len = prices.length;
        int[][][] dp = new int[len][2][2];
        dp[0][0][0] = 0;
        dp[0][0][1] = -prices[0];
        dp[0][1][0] = 0;
        dp[0][1][1] = -prices[0];
        for(int i = 1; i<len; i++){
            for(int k = 0; k<2; k++){
                if(k == 0){
                    dp[i][k][0] = Math.max(dp[i-1][k][0], dp[i-1][k][1] + prices[i]);
                    dp[i][k][1] = Math.max(dp[i-1][k][1], - prices[i]);
                }else{
                    dp[i][k][0] = Math.max(dp[i-1][k][0], dp[i-1][k][1] + prices[i]);
                    dp[i][k][1] = Math.max(dp[i-1][k][1], dp[i-1][k-1][0] - prices[i]);
                }
                
            }
        }
        return dp[len-1][1][0];
    }


    public int maxProfit1(int[] prices) {
        if(prices.length == 0) return 0;
        int len = prices.length;
        int[][][] dp = new int[len][2][2];
        for(int i = 0; i<len; i++){
            for(int k = 0; k<2; k++){
                if(i == 0){
                    dp[0][k][0] = 0;
                    dp[0][k][1] = -prices[i];
                    continue;
                }
                if(k == 0){
                    dp[i][k][0] = Math.max(dp[i-1][k][0], dp[i-1][k][1] + prices[i]);
                    dp[i][k][1] = Math.max(dp[i-1][k][1], - prices[i]);
                }else{
                    dp[i][k][0] = Math.max(dp[i-1][k][0], dp[i-1][k][1] + prices[i]);
                    dp[i][k][1] = Math.max(dp[i-1][k][1], dp[i-1][k-1][0] - prices[i]);
                }
                
            }
        }
        return dp[len-1][1][0];
    }
}

