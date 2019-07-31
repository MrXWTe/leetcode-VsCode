/*
 * @lc app=leetcode.cn id=188 lang=java
 *
 * [188] 买卖股票的最佳时机 IV
 *
 * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-iv/description/
 *
 * algorithms
 * Hard (27.42%)
 * Likes:    73
 * Dislikes: 0
 * Total Accepted:    2.4K
 * Total Submissions: 8.9K
 * Testcase Example:  '2\n[2,4,1]'
 *
 * 给定一个数组，它的第 i 个元素是一支给定的股票在第 i 天的价格。
 * 
 * 设计一个算法来计算你所能获取的最大利润。你最多可以完成 k 笔交易。
 * 
 * 注意: 你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 * 
 * 示例 1:
 * 
 * 输入: [2,4,1], k = 2
 * 输出: 2
 * 解释: 在第 1 天 (股票价格 = 2) 的时候买入，在第 2 天 (股票价格 = 4) 的时候卖出，这笔交易所能获得利润 = 4-2 = 2 。
 * 
 * 
 * 示例 2:
 * 
 * 输入: [3,2,6,5,0,3], k = 2
 * 输出: 7
 * 解释: 在第 2 天 (股票价格 = 2) 的时候买入，在第 3 天 (股票价格 = 6) 的时候卖出, 这笔交易所能获得利润 = 6-2 = 4
 * 。
 * 随后，在第 5 天 (股票价格 = 0) 的时候买入，在第 6 天 (股票价格 = 3) 的时候卖出, 这笔交易所能获得利润 = 3-0 = 3 。
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
     *      这里k = k，即只能买入和卖出k支股票，因此，状态转移方程可以转化为如下形式
     * 
     * 转化后的状态转移方程：
     *      dp[i][k][0] = max(dp[i-1][k][0], dp[i-1][k][1] + prices[i])
     *      dp[i][k][1] = max(dp[i-1][k][1], dp[i-1][k-1][0] - prices[i])
     * 
     *      当k = 1时
     *      dp[i][1][0] = max(dp[i-1][1][0], dp[i-1][1][1] + prices[i])
     *      dp[i][1][1] = max(dp[i-1][1][1], dp[i-1][0][0] - prices[i])
     * 
     * 这里dp[i-1][0][0] = 0 恒成立
     * 
     * 
     * 
     * 
     * @param prices
     * @return
     */
    public int maxProfit(int k, int[] prices) {
        if(prices.length == 0 || k==0) return 0;
        int len = prices.length;

        // k过大的情况
        if(k > len/2){
           return maxProfit_ini(prices);
        }


        int[][][] dp = new int[len][k][2];

        for(int i = 0; i<k; i++){
            dp[0][i][0] = 0;
            dp[0][i][1] = -prices[0]; 
        }

        for(int i = 1; i<len; i++){
            for(int m = 0; m<k; m++){
                if(m==0){
                    dp[i][m][0] = Math.max(dp[i-1][m][0], dp[i-1][m][1] + prices[i]);
                    dp[i][m][1] = Math.max(dp[i-1][m][1], - prices[i]);
                    continue;
                }
                dp[i][m][0] = Math.max(dp[i-1][m][0], dp[i-1][m][1] + prices[i]);
                dp[i][m][1] = Math.max(dp[i-1][m][1], dp[i-1][m-1][0] - prices[i]);
            }
        }
        return dp[len-1][k-1][0];
    }

    public int maxProfit_ini(int[] prices){
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

    /**
     * 如果只用下面的解法，通过率209/211，有一个样例k=1000000000，导致dp数组内存溢出
     * 因为买卖股票最少需要两天才能盈利，因此k只有在k<=n/2的条件下能够保证最大盈利
     * 当k再大时，也只会等于最大盈利，这时，可以将k=ini进行求解，这样回归到了求解《买卖股票的最佳时机II》了了
     * @param k
     * @param prices
     * @return
     */
    public int maxProfit1(int k, int[] prices) {
        if(prices.length == 0 || k==0) return 0;
        int len = prices.length;
        int[][][] dp = new int[len][k][2];

        for(int i = 0; i<k; i++){
            dp[0][i][0] = 0;
            dp[0][i][1] = -prices[0]; 
        }

        for(int i = 1; i<len; i++){
            for(int m = 0; m<k; m++){
                if(m==0){
                    dp[i][m][0] = Math.max(dp[i-1][m][0], dp[i-1][m][1] + prices[i]);
                    dp[i][m][1] = Math.max(dp[i-1][m][1], - prices[i]);
                    continue;
                }
                dp[i][m][0] = Math.max(dp[i-1][m][0], dp[i-1][m][1] + prices[i]);
                dp[i][m][1] = Math.max(dp[i-1][m][1], dp[i-1][m-1][0] - prices[i]);
            }
        }
        return dp[len-1][k-1][0];
    }
}

