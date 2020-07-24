package com.csms.leetcode.number.other.other;

import com.csms.leetcode.common.ListNode;

//返回倒数第k个节点
//简单
public class LeetcodeMST_02_02 {
public int kthToLast(ListNode head, int k) {
        ListNode p = head;
        for(int i=0;i<k;i++){
          p = p.next;  
        }

        while(p != null){
            p = p.next;
            head = head.next;
        }

        return head.val;
    }

    public static void main(String[] args) {
    }
}