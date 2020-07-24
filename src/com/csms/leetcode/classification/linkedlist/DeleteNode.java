package com.csms.leetcode.classification.linkedlist;

import com.csms.leetcode.common.ListNode;

public class DeleteNode {
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
