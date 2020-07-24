package com.csms.leetcode.number.other.other;

import com.csms.leetcode.common.ListNode;

//环路检测
//中等
public class LeetcodeMST_02_08 {
public ListNode detectCycle(ListNode head) {
          //快慢指针

        if(head != null && head.next != null) {

            ListNode fast = head;

            ListNode slow = head;

            fast = fast.next.next;
            slow = slow.next;
            while (fast != slow && fast != null && slow != null) {
                if(fast.next == null) {
                    return null;
                }
                fast = fast.next.next;
                slow = slow.next;
            }

            if(fast != null && slow != null) {
                fast = head;
                while (fast != slow) {
                    fast = fast.next;
                    slow = slow.next;
                }

                return fast;
            }

        }

        return null;
    }

    public static void main(String[] args) {
    }
}