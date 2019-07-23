/*
 * @lc app=leetcode.cn id=153 lang=java
 *
 * [153] 寻找旋转排序数组中的最小值
 */
class Solution {
    public int findMin(int[] nums) {
        int head = 0;
        int tail = nums.length - 1;

        // 数组有序
        if(nums[head] < nums[tail]) return nums[head];

        // 数组无序
        while(head < tail && (tail - head) > 1){
            int mid = head + (tail - head)/2;
            if(nums[mid] > nums[head])
                head = mid;
            else
                tail = mid;
        }
        return Math.min(nums[head], nums[tail]);
    }
}

