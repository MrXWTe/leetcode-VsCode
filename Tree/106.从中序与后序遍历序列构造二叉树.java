/*
 * @lc app=leetcode.cn id=106 lang=java
 *
 * [106] 从中序与后序遍历序列构造二叉树
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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(inorder == null || postorder == null || inorder.length == 0)
            return null;
        return helper(inorder, 0, inorder.length-1, postorder, 0, postorder.length-1);
    }

    private TreeNode helper(int[] inorder, int st_in, int end_in, int[] postorder, int st_post, int end_post){
        if(end_in < st_in || end_post < end_post) return null;

        TreeNode root = new TreeNode(postorder[end_post]);


        int rootIndex_in = 0;   //中序遍历中 根节点的位置
        while(inorder[rootIndex_in] != root.val && rootIndex_in < end_in)
            rootIndex_in++;
        
        if(rootIndex_in > end_in) return null;

        int leftLength = rootIndex_in - st_in;
        
        root.left =  helper(inorder, st_in, rootIndex_in - 1, postorder, st_post, st_post + leftLength - 1);
        root.right = helper(inorder, rootIndex_in + 1, end_in, postorder, st_post + leftLength, end_post - 1);
        
        return root;
        //int leftStart_in = st_in;
        //int leftEnd_in = rootIndex_in - 1;
        //int leftStart_post = st_post;
        //int leftEnd_post = st_post + leftLength - 1;

        //int rightStart_in = rootIndex_in + 1;
        //int rightEnd_in = end_in;
        //int rightStart_post = st_post + leftLength;
        //int rightEnd_post = end_post - 1;
        

    }
}

