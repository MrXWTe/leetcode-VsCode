import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=70 lang=java
 *
 * [70] 爬楼梯
 */
class Solution {

/**
 * 动态规划经典入门题，到达n阶楼梯的总方法等于到达n-1阶楼梯和n-2阶楼梯的方法
 * 即 F(n) = F(n-1) + F(n-2)
 */

    /**
     * 动态规划法
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
    */
    public int climbStairs(int n) {
        if(n == 0) return 0;
        if(n == 1) return 1;
        if( n== 2) return 2;
        int one = 1;
        int two = 2;
        int res = 0;
        for(int i = 3; i<=n; i++){
            res = one + two;
            one = two;
            two = res;
        }
        return res;
    }

    /**
     * 备忘录算法， hashmap 为备忘录，用于存储已经计算的节点，避免重复计算
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     */
    Map<Integer, Integer> map = new HashMap<>();
    public int climbStairs2(int n) {
        if(n == 0) return 0;
        if(n == 1) return 1;
        if( n== 2) return 2;

        if(map.containsKey(n)){
            return map.get(n);
        }else{
            int value = climbStairs2(n-1) + climbStairs2(n-2);
            map.put(n, value);
            return value;
        }
    }

    /**
     * 递归算法：超出时间限制
     * 时间复杂度：O(2^n)
     * @param n
     * @return
     */
    public int climbStairs1(int n) {
        if(n == 0) return 0;
        if(n == 1) return 1;
        if( n== 2) return 2;
        return climbStairs1(n-1) + climbStairs1(n-2);
    }
}

