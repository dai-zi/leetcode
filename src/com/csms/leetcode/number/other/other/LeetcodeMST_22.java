package com.csms.leetcode.number.other.other;

import com.csms.leetcode.common.ListNode;

//链表中倒数第k个节点
//简单
public class LeetcodeMST_22 {
public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode former = head, latter = head;
        for(int i = 0; i < k; i++) {
            if(former == null) return null;
            former = former.next;
        }
        while(former != null) {
            former = former.next;
            latter = latter.next;
        }
        return latter;
    }

    public static void main(String[] args) {
    }
}