package com.csms.leetcode.number.n300.n320;

import com.csms.leetcode.common.ListNode;

//奇偶链表
//中等
public class Leetcode328 {
    public ListNode oddEvenList(ListNode head) {
        if (head == null) return null;
        ListNode odd = head, even = head.next, evenHead = even;
        while (even != null && even.next != null) {
            odd.next = even.next;
            odd = odd.next;
            even.next = odd.next;
            even = even.next;
        }
        odd.next = evenHead;
        return head;
    }
    public static void main(String[] args) {
    }
}