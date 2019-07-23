/*
 * @lc app=leetcode.cn id=152 lang=java
 *
 * [152] 乘积最大子序列
 */
class Solution {
    public int maxProduct(int[] nums) {
        if(nums.length == 0) return 0;
        if(nums.length == 1) return nums[0];

        int res, max, min, preMax, preMin;
        res = min = max = nums[0];

        for(int i = 1; i<nums.length; i++){
            preMax = max;
            preMin = min;
            max = Math.max(nums[i], Math.max(nums[i] * preMax, nums[i] * preMin));
            min = Math.min(nums[i], Math.min(nums[i] * preMax, nums[i] * preMin));
            res = Math.max(max, res);
        }
        return res;
    }
}

