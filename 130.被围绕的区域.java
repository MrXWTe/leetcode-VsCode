/*
 * @lc app=leetcode.cn id=130 lang=java
 *
 * [130] 被围绕的区域
 *
 * https://leetcode-cn.com/problems/surrounded-regions/description/
 *
 * algorithms
 * Medium (36.62%)
 * Likes:    77
 * Dislikes: 0
 * Total Accepted:    7.1K
 * Total Submissions: 19.2K
 * Testcase Example:  '[["X","X","X","X"],["X","O","O","X"],["X","X","O","X"],["X","O","X","X"]]'
 *
 * 给定一个二维的矩阵，包含 'X' 和 'O'（字母 O）。
 * 
 * 找到所有被 'X' 围绕的区域，并将这些区域里所有的 'O' 用 'X' 填充。
 * 
 * 示例:
 * 
 * X X X X
 * X O O X
 * X X O X
 * X O X X
 * 
 * 
 * 运行你的函数后，矩阵变为：
 * 
 * X X X X
 * X X X X
 * X X X X
 * X O X X
 * 
 * 
 * 解释:
 * 
 * 被围绕的区间不会存在于边界上，换句话说，任何边界上的 'O' 都不会被填充为 'X'。 任何不在边界上，或不与边界上的 'O' 相连的 'O'
 * 最终都会被填充为 'X'。如果两个元素在水平或垂直方向相邻，则称它们是“相连”的。
 * 
 */
class Solution {
    public void solve(char[][] board) {
        if(board == null || board.length <=0)
            return ;
        int rows = board.length;
        int cols = board[0].length;
        
        for(int i=0; i<rows; i++){
            for(int j=0; j<cols; j++){
                boolean isEdge = (i==0 || j==0 || i==rows-1 || j==cols-1);
                if(isEdge && board[i][j] == 'O'){
                    dfs(board, i, j);
                }
            }
        }
        
        for(int i = 0; i<rows; i++){
            for(int j = 0; j<cols; j++){
                if(board[i][j] == 'O')
                    board[i][j] = 'X';
                if(board[i][j] == '#')
                    board[i][j] = 'O';
            }
        }
    }
    
    
    public void dfs(char[][] board, int i, int j){
        if(i<0 || j<0 || i>=board.length || j>=board[0].length || 
           board[i][j]=='X' || board[i][j]=='#')
        {
            return;
        }
        board[i][j] = '#';
        dfs(board, i-1, j);
        dfs(board, i+1, j);
        dfs(board, i, j-1);
        dfs(board, i, j+1);
    }
}

