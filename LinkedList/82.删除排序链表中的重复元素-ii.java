/*
 * @lc app=leetcode.cn id=82 lang=java
 *
 * [82] 删除排序链表中的重复元素 II
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
    public ListNode deleteDuplicates(ListNode head) {
        // 空结点或单个结点
        if(head == null || head.next == null) return head;

        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;

        ListNode temp = dummyHead;
        ListNode cur = temp.next;

        while(cur != null && cur.next != null){
            if(cur.val == cur.next.val){
                int val = cur.val;
                while(cur != null && cur.val == val){
                    cur = cur.next;
                }
                temp.next = cur;
            }else{
                temp = temp.next;
                cur = cur.next;
            }
        }
        return dummyHead.next;
    }
}

