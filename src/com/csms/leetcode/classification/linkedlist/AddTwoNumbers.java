package com.csms.leetcode.classification.linkedlist;

import com.csms.leetcode.common.ListNode;

public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1 == null){
            return l2;
        }else if(l2 == null){
            return l1;
        }
        //l1 = reverseList(l1);
        //l2 = reverseList(l2);

        ListNode head = null;
        ListNode tail = null;
        int carry = 0;
        while(l1 != null && l2 != null){
            int sum = l1.val + l2.val + carry;
            if(tail == null){
                tail = new ListNode(sum % 10);
                head = tail;
            }else{
                tail.next = new ListNode(sum % 10);
                tail = tail.next;
            }
            carry = sum / 10;
            l1 = l1.next;
            l2 = l2.next;
        }
        while(l1 != null){
            int sum = l1.val + carry;
            tail.next = new ListNode(sum % 10);
            tail = tail.next;
            carry = sum / 10;
            l1 = l1.next;
        }
        while(l2 != null){
            int sum = l2.val + carry;
            tail.next = new ListNode(sum % 10);
            tail = tail.next;
            carry = sum / 10;
            l2 = l2.next;
        }
        if(carry > 0){
            tail.next = new ListNode(carry);
        }
        return head;
    }
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
