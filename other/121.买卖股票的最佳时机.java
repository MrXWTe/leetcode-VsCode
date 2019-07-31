/*
 * @lc app=leetcode.cn id=121 lang=java
 *
 * [121] 买卖股票的最佳时机
 *
 * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock/description/
 *
 * algorithms
 * Easy (50.19%)
 * Likes:    464
 * Dislikes: 0
 * Total Accepted:    60.3K
 * Total Submissions: 119.7K
 * Testcase Example:  '[7,1,5,3,6,4]'
 *
 * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
 * 
 * 如果你最多只允许完成一笔交易（即买入和卖出一支股票），设计一个算法来计算你所能获取的最大利润。
 * 
 * 注意你不能在买入股票前卖出股票。
 * 
 * 示例 1:
 * 
 * 输入: [7,1,5,3,6,4]
 * 输出: 5
 * 解释: 在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
 * ⁠    注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格。
 * 
 * 
 * 示例 2:
 * 
 * 输入: [7,6,4,3,1]
 * 输出: 0
 * 解释: 在这种情况下, 没有交易完成, 所以最大利润为 0。
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
     *      这里k = 1，即只能买入和卖出一支股票，因此，状态转移方程可以转化为如下形式
     * 
     * 转化后的状态转移方程：
     *      dp[i][1][0] = max(dp[i-1][1][0], dp[i-1][1][1] + prices[i])
     *      dp[i][1][1] = max(dp[i-1][1][1], dp[i-1][0][0] - prices[i])
     * 
     * 这里dp[i-1][0][0] = 0 恒成立
     * 
     * 转化后的状态转移方程：
     *      dp[i][1][0] = max(dp[i-1][1][0], dp[i-1][1][1] + prices[i])
     *      dp[i][1][1] = max(dp[i-1][1][1], - prices[i])
     * 
     * 这里k已经不再影响整个方程了
     * 转化后的状态转移方程：
     *      dp[i][0] = max(dp[i-1][0], dp[i-1][1] + prices[i])
     *      dp[i][1] = max(dp[i-1][1], - prices[i])
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
        for(int i = 1; i<len; i++){
            dp_i0 = Math.max(dp_i0, dp_i1+prices[i]);
            dp_i1 = Math.max(dp_i1, -prices[i]);
        }
        return dp_i0;
    }

    public int maxProfit2(int[] prices) {
        if(prices.length == 0) return 0;
        int len = prices.length;
        int[][] dp = new int[len][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        for(int i = 1; i<len; i++){
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1]+prices[i]);
            dp[i][1] = Math.max(dp[i-1][1], -prices[i]);
        }
        return dp[len - 1][0];
    }

    public int maxProfit1(int[] prices) {
        if(prices.length == 0) return 0;
        int len = prices.length;
        int[][] dp = new int[len][2];
        for(int i = 0; i<len; i++){
            if(i == 0){
                dp[0][0] = 0;
                dp[0][1] = -prices[0];
                continue;
            }
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1]+prices[i]);
            dp[i][1] = Math.max(dp[i-1][1], -prices[i]);
        }
        return dp[len - 1][0];
    }
}

