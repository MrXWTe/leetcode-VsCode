import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=15 lang=java
 *
 * [15] 三数之和
 */
class Solution {

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>();
        for(int i = 0; i<nums.length; i++){
            int temp = nums[i];

            Map<Integer, Integer> map = new HashMap<>();

            for(int j = i+1; j<nums.length; j++){
                if(map.containsKey(-temp - nums[j])){
                    ArrayList<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[j]);
                    list.add(-temp - nums[j]);

                    lists.add(list);
                }else{
                    map.put(nums[j], j);
                }
            }
        }
        return lists;
    }

    /**
     * 暴力循环法
     * 超出时间限制
     */
    public List<List<Integer>> threeSum2(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>();

        for(int i = 0; i<nums.length; i++){
            for(int j = i+1; j<nums.length; j++){
                for(int k = j+1; k<nums.length; k++){
                    if((nums[i] + nums[j] + nums[k]) == 0){
                        ArrayList<Integer> list = new ArrayList<>();
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[k]);

                        lists.add(list);
                    }   
                }
            }
        }

        return lists;
    }
}

