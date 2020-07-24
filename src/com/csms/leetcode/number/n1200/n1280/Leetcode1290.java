package com.csms.leetcode.number.n1200.n1280;

import com.csms.leetcode.common.ListNode;

//二进制链表转整数
//简单
public class Leetcode1290 {
public int getDecimalValue(ListNode head) {
        ListNode cur = head;
        int ans = 0;
        while (cur != null) {
            ans <<= 1;
            ans += cur.val;
            cur = cur.next;
        }
        return ans;
    }
    public static void main(String[] args) {
    }
}