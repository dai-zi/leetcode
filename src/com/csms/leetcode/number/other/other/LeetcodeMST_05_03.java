package com.csms.leetcode.number.other.other;
//翻转数位
//简单
public class LeetcodeMST_05_03 {
public int reverseBits(int num) {
        int bits = 32;
        int max = 0;
        // 0标志前串
        int maxPre = 0;
        // 0标志后串
        int maxAfter = 0;
        while (bits-- > 0) {
            if ((num & 1) == 0) {
                max = Math.max(max, maxPre + 1 + maxAfter);
                maxPre = maxAfter;
                maxAfter = 0;
            } else {
                maxAfter++;
            }
            num >>= 1;
        }
        max = Math.max(max, maxPre + 1 + maxAfter);
        return max;
    }
    public static void main(String[] args) {
    }
}