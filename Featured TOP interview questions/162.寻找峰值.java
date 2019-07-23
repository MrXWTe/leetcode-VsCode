/*
 * @lc app=leetcode.cn id=162 lang=java
 *
 * [162] 寻找峰值
 * 
 * 一般O(lonN)的时间复杂度都利用二分法
 * 如果nums[n] < nums[n+1]，则峰值必在n的右侧，有可能是n+1
 * 如果nums[n] > nums[n+1], 则峰值必在n+1的左侧，有可能是n
 */
class Solution {
    public int findPeakElement(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        while(left < right){
            int mid = left + (right - left) / 2;
            if(nums[mid] > nums[mid + 1]){
                right = mid;
            }else{
                left = mid+1;
            }
        }

        return left;
    }
}

