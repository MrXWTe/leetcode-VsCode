/*
 * @lc app=leetcode.cn id=79 lang=java
 *
 * [79] 单词搜索
 *
 * https://leetcode-cn.com/problems/word-search/description/
 *
 * algorithms
 * Medium (37.30%)
 * Likes:    140
 * Dislikes: 0
 * Total Accepted:    10.4K
 * Total Submissions: 27.8K
 * Testcase Example:  '[["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]]\n"ABCCED"'
 *
 * 给定一个二维网格和一个单词，找出该单词是否存在于网格中。
 * 
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
 * 
 * 示例:
 * 
 * board =
 * [
 * ⁠ ['A','B','C','E'],
 * ⁠ ['S','F','C','S'],
 * ⁠ ['A','D','E','E']
 * ]
 * 
 * 给定 word = "ABCCED", 返回 true.
 * 给定 word = "SEE", 返回 true.
 * 给定 word = "ABCB", 返回 false.
 * 
 */
class Solution {
    public boolean exist(char[][] board, String word) {
        int rows = board.length;
        int cols = board[0].length;

        boolean[][] visited = new boolean[rows][cols];
        for(int i = 0; i<rows; i++){
            for(int j = 0; j<cols; j++){
                if(board[i][j] == word.charAt(0)&&
                   backtrack(i, j, 0, board, word, visited))
                {
                    return true;
                }
            }
        }
        return false;
    }
    public boolean backtrack(int i, int j, int index, char[][] board, 
                                String word, boolean[][] visited)
    {
        if(index == word.length()) return true;

        if(i>=board.length || i<0 || j>=board[0].length || j<0
            || board[i][j]!=word.charAt(index) || visited[i][j])
        {
            return false;
        }
        visited[i][j] = true;
        if(backtrack(i-1, j, index+1, board, word, visited) || 
           backtrack(i+1, j, index+1, board, word, visited) ||
           backtrack(i, j+1, index+1, board, word, visited) ||
           backtrack(i, j-1, index+1, board, word, visited))
        {
            return true;
        }
        visited[i][j] = false;
        return false;
    }
}

