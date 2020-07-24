package com.csms.leetcode.number.n1400.n1400;
//将二进制表示减到1的步骤数
//中等
public class Leetcode1404 {
public int numSteps(String s) {
        int res = 0,cur = 0,carry = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            cur = s.charAt(i) - '0' + carry;
            if (cur % 2 == 0) {
                res += 1;
            } else {
                if (i == 0) 
                    break;
                res += 2;
                carry = 1;
            }
        }
        return res;
    }

    public static void main(String[] args) {
    }
}