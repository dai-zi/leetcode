package com.csms.leetcode.number.n400.n460;
//汉明距离
//简单
public class Leetcode461 {
    public int hammingDistance(int x, int y) {
        int xor = x ^ y;
        int distance = 0;
        while (xor != 0) {
            if (xor % 2 == 1)
                distance += 1;
            xor = xor >> 1;
        }
        return distance;
    }
    public static void main(String[] args) {
    }
}