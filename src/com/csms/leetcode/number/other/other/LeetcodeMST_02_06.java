package com.csms.leetcode.number.other.other;

import com.csms.leetcode.common.ListNode;

//回文链表
//简单
public class LeetcodeMST_02_06 {
public boolean isPalindrome(ListNode head) {
 //判断长度

        //头删除 头插插入 判断

        int length = 0;

        ListNode p = head;

        while (p != null) {
            length ++;
            p = p.next;
        }

        int size = length / 2;

        ListNode newHead = null;

        for (int i = 0; i < size; i ++) {
            //头删除 头插入
            ListNode temp = head;
            head = head.next;
            temp.next = null;
            if(newHead == null) {
                newHead = temp;
            }else {
                temp.next = newHead;
                newHead = temp;
            }
        }

        //基数
        if(length % 2 == 1) {
            head = head.next;
        }

        for (int i = 0; i < size; i ++) {
            if(head.val != newHead.val) {
                return false;
            }
            head = head.next;
            newHead = newHead.next;
        }

        return true;
    }
    public static void main(String[] args) {
    }
}