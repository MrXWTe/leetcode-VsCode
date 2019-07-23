import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=77 lang=java
 *
 * [77] 组合
 *
 * https://leetcode-cn.com/problems/combinations/description/
 *
 * algorithms
 * Medium (68.95%)
 * Likes:    131
 * Dislikes: 0
 * Total Accepted:    14K
 * Total Submissions: 20.2K
 * Testcase Example:  '4\n2'
 *
 * 给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
 * 
 * 示例:
 * 
 * 输入: n = 4, k = 2
 * 输出:
 * [
 * ⁠ [2,4],
 * ⁠ [3,4],
 * ⁠ [2,3],
 * ⁠ [1,2],
 * ⁠ [1,3],
 * ⁠ [1,4],
 * ]
 * 
 */
class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        ArrayList<Integer> list = new ArrayList<>();
        backTrack(1, n, k, list, res);
        return res;
    }
    
    public void backTrack(int level, int n, int k, ArrayList<Integer> list, List<List<Integer>> res){
        if(list.size() == k)
            res.add(new ArrayList<Integer>(list));
       
        for(int i = level; i < n+1; i++){
            list.add(i);
            //if(list.size() <= k)
                backTrack(i+1, n, k, list, res);
            list.remove(list.size() - 1);
        }
    }
}

