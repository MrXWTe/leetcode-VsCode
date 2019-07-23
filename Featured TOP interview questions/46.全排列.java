import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
 * @lc app=leetcode.cn id=46 lang=java
 *
 * [46] 全排列
 *
 * https://leetcode-cn.com/problems/permutations/description/
 *
 * algorithms
 * Medium (69.98%)
 * Likes:    306
 * Dislikes: 0
 * Total Accepted:    31.2K
 * Total Submissions: 44.4K
 * Testcase Example:  '[1,2,3]'
 *
 * 给定一个没有重复数字的序列，返回其所有可能的全排列。
 * 
 * 示例:
 * 
 * 输入: [1,2,3]
 * 输出:
 * [
 * ⁠ [1,2,3],
 * ⁠ [1,3,2],
 * ⁠ [2,1,3],
 * ⁠ [2,3,1],
 * ⁠ [3,1,2],
 * ⁠ [3,2,1]
 * ]
 * 
 */
class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        ArrayList<Integer> nums_lst = new ArrayList<Integer>();
        for (int num : nums)
            nums_lst.add(num);
        backTrack(0, nums_lst, res, nums.length);
        return res;
    }
    public void backTrack(int level, 
            ArrayList<Integer> nums, List<List<Integer>> res, int n)
    {
        if(level == n){
            res.add(new ArrayList<Integer>(nums));
        }else{
            for(int i = level; i<n; i++){
                Collections.swap(nums, i, level);
                backTrack(level+1, nums, res, n);
                Collections.swap(nums, i, level);
            }
        }
    }
    
}

