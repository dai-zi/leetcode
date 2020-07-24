package com.csms.leetcode.number.n1000.n1000;

import com.csms.leetcode.common.ListNode;

import java.util.ArrayList;
import java.util.Stack;

//负二进制转换
//中等
public class Leetcode1017 {
public int[] nextLargerNodes(ListNode head) {
        Stack stack = new Stack();
        ArrayList<Integer> data = new ArrayList<>();
        ArrayList<Integer> res = new ArrayList<>();

        int index = 0;
        while(head != null) {
            res.add(0);
            data.add(head.val);

            while (!stack.empty() && head.val > data.get((Integer)stack.peek())) {
                res.set((Integer)stack.pop(), head.val);
            }

            stack.push(index);
            index++;
            head = head.next;
        }

        int[] ans = new int[res.size()];

        for (int i = 0; i < res.size(); i++) {
            ans[i] = res.get(i);
        }

        return ans;
    }

    public static void main(String[] args) {
    }
}