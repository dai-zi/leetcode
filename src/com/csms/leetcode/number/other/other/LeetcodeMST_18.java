package com.csms.leetcode.number.other.other;

import com.csms.leetcode.common.ListNode;

//删除链表的节点
//简单
public class LeetcodeMST_18 {
public ListNode deleteNode(ListNode head, int val) {
        if(head.val == val) return head.next;
        ListNode pre = head, cur = head.next;
        while(cur != null && cur.val != val) {
            pre = cur;
            cur = cur.next;
        }
        if(cur != null) pre.next = cur.next;
        return head;
    }

    public static void main(String[] args) {
    }
}