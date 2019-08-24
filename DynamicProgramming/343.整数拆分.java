/*
 * @lc app=leetcode.cn id=343 lang=java
 *
 * [343] 整数拆分
 *
 * https://leetcode-cn.com/problems/integer-break/description/
 *
 * algorithms
 * Medium (52.16%)
 * Likes:    97
 * Dislikes: 0
 * Total Accepted:    8.8K
 * Total Submissions: 16.8K
 * Testcase Example:  '2'
 *
 * 给定一个正整数 n，将其拆分为至少两个正整数的和，并使这些整数的乘积最大化。 返回你可以获得的最大乘积。
 * 
 * 示例 1:
 * 
 * 输入: 2
 * 输出: 1
 * 解释: 2 = 1 + 1, 1 × 1 = 1。
 * 
 * 示例 2:
 * 
 * 输入: 10
 * 输出: 36
 * 解释: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36。
 * 
 * 说明: 你可以假设 n 不小于 2 且不大于 58。
 * 
 */
class Solution {
    int[] memory;
    public int integerBreak(int n) {
        memory = new int[n+1];
        return helper5(n);
    }

    /**
     * 暴力搜索法
     * @param n
     * @return
     */
    public int helper1(int n){
        if(n == 2)
            return 1;
        int res = -1;
        for(int i = 1; i<n; i++){
            res = Math.max(res, Math.max(i*(n-i), i*helper1(n-i)));
        }
        return res;
    }

    /**
     * 备忘录法：自顶向下
     * @param n
     * @return
     */
    public int helper2(int n){
        if(n == 2)
            return 1;
        if(memory[n]!=0)
            return memory[n];
        int res = -1;
        for(int i = 1; i<n; i++){
            res = Math.max(res, Math.max(i*(n-i), i*helper2(n-i)));
        }
        memory[n] = res;
        return res;
    }

    /**
     * 动态规划：自底向上
     * @param n
     * @return
     */
    public int helper3(int n){
        int[] memory1 = new int[n+1];
        memory1[2] = 1;
        for(int i = 3; i<=n; i++){
            for(int j = 1; j<i-1; j++){
                memory1[i] = Math.max(memory1[i], Math.max(j*(i-j), j*memory1[i-j]));
            }
        }
        return memory1[n];
    }

    /**
     * 动态规划：自底向上
     * 根据贪心原则，大于3的因子不需要考虑，因此只需一层循环即可
     * @param n
     * @return
     */
    public int helper4(int n){
        int[] memory1 = new int[n+1];
        memory1[2] = 1;
        for(int i = 3; i<=n; i++){
            memory1[i] = Math.max(Math.max(memory1[i-1], i-1),
                                  Math.max(2*Math.max(memory1[i-2], i-2), 
                                           3*Math.max(memory1[i-3], i-3)));
        }
        return memory1[n];
    }

    /**
     * 动态规划：自底向上
     * 根据贪心原则，大于3的因子不需要考虑，因此只需一层循环即可
     * 使用滚动数组，将空间复杂度降至常数级别
     * @param n
     * @return
     */
    public int helper5(int n){
        int[] memory1 = {0, 1, 1};
        for(int i = 3; i<=n; i++){
            memory1[i%3] = Math.max(Math.max(memory1[(i-1)%3], i-1),
                                    Math.max(2*Math.max(memory1[(i-2)%3], i-2), 
                                             3*Math.max(memory1[(i-3)%3], i-3)));
        }
        return memory1[n%3];
    }

}

