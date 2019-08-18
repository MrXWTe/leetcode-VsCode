/*
 * @lc app=leetcode.cn id=143 lang=java
 *
 * [143] 重排链表
 *
 * https://leetcode-cn.com/problems/reorder-list/description/
 *
 * algorithms
 * Medium (50.83%)
 * Likes:    97
 * Dislikes: 0
 * Total Accepted:    7.7K
 * Total Submissions: 15K
 * Testcase Example:  '[1,2,3,4]'
 *
 * 给定一个单链表 L：L0→L1→…→Ln-1→Ln ，
 * 将其重新排列后变为： L0→Ln→L1→Ln-1→L2→Ln-2→…
 * 
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 * 
 * 示例 1:
 * 
 * 给定链表 1->2->3->4, 重新排列为 1->4->2->3.
 * 
 * 示例 2:
 * 
 * 给定链表 1->2->3->4->5, 重新排列为 1->5->2->4->3.
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
class Solution {
    public void reorderList(ListNode head) {
        if(head==null || head.next==null || head.next.next==null) return;
        ListNode fast = head;
        ListNode slow = head;
        // 1、寻找中间结点
        while(fast!=null && fast.next!=null){
            fast = fast.next.next;
            slow = slow.next;
        }
        
        //2、从中间断开链表
        ListNode head2 = slow.next;
        slow.next = null;
        
        //3、反转后半部分结点
        ListNode prev2 = null;
        while(head2!=null){
            ListNode next2 = head2.next;
            head2.next = prev2;
            prev2 = head2;
            head2 = next2;
        }
        
        // 4、拼接两部分链表
        ListNode p1 = head;
        ListNode p2 = prev2;
        while(p1!=null && p2!=null){
            ListNode cur1 = p1.next;
            ListNode cur2 = p2.next;
            p1.next = p2;
            p2.next = cur1;
            p1 = cur1;
            p2 = cur2;
        }
        
    }
}

