package com.csms.leetcode.classification.linkedlist;

import com.csms.leetcode.common.ListNode;

public class ReverseList {
    public ListNode reverseList(ListNode head) {
        if(head ==null || head.next == null){
            return head;
        }
        ListNode newHead = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }
}
