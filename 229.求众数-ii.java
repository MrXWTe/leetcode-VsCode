import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=229 lang=java
 *
 * [229] 求众数 II
 * 
 * 摩尔投票法
 * 桶计数法
 */
class Solution {
    // 摩尔投票法
    // 数组中最多存在两个数，他们的个数能大于 n/3
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> list = new ArrayList<>();
        int n = 0, m = 0, cn = 0, cm = 0;
        for(int a : nums){
            // 找出个数大于n/3的两个数
            if(a == n) cn++;
            else if(a == m) cm++;
            else if(cn == 0){
                n = a;
                cn = 1;
            }
            else if(cm == 0){
                m = a;
                cm = 1;
            }
            else{
                cn--;
                cm--;
            }
        }

        // 计算两个数的个数
        cn = cm = 0;
        for(int a : nums){
            if(a == n) cn++;
            else if(a == m) cm++;
        }

        if(cn > nums.length / 3) list.add(n);
        if(cm > nums.length / 3) list.add(m);
        return list;
    }

    // 桶计数法
    public List<Integer> majorityElement2(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        int num = nums.length / 3;
        
        for(int i = 0; i<nums.length; i++){
            if(map.containsKey(nums[i]))
                map.replace(nums[i], map.get(nums[i]), map.get(nums[i])+1);
            else
                map.put(nums[i], 1);
        }

        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            if(entry.getValue() > num){
                list.add(entry.getKey());
            }
        }
        return list;
    }
}