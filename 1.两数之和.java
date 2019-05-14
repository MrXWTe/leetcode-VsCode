import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=1 lang=java
 *
 * [1] 两数之和
 * 一次哈希遍历，每次存入数字时，都检测是否存在对应的数字
 */
class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i<nums.length; i++){
            if(map.containsKey(target - nums[i])){
                return new int[] {i, map.get(target - nums[i])};
            }else{
                map.put(nums[i], i);
            }
        }
        return null;
    }
}

