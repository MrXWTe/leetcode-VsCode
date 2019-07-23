/*
 * @lc app=leetcode.cn id=538 lang=java
 *
 * [538] 把二叉搜索树转换为累加树
 *
 * https://leetcode-cn.com/problems/convert-bst-to-greater-tree/description/
 *
 * algorithms
 * Easy (54.77%)
 * Likes:    116
 * Dislikes: 0
 * Total Accepted:    5.3K
 * Total Submissions: 9.6K
 * Testcase Example:  '[5,2,13]'
 *
 * 给定一个二叉搜索树（Binary Search Tree），把它转换成为累加树（Greater
 * Tree)，使得每个节点的值是原来的节点值加上所有大于它的节点值之和。
 * 
 * 例如：
 * 
 * 
 * 输入: 二叉搜索树:
 * ⁠             5
 * ⁠           /   \
 * ⁠          2     13
 * 
 * 输出: 转换为累加树:
 * ⁠            18
 * ⁠           /   \
 * ⁠         20     13
 * 
 * 
 */
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {

    public TreeNode convertBST(TreeNode root) {
        backOrder(root);
        return root;
    }

    public void backOrder(TreeNode root) {
        if(root == null) {
            return ;
        }
        backOrder(root.right);
        root.val += sum;
        sum = root.val;
        backOrder(root.left);
    }





    /**********************************/
    int sum = 0;
    int cur = 0;
    public TreeNode convertBST2(TreeNode root) {
        sumBST(root);
        cur = sum;
        convert(root);
        return root;
    }
    
    public void convert(TreeNode root){
        if(root == null) return;
        convert(root.left);
        sum -= root.val;
        root.val = cur;
        cur = sum;
        convert(root.right);
    }
    
    public void sumBST(TreeNode root){
        if(root == null) return ;
        sumBST(root.left);
        sum += root.val;
        sumBST(root.right);
    }
}

