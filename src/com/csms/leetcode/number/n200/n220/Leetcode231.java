package com.csms.leetcode.number.n200.n220;
//2的幂
//简单
public class Leetcode231 {
    public boolean isPowerOfTwo(int n) {
        if (n == 0) return false;
        long x = (long) n;
        return (x & (x - 1)) == 0;
    }

    public static void main(String[] args) {
    }
}