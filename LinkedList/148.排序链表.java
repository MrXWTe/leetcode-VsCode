/*
 * @lc app=leetcode.cn id=148 lang=java
 *
 * [148] 排序链表
 *
 * https://leetcode-cn.com/problems/sort-list/description/
 *
 * algorithms
 * Medium (59.88%)
 * Likes:    190
 * Dislikes: 0
 * Total Accepted:    12.8K
 * Total Submissions: 21.4K
 * Testcase Example:  '[4,2,1,3]'
 *
 * 在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序。
 * 
 * 示例 1:
 * 
 * 输入: 4->2->1->3
 * 输出: 1->2->3->4
 * 
 * 
 * 示例 2:
 * 
 * 输入: -1->5->3->4->0
 * 输出: -1->0->3->4->5
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
    public ListNode sortList(ListNode head) {
        public ListNode sortList(ListNode head) {
            if(head == null || head.next == null) 
                return head;
                
            ListNode fast = head.next;
            ListNode slow = head;
    
            // 找到链表中点
            while(fast != null && fast.next != null){
                slow = slow.next;
                fast = fast.next.next;
            }
    
            fast = slow.next;
            slow.next = null;
            head = sortList(head);
            fast = sortList(fast);
            return merge(head, fast);
    
        }
    
        public ListNode merge(ListNode l1, ListNode l2){
            ListNode cur = new ListNode(0);
            ListNode pre = cur;
            while(l1 != null && l2 != null){
                if(l1.val > l2.val){
                    cur.next = l2;
                    l2 = l2.next;
                }else{
                    cur.next = l1;
                    l1 = l1.next;
                }
                cur = cur.next;
            }
    
            cur.next = l1==null?l2:l1;
            return pre.next;
        }
    }
}

