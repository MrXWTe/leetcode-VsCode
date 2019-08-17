/*
 * @lc app=leetcode.cn id=86 lang=java
 *
 * [86] 分隔链表
 *
 * https://leetcode-cn.com/problems/partition-list/description/
 *
 * algorithms
 * Medium (51.42%)
 * Likes:    108
 * Dislikes: 0
 * Total Accepted:    12.5K
 * Total Submissions: 24.1K
 * Testcase Example:  '[1,4,3,2,5,2]\n3'
 *
 * 给定一个链表和一个特定值 x，对链表进行分隔，使得所有小于 x 的节点都在大于或等于 x 的节点之前。
 * 
 * 你应当保留两个分区中每个节点的初始相对位置。
 * 
 * 示例:
 * 
 * 输入: head = 1->4->3->2->5->2, x = 3
 * 输出: 1->2->2->4->3->5
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
    public ListNode partition(ListNode head, int x) {
        ListNode lt = new ListNode(0);
        ListNode gt = new ListNode(0);
        ListNode gtt = gt;
        ListNode ltt = lt;
        ListNode cur = head;
        while(cur!=null){
            if(cur.val<x){
                lt.next = cur;
                lt = lt.next;
            }else{
                gt.next = cur;
                gt = gt.next;
            }
            cur = cur.next;
        }
        lt.next = gtt.next;
        gt.next = null;
        return ltt.next;
    }
}

