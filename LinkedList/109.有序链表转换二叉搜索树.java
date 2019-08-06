import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=109 lang=java
 *
 * [109] 有序链表转换二叉搜索树
 *
 * https://leetcode-cn.com/problems/convert-sorted-list-to-binary-search-tree/description/
 *
 * algorithms
 * Medium (65.38%)
 * Likes:    75
 * Dislikes: 0
 * Total Accepted:    6.9K
 * Total Submissions: 10.5K
 * Testcase Example:  '[-10,-3,0,5,9]'
 *
 * 给定一个单链表，其中的元素按升序排序，将其转换为高度平衡的二叉搜索树。
 * 
 * 本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。
 * 
 * 示例:
 * 
 * 给定的有序链表： [-10, -3, 0, 5, 9],
 * 
 * 一个可能的答案是：[0, -3, 9, -10, null, 5], 它可以表示下面这个高度平衡二叉搜索树：
 * 
 * ⁠     0
 * ⁠    / \
 * ⁠  -3   9
 * ⁠  /   /
 * ⁠-10  5
 * 
 * 
 */
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
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

    /**
     * 首先将链表转化成数组，在利用数组递归构建二叉树
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     * @param head
     * @return
     */
    public TreeNode sortedListToBST(ListNode head){
        if(head == null) return null;
        else if(head.next == null) return new TreeNode(head.val);
        ArrayList<Integer> list = new ArrayList<>();
        // 将链表中的元素添加进数组
        ListNode cur = head;
        while(cur!=null){
            list.add(cur.val);
            cur = cur.next;
        }
        return sortedArrayToBST(list, 0, list.size() - 1);
    }
    public TreeNode sortedArrayToBST(List<Integer> list, int l, int r){
        if(l > r) return null;
        int m = l + (r - l) >> 1;
        TreeNode root = new TreeNode(list.get(m));
        root.left = sortedArrayToBST(list, l, m-1);
        root.right = sortedArrayToBST(list, m+1, r);
        return root;
    }


    /**
     * 递归
     * 时间复杂度：O(nlogn)
     * 空间复杂度：O(logn)
     * @param head
     * @return
     */
    public TreeNode sortedListToBST2(ListNode head) {
        if(head == null) return null;
        else if(head.next == null) return new TreeNode(head.val);
        ListNode pre = head;
        ListNode p = pre.next;
        ListNode q = p.next;
        //找到链表的中点p
        while(q!=null && q.next!=null){
            pre = pre.next;
            p = pre.next;
            q = q.next.next;
        }
        //将中点左边的链表分开
        pre.next = null;
        TreeNode root = new TreeNode(p.val);
        root.left = sortedListToBST(head);
        root.right = sortedListToBST(p.next);
        return root;
    }
}

