/*
 * @lc app=leetcode.cn id=717 lang=java
 *
 * [717] 1比特与2比特字符
 */
class Solution {
    public boolean isOneBitCharacter(int[] bits) {
        int i = 0;
        for(; i<bits.length-1; ){
            if(bits[i] == 1) i+=2;
            else if(bits[i] == 0) i++;
        }
        return i == bits.length - 1;
    }
}

