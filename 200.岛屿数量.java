/*
 * @lc app=leetcode.cn id=200 lang=java
 *
 * [200] 岛屿数量
 *
 * https://leetcode-cn.com/problems/number-of-islands/description/
 *
 * algorithms
 * Medium (44.53%)
 * Likes:    194
 * Dislikes: 0
 * Total Accepted:    20K
 * Total Submissions: 44.6K
 * Testcase Example:  '[["1","1","1","1","0"],["1","1","0","1","0"],["1","1","0","0","0"],["0","0","0","0","0"]]'
 *
 * 给定一个由 '1'（陆地）和
 * '0'（水）组成的的二维网格，计算岛屿的数量。一个岛被水包围，并且它是通过水平方向或垂直方向上相邻的陆地连接而成的。你可以假设网格的四个边均被水包围。
 * 
 * 示例 1:
 * 
 * 输入:
 * 11110
 * 11010
 * 11000
 * 00000
 * 
 * 输出: 1
 * 
 * 
 * 示例 2:
 * 
 * 输入:
 * 11000
 * 11000
 * 00100
 * 00011
 * 
 * 输出: 3
 * 
 * 
 */
class Solution {
    public int numIslands(char[][] grid) {
        if(grid.length <= 0)
            return 0;
        int rows = grid.length;
        int cols = grid[0].length;
        
        int res = 0;
        for(int i = 0; i<rows; i++){
            for(int j = 0; j<cols; j++){
                if(grid[i][j] == '1'){
                    res++;
                    bfs(grid, i, j);
                }
            }
        }
        
        return res;
    }
    
    public void bfs(char[][] grid, int row, int col){
        if(row<0 || row>=grid.length || col<0 || col>=grid[0].length){
            return;
        }
        
        if(grid[row][col] == '1'){
            grid[row][col] = '2';
            bfs(grid, row-1, col);
            bfs(grid, row+1, col);
            bfs(grid, row, col-1);
            bfs(grid, row, col+1);
        }
    }
}

