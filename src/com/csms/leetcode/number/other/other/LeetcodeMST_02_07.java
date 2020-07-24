package com.csms.leetcode.number.other.other;

import com.csms.leetcode.common.ListNode;

//链表相交
//简单
public class LeetcodeMST_02_07 {
public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        
        if(headA == null || headB == null) {
            return null;
        }

        //跑到最后一个节点，判断是否相同，统计长度
        //相同则有，不同则无
        //长的先跑这部分长度，然后一起跑等相等

        ListNode p = headA, q = headB;

        int lengthA = 1, lengthB = 1;

        while (p.next != null) {
            lengthA ++;
            p = p.next;
        }

        while (q.next != null) {
            lengthB ++;
            q = q.next;
        }

        if(p == q) {
            int length = Math.abs(lengthA - lengthB);

            for (int i = 0; i < length; i ++) {
                if(lengthA > lengthB) {
                    headA = headA.next;
                }else {
                    headB = headB.next;
                }
            }

            while (headA != null && headB != null) {
                if(headA == headB) {
                    return headA;
                }
                headA = headA.next;
                headB = headB.next;
            }

        }

        return null;



    }


    public static void main(String[] args) {
    }
}