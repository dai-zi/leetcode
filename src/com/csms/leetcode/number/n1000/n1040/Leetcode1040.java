package com.csms.leetcode.number.n1000.n1040;

import java.util.Arrays;

//移动石子直到连续II
//中等
public class Leetcode1040 {
public int[] numMovesStonesII(int[] stones) {
        Arrays.sort(stones);
        int n = stones.length;
        int low = n;
        int start = 0;
        int hi = Math.max(stones[n - 1] - stones[1] - n + 2, stones[n - 2] - stones[0] - n + 2);
        for (int i = 0; i < stones.length; i ++) {
            while (stones[i] - stones[start] >= n) start ++;
            if (i - start + 1 == n - 1 && stones[i] - stones[start] == n - 2) {
                low = Math.min(low, 2);
            } else {
                low = Math.min(low, n - (i - start + 1));
            }
        }
        return new int[]{low, hi};
    }

    public static void main(String[] args) {
    }
}