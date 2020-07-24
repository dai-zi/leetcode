package com.csms.leetcode.number.n1000.n1000;

import java.util.Stack;

//检查替换后的词是否有效
//中等
public class Leetcode1003 {
public boolean isValid(String S) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < S.length(); i++) {
            if (S.charAt(i) == 'c') {
                if (stack.empty() || stack.pop() != 'b')
                    return false;
                if (stack.empty() || stack.pop() != 'a')
                    return false;
            } else {
                stack.push(S.charAt(i));
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
    }
}