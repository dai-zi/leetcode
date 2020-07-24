package com.csms.leetcode.classification.linkedlist;

import com.csms.leetcode.common.ListNode;
//
//����һ��������?L��L0��L1������Ln-1��Ln ��
//        �����������к��Ϊ�� L0��Ln��L1��Ln-1��L2��Ln-2����
//
//        �㲻��ֻ�ǵ����ĸı�ڵ��ڲ���ֵ��������Ҫʵ�ʵĽ��нڵ㽻����


public class ReorderList {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) {
            return;
        }
        //���е㣬����ֳ�����
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode newHead = slow.next;
        slow.next = null;

        //�ڶ���������
        newHead = reverseList(newHead);

        //����ڵ���������
        while (newHead != null) {
            ListNode temp = newHead.next;
            newHead.next = head.next;
            head.next = newHead;
            head = newHead.next;
            newHead = temp;
        }

    }

    private ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode tail = head;
        head = head.next;

        tail.next = null;

        while (head != null) {
            ListNode temp = head.next;
            head.next = tail;
            tail = head;
            head = temp;
        }

        return tail;
    }
}
