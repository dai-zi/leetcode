package com.csms.leetcode.number.other.other;

import java.util.Stack;

//用两个栈实现队列
//简单
public class LeetcodeMST_09 {
Stack<Integer> stack1;
    Stack<Integer> stack2;
    int size;

    public LeetcodeMST_09() {
        stack1 = new Stack<Integer>();
        stack2 = new Stack<Integer>();
        size = 0;
    }
    
    public void appendTail(int value) {
        while (!stack1.isEmpty()) {
            stack2.push(stack1.pop());
        }
        stack1.push(value);
        while (!stack2.isEmpty()) {
            stack1.push(stack2.pop());
        }
        size++;
    }
    
    public int deleteHead() {
        if (size == 0) {
            return -1;
        }
        size--;
        return stack1.pop();
    }
    public static void main(String[] args) {
    }
}