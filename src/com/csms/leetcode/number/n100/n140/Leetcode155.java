package com.csms.leetcode.number.n100.n140;

import java.util.Stack;

//最小栈
//简单
public class Leetcode155 {
    private Stack<Integer> stack;
    private Stack<Integer> min_stack;
    public Leetcode155() {
        stack = new Stack<>();
        min_stack = new Stack<>();
    }
    public void push(int x) {
        stack.push(x);
        if(min_stack.isEmpty() || x <= min_stack.peek())
            min_stack.push(x);
    }
    public void pop() {
        if(stack.pop().equals(min_stack.peek()))
            min_stack.pop();
    }
    public int top() {
        return stack.peek();
    }
    public int getMin() {
        return min_stack.peek();
    }

    public static void main(String[] args) {
    }
}