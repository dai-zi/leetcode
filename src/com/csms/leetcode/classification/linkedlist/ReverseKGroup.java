package com.csms.leetcode.classification.linkedlist;

import com.csms.leetcode.common.ListNode;

import java.util.List;

public class ReverseKGroup {
    public ListNode reverseKGroup(ListNode head, int k) {
        if(k == 1){
            return head;
        }
        //1->2->3->4->5, ºÍ n = 2
        boolean isFirstReverse = true;
        ListNode fast = head;
        ListNode slow = head;
        ListNode bak;
        ListNode pre = null;

        ListNode headOfThisTime;//pre
        ListNode tailOfLastTime = head;
        int cnt = k;
        while(fast != null){
            while(fast != null && cnt > 0){
                fast = fast.next;
                cnt--;
            }
            if(cnt > 0){
                if(isFirstReverse){
                    return head;
                }
                tailOfLastTime.next = slow;
                return head;
            }
            headOfThisTime = slow;
            while(slow != fast){
                bak = slow.next;
                slow.next = pre;
                pre = slow;
                slow = bak;
            }
            if(!isFirstReverse) {
                tailOfLastTime.next = pre;
            }else{
                head = pre;
                isFirstReverse = false;
            }
            tailOfLastTime = headOfThisTime;
            pre = null;
            cnt = k;
        }
        return head;
    }
    public static void main(String[] args) {

    }
}
