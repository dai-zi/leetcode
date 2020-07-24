package com.csms.leetcode.classification.linkedlist;

import com.csms.leetcode.common.ListNode;

public class DeleteDuplicates {
    //    ����һ����������ɾ�����к����ظ����ֵĽڵ㣬ֻ����ԭʼ������?û���ظ�����?�����֡�
//
//    ʾ��?1:
//
//    ����: 1->2->3->3->4->4->5
//    ���: 1->2->5
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode a = dummy;
        ListNode b = head;
        while (b != null && b.next != null) {
            //��ʼ����ʱaָ������ƽ�㣬���ԱȽ��߼�Ӧ����a����һ���ڵ��b����һ���ڵ�
            if (a.next.val != b.next.val) {
                a = a.next;
                b = b.next;
            } else {
                //���a��bָ��Ľڵ�ֵ��ȣ��Ͳ����ƶ�b��ֱ��a��bָ���ֵ�����
                while (b != null && b.next != null && a.next.val == b.next.val) {
                    b = b.next;
                }
                a.next = b.next;
                b = b.next;
            }
        }
        return dummy.next;
    }

    //    ����һ����������ɾ�������ظ���Ԫ�أ�ʹ��ÿ��Ԫ��ֻ����һ�Ρ�
//
//    ʾ�� 1:
//
//    ����: 1->1->2
//    ���: 1->2
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
