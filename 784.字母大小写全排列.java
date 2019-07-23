import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=784 lang=java
 *
 * [784] 字母大小写全排列
 *
 * https://leetcode-cn.com/problems/letter-case-permutation/description/
 *
 * algorithms
 * Easy (56.68%)
 * Likes:    80
 * Dislikes: 0
 * Total Accepted:    5.8K
 * Total Submissions: 10.1K
 * Testcase Example:  '"a1b2"'
 *
 * 给定一个字符串S，通过将字符串S中的每个字母转变大小写，我们可以获得一个新的字符串。返回所有可能得到的字符串集合。
 * 
 * 
 * 示例:
 * 输入: S = "a1b2"
 * 输出: ["a1b2", "a1B2", "A1b2", "A1B2"]
 * 
 * 输入: S = "3z4"
 * 输出: ["3z4", "3Z4"]
 * 
 * 输入: S = "12345"
 * 输出: ["12345"]
 * 
 * 
 * 注意：
 * 
 * 
 * S 的长度不超过12。
 * S 仅由数字和字母组成。
 * 
 * 
 */
class Solution {
    public List<String> letterCasePermutation(String S) {
        List<String> list = new ArrayList<>();
        backTrack(S.toCharArray(), 0, list);
        return list;
    }
    
    public void backTrack(char[] chars, int t, List<String> list){
        if(t >= chars.length){
            list.add(String.valueOf(chars));
        }else{
            backTrack(chars, t+1, list);
            if(chars[t] < '0' || chars[t] > '9'){
                chars[t] ^= (1<<5);
                backTrack(chars, t+1, list);
            }
        }
    }
}

