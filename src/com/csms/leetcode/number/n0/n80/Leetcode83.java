package com.csms.leetcode.number.n0.n80;

import com.csms.leetcode.common.ListNode;

//删除排序链表中的重复元素
//简单
public class Leetcode83 {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode current = head;
        while (current != null && current.next != null) {
            if (current.next.val == current.val) {
                current.next = current.next.next;
            } else {
                current = current.next;
            }
        }
        return head;
    }

    public static void main(String[] args) {
    }
}