/*
 * @lc app=leetcode.cn id=718 lang=java
 *
 * [718] 最长重复子数组
 * 给两个整数数组 A 和 B ，返回两个数组中公共的、长度最长的子数组的长度。
 * 示例 1:
 * 输入:
 * A: [1,2,3,2,1]
 * B: [3,2,1,4,7]
 * 输出: 3
 * 解释: 长度最长的公共子数组是 [3, 2, 1]。
 * 
 * 明显可以用动态规划解决
 * 构造二维dp，循环行和列，当行索引和列索引的值相等时，该索引出的值等于左上角的值加一
 *   * 1 2 3 2 1
 * * 0 0 0 0 0 0
 * 3 0 0 0 1 0 0
 * 2 0 0 1 0 2 0
 * 1 0 1 0 0 0 3
 * 4 0 0 0 0 0 0
 * 7 0 0 0 0 0 0
 */
class Solution {
    

    public int findLength(int[] A, int[] B) {
        int[] dp = new int[B.length + 1];
        int res = 0;
        for (int i = 0; i < A.length; i++) {
            for (int j = B.length - 1; j >= 0; j--) {
                dp[j + 1] = A[i] == B[j] ? dp[j] + 1 : 0;
                res = Math.max(res, dp[j + 1]);
            }
        }     
        return res;
    }
    
    public int findLength2(int[] A, int[] B) {
        int[][] dp = new int[A.length+1][B.length+1];
        int res = 0;

        for(int i = 0; i<=A.length; i++){
            for(int j = 0; j<=B.length; j++){
                if(i == 0 || j == 0){
                    dp[i][j] = 0;
                    continue;
                }else{
                    if(A[i-1] == B[j-1]){
                        dp[i][j] = dp[i-1][j-1]+1;
                        res = Math.max(dp[i][j], res);
                    }
                }
            }
        }
        return res;
    }
}

