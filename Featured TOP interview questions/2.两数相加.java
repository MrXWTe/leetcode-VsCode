/*
 * @lc app=leetcode.cn id=2 lang=java
 *
 * [2] 两数相加
 *
 * https://leetcode-cn.com/problems/add-two-numbers/description/
 *
 * algorithms
 * Medium (34.03%)
 * Likes:    2392
 * Dislikes: 0
 * Total Accepted:    127.9K
 * Total Submissions: 375.2K
 * Testcase Example:  '[2,4,3]\n[5,6,4]'
 *
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 * 
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 * 
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 * 
 * 示例：
 * 
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
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
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode q = l1;
        ListNode p = l2;
        
        int jin = 0;
        
        while(p != null){
            if(p.next == null && q.next != null){
                p.next = new ListNode(0);
            }
            if(p.next != null && q.next == null){
                q.next = new ListNode(0);
            }
            
            q.val = q.val + p.val + jin;
            jin = q.val / 10;
            q.val %= 10;
            if(p.next==null && q.next==null && jin!=0){
                q.next = new ListNode(jin);
            }
            q = q.next;
            p = p.next;
        }
        
        
        return l1;
    }
}

