package com.csms.leetcode.number.other.other;

import java.util.Stack;

//栈的最小值
//简单
public class LeetcodeMST_03_02 {
private Stack<Integer> stack;

    private Stack<Integer> minStack;

    /** initialize your data structure here. */
    public LeetcodeMST_03_02() {
        stack = new Stack<Integer>();
        minStack = new Stack<Integer>();
    }

    public void push(int x) {
        stack.push(x);
        if(minStack.size() <= 0) {
            minStack.push(x);
        }else {
            if(minStack.peek() < x) {
                minStack.push(minStack.peek());
            }else {
                minStack.push(x);
            }
        }
    }

    public void pop() {
        stack.pop();
        minStack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
    public static void main(String[] args) {
    }
}