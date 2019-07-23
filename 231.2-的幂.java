/*
 * @lc app=leetcode.cn id=231 lang=java
 *
 * [231] 2的幂
 */
class Solution {
    public boolean isPowerOfTwo(int n) {
        if(n <= 0) return false;
        return (n & (n-1)) == 0;
    }
}

