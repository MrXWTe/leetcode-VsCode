/*
 * @lc app=leetcode.cn id=26 lang=java
 *
 * [26] 删除排序数组中的重复项
 */
class Solution {
    public int removeDuplicates(int[] nums) {
        int fast = 0;
        int slow = 0;

        while(fast < nums.length){
            if(nums[fast] == nums[slow]){
                fast++;
            }else{
                slow++;
                int temp = nums[fast];
                nums[fast] = nums[slow];
                nums[slow] = temp;
                fast++;
            }
        }
        return ++slow;
    }
}

