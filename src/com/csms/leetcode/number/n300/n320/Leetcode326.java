package com.csms.leetcode.number.n300.n320;
//3的幂
//简单
public class Leetcode326 {
    public boolean isPowerOfThree(int n) {
        if (n < 1) {
            return false;
        }

        while (n % 3 == 0) {
            n /= 3;
        }

        return n == 1;
    }
    public static void main(String[] args) {
    }
}