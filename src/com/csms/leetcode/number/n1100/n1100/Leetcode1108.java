package com.csms.leetcode.number.n1100.n1100;
//IP地址无效化
//简单
public class Leetcode1108 {
public String defangIPaddr(String address) {
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < address.length(); i++) {
            if (address.charAt(i) == '.') {
                //s.append('[');
                //s.append('.');
                //s.append(']');
                s.append("[.]");
            } else {
                s.append(address.charAt(i));
            }
        }
        return s.toString();
    }

    public static void main(String[] args) {
    }
}