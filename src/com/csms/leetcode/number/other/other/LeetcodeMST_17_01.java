package com.csms.leetcode.number.other.other;
//不用加号的加法
//简单
public class LeetcodeMST_17_01 {
public int add(int a, int b) {
        while (b != 0) {
            int sum = (a ^ b);
            int carry = (a & b) << 1;
            a = sum;
            b = carry;
        }

        return a;
    }
    public static void main(String[] args) {
    }
}