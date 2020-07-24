package com.csms.leetcode.number.other.other;
//斐波那契数列
//简单
public class LeetcodeMST_10_I {
public int fib(int n) {
        int a = 0, b = 1, sum;
        for(int i = 0; i < n; i++){
            sum = (a + b) % 1000000007;
            a = b;
            b = sum;
        }
        return a;
    }
    public static void main(String[] args) {
    }
}