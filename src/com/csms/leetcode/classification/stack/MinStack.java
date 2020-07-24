package com.csms.leetcode.classification.stack;

import java.util.Stack;

public class MinStack {
    Stack<Integer> min;
    Stack<Integer> stack;
    /** initialize your data structure here. */
    public MinStack() {
        stack = new Stack<Integer>();
        min = new Stack<Integer>();
    }

    public void push(int x) {
        stack.push(x);
        if(min.empty()){
            min.push(x);
        }else{
            if(x<=min.peek()){
                min.push(x);
            }
        }
    }

    public void pop() {

        if(min.peek().equals(stack.peek())){
            min.pop();
        }
        stack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return min.peek();
    }
}
