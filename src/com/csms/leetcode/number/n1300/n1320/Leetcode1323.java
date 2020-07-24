package com.csms.leetcode.number.n1300.n1320;
//6和9组成的最大数字
//简单
public class Leetcode1323 {
public int maximum69Number (int num) {
        String s = num + "";

        s = s.replaceFirst("6", "9");

        return Integer.valueOf(s);
    }

    public static void main(String[] args) {
    }
}