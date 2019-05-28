import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=228 lang=java
 *
 * [228] 汇总区间
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

