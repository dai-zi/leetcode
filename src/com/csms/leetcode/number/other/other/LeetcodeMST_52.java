package com.csms.leetcode.number.other.other;

import com.csms.leetcode.common.ListNode;

//两个链表的第一个公共节点
//简单
public class LeetcodeMST_52 {
    public ListNode getIntersectionNode1(ListNode headA, ListNode headB) {
        int lengthA = 0, lengthB = 0;
        ListNode tmpA = headA, tmpB = headB;
        while(tmpA!=null){
            tmpA=tmpA.next;
            lengthA++;
        }
        while(tmpB!=null){
            tmpB = tmpB.next;
            lengthB++;
        }
        ListNode tmpLong = headA;//默认取A为长链表
        ListNode tmpShort = headB;
        int lengthDif = lengthA-lengthB;
        if(lengthA<lengthB) {//若A不为长链表，则进行修改
            tmpLong = headB;
            tmpShort = headA;
            lengthDif = lengthB-lengthA;
        }
        for(int i =0;i<lengthDif;i++) tmpLong=tmpLong.next;

        while(tmpLong!=tmpShort){//此时两链表剩下的长度相同，这里的判断条件也可改为tmpShort!=null
            tmpLong=tmpLong.next;
            tmpShort=tmpShort.next;
        }
        return tmpLong;//若不存在公共节点，则此时tmpLong=null
    }
    public static void main(String[] args) {
    }
}