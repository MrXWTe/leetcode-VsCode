import java.util.Arrays;
import java.util.Comparator;

/*
 * @lc app=leetcode.cn id=179 lang=java
 *
 * [179] 最大数
 *
 * https://leetcode-cn.com/problems/largest-number/description/
 *
 * algorithms
 * Medium (31.46%)
 * Likes:    106
 * Dislikes: 0
 * Total Accepted:    6.1K
 * Total Submissions: 19.1K
 * Testcase Example:  '[10,2]'
 *
 * 给定一组非负整数，重新排列它们的顺序使之组成一个最大的整数。
 * 
 * 示例 1:
 * 
 * 输入: [10,2]
 * 输出: 210
 * 
 * 示例 2:
 * 
 * 输入: [3,30,34,5,9]
 * 输出: 9534330
 * 
 * 说明: 输出结果可能非常大，所以你需要返回一个字符串而不是整数。
 * 
 */
class Solution {
    public String largestNumber(int[] nums) {
        String[] strs = new String[nums.length];
        for(int i = 0; i<nums.length; i++){
            strs[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(strs, new LargeNumberComparator());

        if(strs[0].equals("0")){
            return "0";
        }
        StringBuilder sb = new StringBuilder();
        for(String str : strs){
            sb.append(str);
        }
        return sb.toString();
    }
    
}

/**
 * 自定义比较器，保证排序后使得组合的整数最大
 */
class LargeNumberComparator implements Comparator<String>{
            
    @Override
    public int compare(String s1, String s2){
        String str1 = s1 + s2;
        String str2 = s2 + s1;
        return str2.compareTo(str1);
    }
} 

