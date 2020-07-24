package com.csms.leetcode.number.other.other;
//二进制中1的个数
//简单
public class LeetcodeMST_15 {
public int hammingWeight(int n) {
        int res = 0;
        while(n != 0) {
            res++;
            n &= n - 1;
        }
        return res;
    }
    public static void main(String[] args) {
    }
}