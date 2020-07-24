package com.csms.leetcode.number.n200.n200;

import com.csms.leetcode.common.ListNode;

//移除链表元素
//简单
public class Leetcode203 {
    public ListNode removeElements(ListNode head, int val) {
        ListNode sentinel = new ListNode(0);
        sentinel.next = head;

        ListNode prev = sentinel, curr = head;
        while (curr != null) {
            if (curr.val == val) prev.next = curr.next;
            else prev = curr;
            curr = curr.next;
        }
        return sentinel.next;
    }

    public static void main(String[] args) {
    }
}