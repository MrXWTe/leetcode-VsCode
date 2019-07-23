import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/*
 * @lc app=leetcode.cn id=144 lang=java
 *
 * [144] 二叉树的前序遍历
 *
 * https://leetcode-cn.com/problems/binary-tree-preorder-traversal/description/
 *
 * algorithms
 * Medium (60.35%)
 * Likes:    120
 * Dislikes: 0
 * Total Accepted:    27.9K
 * Total Submissions: 46.1K
 * Testcase Example:  '[1,null,2,3]'
 *
 * 给定一个二叉树，返回它的 前序 遍历。
 * 
 * 示例:
 * 
 * 输入: [1,null,2,3]  
 * ⁠  1
 * ⁠   \
 * ⁠    2
 * ⁠   /
 * ⁠  3 
 * 
 * 输出: [1,2,3]
 * 
 * 
 * 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
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
    /*************************莫里斯****************************/
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        TreeNode node = root;
        while(node != null){
            if(node.left == null){
                res.add(node.val);
                node = node.right;
            }else{
                TreeNode pre = node.left;
                while(pre.right != null && pre.right != node){
                    pre = pre.right;
                } 
                if(pre.right == null){
                    res.add(node.val);
                    pre.right = node;
                    node = node.left;
                }else if(pre.right == node){
                    pre.right = null;
                    node = node.right;
                }
            }
        }
        return res;
    }

    /*************************迭代****************************/
    public List<Integer> preorderTraversal2(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        if(root == null)
            return res;
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode temp = stack.pop();
            res.add(temp.val);
            if(temp.right != null){
                stack.push(temp.right);
            }
            if(temp.left != null){
                stack.push(temp.left);
            }
        }
        return res;
    }

    /*************************递归****************************/
    public List<Integer> preorderTraversal1(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        preorderTraversal(root, res);
        return res;
    }

    public void preorderTraversal(TreeNode root, List<Integer> res){
        if(root == null){
            return ;
        }
        res.add(root.val);
        preorderTraversal(root.left, res);
        preorderTraversal(root.right, res);
    }
}

