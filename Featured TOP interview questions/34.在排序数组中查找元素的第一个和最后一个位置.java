/*
 * @lc app=leetcode.cn id=34 lang=java
 *
 * [34] 在排序数组中查找元素的第一个和最后一个位置
 *
 * https://leetcode-cn.com/problems/find-first-and-last-position-of-element-in-sorted-array/description/
 *
 * algorithms
 * Medium (36.37%)
 * Likes:    129
 * Dislikes: 0
 * Total Accepted:    18.1K
 * Total Submissions: 49.9K
 * Testcase Example:  '[5,7,7,8,8,10]\n8'
 *
 * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
 * 
 * 你的算法时间复杂度必须是 O(log n) 级别。
 * 
 * 如果数组中不存在目标值，返回 [-1, -1]。
 * 
 * 示例 1:
 * 
 * 输入: nums = [5,7,7,8,8,10], target = 8
 * 输出: [3,4]
 * 
 * 示例 2:
 * 
 * 输入: nums = [5,7,7,8,8,10], target = 6
 * 输出: [-1,-1]
 * 
 */
class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] res = {-1, -1};
        int left = findIndex(nums, target, true);
        if(left == nums.length || nums[left] != target){
            return res;
        }
        res[0] = left;
        res[1] = findIndex(nums, target, false) - 1;
        return res;
    }

    public int findIndex(int[] nums, int target, boolean left){
        int l = 0;
        int r = nums.length;

        while(l < r){
            int mid = l + (r-l) / 2;
            if(nums[mid] > target || left && nums[mid] == target){
                // 左区间寻找
                r = mid;
            }else{
                // 右区间寻找
                l = mid+1;
            }
        }
        return l;
    }
}

