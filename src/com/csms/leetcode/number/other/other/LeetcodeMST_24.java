package com.csms.leetcode.number.other.other;

import com.csms.leetcode.common.ListNode;

//反转链表
//简单
public class LeetcodeMST_24 {
public ListNode reverseList(ListNode head) {
		//申请节点，pre和 cur，pre指向null
		ListNode pre = null;
		ListNode cur = head;
		ListNode tmp = null;
		while(cur!=null) {
			//记录当前节点的下一个节点
			tmp = cur.next;
			//然后将当前节点指向pre
			cur.next = pre;
			//pre和cur节点都前进一位
			pre = cur;
			cur = tmp;
		}
		return pre;
	}

    public static void main(String[] args) {
    }
}