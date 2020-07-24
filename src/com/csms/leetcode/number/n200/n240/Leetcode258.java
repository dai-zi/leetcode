package com.csms.leetcode.number.n200.n240;
//各位相加
//简单
public class Leetcode258 {
    public int addDigits(int num) {
        return (num - 1) % 9 + 1;
    }
    public static void main(String[] args) {
    }
}