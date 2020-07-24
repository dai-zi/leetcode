package com.csms.leetcode.number.n100.n160;
//阶乘后的零
//简单
public class Leetcode172 {
    public int trailingZeroes(int n) {
        int zeroCount = 0;
        // We need to use long because currentMultiple can potentially become
        // larger than an int.
        long currentMultiple = 5;
        while (n >= currentMultiple) {
            zeroCount += (n / currentMultiple);
            currentMultiple *= 5;
        }
        return zeroCount;
    }

    public static void main(String[] args) {
    }
}