/*
 * @lc app=leetcode.cn id=371 lang=java
 *
 * [371] 两整数之和
 */
class Solution {
    public int getSum(int a, int b) {
        while(b != 0){
            int temp = a ^ b;
            b = (a & b) << 1;
            a = temp;
        }
        return a;
    }
}

