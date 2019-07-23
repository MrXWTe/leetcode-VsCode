import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * @lc app=leetcode.cn id=90 lang=java
 *
 * [90] 子集 II
 */
class Solution {
    private List<List<Integer>> list;
    private List<Integer> backTrack;
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        list = new ArrayList<>();
        backTrack = new ArrayList<>();
        Arrays.sort(nums);
        findSubsets(nums, 0);
        return list;
    }
    private void findSubsets(int[] nums, int index){
        
        list.add(new ArrayList<>(backTrack));
        
        for(int i = index; i < nums.length; ++i){
            //去除重复的子集
            if(i != index  && nums[i] == nums[i-1])
                continue;
            backTrack.add(nums[i]);
            findSubsets(nums, i+1);
            backTrack.remove(backTrack.size()-1);
        }
    }
}

