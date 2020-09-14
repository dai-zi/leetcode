package com.csms.leetcode.number.n0.n60;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

//简化路径
//中等
public class Leetcode71 {
    public String simplifyPath(String path) {
        String[] s = path.split("/");
        Stack<String> stack = new Stack<>();

        for (int i = 0; i < s.length; i++) {
            if (!stack.isEmpty() && s[i].equals(".."))
                stack.pop();
            else if (!s[i].equals("") && !s[i].equals(".") && !s[i].equals(".."))
                stack.push(s[i]);
        }
        if (stack.isEmpty())
            return "/";

        StringBuffer res = new StringBuffer();
        for (int i = 0; i < stack.size(); i++) {
            res.append("/" + stack.get(i));
        }
        return res.toString();
    }
    public static void main(String[] args) {
    }
}