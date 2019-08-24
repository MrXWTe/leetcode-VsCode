/*
 * @lc app=leetcode.cn id=338 lang=java
 *
 * [338] 比特位计数
 *
 * https://leetcode-cn.com/problems/counting-bits/description/
 *
 * algorithms
 * Medium (72.84%)
 * Likes:    165
 * Dislikes: 0
 * Total Accepted:    13K
 * Total Submissions: 17.8K
 * Testcase Example:  '2'
 *
 * 给定一个非负整数 num。对于 0 ≤ i ≤ num 范围中的每个数字 i ，计算其二进制数中的 1 的数目并将它们作为数组返回。
 * 
 * 示例 1:
 * 
 * 输入: 2
 * 输出: [0,1,1]
 * 
 * 示例 2:
 * 
 * 输入: 5
 * 输出: [0,1,1,2,1,2]
 * 
 * 进阶:
 * 
 * 
 * 给出时间复杂度为O(n*sizeof(integer))的解答非常容易。但你可以在线性时间O(n)内用一趟扫描做到吗？
 * 要求算法的空间复杂度为O(n)。
 * 你能进一步完善解法吗？要求在C++或任何其他语言中不使用任何内置函数（如 C++ 中的 __builtin_popcount）来执行此操作。
 * 
 * 
 */
class Solution {
    public int[] countBits1(int num) {
        int[] res = new int[num+1];
        res[0] = 0;
        if(num == 0) return res;
        int cur = 1;
        int curs = 1;
        
        for(int i = 1; i<=num; i++){
            if(i == cur){
                curs = cur;
                cur*=2;
                res[i] = 1;
            }else{
                res[i] = res[curs]+res[i-curs];
            }
        }
        return res;
    }
    
     public int[] countBits2(int num) {
        int[] ans = new int[num + 1];
        int i = 0, b = 1;
        // [0, b) is calculated
        while (b <= num) {
            // generate [b, 2b) or [b, num) from [0, b)
            while(i < b && i + b <= num){
                ans[i + b] = ans[i] + 1;
                ++i;
            }
            i = 0;   // reset i
            b <<= 1; // b = 2b
        }
        return ans;
    }
    
    // dp[x] = dp[x>>1] + x&1;
    public int[] countBits3(int num) {
        int[] ans = new int[num + 1];
        for (int i = 1; i <= num; ++i)
            ans[i] = ans[i >> 1] + (i & 1); // x / 2 is x >> 1 and x % 2 is x & 1
        return ans;
    }
    
    // dp[x] = dp[x&(x-1)] + 1;
    public int[] countBits(int num) {
        int[] ans = new int[num + 1];
        for (int i = 1; i <= num; ++i)
            ans[i] = ans[i & (i - 1)] + 1;
        return ans;
    }
}

