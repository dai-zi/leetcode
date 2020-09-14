package com.csms.leetcode.number.n400.n440;

import com.csms.leetcode.common.ListNode;

//两数相加II
//中等
public class Leetcode445 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null || l2 == null) return l1 == null ? l2 : l1;
        int carry = 0;
        ListNode dummy = new ListNode(-1);
        ListNode head = dummy;
        while (l1 != null || l2 != null) {
            int sum = carry;
            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }
            carry = sum / 10;
            sum %= 10;
            dummy.next = new ListNode(sum);
            dummy = dummy.next;
        }
        if (carry != 0) {
            dummy.next = new ListNode(carry);
        }
        return head.next;
    }
    public static void main(String[] args) {
    }
}