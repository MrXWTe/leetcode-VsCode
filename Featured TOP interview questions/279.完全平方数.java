/*
 * @lc app=leetcode.cn id=279 lang=java
 *
 * [279] 完全平方数
 *
 * https://leetcode-cn.com/problems/perfect-squares/description/
 *
 * algorithms
 * Medium (49.17%)
 * Likes:    127
 * Dislikes: 0
 * Total Accepted:    9.8K
 * Total Submissions: 19.9K
 * Testcase Example:  '12'
 *
 * 给定正整数 n，找到若干个完全平方数（比如 1, 4, 9, 16, ...）使得它们的和等于 n。你需要让组成和的完全平方数的个数最少。
 * 
 * 示例 1:
 * 
 * 输入: n = 12
 * 输出: 3 
 * 解释: 12 = 4 + 4 + 4.
 * 
 * 示例 2:
 * 
 * 输入: n = 13
 * 输出: 2
 * 解释: 13 = 4 + 9.
 * 
 */
class Solution {
    public int numSquares(int n) {
        int[] dp = new int[n+1];
        for(int i = 1; i <= n ;i++)
            dp[i] = Integer.MAX_VALUE;
        for(int i = 0; i <= n; i++)
            for(int j = 1 ;i+j*j <= n;j++)
                dp[i+j*j]= dp[i+j*j]>dp[i]+1 ? dp[i]+1 : dp[i+j*j];
        return dp[n];
    }
}

