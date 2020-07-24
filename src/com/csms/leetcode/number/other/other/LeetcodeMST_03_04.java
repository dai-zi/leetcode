package com.csms.leetcode.number.other.other;

import java.util.Stack;

//化栈为队
//简单
public class LeetcodeMST_03_04 {
private Stack<Integer> numStack;
        private Stack<Integer> helpStack;

        /** Initialize your data structure here. */
        public LeetcodeMST_03_04() {
            numStack = new Stack<>();
            helpStack = new Stack<>();
        }

        /** Push element x to the back of queue. */
        public void push(int x) {
            numStack.push(x);
        }

        /** Removes the element from in front of queue and returns that element. */
        public int pop() {
            peek();
            return helpStack.pop();
        }

        /** Get the front element. */
        public int peek() {
            if (helpStack.isEmpty()) {
                while (!numStack.isEmpty()) {
                    helpStack.push(numStack.pop());
                }
            }

            return helpStack.peek();
        }

        /** Returns whether the queue is empty. */
        public boolean empty() {
            return helpStack.isEmpty() && numStack.isEmpty();
        }

    public static void main(String[] args) {
    }
}