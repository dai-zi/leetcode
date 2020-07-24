package com.csms.leetcode.number.other.other;

import com.csms.leetcode.common.ListNode;

//删除中间节点
//简单
public class LeetcodeMST_02_03 {
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }

    public static void main(String[] args) {
    }
}