/*
 * @lc app=leetcode.cn id=268 lang=java
 *
 * [268] 缺失数字
 *
 * https://leetcode-cn.com/problems/missing-number/description/
 *
 * algorithms
 * Easy (51.43%)
 * Likes:    145
 * Dislikes: 0
 * Total Accepted:    26.5K
 * Total Submissions: 51.1K
 * Testcase Example:  '[3,0,1]'
 *
 * 给定一个包含 0, 1, 2, ..., n 中 n 个数的序列，找出 0 .. n 中没有出现在序列中的那个数。
 * 
 * 示例 1:
 * 
 * 输入: [3,0,1]
 * 输出: 2
 * 
 * 
 * 示例 2:
 * 
 * 输入: [9,6,4,2,3,5,7,0,1]
 * 输出: 8
 * 
 * 
 * 说明:
 * 你的算法应具有线性时间复杂度。你能否仅使用额外常数空间来实现?
 * 
 */
class Solution {

    /**
     * 异或求解缺少的那个数
     * 0 1 2 3 4 
     * 0 1 3 4 5
     * 长度为5
     * res = (0^0) ^ (1^1) ^ (2^3) ^ (3^4) ^ (4^5) ^ 5
     * @param nums
     * @return
     */
    public int missingNumber2(int[] nums) {
        int len = nums.length;
        int res = len;
        for(int i = 0; i<len; i++){
            res ^= i;
            res ^= nums[i];
        }
        return res;
    }

    /**
     * 计算总和然后减去数组中的每个数，余数便是缺少的数
     */
    public int missingNumber(int[] nums){
        int len = nums.length;
        int sum = (len + 0) * (len + 1) / 2;
        for(int i : nums){
            sum -= i;
        }
        return sum;
    }
}

