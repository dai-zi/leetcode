package com.csms.leetcode.classification.linkedlist;

import com.csms.leetcode.common.ListNode;

public class DeleteDuplicates {
    //    给定一个排序链表，删除所有含有重复数字的节点，只保留原始链表中?没有重复出现?的数字。
//
//    示例?1:
//
//    输入: 1->2->3->3->4->4->5
//    输出: 1->2->5
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode a = dummy;
        ListNode b = head;
        while (b != null && b.next != null) {
            //初始化的时a指向的是哑结点，所以比较逻辑应该是a的下一个节点和b的下一个节点
            if (a.next.val != b.next.val) {
                a = a.next;
                b = b.next;
            } else {
                //如果a、b指向的节点值相等，就不断移动b，直到a、b指向的值不相等
                while (b != null && b.next != null && a.next.val == b.next.val) {
                    b = b.next;
                }
                a.next = b.next;
                b = b.next;
            }
        }
        return dummy.next;
    }

    //    给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。
//
//    示例 1:
//
//    输入: 1->1->2
//    输出: 1->2
    public ListNode deleteDuplicates1(ListNode head) {
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
}
