package com.csms.leetcode.number.n100.n160;

import com.csms.leetcode.common.ListNode;

//相交链表
//简单
public class Leetcode160 {
    public ListNode getIntersectionNode1(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;
        ListNode L = headA;
        ListNode R = headB;
        int count=0; //当一个节点达到一个链表的尾部，则从另一个链表继续，同时count++
        while (L != R) {
            L = L.next;
            R = R.next;
            if (L == null) {
                L = headB;
                count ++;
            }
            if (R == null) {
                R = headA;
                count++;
            }
            if (count >2) {
                return null;
            }
        }
        return L;
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null) return null;
        ListNode A = headA;
        ListNode B = headB;
        int length = 0;
        //先将每个链表遍历一遍，并记录长度差如果最后节点不是一个节点，则表示两个链表没有相交，return null
        while(A.next != null) {
            A = A.next;
            length++;
        }
        while(B.next != null) {
            B = B.next;
            length--;
        }
        if(A != B) return null;
        A = headA;
        B = headB;
        //之后两个指针一起走，走到相同的地方则为相交的节点。
        while(A != B){
            //根据长度差，我们可让比较长的链表先走差值那么多步。
            if(length > 0){
                A = A.next;
                length--;
                continue;
            }
            if(length < 0){
                B = B.next;
                length++;
                continue;
            }
            A = A.next;
            B = B.next;
        }
        return A;

    }

    public static void main(String[] args) {
    }
}