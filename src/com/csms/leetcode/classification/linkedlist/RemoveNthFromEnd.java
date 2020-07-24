package com.csms.leetcode.classification.linkedlist;

import com.csms.leetcode.common.ListNode;

public class RemoveNthFromEnd {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        //a-->b-->c-->d-->e-->f
        //a-->c
        ListNode fast = head;
        ListNode slow = head;
        while(n>0){
            fast = fast.next;
            n--;
        }
        if(fast == null){
            return slow.next;
        }
        //a-->b-->c
        while(fast.next != null){
            fast = fast.next;
            slow = slow.next;
        }
        ListNode bak = slow.next;
        slow.next = bak.next;
        bak.next = null;
        return head;
    }
}
