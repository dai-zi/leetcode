package com.csms.leetcode.number.n1000.n1000;
//可被K整除的最小整数
//中等
public class Leetcode1015 {
public static int smallestRepunitDivByK(int K) {
    if (K % 2 == 0 || K % 5 == 0) {
        return -1;
    }
    int temp = 1;
    int len = 1;
    while (temp % K != 0) {
        temp = temp % K;
        temp = temp * 10 + 1;
        len += 1;
    }
    return len;
}
    public static void main(String[] args) {
    }
}