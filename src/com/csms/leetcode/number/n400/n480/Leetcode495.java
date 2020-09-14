package com.csms.leetcode.number.n400.n480;
//提莫攻击
//中等
public class Leetcode495 {
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        int n = timeSeries.length;
        if (n == 0) return 0;

        int total = 0;
        for (int i = 0; i < n - 1; ++i)
            total += Math.min(timeSeries[i + 1] - timeSeries[i], duration);
        return total;
    }
    public static void main(String[] args) {
    }
}