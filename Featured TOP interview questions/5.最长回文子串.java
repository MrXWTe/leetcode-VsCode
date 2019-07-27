/*
 * @lc app=leetcode.cn id=5 lang=java
 *
 * [5] 最长回文子串
 *
 * https://leetcode-cn.com/problems/longest-palindromic-substring/description/
 *
 * algorithms
 * Medium (25.73%)
 * Likes:    1056
 * Dislikes: 0
 * Total Accepted:    79.4K
 * Total Submissions: 304.2K
 * Testcase Example:  '"babad"'
 *
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 * 
 * 示例 1：
 * 
 * 输入: "babad"
 * 输出: "bab"
 * 注意: "aba" 也是一个有效答案。
 * 
 * 
 * 示例 2：
 * 
 * 输入: "cbbd"
 * 输出: "bb"
 * 
 * 
 */
class Solution {
    public String longestPalindrome(String s) {
        int len = s.length();
        if(len == 0) return "";
        
        int resLen = 1;
        String resStr = s.substring(0, 1);
        for(int i = 0; i<len; i++){
            String resOdd = center(s, i, i+1);
            String resEven = center(s, i, i);
            
            String maxLenStr = resOdd.length()>resEven.length()?resOdd:resEven;
            if(maxLenStr.length() > resLen){
                resLen = maxLenStr.length();
                resStr = maxLenStr;
            }
        }
        return resStr;
    }
    
    public String center(String s, int l, int r){
        
        while(l>=0 && r<s.length() && s.charAt(l) == s.charAt(r)){
            l--;
            r++;
        }
        return s.substring(l+1, r);
    }
}

