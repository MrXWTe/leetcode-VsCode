/*
 * @lc app=leetcode.cn id=191 lang=java
 *
 * [191] 位1的个数
 */
public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int count = 0;
        while(n != 0){
            if((n & 1) == 1){
                ++count;
            }  
            n >>>= 1;
        }
        return count;
    }
}

