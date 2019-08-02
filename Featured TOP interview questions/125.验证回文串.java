/*
 * @lc app=leetcode.cn id=125 lang=java
 *
 * [125] 验证回文串
 *
 * https://leetcode-cn.com/problems/valid-palindrome/description/
 *
 * algorithms
 * Easy (40.21%)
 * Likes:    97
 * Dislikes: 0
 * Total Accepted:    45K
 * Total Submissions: 111.1K
 * Testcase Example:  '"A man, a plan, a canal: Panama"'
 *
 * 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
 * 
 * 说明：本题中，我们将空字符串定义为有效的回文串。
 * 
 * 示例 1:
 * 
 * 输入: "A man, a plan, a canal: Panama"
 * 输出: true
 * 
 * 
 * 示例 2:
 * 
 * 输入: "race a car"
 * 输出: false
 * 
 * 
 */
class Solution {
    public boolean isPalindrome(String s) {
        if(s.length() == 0 || s.length() == 1) return true; 
        int head = 0;
        int tail = s.length() - 1;
        while(head < tail){
            char l = s.charAt(head);
            char r = s.charAt(tail); 
            if(!isCheck(l)){
                head++;
                continue;
            }
            if(!isCheck(r)){
                tail--;
                continue;
            }
            if(l == r || (l ^ 32) == r){
                head++;
                tail--;
                continue;
            }else{
                return false;
            }
        }
        return true;

    }

    public boolean isCheck(char c){
        if( (c <= 'z' && c >= 'a') || (c <= 'Z' && c >= 'A') || (c <= '9' && c >= '0'))
            return true;
        return false;
    }
}

