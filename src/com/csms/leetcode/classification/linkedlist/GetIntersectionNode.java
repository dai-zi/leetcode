package com.csms.leetcode.classification.linkedlist;

import com.csms.leetcode.common.ListNode;

public class GetIntersectionNode {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null){
            return null;
        }
        int lenA = 0;
        ListNode ptr = headA;
        while(ptr != null){
            lenA++;
            ptr = ptr.next;
        }

        int lenB = 0;
        ptr = headB;
        while(ptr != null){
            lenB++;
            ptr = ptr.next;
        }

        if(lenA < lenB){
            //调整headA和headB的指向,使得headA总指向长的链表
            ListNode tmp = headA;
            headA = headB;
            headB = tmp;
            int tmp1 = lenA;
            lenA = lenB;
            lenB = tmp1;
        }
        while(lenA - lenB > 0){
            headA = headA.next;
            lenA--;
        }
        while(headA != null){
            if(headA == headB){
                return headA;
            }
            headA = headA.next;
            headB = headB.next;
        }
        return null;
    }
}
