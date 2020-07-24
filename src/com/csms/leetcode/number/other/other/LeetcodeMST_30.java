package com.csms.leetcode.number.other.other;

import java.util.Stack;

//包含min函数的栈
//简单
public class LeetcodeMST_30 {
Stack<Integer> A, B;
    public LeetcodeMST_30() {
        A = new Stack<>();
        B = new Stack<>();
    }
    public void push(int x) {
        A.add(x);
        if(B.empty() || B.peek() >= x)
            B.add(x);
    }
    public void pop() {
        if(A.pop().equals(B.peek()))
            B.pop();
    }
    public int top() {
        return A.peek();
    }
    public int min() {
        return B.peek();
    }
    public static void main(String[] args) {
    }
}