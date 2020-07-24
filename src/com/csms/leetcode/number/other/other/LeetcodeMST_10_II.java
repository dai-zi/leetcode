package com.csms.leetcode.number.other.other;
//青蛙跳台阶问题
//简单
public class LeetcodeMST_10_II {
public int numWays(int n) {
        int a = 1, b = 1, sum;
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