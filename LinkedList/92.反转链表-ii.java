/*
 * @lc app=leetcode.cn id=92 lang=java
 *
 * [92] 反转链表 II
 *
 * https://leetcode-cn.com/problems/reverse-linked-list-ii/description/
 *
 * algorithms
 * Medium (45.87%)
 * Likes:    178
 * Dislikes: 0
 * Total Accepted:    16.8K
 * Total Submissions: 36.3K
 * Testcase Example:  '[1,2,3,4,5]\n2\n4'
 *
 * 反转从位置 m 到 n 的链表。请使用一趟扫描完成反转。
 * 
 * 说明:
 * 1 ≤ m ≤ n ≤ 链表长度。
 * 
 * 示例:
 * 
 * 输入: 1->2->3->4->5->NULL, m = 2, n = 4
 * 输出: 1->4->3->2->5->NULL
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
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if(head==null) return null;

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode cur = dummy;
        for(int i = 1; i<m; i++){
            cur = cur.next;
        }
        head = cur.next;
        for(int i = m; i<n; i++){
            ListNode next = head.next;
            head.next = next.next;
            next.next = cur.next;
            cur.next = next;
        }
        return dummy.next;
    }
}

