package com.csms.leetcode.number.other.other;

import com.csms.leetcode.common.ListNode;

import java.util.HashMap;
import java.util.Map;

//移除重复节点
//简单
public class LeetcodeMST_02_01 {
   public ListNode removeDuplicateNodes(ListNode head) {
        if (head == null || head.next == null){
            return head;
        }
        ListNode pre = head;
        ListNode later = null;
        Map<Integer, Integer> hashMap = new HashMap<>();
        while (pre != null){
            if (!hashMap.containsKey(pre.val)){
                hashMap.put(pre.val, 1);
                later = pre;
                pre = pre.next;
            } else {
                pre = pre.next;
                later.next = pre;
            }
        }
        return head;
    }
    public static void main(String[] args) {
    }
}