package com.csms.leetcode.number.other.other;
//阶乘尾数
//简单
public class LeetcodeMST_16_05 {
public int trailingZeroes(int n) {
       return hepl(n);
    }
    private int hepl(int n) {
        if (n < 5){
            return 0;
        }
        return hepl(n / 5) + n / 5;
    }
    public static void main(String[] args) {
    }
}