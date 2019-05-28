import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=228 lang=java
 *
 * [228] 汇总区间
 * 
 * 快慢指针法，仅快指针运动，当查找到不在区间的数时，快指针停止查找，将区间添加进list。
 * 并且将慢指针指向快指针++后的位置，此时重新寻找区间
 */
class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> list = new ArrayList<>();
        if(nums.length == 0) return list;

        
        int slow = 0, fast = 0;
        while(fast < nums.length){
            while((fast < nums.length-1) && (nums[fast] == (nums[fast+1] - 1))){
                fast++;
            }
            if(slow == fast){
                list.add(nums[slow]+"");
            }else{
                list.add(nums[slow] + "->" + nums[fast]);
            }

            slow = ++fast;
        }
        return list;
        
    }
}

