/*
 * @lc app=leetcode.cn id=206 lang=java
 *
 * [206] 反转链表
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
    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        ListNode reverseNode = null;

        while(cur != null){
            if(cur.next == null){
                reverseNode = cur;
            }
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return reverseNode;
    }
}

