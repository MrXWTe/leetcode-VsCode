/*
 * @lc app=leetcode.cn id=69 lang=java
 *
 * [69] x 的平方根
 *
 * https://leetcode-cn.com/problems/sqrtx/description/
 *
 * algorithms
 * Easy (36.32%)
 * Likes:    203
 * Dislikes: 0
 * Total Accepted:    47.7K
 * Total Submissions: 130.6K
 * Testcase Example:  '4'
 *
 * 实现 int sqrt(int x) 函数。
 * 
 * 计算并返回 x 的平方根，其中 x 是非负整数。
 * 
 * 由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。
 * 
 * 示例 1:
 * 
 * 输入: 4
 * 输出: 2
 * 
 * 
 * 示例 2:
 * 
 * 输入: 8
 * 输出: 2
 * 说明: 8 的平方根是 2.82842..., 
 * 由于返回类型是整数，小数部分将被舍去。
 * 
 * 
 */
class Solution {
    
    public int mySqrt(int x){
        if(x < 1)
            return x;
        int l = 1;
        int r = x/2;
        while(true){
            int m = l + (r-l)/2;
            if(m > x/m){
                r = m-1;
            }else if((m+1) > x/(m+1)){
                return m;
            }else{
                l = m+1;
            }
        }
    }
    
    public int mySqrt2(int x) {
        long temp = x;
        while(temp*temp > x){
            temp = (temp + x/temp) / 2;
        }
        return (int)temp;
    }
}

