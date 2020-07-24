package com.csms.leetcode.number.n200.n260;
//丑数
//简单
public class Leetcode263 {
    public boolean isUgly(int num) {
        if (num <= 0) {
            return false;
        }

        int[] factor = new int[]{2,3,5};
        for (int i : factor) {
            while (num%i == 0) {
                num = num/i;
            }
        }
        if (num == 1) {
            return true;
        }
        return false;
    }
    public static void main(String[] args) {
    }
}