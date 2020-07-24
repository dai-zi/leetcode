package com.csms.leetcode.number.n800.n860;

import com.csms.leetcode.common.ListNode;

//链表的中间结点
//简单
public class Leetcode876 {
public ListNode middleNode(ListNode head) {
        ListNode[] A = new ListNode[100];
        int t = 0;
        while (head != null) {
            A[t++] = head;
            head = head.next;
        }
        return A[t / 2];
    }
    public static void main(String[] args) {
    }
}