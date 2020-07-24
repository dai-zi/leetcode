package com.csms.leetcode.number.n200.n220;

import java.util.LinkedList;
import java.util.Queue;

//用队列实现栈
//简单
public class Leetcode225 {
    private Queue<Integer> q1 = new LinkedList<>();
    private Queue<Integer> q2 = new LinkedList<>();
    private int top;

    public void push(int x) {
        q2.add(x);
        top = x;
        while (!q1.isEmpty()) {
            q2.add(q1.remove());
        }
        Queue<Integer> temp = q1;
        q1 = q2;
        q2 = temp;
    }
    // Removes the element on top of the stack.
    public int pop() {
        q1.remove();
        int res = top;
        if (!q1.isEmpty()) {
            top = q1.peek();
        }
        return res;
    }

    public static void main(String[] args) {
    }
}