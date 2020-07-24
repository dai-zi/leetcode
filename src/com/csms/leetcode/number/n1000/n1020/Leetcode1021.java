package com.csms.leetcode.number.n1000.n1020;
//删除最外层的括号
//简单
public class Leetcode1021 {
public String removeOuterParentheses(String S) {
        StringBuilder sb = new StringBuilder();
        int level = 0;
        for (char c : S.toCharArray()) {
            if (c == ')') --level;
            if (level >= 1) sb.append(c);
            if (c == '(') ++level;
        }
        return sb.toString();
    }

    public static void main(String[] args) {
    }
}