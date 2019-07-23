/*
 * @lc app=leetcode.cn id=105 lang=java
 *
 * [105] 从前序与中序遍历序列构造二叉树
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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return pre_in(0,preorder.length-1,0,inorder.length-1,preorder,inorder);
      
      }
    
      TreeNode pre_in(int leftPre, int rightPre,int leftIn,int rightIn,int[] pre,int[] in){
        if(leftPre> rightPre || leftIn > rightIn) return null;
        TreeNode root = new TreeNode(pre[leftPre]);//根节点
        
        int rootIn = leftIn;
        while(pre[leftPre] != in[rootIn]){//中序数组中找到根节点的位置
            rootIn++;
        }
        
        int leftLen = rootIn - leftIn;//左子树的个数
        root.left = pre_in(leftPre+1,leftPre+leftLen,leftIn,rootIn-1,pre,in);//便利左子树（前序左子树范围，中序左子树范围，前序序列，中序序列）
        root.right = pre_in(leftPre+leftLen+1,rightPre,rootIn+1,rightIn,pre,in);//便利右子树（前序右子树范围，中序右子树范围，前序序列，中序序列）
        return root;
      }
}

