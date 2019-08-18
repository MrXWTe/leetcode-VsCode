/*
 * @lc app=leetcode.cn id=445 lang=java
 *
 * [445] 两数相加 II
 *
 * https://leetcode-cn.com/problems/add-two-numbers-ii/description/
 *
 * algorithms
 * Medium (49.75%)
 * Likes:    75
 * Dislikes: 0
 * Total Accepted:    6.1K
 * Total Submissions: 12.1K
 * Testcase Example:  '[7,2,4,3]\n[5,6,4]'
 *
 * 给定两个非空链表来代表两个非负整数。数字最高位位于链表开始位置。它们的每个节点只存储单个数字。将这两数相加会返回一个新的链表。
 * 
 * 
 * 
 * 你可以假设除了数字 0 之外，这两个数字都不会以零开头。
 * 
 * 进阶:
 * 
 * 如果输入链表不能修改该如何处理？换句话说，你不能对列表中的节点进行翻转。
 * 
 * 示例:
 * 
 * 
 * 输入: (7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出: 7 -> 8 -> 0 -> 7
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
        
        Stack<Integer> stack1=new Stack();
        Stack<Integer> stack2=new Stack();
        ListNode node1=l1;
        while(node1!=null){
            stack1.push(node1.val);
            node1=node1.next;
        }
        ListNode node2=l2;
        while(node2!=null){
            stack2.push(node2.val);
            node2=node2.next;
        }
        ListNode head=null;
        int flag=0;
        while(!stack1.isEmpty()||!stack2.isEmpty()||flag!=0){
            int value=0;
            if(!stack1.isEmpty())
                value+=stack1.pop();
            if(!stack2.isEmpty())
                value+=stack2.pop();
            value+=flag;
            ListNode node=new ListNode(value%10);
            flag=value/10;
            node.next=head;
            head=node;
        }
       return head;
    }
}

