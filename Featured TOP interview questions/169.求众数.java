/*
 * @lc app=leetcode.cn id=169 lang=java
 *
 * [169] 求众数
 *
 * https://leetcode-cn.com/problems/majority-element/description/
 *
 * algorithms
 * Easy (59.82%)
 * Likes:    267
 * Dislikes: 0
 * Total Accepted:    51.4K
 * Total Submissions: 85.9K
 * Testcase Example:  '[3,2,3]'
 *
 * 给定一个大小为 n 的数组，找到其中的众数。众数是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。
 * 
 * 你可以假设数组是非空的，并且给定的数组总是存在众数。
 * 
 * 示例 1:
 * 
 * 输入: [3,2,3]
 * 输出: 3
 * 
 * 示例 2:
 * 
 * 输入: [2,2,1,1,1,2,2]
 * 输出: 2
 * 
 * 
 */
class Solution {
    public int majorityElement(int[] nums) {
        int res = 0;
        int count = 0;
        for(int num : nums){
            if(count == 0) res = num;
            count += res == num ? 1 : -1;
        }
        return res;
    }
}

