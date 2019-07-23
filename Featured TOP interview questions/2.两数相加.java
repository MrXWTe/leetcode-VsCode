/*
 * @lc app=leetcode.cn id=2 lang=java
 *
 * [2] 两数相加
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
        int firstVal = (l1.val + l2.val)%10;
        ListNode head = new ListNode(firstVal);
        ListNode cur = head;
        while(l1.next != null && l2.next != null){
            int val = (l1.next.val + l2.next.val + (l1.val + l2.val)/10) % 10;
        }
    }
}

