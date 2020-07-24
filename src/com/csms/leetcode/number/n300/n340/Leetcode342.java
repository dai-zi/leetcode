package com.csms.leetcode.number.n300.n340;
//4的幂
//简单
public class Leetcode342 {
    public boolean isPowerOfFour(int num) {
        return num > 0 && (num & (num - 1)) == 0 && (num & 0xaaaaaaaa) == 0;
    }

    public static void main(String[] args) {
    }
}