/*
 * @lc app=leetcode.cn id=342 lang=java
 *
 * [342] 4的幂
 */
class Solution {
    public boolean isPowerOfFour(int num) {
        if(num <= 0) return false;
        if( (num & (num - 1)) != 0) return false;
        return (num & 0x55555555) == num;
    }
}

