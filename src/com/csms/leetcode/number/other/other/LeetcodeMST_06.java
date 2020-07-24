package com.csms.leetcode.number.other.other;

import com.csms.leetcode.common.ListNode;

import java.util.Stack;

//从尾到头打印链表
//简单
public class LeetcodeMST_06 {
public int[] reversePrint(ListNode head) {
        Stack<ListNode> stack = new Stack<ListNode>();
        ListNode temp = head;
        while (temp != null) {
            stack.push(temp);
            temp = temp.next;
        }
        int size = stack.size();
        int[] print = new int[size];
        for (int i = 0; i < size; i++) {
            print[i] = stack.pop().val;
        }
        return print;
    }
    public static void main(String[] args) {
    }
}