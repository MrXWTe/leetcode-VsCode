/*
 * @lc app=leetcode.cn id=172 lang=java
 *
 * [172] 阶乘后的零
 *
 * https://leetcode-cn.com/problems/factorial-trailing-zeroes/description/
 *
 * algorithms
 * Easy (38.76%)
 * Likes:    133
 * Dislikes: 0
 * Total Accepted:    14K
 * Total Submissions: 36.2K
 * Testcase Example:  '3'
 *
 * 给定一个整数 n，返回 n! 结果尾数中零的数量。
 * 
 * 示例 1:
 * 
 * 输入: 3
 * 输出: 0
 * 解释: 3! = 6, 尾数中没有零。
 * 
 * 示例 2:
 * 
 * 输入: 5
 * 输出: 1
 * 解释: 5! = 120, 尾数中有 1 个零.
 * 
 * 说明: 你算法的时间复杂度应为 O(log n) 。
 * 
 */
class Solution {
    public int trailingZeroes2(int n) {
        int res = 0;
        while(n <= 5){
            res += n/5;
            n /= 5;
        }
        return res;
    }

    public int trailingZeroes(int n){
        if(n < 5) return 0;
        return n/5 + trailingZeroes(n/5);
    }
}

