import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=118 lang=java
 *
 * [118] 杨辉三角
 *
 * https://leetcode-cn.com/problems/pascals-triangle/description/
 *
 * algorithms
 * Easy (62.97%)
 * Likes:    161
 * Dislikes: 0
 * Total Accepted:    28K
 * Total Submissions: 44.4K
 * Testcase Example:  '5'
 *
 * 给定一个非负整数 numRows，生成杨辉三角的前 numRows 行。
 * 
 * 
 * 
 * 在杨辉三角中，每个数是它左上方和右上方的数的和。
 * 
 * 示例:
 * 
 * 输入: 5
 * 输出:
 * [
 * ⁠    [1],
 * ⁠   [1,1],
 * ⁠  [1,2,1],
 * ⁠ [1,3,3,1],
 * ⁠[1,4,6,4,1]
 * ]
 * 
 */
class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        if(numRows == 0)
            return res;
        List<Integer> list = new ArrayList<>();
        list.add(1);
        res.add(list);

        for(int i = 1; i<numRows; i++){
            List<Integer> preList = res.get(i-1);
            List<Integer> list2 = new ArrayList<>();
            list2.add(1);
            for(int j = 1; j<preList.size(); j++){
                list2.add(preList.get(j-1) + preList.get(j));
            }
            list2.add(1);
            res.add(list2);
        }
        return res;
    }
}

