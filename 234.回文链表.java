/*
 * @lc app=leetcode.cn id=234 lang=java
 *
 * [234] 回文链表
 *
 * https://leetcode-cn.com/problems/palindrome-linked-list/description/
 *
 * algorithms
 * Easy (37.58%)
 * Likes:    245
 * Dislikes: 0
 * Total Accepted:    31.7K
 * Total Submissions: 83.2K
 * Testcase Example:  '[1,2]'
 *
 * 请判断一个链表是否为回文链表。
 * 
 * 示例 1:
 * 
 * 输入: 1->2
 * 输出: false
 * 
 * 示例 2:
 * 
 * 输入: 1->2->2->1
 * 输出: true
 * 
 * 
 * 进阶：
 * 你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？
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
    public boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null) return true;

        ListNode slow = head;
        ListNode fast = head;

        ListNode pre = null;
        ListNode next = null;
        while(fast!=null && fast.next!=null){
            fast = fast.next.next;

            next = slow.next;
            slow.next = pre;
            pre = slow;
            slow = next;
        }

        ListNode l = pre;
        ListNode r = fast==null?slow:slow.next;

        while(l != null){
            if(l.val != r.val)
                return false;
            l = l.next;
            r = r.next;
        }
        return true;
    }
}

