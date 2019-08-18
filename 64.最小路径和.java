/*
 * @lc app=leetcode.cn id=64 lang=java
 *
 * [64] 最小路径和
 *
 * https://leetcode-cn.com/problems/minimum-path-sum/description/
 *
 * algorithms
 * Medium (60.51%)
 * Likes:    204
 * Dislikes: 0
 * Total Accepted:    16.3K
 * Total Submissions: 26.7K
 * Testcase Example:  '[[1,3,1],[1,5,1],[4,2,1]]'
 *
 * 给定一个包含非负整数的 m x n 网格，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
 * 
 * 说明：每次只能向下或者向右移动一步。
 * 
 * 示例:
 * 
 * 输入:
 * [
 * [1,3,1],
 * ⁠ [1,5,1],
 * ⁠ [4,2,1]
 * ]
 * 输出: 7
 * 解释: 因为路径 1→3→1→1→1 的总和最小。
 * 
 * 
 */
class Solution {
    public int minPathSum(int[][] grid) {
        if(grid.length == 0 || grid[0].length == 0) return 0;
        for(int i = 1; i<grid[0].length; i++)
            grid[0][i] += grid[0][i-1];
        
        for(int j = 1; j<grid.length; j++)
            grid[j][0] += grid[j-1][0];
        
        for(int i = 1; i<grid.length; i++){
            for(int j = 1; j<grid[0].length; j++){
                grid[i][j] = Math.min(grid[i][j-1], grid[i-1][j]) + grid[i][j];
            }
        }
        
        return grid[grid.length-1][grid[0].length-1];
    }
}

