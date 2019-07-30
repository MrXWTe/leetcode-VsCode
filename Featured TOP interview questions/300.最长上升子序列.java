/*
 * @lc app=leetcode.cn id=300 lang=java
 *
 * [300] 最长上升子序列
 *
 * https://leetcode-cn.com/problems/longest-increasing-subsequence/description/
 *
 * algorithms
 * Medium (42.24%)
 * Likes:    230
 * Dislikes: 0
 * Total Accepted:    18.1K
 * Total Submissions: 42.3K
 * Testcase Example:  '[10,9,2,5,3,7,101,18]'
 *
 * 给定一个无序的整数数组，找到其中最长上升子序列的长度。
 * 
 * 示例:
 * 
 * 输入: [10,9,2,5,3,7,101,18]
 * 输出: 4 
 * 解释: 最长的上升子序列是 [2,3,7,101]，它的长度是 4。
 * 
 * 说明:
 * 
 * 
 * 可能会有多种最长上升子序列的组合，你只需要输出对应的长度即可。
 * 你算法的时间复杂度应该为 O(n^2) 。
 * 
 * 
 * 进阶: 你能将算法的时间复杂度降低到 O(n log n) 吗?
 * 
 */
class Solution {

    /**
     * 动态规划
     * 时间复杂度：O(n^2)
     * @param nums
     * @return
     */
    public int lengthOfLIS(int[] nums) {
        // 边界检测
        if(nums.length == 0)
            return 0;
        int[] dp = new int[nums.length];
        dp[0] = 1;  // 表示最少也有一个上升序列
        int maxToI = 1;
        for(int i = 0; i<nums.length; i++){
            int maxToJ = 0;
            for(int j = 0; j<i; j++){
                if(nums[i] > nums[j]){
                    maxToJ = Math.max(dp[j], maxToJ);
                }
            }
            dp[i] = maxToJ + 1;
            maxToI = Math.max(dp[i], maxToI);
        }
        return maxToI;
    }
}

