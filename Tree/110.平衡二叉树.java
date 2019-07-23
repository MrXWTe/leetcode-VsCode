/*
 * @lc app=leetcode.cn id=110 lang=java
 *
 * [110] 平衡二叉树
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
    boolean flag = true;

    public boolean isBalanced(TreeNode root) {
        if(root == null) return true;
        depth(root);
        return flag;
    }

    public int depth(TreeNode root){
        if(root == null) return 0;
        int leftValue = depth(root.left);
        int rightValue = depth(root.right);
        if(Math.abs(leftValue - rightValue) > 1)
            flag = false;
        return 1 + Math.max(leftValue, rightValue);
    }
}

