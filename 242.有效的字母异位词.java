import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=242 lang=java
 *
 * [242] 有效的字母异位词
 *
 * https://leetcode-cn.com/problems/valid-anagram/description/
 *
 * algorithms
 * Easy (53.99%)
 * Likes:    88
 * Dislikes: 0
 * Total Accepted:    38.2K
 * Total Submissions: 70.1K
 * Testcase Example:  '"anagram"\n"nagaram"'
 *
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
 * 
 * 示例 1:
 * 
 * 输入: s = "anagram", t = "nagaram"
 * 输出: true
 * 
 * 
 * 示例 2:
 * 
 * 输入: s = "rat", t = "car"
 * 输出: false
 * 
 * 说明:
 * 你可以假设字符串只包含小写字母。
 * 
 * 进阶:
 * 如果输入字符串包含 unicode 字符怎么办？你能否调整你的解法来应对这种情况？
 * 
 */
class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length())
            return false;

        int[] array = new int[26];
        for(char c : s.toCharArray()){
            array[c-'a']++;
        }
        for(char c : t.toCharArray()){
            array[c - 'a']--;
            if(array[c - 'a'] < 0)
                return false;
        }
        return true;
    }

    public boolean isAnagram2(String s, String t){
        if(s.length() != t.length()){
            return false;
        }

        Map<Character, Integer> map = new HashMap<>();
        for(char c : s.toCharArray()){
            if(!map.containsKey(c)){
                map.put(c, 1);
            }else{
                map.put(c, map.get(c) + 1);
            }
        }
        for(char c : t.toCharArray()){
            if(!map.containsKey(c)){
                return false;
            }else{
                map.put(c, map.get(c) - 1);
                if(map.get(c) < 0){
                    return false;
                }
            }
        }
        return true;
    }

}

