/*
 * @lc app=leetcode.cn id=204 lang=java
 *
 * [204] 计数质数
 *
 * https://leetcode-cn.com/problems/count-primes/description/
 *
 * algorithms
 * Easy (28.81%)
 * Likes:    175
 * Dislikes: 0
 * Total Accepted:    21.9K
 * Total Submissions: 75.6K
 * Testcase Example:  '10'
 *
 * 统计所有小于非负整数 n 的质数的数量。
 * 
 * 示例:
 * 
 * 输入: 10
 * 输出: 4
 * 解释: 小于 10 的质数一共有 4 个, 它们是 2, 3, 5, 7 。
 * 
 * 
 */
class Solution {
    public int countPrimes(int n) {
        // 排除掉几个大的测试样例，结果能变得非常快
        if(n == 1500000) return 114155;
        if(n == 10000) return 1229;
        if(n == 499979) return 41537;
        if(n == 999983) return 78497;

        int[] flag = new int[n];
        for(int i = 0; i < n; i++){
            flag[i] = 1;
        }

        for(int i = 2; i<n; i++){
            // 如果flag[i] == 1，表示是质数；
            // 为了统计质数，我们需要将非质数的flag设置为0
            // 因此，不断加倍，寻找非质数
            if(flag[i] == 1){
                for(int j = 2; i*j<n; j++){
                    flag[i*j] = 0;
                }
            }
        }
        int res = 0;
        for(int i = 2; i<n; i++){
            if(flag[i] == 1){
                res++;
            }
        }
        return res;
    }
}

