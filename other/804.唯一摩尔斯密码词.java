import java.util.*;

/*
 * @lc app=leetcode.cn id=804 lang=java
 *
 * [804] 唯一摩尔斯密码词
 */
class Solution {
    public int uniqueMorseRepresentations(String[] words) {
        String[] mose = {".-","-...","-.-.","-..",".",
        "..-.","--.","....","..",".---","-.-",
        ".-..","--","-.","---",".--.","--.-",
        ".-.","...","-","..-","...-",".--","-..-",
        "-.--","--.."};

        Set<String> set = new HashSet<>();

        for(String s : words){
            StringBuilder sb = new StringBuilder();
            for(char c : s.toCharArray()){
                sb.append(mose[c - 'a']);
            }
            set.add(sb.toString());
        }
        return set.size();
    }
}

