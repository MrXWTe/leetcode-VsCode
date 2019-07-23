/*
 * @lc app=leetcode.cn id=238 lang=java
 *
 * [238] 除自身以外数组的乘积
 * 
 * 除了自身以外数组的乘积 = 当前数字左边的乘积  x  当前数字右边的乘积
 */
class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] res = new int[nums.length];

        int k = 1;

        for(int i = 0; i < nums.length; i++){
            res[i] = k;
            k *= nums[i];
        }

        k = 1;

        for(int i = nums.length - 1; i>=0; i--){
            res[i] *= k;
            k *= nums[i];
        }

        return res;
    }
}

