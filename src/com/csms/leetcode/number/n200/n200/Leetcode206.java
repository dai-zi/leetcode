package com.csms.leetcode.number.n200.n200;

import com.csms.leetcode.common.ListNode;

//反转链表
//简单
//要背下来
public class Leetcode206 {
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }
        return prev;
    }

    public static void main(String[] args) {
    }
}