/*
 * @lc app=leetcode.cn id=34 lang=java
 *
 * [34] 在排序数组中查找元素的第一个和最后一个位置
 */
class Solution {
    public int[] searchRange(int[] nums, int target) {
        if(nums == null || nums.length <0 || target < nums[0] || target > nums[nums.length-1]){
            return new int[]{-1, -1};
        }

        int first = getFirst(nums, target, 0, nums.length);
        int last = getLast(nums, target, 0, nums.length);
        return new int[]{first, last};
    }

    private int getFirst(int[] nums, int target, int start, int end){
        if(start > end) return 0;
        int mid = (end-start) / 2 + start;
        
        if(nums[mid] > target){
            return getFirst(nums, target, start, mid - 1);
        }else if(nums[mid] < target){
            return getFirst(nums, target, mid + 1, end);
        }else{
        	if(mid == 0) {
        		return mid;
        	}if(nums[mid - 1] == target){
                return getFirst(nums, target, start, mid - 1); 
            }else{
                return mid;
            }
        }
    }
    private int getLast(int[] nums, int target, int start, int end){
        if(start > end) return 0;
        int mid = (end-start) / 2 + start;
        
        if(nums[mid] > target){
            return getLast(nums, target, start, mid - 1);
        }else if(nums[mid] < target){
            return getLast(nums, target, mid + 1, end);
        }else{
        	if(mid == nums.length - 1) {
        		return mid;
        	}else if(nums[mid + 1] == target){
                return getLast(nums, target, mid+1, end); 
            }else{
                return mid;
            }
        }
    }
}

