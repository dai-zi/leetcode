package com.csms.leetcode.number.n200.n220;

import com.csms.leetcode.common.ListNode;

//删除链表中的节点
//简单
public class Leetcode237 {
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
    public static void main(String[] args) {
    }
}