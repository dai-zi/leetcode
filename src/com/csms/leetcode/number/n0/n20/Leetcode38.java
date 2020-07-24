package com.csms.leetcode.number.n0.n20;
//外观数列
//简单
public class Leetcode38 {
    public String countAndSay(int n) {
        if (n == 1) {
            return "1";
        } else {
            String prevStr = countAndSay(n - 1);
            String result = "";
            char num = prevStr.charAt(0);
            int count = 0;
            for (int i = 0; i < prevStr.length(); i++) {
                if (prevStr.charAt(i) != num) {
                    result = result + String.valueOf(count) + num;
                    num = prevStr.charAt(i);
                    count = 1;
                } else {
                    count++;
                }
            }
            return result = result + String.valueOf(count) + num;
        }
    }

    public static void main(String[] args) {
    }
}