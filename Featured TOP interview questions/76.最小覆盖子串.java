/*
 * @lc app=leetcode.cn id=76 lang=java
 *
 * [76] 最小覆盖子串
 *
 * https://leetcode-cn.com/problems/minimum-window-substring/description/
 *
 * algorithms
 * Hard (35.71%)
 * Likes:    161
 * Dislikes: 0
 * Total Accepted:    6.7K
 * Total Submissions: 18.8K
 * Testcase Example:  '"ADOBECODEBANC"\n"ABC"'
 *
 * 给你一个字符串 S、一个字符串 T，请在字符串 S 里面找出：包含 T 所有字母的最小子串。
 * 
 * 示例：
 * 
 * 输入: S = "ADOBECODEBANC", T = "ABC"
 * 输出: "BANC"
 * 
 * 说明：
 * 
 * 
 * 如果 S 中不存这样的子串，则返回空字符串 ""。
 * 如果 S 中存在这样的子串，我们保证它是唯一的答案。
 * 
 * 
 */
class Solution {
    public String minWindow(String s, String t) {
        int count = 0, left = 0, right = 0, tcount = t.length();
        int[] tHash = new int[128], sHash = new int[128];
        int len = Integer.MAX_VALUE, minLeft = 0;
        
        for(char val : t.toCharArray()){
            tHash[val] ++ ;
            if(tHash[val] > 1) tcount --;
        }
        
        for(char val : s.toCharArray()){
            sHash[val] ++ ;
            if(sHash[val] == tHash[val]) count ++;
            
            while (left <= right && sHash[s.charAt(left)] > tHash[s.charAt(left)]) {
                sHash[s.charAt(left)] -- ;
                left ++ ;
            }
            
            if(count >= tcount){
                int temp = right - left + 1;
                if(temp < len){
                    minLeft = left;
                    len = temp;
                }
            }
            right ++;
        }
        
        if(len != Integer.MAX_VALUE) 
            return s.substring(minLeft, len + minLeft);
        else
            return "";
    }
}

