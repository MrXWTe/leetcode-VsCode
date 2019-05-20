/*
 * @lc app=leetcode.cn id=147 lang=java
 *
 * [147] 对链表进行插入排序
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
    public ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode p = head;
        while (p.next != null) {
            if (p.val > p.next.val) {
                ListNode q = p.next;
                p.next = q.next;
                ListNode pre = dummyHead;
                while (pre.next.val < q.val) {
                    pre = pre.next;
                }
                q.next = pre.next;
                pre.next = q;
            } else {
                p = p.next;
            }
        }
        return dummyHead.next;
    }
}

