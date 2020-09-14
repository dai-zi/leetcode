package com.csms.leetcode.number.n300.n380;
//消除游戏
//中等
public class Leetcode390 {
    public int lastRemaining(int n) {
        int count = n;
        int first = 1;
        int diff = 1;
        boolean isFromLeft = true;
        while (count > 1) {
            if (isFromLeft) {
                first += diff;
            } else {
                if ((count & 1) == 1) {
                    first += diff;
                }
            }

            count >>>= 1;
            diff <<= 1;
            isFromLeft = !isFromLeft;
        }

        return first;
    }
    public static void main(String[] args) {
    }
}