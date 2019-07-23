import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=75 lang=java
 *
 * [75] 颜色分类
 */
class Solution {
    public void sortColors(int[] nums) {
        int p0 = 0, curr = 0;
        int p2 = nums.length - 1;

        int temp = 0;
        while(curr <= p2){
            if(nums[curr] == 0){
                temp = nums[p0];
                nums[p0++] = nums[curr];
                nums[curr++] = temp;
            }else if(nums[curr] == 2){
                temp = nums[p2];
                nums[p2--] = nums[curr];
                nums[curr] = temp;
            }else{
                curr++;
            }
        }
    }
}

