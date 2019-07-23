import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/*
 * @lc app=leetcode.cn id=94 lang=java
 *
 * [94] 二叉树的中序遍历
 *
 * https://leetcode-cn.com/problems/binary-tree-inorder-traversal/description/
 *
 * algorithms
 * Medium (66.24%)
 * Likes:    220
 * Dislikes: 0
 * Total Accepted:    40K
 * Total Submissions: 60.3K
 * Testcase Example:  '[1,null,2,3]'
 *
 * 给定一个二叉树，返回它的中序 遍历。
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
 * 输出: [1,3,2]
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
    /********************莫里斯方法****************************/
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        TreeNode cur = root;
        TreeNode pre = null;
        while(cur != null){
            // 如果当前结点左结点为空，则可以直接添加进列表，令当前结点为右子结点
            if(cur.left == null){
                list.add(cur.val);
                cur = cur.right;
            }else{// 当前结点左节点不为空
                // 找到当前结点左节点的最右结点
                pre = cur.left;
                while(pre.right != null){
                    pre = pre.right;
                }
                pre.right = cur;
                TreeNode temp = cur.left;
                cur.left = null;
                cur = temp;
            }
        }
        return list;
    }
    
    
    /********************迭代****************************/
    public List<Integer> inorderTraversal3(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        
        while(root != null || !stack.isEmpty()){
            while(root != null){
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            list.add(root.val);
            root = root.right;
        }
        return list;
    }
    
    
    /********************递归****************************/
    public List<Integer> inorderTraversal2(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        inorderTraversal(root, list);
        return list;
    }
    
    public void inorderTraversal(TreeNode root, List<Integer> list){
        if(root == null) return ;
        inorderTraversal(root.left, list);
        list.add(root.val);
        inorderTraversal(root.right, list);
    }
}

